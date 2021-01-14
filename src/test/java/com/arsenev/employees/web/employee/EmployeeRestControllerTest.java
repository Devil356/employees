package com.arsenev.employees.web.employee;

import com.arsenev.employees.model.Employee;
import com.arsenev.employees.testData.EmployeeTestData;
import com.arsenev.employees.util.JsonUtil;
import com.arsenev.employees.util.exception.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static com.arsenev.employees.testData.EmployeeTestData.*;
import static com.arsenev.employees.util.exception.ErrorType.APP_ERROR;
import static com.arsenev.employees.util.exception.ErrorType.DATA_ERROR;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class EmployeeRestControllerTest extends AbstractEmployeeRestControllerTest {
    @Test
    void getAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(REST_URL))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    void create() throws Exception {
        Employee newEmployee = EmployeeTestData.getNew();
        ResultActions action = mockMvc.perform(post("/rest")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(JsonUtil.getMapper().writeValueAsString(newEmployee)));

        Employee created = JsonUtil.getMapper().readValue(action.andReturn().getResponse().getContentAsString(), Employee.class);
        Long newId = created.getId();
        newEmployee.setId(newId);
        Assertions.assertEquals(newEmployee, created);
    }

    @Test
    void get() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(REST_URL))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    void getNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(REST_URL + NOT_FOUND))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete(REST_URL + EMPLOYEE9.getId()))
                .andExpect(status().isNoContent());
        assertThrows(NotFoundException.class, () -> service.get(EMPLOYEE9.getId()));
    }

    @Test
    void deleteNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete(REST_URL + NOT_FOUND))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void update() throws Exception {
        Employee updated = getUpdated();
        mockMvc.perform(MockMvcRequestBuilders.put(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updated)))
                .andDo(print())
                .andExpect(status().isNoContent());

        Assertions.assertEquals(service.get(updated.getId()), updated);
    }

    @Test
    void createInvalid() throws Exception {
        Employee invalid = new Employee(null, "Invalid", "Invalidov", "200", null);
        mockMvc.perform(MockMvcRequestBuilders.post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(invalid)))
                .andDo(print())
                .andExpect(status().isInternalServerError())
                .andExpect(errorType(APP_ERROR));
    }

    @Test
    void updateInvalid() throws Exception {
        Employee invalid = new Employee(EMPLOYEE9.getId(), null, null, "aaa", null);
        mockMvc.perform(MockMvcRequestBuilders.put(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(invalid)))
                .andDo(print())
                .andExpect(status().isInternalServerError())
                .andExpect(errorType(APP_ERROR));
    }

    @Test
    @Transactional(propagation = Propagation.NEVER)
    void updateDuplicateEmail() throws Exception {
        Employee invalid = new Employee(EMPLOYEE9.getId(), "aa", "aa", EMPLOYEE1.getEmail(), "12345678901");

        mockMvc.perform(MockMvcRequestBuilders.put(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(invalid)))
                .andDo(print())
                .andExpect(status().isConflict())
                .andExpect(errorType(DATA_ERROR));
    }

    @Test
    @Transactional(propagation = Propagation.NEVER)
    void createDuplicateEmail() throws Exception {
        Employee invalid = new Employee(null, "Invalid", "Invalidov", EMPLOYEE1.getEmail(), "12345678901");
        mockMvc.perform(MockMvcRequestBuilders.post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(invalid)))
                .andDo(print())
                .andExpect(status().isConflict())
                .andExpect(errorType(DATA_ERROR));
    }
}

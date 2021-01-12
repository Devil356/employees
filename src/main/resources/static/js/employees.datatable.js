var employeeAjaxUrl = "rest/"

//TODO: create description
var ctx = {
    ajaxUrl: employeeAjaxUrl,
    updateTable: function () {
        $.ajax({
            type: "GET",
            url: employeeAjaxUrl + "filter",
            data: $("#filter").serialize()
        }).done(updateTableByData);
    }
}

/**
 * Создание таблицы. Отрисовка кнопок редактирования и удаления происходит
 * в общем для всех таблиц файле (employees.common.js).
 * Основная конфигурация (источник данных, пагинация) расположена в
 * файле (employees.common.js)
 */
function drawTable() {
    makeEditable({
        "columns": [
            {"data": "name"},
            {"data": "lastname"},
            {"data": "email"},
            {"data": "phoneNumber"},
            {
                "defaultContent": "",
                "orderable": false,
                "render": renderEditBtn
            },
            {
                "defaultContent": "",
                "orderable": false,
                "render": renderDeleteBtn
            }
        ]
    })
}

//TODO: create description
function clearFilter() {
    $("#filter")[0].reset();
    $.get(mealAjaxUrl, updateTableByData);
}

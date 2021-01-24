DROP TABLE IF EXISTS history;
DROP TABLE IF EXISTS employee;
DROP SEQUENCE IF EXISTS history_seq;
DROP SEQUENCE IF EXISTS employee_seq;

CREATE SEQUENCE employee_seq START WITH 100000;
CREATE SEQUENCE history_seq START WITH 100000;

CREATE TABLE employee
(
    id           BIGINT PRIMARY KEY DEFAULT nextval('employee_seq'),
    name         VARCHAR                          NOT NULL,
    lastname     VARCHAR                          NOT NULL,
    email        VARCHAR                          NOT NULL,
    phone_number VARCHAR                          NOT NULL,
    edit_time    TIMESTAMP          DEFAULT now() NOT NULL
);

CREATE UNIQUE INDEX employee_unique_email_idx ON employee (email);

CREATE TABLE history
(
    id           BIGINT PRIMARY KEY DEFAULT nextval('history_seq'),
    employee_id  BIGINT    NOT NULL,
    name         VARCHAR   NOT NULL,
    lastname     VARCHAR   NOT NULL,
    email        VARCHAR   NOT NULL,
    phone_number VARCHAR   NOT NULL,
    edit_time    TIMESTAMP NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES employee (id) ON DELETE CASCADE
);
--
--
-- TRIGGER INSERT
CREATE OR REPLACE FUNCTION new_employee()
    RETURNS TRIGGER
AS
$$
BEGIN
    INSERT INTO history(employee_id, name, lastname, email, phone_number, edit_time)
    VALUES (NEW.id, NEW.name, NEW.lastname, NEW.email, NEW.phone_number, NEW.edit_time);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;
DROP TRIGGER IF EXISTS tr_new_employee ON employee;
CREATE TRIGGER tr_new_employee
    AFTER INSERT
    ON employee
    FOR EACH ROW
EXECUTE PROCEDURE new_employee();
--
--
-- TRIGGER UPDATE
DROP TRIGGER IF EXISTS tr_update_employee ON employee;
CREATE TRIGGER tr_update_employee
    AFTER UPDATE
    ON employee
    FOR EACH ROW
EXECUTE PROCEDURE new_employee();
--
--
-- TRIGGER DELETE
CREATE OR REPLACE FUNCTION delete_employee()
    RETURNS TRIGGER
AS
$$
BEGIN
    DELETE FROM history WHERE employee_id = OLD.id;
    RETURN OLD;
END;
$$ LANGUAGE plpgsql;
DROP TRIGGER IF EXISTS tr_delete_employee ON employee;
CREATE TRIGGER tr_delete_employee
    AFTER DELETE
    ON employee
    FOR EACH ROW
EXECUTE PROCEDURE delete_employee();


DROP TABLE IF EXISTS employee;
DROP SEQUENCE IF EXISTS employee_seq;

CREATE SEQUENCE employee_seq START WITH 100000;

CREATE TABLE employee
(
    id           BIGINT PRIMARY KEY DEFAULT nextval('employee_seq'),
    name         VARCHAR NOT NULL,
    lastname     VARCHAR NOT NULL,
    email        VARCHAR NOT NULL,
    phone_number VARCHAR NOT NULL,
    edit_time TIMESTAMP default now() NOT NULL
);

CREATE UNIQUE INDEX employee_unique_email_idx ON employee (email);
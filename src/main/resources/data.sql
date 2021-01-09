DELETE
FROM employee;
ALTER SEQUENCE employee_seq RESTART WITH 100000;

INSERT INTO employee (name, lastname, email, phone_number)
VALUES ('Работник1', 'Работников1', 'rabotnik1@gmail.com', '89995848391'),
       ('Работник2', 'Работников2', 'rabotnik2@gmail.com', '89995848392'),
       ('Работник3', 'Работников3', 'rabotnik3@gmail.com', '89995848393'),
       ('Работник4', 'Работников4', 'rabotnik4@gmail.com', '89995848394'),
       ('Работник5', 'Работников5', 'rabotnik5@gmail.com', '89995848395'),
       ('Работник6', 'Работников6', 'rabotnik6@gmail.com', '89995848396'),
       ('Работник7', 'Работников7', 'rabotnik7@gmail.com', '89995848397'),
       ('Работник8', 'Работников8', 'rabotnik8@gmail.com', '89995848398'),
       ('Работник9', 'Работников9', 'rabotnik9@gmail.com', '89995848399');
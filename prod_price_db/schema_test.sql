drop schema testdb CASCADE;

CREATE SCHEMA testdb;

CREATE TABLE testdb.students
(
    id bigint GENERATED ALWAYS AS IDENTITY,
    age int NOT NULL,
    name VARCHAR(100),
    PRIMARY KEY (id)
);

CREATE TABLE testdb.assignments
(
    id INT GENERATED ALWAYS AS IDENTITY,
    grade int,
    name VARCHAR(100),
    student_id INT NOT NULL REFERENCES testdb.students(id),
    PRIMARY KEY (id)
);

INSERT INTO testdb.students(age, name) VALUES (21,'pesho');
INSERT INTO testdb.students(age, name) VALUES (34,'gosho');
INSERT INTO testdb.students(age, name) VALUES (12,'tosho');
INSERT INTO testdb.students(age, name) VALUES (2,'konio');
INSERT INTO testdb.students(age, name) VALUES (43,'valnio');
 
INSERT INTO testdb.assignments(grade, name, student_id) VALUES (100,'sf',1);
INSERT INTO testdb.assignments(grade, name, student_id) VALUES (80,'dfg',1);
INSERT INTO testdb.assignments(grade, name, student_id) VALUES (65,'dfg',1);
INSERT INTO testdb.assignments(grade, name, student_id) VALUES (34,'dffgewr',2);
INSERT INTO testdb.assignments(grade, name, student_id) VALUES (54,'werwe',2);
INSERT INTO testdb.assignments(grade, name, student_id) VALUES (23,'fdgbd',3);

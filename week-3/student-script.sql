DROP TABLE IF EXISTS students;

CREATE TABLE students (
	--This is a comment
	-- When creating a table, we need to specify the columns that we want
	-- The format is <column_name> <data type>
	student_id SERIAL PRIMARY KEY,
	student_first_name VARCHAR(255) NOT NULL,
	student_last_name VARCHAR(255) NOT NULL,
	student_classification VARCHAR(20) NOT NULL,
	student_age INTEGER NOT NULL
);

INSERT INTO students
	(student_first_name, student_last_name, student_classification,student_age)
VALUES 
	('John', 'Doe', 'Freshman', 18),
	('Jane', 'Doe', 'Senior', 22);
	

-- grades table
DROP TABLE IF EXISTS grades;

CREATE TABLE grades (
	grade_id SERIAL PRIMARY KEY,
	grade INTEGER NOT NULL,
	assignment_name VARCHAR(100) NOT NULL,
	student_id INTEGER NOT NULL,
	
	CONSTRAINT fk_student FOREIGN KEY(student_id)
		REFERENCES students(student_id)
);

INSERT INTO grades (grade, assignment_name, student_id)
VALUES
(85, 'homework 1.1', 1),
(90, 'homework 1.1', 2),
(93, 'homework 1.2', 1),
(92, 'homework 1.2', 2);

SELECT *
FROM grades

DELETE FROM grades 
WHERE student_id = 1;

DELETE FROM students 
WHERE student_id = 1;


SELECT *
FROM students

SELECT *
From grades

DELETE FROM grades 
WHERE grade_id = 3;

DELETE FROM grades 
WHERE grade_id = 4;

INSERT INTO grades (grade, assignment_name, student_id)
VALUES (100, 'Midterm 1', 1);

SELECT student_first_name, LENGTH(student_first_name),
FROM students;

SELECT AVG(student_age)
FROM students;

SELECT *
FROM grades;

INSERT INTO grades (grade, assignment_name, student_id)
VALUES 
(70, 'Homework 1.3', 1),
(75, 'Homework 1.3', 2),
(70, 'Midterm 2', 1),
(80, 'Midterm 2', 2);

SELECT AVG(grade)
FROM grades;

SELECT assignment_name, AVG(grade)
FROM grades 
GROUP BY assignment_name
HAVING AVG(grade) > 80;

SELECT *
FROM students s 
INNER JOIN grades g 
ON s.student_id = g.student_id;

SELECT s.student_first_name, g.assignment_name, AVG(grade)
FROM students s 
INNER JOIN grades g 
ON s.student_id = g.student_id
GROUP BY s.student_first_name, g.assignment_name;

SELECT *
FROM grades 
ORDER BY grade;

SELECT *
FROM grades 
ORDER BY grade DESC;









SELECT *
FROM students;

SELECT student_id, student_first_name, student_last_name
FROM students;

SELECT *
FROM students
WHERE student_id = 1;

UPDATE students 
	SET student_first_name = 'Megan',
		student_last_name  = 'Doe',
		student_classification = 'Sophmore',
		student_age = '19'
WHERE 
student_id = 3;
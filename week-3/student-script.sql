CREATE TABLE students (
	--This is a comment
	-- When creating a table, we need to specify the columns that we want
	-- The format is <column_name> <data type>
	student_id INTEGER PRIMARY KEY,
	student_first_name VARCHAR(255) NOT NULL,
	student_last_name VARCHAR(255) NOT NULL,
	student_classification VARCHAR(20) NOT NULL,
	student_age INTEGER NOT NULL
);

INSERT INTO students
	(student_id, student_first_name, student_last_name, student_classification,student_age)
VALUES 
	(1,'John', 'Doe', 'Freshman', 18),
	(2,'Jane', 'Doe', 'Senior', 22);
	
SELECT *
FROM students;

SELECT student_id, student_first_name, student_last_name
FROM students;

SELECT *
FROM students
WHERE student_id = 2
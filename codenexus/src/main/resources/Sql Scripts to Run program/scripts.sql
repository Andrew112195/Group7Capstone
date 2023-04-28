
INSERT INTO user_type (type_name) VALUES ('Student');
INSERT INTO user_type (type_name) VALUES ('Instructor');
INSERT INTO user_type (type_name) VALUES ('Admin');
INSERT INTO course (id, description ,price,title) VALUES ('1','The aim of the course is to teach the basic concepts of programing and develop problem-solving and critical thinking skills in children', 14, 'Intro to programming');
INSERT INTO course (id,description,price,title) VALUES ('2',' This course teaches children the basics of the Java programming language in a simple and interactive manner.', 18, 'Introduction to Java');
INSERT INTO course (id,description, price,title) VALUES ('3','This course teaches children the fundamentals of the Python programming language through tasks',132,'Introduction to Python');
INSERT INTO user_entity(id, user_type_id, first_name, last_name, email, username, password) VALUES ('999', '1', 'Andrew', 'Shapiro','and@hello.com','and' ,'$2a$10$xu41RsOhK8clSXnovXBDR.OqwaxQw6JEZ/rFheGyKXw2L1w4oTeai');
INSERT INTO user_entity(id, user_type_id, first_name, last_name, email, username, password) VALUES ('995', '1', 'Berly', 'Paul','berl@hello.com', 'berl' ,'$2a$10$xu41RsOhK8clSXnovXBDR.OqwaxQw6JEZ/rFheGyKXw2L1w4oTeai');
INSERT INTO user_entity(id, user_type_id, first_name, last_name, email, username, password) VALUES ('996', '2', 'Mary', 'Ramirez','Mary@hello.com','mar' ,'$2a$10$xu41RsOhK8clSXnovXBDR.OqwaxQw6JEZ/rFheGyKXw2L1w4oTeai');
INSERT INTO user_entity(id, user_type_id, first_name, last_name, email, username, password) VALUES ('997', '2', 'Deland', 'Patrice','pat@hello.com', 'pat' ,'$2a$10$xu41RsOhK8clSXnovXBDR.OqwaxQw6JEZ/rFheGyKXw2L1w4oTeai');
INSERT INTO user_entity(id, user_type_id, first_name, last_name, email, username, password) VALUES ('998', '2', 'Alexander', 'Justiniano','alex@hello.com','ale' ,'$2a$10$xu41RsOhK8clSXnovXBDR.OqwaxQw6JEZ/rFheGyKXw2L1w4oTeai');
INSERT INTO user_entity(id, user_type_id, first_name, last_name, email, username, password) VALUES ('994', '1', 'Matt', 'Arias','matt@hello.com', 'matt' ,'$2a$10$xu41RsOhK8clSXnovXBDR.OqwaxQw6JEZ/rFheGyKXw2L1w4oTeai');

INSERT INTO user_course(progress, course_id, user_id) VALUES ('1', '1', '999');
INSERT INTO user_course(progress, course_id, user_id) VALUES ('1', '2', '999');
INSERT INTO user_course(progress, course_id, user_id) VALUES ('1', '1', '995');
INSERT INTO user_course(progress, course_id, user_id) VALUES ('1', '2', '995');
INSERT INTO user_course(progress, course_id, user_id) VALUES ('1', '3', '995');
INSERT INTO user_course(progress, course_id, user_id) VALUES ('1', '2', '997');
INSERT INTO user_course(progress, course_id, user_id) VALUES ('1', '3', '996');
INSERT INTO user_course(progress, course_id, user_id) VALUES ('1', '3', '998');
INSERT INTO user_course(progress, course_id, user_id) VALUES ('1', '3', '995');
INSERT INTO user_course(progress, course_id, user_id) VALUES ('1', '2', '994');
INSERT INTO user_course(progress, course_id, user_id) VALUES ('1', '3', '996');
INSERT into messages_entity(read, header, body, sender, recipient, time_sent) values ('false', 'Important Meeting', 'I am writing to inform you about an important meeting that has been scheduled for tomorrow at 2pm. The meeting will take place at room 1532, and it is of utmost importance that you attend.', '999', '995', '2023-03-14 16:24:38.155');
INSERT into messages_entity(read, header, body, sender, recipient, time_sent) values ('false', 'Follow-up on Project 2', 'As you may recall, we had set a deadline for completion of this project for next week. I wanted to check in and see how the project is progressing and whether there are any roadblocks or issues that need to be addressed.', '999', '995', '2023-02-14 12:24:38.155');
INSERT into messages_entity(read, header, body, sender, recipient, time_sent) values ('false', 'Training/Workshops', 'I am writing to remind you of the upcoming training/workshop session on Java Programming, which will be held on June 23rd at 1:00pm at room 102.', '995', '998', '2023-04-10 16:00:00.155');
INSERT into messages_entity(read, header, body, sender, recipient, time_sent) values ('false', 'Homework Documentation', 'Hello, I just post the documentation of the assingment 3. Please let me know if you can see it.', '995', '997', '2023-04-14 16:24:38.155');
INSERT into messages_entity(read, header, body, sender, recipient, time_sent) values ('false', 'Homework 4', 'Hello, I just uploaded the homework 4. Please check it.', '995', '996', '2023-04-11 13:24:38.155');
INSERT into messages_entity(read, header, body, sender, recipient, time_sent) values ('false', 'New Project Proposal', 'Hi, I have a new project proposal for the final project. Let me know when you are available to discuss the idea.', '999', '995', '2023-04-11 13:24:38.155');
INSERT into messages_entity(read, header, body, sender, recipient, time_sent) values ('false', 'Follow-up on Task 1', 'I am writing to follow up on the progress of task 1, which we had discussed earlier. I wanted to check in and see how the project is progressing.', '999', '994', '2023-04-11 13:24:38.155');
INSERT into messages_entity(read, header, body, sender, recipient, time_sent) values ('false', 'Feedback/Reviews', 'Hi, I just want to remind you that the homework feedback is available. ', '995', '999', '2023-04-11 13:24:38.155');
INSERT into messages_entity(read, header, body, sender, recipient, time_sent) values ('false', 'Follow-up on Project 2', 'Hello, I am writing to follow up on the progress of Project 2, which we had discussed earlier.  I wanted to check in and see how the project is progressing.', '996', '999','2023-04-11 13:24:38.155');
INSERT INTO module(course_id, name, description, module_complete) VALUES(1, 'Attributes', 'An attribute is a characteristic or property of an object that describes its state or behavior. Attributes are used to store data associated with an object, such as its size, color, or position, 
and can also be used to define its behavior.', 'false');
INSERT INTO module(course_id, name, description, module_complete) VALUES(1, 'Variables', 'Variables are used to store data values that can be accessed and modified throughout the code. A variable has a name, which is used to refer to the value it stores. 
Variables can store various types of data, such as numbers, strings, and Boolean values', 'false');
INSERT INTO module(course_id, name, description, module_complete) VALUES(1, 'Loops', 'In programming, loops are used to execute a block of code repeatedly, a fixed number of times or when a condition is met. Loops are used to iterate over a collection of data, such as an array,
 and perform the same operation on each element', 'false');
INSERT INTO module(course_id, name, description, module_complete) VALUES(2, 'Java Loops', 'Java supports three loops:for, while, and do-while. A for loop is used to execute a block of code a fixed number of times. A while loop is used to execute a block of code repeatedly until a certain condition is met.', 'false');
INSERT INTO module(course_id, name, description, module_complete) VALUES(2, 'Java Objects', 'In Java, an object is an instance of a class that encapsulates data and behavior into a single entity. An object is created from a class using the "new" keyword and can then be used to invoke the methods defined by the class', 'false');
INSERT INTO module(course_id, name, description, module_complete) VALUES(2, 'Java arrays', 'An array is a collection of data items of the same type, stored in a contiguous block of memory. Arrays are used to store and manipulate large amounts of data efficiently and effectively.', 'false');
INSERT INTO module(course_id, name, description, module_complete) VALUES(3, 'Python variables', 'A variable is a name that refers to a value or an object in memory. Variables store data and can be of various types, including numbers, strings, lists, tuples, and dictionaries. Unlike some other programming languages, 
Python is dynamically typed', 'false');
INSERT INTO module(course_id, name, description, module_complete) VALUES(3, 'Python lists', 'A list is a mutable data structure that stores a collection of related items or values. Lists can contain any type of data, including numbers, strings, and other lists, and can be of any length. 
Lists are created using square brackets.', 'false');
INSERT INTO module(course_id, name, description, module_complete) VALUES(3, 'Python strings', 'String is a sequence of characters that represents text. Strings are enclosed in quotation marks. Strings are immutable, so once a string is created, its value cannot be changed. 
You can create a new string by concatenating or slicing existing strings', 'false');
INSERT INTO task (module_id, task_name, question, answer, difficulty_level, complete, is_correct)
VALUES (1, 'Coding Attribute', 'Which of the following is an example of a coding attribute?','Font size', 1, false, false);
INSERT INTO task (module_id, task_name, question, answer, difficulty_level, complete, is_correct)
VALUES (1, 'HTML tags', 'Which of the following HTML tags is used for creating a hyperlink?', '<a>', 2, false, false);
INSERT INTO task (module_id, task_name, question, answer, difficulty_level, complete, is_correct)
VALUES (2, 'Storing Variables', 'Which of the following data types is used to store whole numbers in programming?', 'integer', 3, false, false);
INSERT INTO task (module_id, task_name, question, answer, difficulty_level, complete, is_correct)
VALUES (2, 'Variable naming', 'Which of the following is an example of a valid variable name in programming?', 'my_name', 2, false, false);
INSERT INTO task (module_id, task_name, question, answer, difficulty_level, complete, is_correct)
VALUES (3, 'Understanding loops', 'Which of the following loop structures executes a block of code at least once, regardless of whether the condition is true or false?', 'do-while loop', 3, false, false);
INSERT INTO task (module_id, task_name, question, answer, difficulty_level, complete, is_correct)
VALUES (3, 'Understanding loops 2', 'What is the purpose of the break keyword in a loop?', 'to exit the loop immediately', 3, false, false);
INSERT INTO task (module_id, task_name, question, answer, difficulty_level, complete, is_correct) 
VALUES (4, 'Java do-while loop', 'What is the output of the following Java code snippet?\n\nint i = 5;\ndo {\n System.out.print(i + " ");\n i--;\n} while (i > 0);', 'A) 5 4 3 2 1', 2, false, false);
INSERT INTO task (module_id, task_name, question, answer, difficulty_level, complete, is_correct)
VALUES (4, 'Java do-while loop 2', 'What is the output of the following code snippet: \n int i = 0;\n do {\n i++;\n } while (i < 5);\n System.out.println(i);', '5', 1, false, false);
INSERT INTO task (module_id, task_name, question, answer, difficulty_level, complete, is_correct)
VALUES (5, 'Java object constructor','What is the purpose of a constructor in Java?', 'to initialize the state of an object', 1, false, false);
INSERT INTO task (module_id, task_name, question, answer, difficulty_level, complete, is_correct)
VALUES (5, 'Java object class', 'Which of the following is an example of a class in Java?', 'String', 1, false, false);
INSERT INTO task (module_id, task_name, question, answer, difficulty_level, complete, is_correct)
VALUES (6, 'Java array index','What is the index of the first element in a Java array?', '0', 1, false, false);
INSERT INTO task (module_id, task_name, question, answer, difficulty_level, complete, is_correct) 
VALUES (6, 'Java array length', 'What is the purpose of the "length" property in a Java array?', 'to return the number of elements in the array', 2, false, false);
INSERT INTO task (module_id, task_name, question, answer, difficulty_level, complete, is_correct)
VALUES (7, 'Python variable', 'Which of the following data types is used to store a single character in Python?', 'string', 1, false, false);
INSERT INTO task (module_id, task_name, question, answer, difficulty_level, complete, is_correct)
VALUES (7, 'Python variable assignment','What is the correct way to assign a value to multiple variables at once in Python?', 'x = y = 10', 1, false, false);
INSERT INTO task (module_id, task_name, question, answer, difficulty_level, complete, is_correct)
VALUES (8, 'Python new list', 'What is the syntax for creating an empty list in Python?', 'myList = []', 1, false, false);
INSERT INTO task (module_id, task_name, question, answer, difficulty_level, complete, is_correct)
VALUES (8, 'Python access list','How do you access the last element in a Python list?', 'myList[-1]', 1, false, false);
INSERT INTO task (module_id, task_name, question, answer, difficulty_level, complete, is_correct)
VALUES (9, 'Python string array', 'Which of the following is a correct way to access a character in a Python string?', 'myString[index]', 1, false, false);
INSERT INTO task (module_id, task_name, question, answer, difficulty_level, complete, is_correct)
VALUES (9, 'Python string concatenate','What is the correct way to concatenate two strings in Python?', 'string1 + string2', 1, false, false);


SELECT * from user_entity;
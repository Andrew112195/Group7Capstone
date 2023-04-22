
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
INSERT INTO module(course_id, name, description, module_complete) VALUES(1, 'Loop', 'Do the loop', 'false');
INSERT INTO module(course_id, name, description, module_complete) VALUES(2, 'attributes', 'values and stuff', 'false');
INSERT INTO task (module_id, question, answer, difficulty_level, complete, is_correct)
VALUES (1, 'What is the output of the following code? \n\n int x = 5; \n System.out.println(x++); \n System.out.println(++x);', '6 \n 7', 1, false, false);
INSERT INTO task (module_id, question, answer, difficulty_level, complete, is_correct)
VALUES (1, 'What is the output of the following code? \n\n for(int i=0; i<5; i++) { \n   System.out.println(i); \n }', '0 \n 1 \n 2 \n 3 \n 4', 2, false, false);
INSERT INTO task (module_id, question, answer, difficulty_level, complete, is_correct)
VALUES (1, 'What is the output of the following code? \n\n String s = "Hello"; \n System.out.println(s.charAt(1));', 'e', 3, false, false);

SELECT * from user_entity;
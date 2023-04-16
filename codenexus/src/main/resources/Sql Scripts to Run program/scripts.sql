INSERT INTO course (id, description ,price,title) VALUES ('1','fun', 14, 'funtimes');
INSERT INTO course (id,description,price,title) VALUES ('2','very fun', 18, 'awesome times');
INSERT INTO course (id,description, price,title) VALUES ('3','very expensive',132,'tough times');
INSERT INTO user_type (type_name) VALUES ('Student');
INSERT INTO user_type (type_name) VALUES ('Instructor');
INSERT INTO user_type (type_name) VALUES ('Admin');
INSERT INTO user_entity(id, user_type_id, first_name, last_name, email, username, password) VALUES ('999', '1', 'Andrew', 'Shapiro','and@hello.com','and' ,'123');
INSERT INTO user_entity(id, user_type_id, first_name, last_name, email, username, password) VALUES ('995', '1', 'Berly', 'Paul','berl@hello.com', 'berl' ,'123');
INSERT INTO user_entity(id, user_type_id, first_name, last_name, email, username, password) VALUES ('996', '2', 'Mary', 'Ramirez','Mary@hello.com','mar' ,'123');
INSERT INTO user_entity(id, user_type_id, first_name, last_name, email, username, password) VALUES ('997', '2', 'Deland', 'Patrice','pat@hello.com', 'pat' ,'123');
INSERT INTO user_entity(id, user_type_id, first_name, last_name, email, username, password) VALUES ('998', '2', 'Alexander', 'Justiniano','alex@hello.com','ale' ,'123');
INSERT INTO user_entity(id, user_type_id, first_name, last_name, email, username, password) VALUES ('994', '1', 'Matt', 'Arias','matt@hello.com', 'matt' ,'123');
INSERT INTO user_entity(user_type_id, first_name, last_name, email, username, password) VALUES (1, 'test', 'test','matt@hello.com', 'test' ,'test');
INSERT INTO user_entity(user_type_id, first_name, last_name, email, username, password) VALUES (2, 'admin', 'admin','matt@hello.com', 'admin' ,'admin');

INSERT INTO user_course(progress, course_id, user_id) VALUES ('1', '1', '999');
INSERT INTO user_course(progress, course_id, user_id) VALUES ('1', '2', '999');
INSERT INTO user_course(progress, course_id, user_id) VALUES ('1', '3', '999');
INSERT INTO user_course(progress, course_id, user_id) VALUES ('1', '1', '995');
INSERT INTO user_course(progress, course_id, user_id) VALUES ('1', '2', '995');
INSERT INTO user_course(progress, course_id, user_id) VALUES ('1', '3', '995');
INSERT INTO user_course(progress, course_id, user_id) VALUES ('1', '2', '997');
INSERT INTO user_course(progress, course_id, user_id) VALUES ('1', '3', '996');
INSERT INTO user_course(progress, course_id, user_id) VALUES ('1', '3', '998');
INSERT INTO user_course(progress, course_id, user_id) VALUES ('1', '3', '995');
INSERT INTO user_course(progress, course_id, user_id) VALUES ('1', '2', '994');
INSERT INTO user_course(progress, course_id, user_id) VALUES ('1', '3', '996');
INSERT into messages_entity(read, header, body, sender, recipient) values ('false', 'sub', 'text', '999', '995');
INSERT into messages_entity(read, header, body, sender, recipient) values ('false', 'sub', 'text', '999', '995');
INSERT into messages_entity(read, header, body, sender, recipient) values ('false', 'sub', 'text', '995', '998');
INSERT into messages_entity(read, header, body, sender, recipient) values ('false', 'sub', 'text', '995', '997');
INSERT into messages_entity(read, header, body, sender, recipient) values ('false', 'sub', 'text', '995', '996');
INSERT into messages_entity(read, header, body, sender, recipient) values ('false', 'sub', 'text', '999', '995');
INSERT into messages_entity(read, header, body, sender, recipient) values ('false', 'sub', 'text', '999', '994');
INSERT into messages_entity(read, header, body, sender, recipient) values ('false', 'sub', 'text', '995', '999');
INSERT into messages_entity(read, header, body, sender, recipient) values ('false', 'sub', 'text', '996', '999');
INSERT INTO module(course_id, name, description, module_complete) VALUES(1, 'Loop', 'Do the loop', 'false');

INSERT INTO module(course_id, name, description, module_complete) VALUES(2, 'attributes', 'values and stuff', 'false');

INSERT INTO task (module_id, question, answer, difficulty_level, complete, is_correct)
VALUES (1, 'What is the output of the following code? \n\n int x = 5; \n System.out.println(x++); \n System.out.println(++x);', '6 \n 7', 1, false, false);

INSERT INTO task (module_id, question, answer, difficulty_level, complete, is_correct)
VALUES (1, 'What is the output of the following code? \n\n for(int i=0; i<5; i++) { \n   System.out.println(i); \n }', '0 \n 1 \n 2 \n 3 \n 4', 2, false, false);

INSERT INTO task (module_id, question, answer, difficulty_level, complete, is_correct)
VALUES (1, 'What is the output of the following code? \n\n String s = "Hello"; \n System.out.println(s.charAt(1));', 'e', 3, false, false);


SELECT * from user_entity;
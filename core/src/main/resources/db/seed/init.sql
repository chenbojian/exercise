INSERT INTO multiple_choice(content) VALUES("this answer is 1?");
INSERT INTO multiple_choice(content) VALUES("this answer is 2?");
INSERT INTO multiple_choice(content) VALUES("this answer is 3?");
INSERT INTO multiple_choice(content) VALUES("this answer is 4?");
INSERT INTO multiple_choice(content) VALUES("this answer is 5?");

INSERT INTO multiple_choice_selection(multiple_choice_id, content, is_answer, description) VALUES (1,"select 1",1,NULL);
INSERT INTO multiple_choice_selection(multiple_choice_id, content, is_answer, description) VALUES (1,"select 2",0,NULL);
INSERT INTO multiple_choice_selection(multiple_choice_id, content, is_answer, description) VALUES (1,"select 3",0,NULL);
INSERT INTO multiple_choice_selection(multiple_choice_id, content, is_answer, description) VALUES (1,"select 4",0,NULL);
INSERT INTO multiple_choice_selection(multiple_choice_id, content, is_answer, description) VALUES (2,"select 1",0,NULL);
INSERT INTO multiple_choice_selection(multiple_choice_id, content, is_answer, description) VALUES (2,"select 2",1,NULL);
INSERT INTO multiple_choice_selection(multiple_choice_id, content, is_answer, description) VALUES (2,"select 3",0,NULL);
INSERT INTO multiple_choice_selection(multiple_choice_id, content, is_answer, description) VALUES (2,"select 4",0,NULL);
INSERT INTO multiple_choice_selection(multiple_choice_id, content, is_answer, description) VALUES (3,"select 1",0,NULL);
INSERT INTO multiple_choice_selection(multiple_choice_id, content, is_answer, description) VALUES (3,"select 3",1,NULL);
INSERT INTO multiple_choice_selection(multiple_choice_id, content, is_answer, description) VALUES (4,"select 1",0,NULL);
INSERT INTO multiple_choice_selection(multiple_choice_id, content, is_answer, description) VALUES (4,"select 4",1,NULL);
INSERT INTO multiple_choice_selection(multiple_choice_id, content, is_answer, description) VALUES (5,"select 1",0,NULL);
INSERT INTO multiple_choice_selection(multiple_choice_id, content, is_answer, description) VALUES (5,"select 5",1,NULL);


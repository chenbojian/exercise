CREATE TABLE multiple_choice_selection (
id INT NOT NULL auto_increment,
multiple_choice_id INT NOT NULL,
content VARCHAR(300),
is_answer INT,
description VARCHAR(800),
PRIMARY KEY (id),
FOREIGN KEY (multiple_choice_id) REFERENCES multiple_choice(id)
);

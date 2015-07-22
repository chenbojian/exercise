CREATE TABLE multiple_choice_of_quiz (
id INT NOT NULL auto_increment,
quiz_id INT NOT NULL,
multiple_choice_id INT NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (quiz_id) REFERENCES quiz(id),
FOREIGN KEY (multiple_choice_id) REFERENCES multiple_choice(id)
);

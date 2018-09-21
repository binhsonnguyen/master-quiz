CREATE TABLE Test
(
  id bigint PRIMARY KEY AUTO_INCREMENT,
  descriptions varchar(255),
  name varchar(255) NOT NULL
);

CREATE TABLE TestQuestion
(
  id bigint PRIMARY KEY AUTO_INCREMENT,
  content varchar(255) NOT NULL,
  descriptions varchar(255),
  hint varchar(255),
  orderRelevance bit DEFAULT false ,
  weight int,
  testId bigint,
  CONSTRAINT TestQuestion_Test_id_fk FOREIGN KEY (testId) REFERENCES Test (id)
);

CREATE INDEX TestQuestion_testId_index ON TestQuestion (testId);

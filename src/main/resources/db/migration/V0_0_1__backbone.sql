CREATE TABLE Test
(
  id           BIGINT PRIMARY KEY AUTO_INCREMENT,
  descriptions VARCHAR(255),
  name         VARCHAR(255) NOT NULL
);

CREATE TABLE TestQuestion
(
  id             BIGINT PRIMARY KEY AUTO_INCREMENT,
  content        VARCHAR(255) NOT NULL,
  descriptions   VARCHAR(255),
  hint           VARCHAR(255),
  orderRelevance BIT                DEFAULT FALSE,
  weight         INT,
  testId         BIGINT,
  CONSTRAINT TestQuestion_Test_id_fk FOREIGN KEY (testId) REFERENCES Test (id)
);

CREATE INDEX TestQuestion_testId_index
  ON TestQuestion (testId);

CREATE TABLE `User`
(
  id        BIGINT PRIMARY KEY AUTO_INCREMENT,
  email     VARCHAR(255) NOT NULL,
  firstName VARCHAR(255),
  midName   VARCHAR(255),
  lastName  VARCHAR(255),
  address   VARCHAR(255),
  phone     VARCHAR(255)
);

CREATE TABLE `UsernamePasswordCredential`
(
  id       BIGINT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255),
  user_id  BIGINT       NOT NULL,
  CONSTRAINT `UsernamePasswordCredential_User_id_fk` FOREIGN KEY (user_id) REFERENCES `User` (id)
);

CREATE INDEX `UsernamePasswordCredential_user_id_index`
  ON `UsernamePasswordCredential` (user_id);

INSERT INTO `User` (email, firstName, midName, lastName, address, phone)
VALUES ('son@codegym.vn', 'Nguyen', 'Binh', 'Son', 'ham nghi', '0834181288');

INSERT INTO `User` (email, firstName, midName, lastName, address, phone)
VALUES ('van@codegym.vn', 'Van', NULL, 'Ha', 'ham nghi', '0834181288');

INSERT INTO `User` (email, firstName, midName, lastName, address, phone)
VALUES ('kieuanh@codegym.vn', 'Vu', 'Thi', 'Kieu Anh', 'ham nghi', '0834181288');

INSERT INTO `User` (email, firstName, midName, lastName, address, phone)
VALUES ('hang@codegym.vn', 'Hang', NULL, 'Le', 'Ham Nghi', '0834181288');

INSERT INTO UsernamePasswordCredential (username, password, user_id)
VALUES ('sonnb', '123456', 1);

INSERT INTO UsernamePasswordCredential (username, password, user_id)
VALUES ('vanha', '123456', 2);

INSERT INTO UsernamePasswordCredential (username, password, user_id)
VALUES ('kieuanh', '123456', 3);

INSERT INTO UsernamePasswordCredential (username, password, user_id)
VALUES ('hang', '123456', 4);

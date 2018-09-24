RENAME TABLE
    `Test` TO `Quiz`;

RENAME TABLE
    `TestQuestion` TO `Question`;

ALTER TABLE `Question`
  DROP FOREIGN KEY `TestQuestion_Test_id_fk`;

ALTER TABLE Question
  CHANGE `testId` `quiz_id` BIGINT,
  ADD CONSTRAINT `Question_Quiz_id_fk` FOREIGN KEY (`quiz_id`) REFERENCES `Quiz` (`id`),
  RENAME INDEX `TestQuestion_testId_index` TO `Question_quizId_index`;

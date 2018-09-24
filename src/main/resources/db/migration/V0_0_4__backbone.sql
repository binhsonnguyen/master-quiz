INSERT INTO `Test` (id, descriptions, name)
VALUES (1, 'For the end of prepare module', 'Prepare Quiz');

INSERT INTO `Test` (id, descriptions, name)
VALUES (2, 'For the end of PF-JAVA module', 'PF-JAVA Quiz');

INSERT INTO `Test` (id, descriptions, name)
VALUES (3, 'For the end of WBD-JAVA module', 'WBD-JAVA Quiz');

INSERT INTO `TestQuestion` (content, descriptions, hint, orderRelevance, weight, testId)
VALUES ('what is the value of `x`?', 'let student use their knowledge about operators', 'choose One', FALSE, 1, 1);

INSERT INTO `TestQuestion` (content, descriptions, hint, orderRelevance, weight, testId)
VALUES ('is javascript case sensivity?', '', 'choose One', FALSE, 1, 1);

INSERT INTO `TestQuestion` (content, descriptions, hint, orderRelevance, weight, testId)
VALUES ('which was naming correctly in javascript?', '', 'choose One', FALSE, 1, 1);

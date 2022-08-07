DROP TABLE if EXISTS `user`;

CREATE TABLE `user`
(
    id   int AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50)
);

INSERT INTO `user` (name)
VALUES ('one');
INSERT INTO `user` (name)
VALUES ('two');
INSERT INTO `user` (name)
VALUES ('three');
INSERT INTO `user` (name)
VALUES ('four');
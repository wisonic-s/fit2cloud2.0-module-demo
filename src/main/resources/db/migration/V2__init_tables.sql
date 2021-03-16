CREATE TABLE IF NOT EXISTS `cache_flavor`
(
    `id`             varchar(100) NOT NULL,
    `workspace`      varchar(100)                                                  DEFAULT NULL,
    `instance_type`  varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
    `engine`         varchar(100)                                                  DEFAULT NULL,
    `engine_version` varchar(100)                                                  DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci
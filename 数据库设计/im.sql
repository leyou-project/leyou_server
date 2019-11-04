DROP TABLE IF EXISTS `t_group`;
CREATE TABLE `t_group`  (
  `id` bigint(20) NOT NULL,
  `group_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '群聊名称',
  `owner` int(11) NULL DEFAULT NULL COMMENT '群主uid',
  `update_time` bigint(20) NULL DEFAULT NULL,
  `create_time` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '聊天群表' ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `t_group_user`;
CREATE TABLE `t_group_user`  (
  `id` bigint(20) NOT NULL,
  `uid` int(11) NULL DEFAULT NULL,
  `group_id` bigint(20) NULL DEFAULT NULL,
  `update_time` bigint(20) NULL DEFAULT NULL,
  `create_time` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '群组-用户关联表' ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message`  (
  `id` bigint(20) NOT NULL,
  `to_id` bigint(20) NULL DEFAULT NULL COMMENT '接收者，单发为用户uid，群发为group_id',
  `form_id` int(11) NULL DEFAULT NULL COMMENT '发送者，1为系统公告',
  `type` tinyint(1) NULL DEFAULT NULL COMMENT '类型，1单发，2组发，3广播',
  `title` varchar(55) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标题',
  `content` blob NULL COMMENT '消息内容，最大65K',
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '状态，1未读，2已读，3删除',
  `update_time` bigint(20) NULL DEFAULT NULL,
  `create_time` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '消息表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

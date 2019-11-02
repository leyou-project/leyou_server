DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods`  (
  `id` bigint(20) NOT NULL,
  `goods_name` varchar(55) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品名称',
  `cover_url` varchar(155) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '封面',
  `goods_type` bigint(20) NOT NULL COMMENT '分类id',
  `status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '1上架，2下架，3删除',
  `update_time` int(11) NULL DEFAULT NULL,
  `create_time` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `t_goods_type`;
CREATE TABLE `t_goods_type`  (
  `id` bigint(20) NOT NULL,
  `pid` bigint(20) NOT NULL COMMENT '0代表顶级分类',
  `type_name` varchar(55) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '分类名称',
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '1正常，2禁用',
  `update_time` int(11) NULL DEFAULT NULL,
  `create_time` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `t_goods_style`;
CREATE TABLE `t_goods_style`  (
    `id` bigint(20) NOT NULL,
    `field` varchar(20) NOT NULL COMMENT 'style字段',
    `stock` int(11) NULL DEFAULT NULL COMMENT '库存',
    `status` tinyint(1) NULL DEFAULT NULL COMMENT '1正常，2禁用',
    `bind_id` bigint(20) NOT NULL COMMENT '绑定id',
    `update_time` int(11) NULL DEFAULT NULL,
    `create_time` int(11) NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `t_goods_bind`;
CREATE TABLE `t_goods_bind`  (
    `id` bigint(20) NOT NULL,
    `goods_id` bigint(20) NOT NULL COMMENT '商品id',
    `field` varchar(20) NOT NULL COMMENT 'style字段',
    `status` tinyint(1) NULL DEFAULT NULL COMMENT '1正常，2禁用',
    `update_time` int(11) NULL DEFAULT NULL,
    `create_time` int(11) NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` bigint(20) NOT NULL,
  `uid` int(11) NOT NULL COMMENT '用户id',
  `nick_name` varchar(55) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '昵称',
  `user_name` varchar(55) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `phone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '绑定手机',
  `salt` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码盐',
  `head_img` varchar(55) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '头像',
  `level` int(11) NOT NULL DEFAULT 0 COMMENT '会员等级',
  `signature` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '签名',
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '状态，1正常，0禁用',
  `update_time` int(11) NULL DEFAULT NULL,
  `create_time` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_index_uid`(`uid`) USING BTREE,
  INDEX `user_index_name`(`user_name`) USING BTREE,
  INDEX `user_index_pass`(`password`) USING BTREE,
  INDEX `user_index_salt`(`salt`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `t_user_details`;
CREATE TABLE `t_user_details`  (
  `id` bigint(20) NOT NULL,
  `uid` int(11) NOT NULL COMMENT '用户id',
  `birth` int(11) NULL DEFAULT NULL COMMENT '出生日期时间戳',
  `phone_area` char(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '86' COMMENT '手机区号',
  `country` varchar(55) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '国家',
  `province` varchar(55) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '省份',
  `city` varchar(55) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '城市',
  `last_login` int(11) NULL DEFAULT NULL COMMENT '最后一次登录',
  `update_time` int(11) NULL DEFAULT NULL,
  `create_time` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `t_user_details_uid`(`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

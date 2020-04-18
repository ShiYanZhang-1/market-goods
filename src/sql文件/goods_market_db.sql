/*
 Navicat Premium Data Transfer

 Source Server         : LOCAL8.0.19
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : goods_market_db

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 18/04/2020 21:48:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goods_id` int NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `goods_type_id` int DEFAULT NULL COMMENT '商品类型id',
  `title` varchar(255) DEFAULT NULL COMMENT '商品名称标题',
  `img` varchar(255) DEFAULT NULL COMMENT '图片保存路径',
  `old_price` double(10,2) DEFAULT NULL COMMENT '商品原价',
  `price` double(10,2) DEFAULT NULL COMMENT '现价',
  `on_sale` varchar(255) DEFAULT NULL COMMENT '是否在售 YES 或者NO',
  `detail` mediumtext COMMENT '商品详情',
  `count` int DEFAULT NULL COMMENT '库存',
  `merchant_name` varchar(255) DEFAULT NULL COMMENT '商家名称',
  `evaluation_count` int DEFAULT NULL COMMENT '评价数量',
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
BEGIN;
INSERT INTO `goods` VALUES (36, 3, '小米电视', '/uploadImg/0c3e0604-3213-4d7c-bc77-8d54b8f9e7f3phone.jpeg', 1299.00, 1299.00, 'YES', '<div id=\"J_TabBarBox\"><ul id=\"J_TabBar\"><li tabindex=\"0\" role=\"tab\" aria-selected=\"true\">小米电视热卖</li></ul></div>', 1000, '小米旗舰店', 1000);
INSERT INTO `goods` VALUES (38, 3, '华为智慧屏', '/uploadImg/99ee6c5d-84f7-4a0a-a01e-dde8e7d20dafjd.png', 1111.00, 1111.00, 'YES', '<p>华为就是6666</p>', 1111, '华为旗舰店', 123);
INSERT INTO `goods` VALUES (39, 9, '小鸟洗衣机', '/uploadImg/d7b96a1c-bf52-4e63-957a-bf59e5fd8830jd.png', 123.00, 123.00, 'YES', '<p>小鸟线上旗舰店</p>', 123, '小鸟旗舰店', 123);
INSERT INTO `goods` VALUES (40, 9, '哈哈洗衣机', '/uploadImg/25fde53d-6ca1-41d1-bd22-09917a9190a9phone.jpeg', 123.00, 123.00, 'YES', '<p>哈哈旗舰店</p>', 123, NULL, 123);
INSERT INTO `goods` VALUES (41, 7, '三国演义', '/uploadImg/3a4c4b39-5e11-45f2-8601-310af662dd71phone.jpeg', 10.80, 10.80, 'YES', '<p>世界书籍旗舰店</p>', 123, '世界书籍旗舰店', 123);
INSERT INTO `goods` VALUES (42, 7, '水浒传', '/uploadImg/e5899a1c-f83e-45e3-87f2-4d4c68007c27jd.png', 10.80, 10.80, 'YES', '<p>世界书籍旗舰店</p>', 123, '世界书籍旗舰店', 123);
INSERT INTO `goods` VALUES (43, 7, '红楼梦', '/uploadImg/083eba8b-0711-40c8-94f3-474be33919c5phone.jpeg', 10.80, 10.80, 'YES', '<p>世界书籍旗舰店</p>', 123, '世界书籍旗舰店', 123);
INSERT INTO `goods` VALUES (44, 10, '玫瑰', '/uploadImg/fbdc6477-6518-4ed5-8f81-accd3cf1be64jd.png', 10.00, 9.90, 'YES', '<p>花店开业啦</p>', 1000, '小言花店', 1000);
COMMIT;

-- ----------------------------
-- Table structure for goods_type
-- ----------------------------
DROP TABLE IF EXISTS `goods_type`;
CREATE TABLE `goods_type` (
  `goods_type_id` int NOT NULL AUTO_INCREMENT COMMENT '商品类型id',
  `parent_type_id` int DEFAULT NULL COMMENT '父级类型id',
  `type_name` varchar(255) DEFAULT NULL COMMENT '类型名称',
  `sort` int DEFAULT NULL COMMENT '类型序号，排序',
  `icon_class` varchar(255) DEFAULT NULL COMMENT '图标样式',
  PRIMARY KEY (`goods_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_type
-- ----------------------------
BEGIN;
INSERT INTO `goods_type` VALUES (2, -1, '家用电器', 0, '无');
INSERT INTO `goods_type` VALUES (3, 2, '电视', 1, '');
INSERT INTO `goods_type` VALUES (4, -1, '礼品鲜花', 2, '');
INSERT INTO `goods_type` VALUES (5, -1, '名著书籍', 3, '');
INSERT INTO `goods_type` VALUES (6, -1, '家居用品', 4, '');
INSERT INTO `goods_type` VALUES (7, 5, '小说', 1, '');
INSERT INTO `goods_type` VALUES (8, -1, '生活日常', 5, '');
INSERT INTO `goods_type` VALUES (9, 2, '洗衣机', 2, NULL);
INSERT INTO `goods_type` VALUES (10, 4, '鲜花', 2, '');
INSERT INTO `goods_type` VALUES (11, 2, '厨具', 3, '');
INSERT INTO `goods_type` VALUES (12, 6, '洗漱', 1, '');
COMMIT;

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `order_info_id` int NOT NULL COMMENT '订单详情id',
  `order_id` varchar(0) DEFAULT NULL COMMENT '外键 订单id',
  `erigin_goods_id` int DEFAULT NULL COMMENT '原来商品的id',
  `price` double(10,2) DEFAULT NULL COMMENT '下单时商品的价格',
  `count` int DEFAULT NULL COMMENT '当时这个商品下单数量',
  `img` varchar(255) DEFAULT NULL COMMENT '当时这个商品的图片路径',
  `old_price` double(10,2) DEFAULT NULL COMMENT '下单时的原价',
  PRIMARY KEY (`order_info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_info
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for shop_car
-- ----------------------------
DROP TABLE IF EXISTS `shop_car`;
CREATE TABLE `shop_car` (
  `shop_car_id` int NOT NULL COMMENT '购物车id',
  `user_id` int DEFAULT NULL COMMENT '用户的id',
  `goods_id` int DEFAULT NULL COMMENT '商品id',
  `count` int DEFAULT NULL COMMENT '商品数量',
  PRIMARY KEY (`shop_car_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_car
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `nick_name` varchar(255) DEFAULT NULL COMMENT '用户昵称',
  `real_name` varchar(255) DEFAULT NULL COMMENT '真是名字',
  `phone` char(11) DEFAULT NULL COMMENT '手机号',
  `password` varchar(255) DEFAULT NULL COMMENT '登录密码',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `last_login_ip` varchar(255) DEFAULT NULL COMMENT '最后登录ip',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'test', '誓言', '12345678999', '123456', '2020-04-16 15:04:59', '127.0.0.1');
COMMIT;

-- ----------------------------
-- Table structure for user_order
-- ----------------------------
DROP TABLE IF EXISTS `user_order`;
CREATE TABLE `user_order` (
  `order_id` varchar(255) NOT NULL COMMENT '订单id根据时间戳生成',
  `user_id` int DEFAULT NULL COMMENT '用户id',
  `all_cost` double(10,2) DEFAULT NULL COMMENT '总金额',
  `create_time` datetime DEFAULT NULL COMMENT '下单时间',
  `pay_time` datetime DEFAULT NULL COMMENT '付款时间',
  `receiver_phone` varchar(255) DEFAULT NULL COMMENT '收货人电话',
  `receiver_name` varchar(255) DEFAULT NULL COMMENT '收货人名字',
  `receiver_address` varchar(255) DEFAULT NULL COMMENT '收货地址',
  `pay_type` varchar(255) DEFAULT NULL COMMENT '付款方式 支付宝微信或者银行卡',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '订单状态  代付款，待收货，待评价，已退款，已取消',
  `actual_payment` double(255,0) DEFAULT NULL COMMENT '实际付款',
  `total_deduction` double(255,0) DEFAULT NULL COMMENT '总减免金额',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_order
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

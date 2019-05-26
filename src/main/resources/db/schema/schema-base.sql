-- auto-generated definition
DROP TABLE IF EXISTS `t_post`;
CREATE TABLE `t_post`
(
  id            BIGINT AUTO_INCREMENT PRIMARY KEY,
  author_id     BIGINT       NOT NULL
  COMMENT '作者ID',
  banner        VARCHAR(255) NULL
  COMMENT '标题图',
  classify_id   BIGINT       NOT NULL
  COMMENT '分类ID',
  content       VARCHAR(255) NOT NULL
  COMMENT '文章内容',
  allow_commend BINARY(1)    NOT NULL
  COMMENT '是否允许评论 [不允许, 允许]',
  liked         BIGINT       NOT NULL
  COMMENT '喜欢数量',
  tags          VARCHAR(255) NULL
  COMMENT '标签',
  title         VARCHAR(255) NOT NULL
  COMMENT '标题',

  `created_at`  DATETIME(6)  NOT NULL
  COMMENT '创建时间',
  `creator`     BIGINT
  COMMENT '创建者',
  `updated_at`  DATETIME(6)
  COMMENT '更新时间',
  `updater`     BIGINT
  COMMENT '更新者',
  `deleted_at`  DATETIME(6)
  COMMENT '删除时间',
  `deleter`     BIGINT
  COMMENT '删除者'
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT = '[基础模块] 文章表';

-- auto-generated definition
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment`
(
  id           BIGINT AUTO_INCREMENT PRIMARY KEY,
  CONTENT      VARCHAR(255) NOT NULL
  COMMENT '评论内容',
  parent_id    BIGINT       NULL
  COMMENT '父评论ID',
  root_id      bigint       null
  COMMENT '根评论ID',
  target_id    varchar(255) not null
  COMMENT '评论目标',
  user_id      bigint       not null
  COMMENT '评论者ID',

  `created_at` DATETIME(6)  NOT NULL
  COMMENT '创建时间',
  `creator`    BIGINT
  COMMENT '创建者',
  `updated_at` DATETIME(6)
  COMMENT '更新时间',
  `updater`    BIGINT
  COMMENT '更新者',
  `deleted_at` DATETIME(6)
  COMMENT '删除时间',
  `deleter`    BIGINT
  COMMENT '删除者'
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT = '[基础模块] 评价表';

-- auto-generated definition
DROP TABLE IF EXISTS `t_classify`;
CREATE TABLE `t_classify`
(
  id           BIGINT AUTO_INCREMENT PRIMARY KEY,
  name         VARCHAR(255) NOT NULL
  COMMENT '分类名称',

  `created_at` DATETIME(6)  NOT NULL
  COMMENT '创建时间',
  `creator`    BIGINT
  COMMENT '创建者',
  `updated_at` DATETIME(6)
  COMMENT '更新时间',
  `updater`    BIGINT
  COMMENT '更新者',
  `deleted_at` DATETIME(6)
  COMMENT '删除时间',
  `deleter`    BIGINT
  COMMENT '删除者'
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT = '[基础模块] 文章类别表';

-- auto-generated definition
DROP TABLE IF EXISTS `t_banner`;
CREATE TABLE `t_banner`
(
  id           BIGINT AUTO_INCREMENT PRIMARY KEY,
  image        VARCHAR(255) NOT NULL
  COMMENT '图片',
  title        VARCHAR(255) NULL
  COMMENT '标题',
  url          VARCHAR(255) NULL
  COMMENT '跳转',

  `created_at` DATETIME(6)  NOT NULL
  COMMENT '创建时间',
  `creator`    BIGINT
  COMMENT '创建者',
  `updated_at` DATETIME(6)
  COMMENT '更新时间',
  `updater`    BIGINT
  COMMENT '更新者'
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT = '[基础模块] 轮播图';




create database SoupaStars_database_test;


USE SoupaStars_database_test;


CREATE TABLE IF NOT EXISTS `users`(
`user_id` int NOT NULL auto_increment,
`username` varchar(15) NOT NULL,
`password` varchar(16) NOT NULL,
`enabled` tinyint(1) NOT NULL,
PRIMARY KEY(`user_id`)
);
 


CREATE TABLE IF NOT EXISTS `posts`(
`post_id` int NOT NULL auto_increment,
`title` varchar(50) NOT NULL,
`post_year` int NOT NULL,
`post_month` varchar(10) NOT NULL,
`post_day` int NOT NULL,
`author` varchar(50) NOT NULL,
`post_body` text(999999) NOT NULL,
`category` varchar(50) NOT NULL,
PRIMARY KEY (`post_id`)
);

CREATE TABLE IF NOT EXISTS `comment`(
`comment_id` int NOT NULL auto_increment,
`name` varchar(50) NOT NULL,
`email` varchar(50) NOT NULL,
`text` varchar(50) NOT NULL,
`date` varchar(50) NOT NULL,
PRIMARY KEY (`comment_id`)
);

CREATE TABLE IF NOT EXISTS `static_page`(
`static_page_id` int NOT NULL auto_increment,
`title` varchar(50) NOT NULL,
`body` text(999999) NOT NULL,
`active` varchar(50) NOT NULL,
`experation_date` varchar(50) NOT NULL,
PRIMARY KEY (static_page_id)
);


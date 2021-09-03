CREATE TABLE `product` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(30) NOT NULL,
	`price` FLOAT NOT NULL,
	`sale` FLOAT,
	`image_url` varchar(100),
	`image_list` varchar(1000),
	`consists` varchar(30),
	`gifts` varchar(30),
	`description` varchar(200),
	`amount` INT NOT NULL,
	`category_id` INT NOT NULL,
	`brand_id` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `specifications` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`product_id` INT NOT NULL,
	`name` varchar(30) NOT NULL,
	`content` varchar(1000) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `category` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`parent_category_id` INT,
	`name` varchar(30) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `brand` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(30) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `user` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`username` varchar(30) NOT NULL,
	`password` varchar(30) NOT NULL,
	`phone` varchar(50) NOT NULL UNIQUE,
	`email` varchar(30) NOT NULL UNIQUE,
	`role` BOOLEAN NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `address` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`country` varchar(30) NOT NULL,
	`city` varchar(50) NOT NULL,
	`district` varchar(50) NOT NULL,
	`ward` varchar(50) NOT NULL,
	`address` varchar(50) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `order` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`user_id` INT NOT NULL,
	`address_id` INT NOT NULL,
	`payments` varchar(30) NOT NULL,
	`status` INT NOT NULL,
	`sale_code` varchar(30),
	`price` FLOAT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `order_details` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`product_id` INT NOT NULL,
	`order_id` INT NOT NULL,
	`amount` INT NOT NULL,
	`price` FLOAT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `reviews` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`user_id` INT NOT NULL,
	`product_id` INT NOT NULL,
	`rate` INT NOT NULL,
	`content` varchar(200) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `advertising` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`image_list` varchar(1000) NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `product` ADD CONSTRAINT `product_fk0` FOREIGN KEY (`specifications_id`) REFERENCES `specifications`(`id`);

ALTER TABLE `product` ADD CONSTRAINT `product_fk1` FOREIGN KEY (`category_id`) REFERENCES `category`(`id`);

ALTER TABLE `product` ADD CONSTRAINT `product_fk2` FOREIGN KEY (`brand_id`) REFERENCES `brand`(`id`);

ALTER TABLE `category` ADD CONSTRAINT `category_fk0` FOREIGN KEY (`parent_category_id`) REFERENCES `category`(`id`);

ALTER TABLE `order` ADD CONSTRAINT `order_fk0` FOREIGN KEY (`user_id`) REFERENCES `user`(`id`);

ALTER TABLE `order` ADD CONSTRAINT `order_fk1` FOREIGN KEY (`address_id`) REFERENCES `address`(`id`);

ALTER TABLE `order_details` ADD CONSTRAINT `order_details_fk0` FOREIGN KEY (`product_id`) REFERENCES `product`(`id`);

ALTER TABLE `order_details` ADD CONSTRAINT `order_details_fk1` FOREIGN KEY (`order_id`) REFERENCES `order`(`id`);

ALTER TABLE `reviews` ADD CONSTRAINT `reviews_fk0` FOREIGN KEY (`user_id`) REFERENCES `user`(`id`);

ALTER TABLE `reviews` ADD CONSTRAINT `reviews_fk1` FOREIGN KEY (`product_id`) REFERENCES `product`(`id`);

ALTER TABLE `specifications` ADD CONSTRAINT `specifications_fk0` FOREIGN KEY (`product_id`) REFERENCES `product`(`id`);












/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Hector Espert
 * Created: 04-ene-2017
 */

CREATE TABLE `cars` (
    `id` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `license_plate` VARCHAR(10) NOT NULL,
    `color` int(11) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `colors_UNIQUE` (`color`),
    KEY `fk_cars_colors_idx` (`color`),
    CONSTRAINT `fk_cars_colors` FOREIGN KEY (`color`) REFERENCES `colors` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8;
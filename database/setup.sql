CREATE SCHEMA IF NOT EXISTS `sportclubsystem` DEFAULT CHARACTER SET utf8 ;
USE `sportclubsystem` ;

-- -----------------------------------------------------
-- Table `sportclubsystem`.`exercise`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sportclubsystem`.`exercise` (
  `id` INT(11) NOT NULL COMMENT '',
  `exercise` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sportclubsystem`.`region`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sportclubsystem`.`region` (
  `id` INT(11) NOT NULL COMMENT '',
  `region` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sportclubsystem`.`exercise_has_region`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sportclubsystem`.`exercise_has_region` (
  `exercise_id` INT(11) NOT NULL COMMENT '',
  `region_id` INT(11) NOT NULL COMMENT '',
  INDEX `fk_exercise_has_region_region1_idx` (`region_id` ASC)  COMMENT '',
  INDEX `fk_exercise_has_region_exercise_idx` (`exercise_id` ASC)  COMMENT '',
  CONSTRAINT `fk_exercise_has_region_exercise`
    FOREIGN KEY (`exercise_id`)
    REFERENCES `sportclubsystem`.`exercise` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_exercise_has_region_region1`
    FOREIGN KEY (`region_id`)
    REFERENCES `sportclubsystem`.`region` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `sportclubsystem` ;

-- -----------------------------------------------------
-- Table `sportclubsystem`.`diet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sportclubsystem`.`diet` (
  `id` INT(11) NOT NULL COMMENT '',
  `diet` VARCHAR(1000) NOT NULL COMMENT '',
  `timestamp` DATE NOT NULL COMMENT '',
  `assign_by_who` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sportclubsystem`.`personal_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sportclubsystem`.`personal_details` (
  `id` INT(11) NOT NULL COMMENT '',
  `weight` VARCHAR(20) NOT NULL COMMENT '',
  `chest` VARCHAR(20) NOT NULL COMMENT '',
  `waist` VARCHAR(20) NOT NULL COMMENT '',
  `hips` VARCHAR(20) NOT NULL COMMENT '',
  `biceps` VARCHAR(20) NOT NULL COMMENT '',
  `timestamp` DATE NOT NULL COMMENT '',
  `assign_by_who` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sportclubsystem`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sportclubsystem`.`role` (
  `id` INT(11) NOT NULL COMMENT '',
  `role` VARCHAR(32) NOT NULL DEFAULT 'ROLE_USER' COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sportclubsystem`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sportclubsystem`.`user` (
  `id` INT(11) NULL COMMENT '',
  `username` VARCHAR(64) NOT NULL COMMENT '',
  `password_hash` VARCHAR(255) NOT NULL COMMENT '',
  `name` VARCHAR(64) NOT NULL COMMENT '',
  `surname` VARCHAR(64) NOT NULL COMMENT '',
  `email` VARCHAR(64) NOT NULL COMMENT '',
  `active` TINYINT(1) NOT NULL DEFAULT '0' COMMENT '',
  `creation_timestamp` DATE NOT NULL COMMENT '',
  `activation_hash` VARCHAR(40) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  UNIQUE INDEX `username` (`username` ASC)  COMMENT '',
  UNIQUE INDEX `email` (`email` ASC)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sportclubsystem`.`user_diet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sportclubsystem`.`user_diet` (
  `user_id` INT(11) NOT NULL COMMENT '',
  `diet_id` INT(11) NOT NULL COMMENT '',
  INDEX `user_d` (`user_id` ASC)  COMMENT '',
  INDEX `diet` (`diet_id` ASC)  COMMENT '',
  CONSTRAINT `diet`
    FOREIGN KEY (`diet_id`)
    REFERENCES `sportclubsystem`.`diet` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `user_d`
    FOREIGN KEY (`user_id`)
    REFERENCES `sportclubsystem`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sportclubsystem`.`user_pdetails`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sportclubsystem`.`user_pdetails` (
  `user_id` INT(11) NOT NULL COMMENT '',
  `pdetails_id` INT(11) NOT NULL COMMENT '',
  INDEX `user_pd` (`user_id` ASC)  COMMENT '',
  INDEX `pdetails` (`pdetails_id` ASC)  COMMENT '',
  CONSTRAINT `pdetails`
    FOREIGN KEY (`pdetails_id`)
    REFERENCES `sportclubsystem`.`personal_details` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `user_pd`
    FOREIGN KEY (`user_id`)
    REFERENCES `sportclubsystem`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sportclubsystem`.`user_roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sportclubsystem`.`user_roles` (
  `user_id` INT(11) NOT NULL COMMENT '',
  `role_id` INT(11) NOT NULL COMMENT '',
  INDEX `user_r` (`user_id` ASC)  COMMENT '',
  INDEX `role` (`role_id` ASC)  COMMENT '',
  CONSTRAINT `role`
    FOREIGN KEY (`role_id`)
    REFERENCES `sportclubsystem`.`role` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `user_r`
    FOREIGN KEY (`user_id`)
    REFERENCES `sportclubsystem`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sportclubsystem`.`workout`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sportclubsystem`.`workout` (
  `id` INT(11) NOT NULL COMMENT '',
  `workout_program` VARCHAR(1000) NULL DEFAULT NULL COMMENT '',
  `timestamp` DATE NOT NULL COMMENT '',
  `assign_by_who` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sportclubsystem`.`user_workout`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sportclubsystem`.`user_workout` (
  `user_id` INT(11) NOT NULL COMMENT '',
  `workout_id` INT(11) NOT NULL COMMENT '',
  INDEX `user_w` (`user_id` ASC)  COMMENT '',
  INDEX `workout` (`workout_id` ASC)  COMMENT '',
  CONSTRAINT `user_w`
    FOREIGN KEY (`user_id`)
    REFERENCES `sportclubsystem`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `workout`
    FOREIGN KEY (`workout_id`)
    REFERENCES `sportclubsystem`.`workout` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sportclubsystem`.`workout_has_exercise`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sportclubsystem`.`workout_has_exercise` (
  `workout_id` INT(11) NOT NULL COMMENT '',
  `exercise_id` INT(11) NOT NULL COMMENT '',
  INDEX `fk_workout_has_exercise_exercise1_idx` (`exercise_id` ASC)  COMMENT '',
  INDEX `fk_workout_has_exercise_workout1_idx` (`workout_id` ASC)  COMMENT '',
  CONSTRAINT `fk_workout_has_exercise_workout1`
    FOREIGN KEY (`workout_id`)
    REFERENCES `sportclubsystem`.`workout` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_workout_has_exercise_exercise1`
    FOREIGN KEY (`exercise_id`)
    REFERENCES `sportclubsystem`.`exercise` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

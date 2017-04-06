USE `ad`;

CREATE TABLE `disciplines` (
	`id` INTEGER NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(255) NOT NULL,
	`shortname` VARCHAR(255) NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARACTER SET utf8;

CREATE TABLE `specialties` (
	`id` INTEGER NOT NULL AUTO_INCREMENT,
	`code` VARCHAR(255) NOT NULL,
	`name` VARCHAR(255) NOT NULL,
	`shortname` VARCHAR(255) NOT NULL,
	`qualification` VARCHAR(255),
	`parent_id` INTEGER,
	PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARACTER SET utf8;

CREATE TABLE `curriculums` (
	`id` INTEGER NOT NULL AUTO_INCREMENT,
	`year` INTEGER NOT NULL,
	`specialty_id` INTEGER NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARACTER SET utf8;

CREATE TABLE `curriculum_disciplines` (
	`id` INTEGER NOT NULL AUTO_INCREMENT,
	`curriculum_id` INTEGER NOT NULL,
	`discipline_id` INTEGER NOT NULL,
	`semester` INTEGER NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARACTER SET utf8;

ALTER TABLE `specialties`
ADD CONSTRAINT `FK_specialties_RT_specialties`
FOREIGN KEY (`parent_id`)
REFERENCES `specialties`(`id`)
ON UPDATE RESTRICT
ON DELETE CASCADE;

ALTER TABLE `curriculums`
ADD CONSTRAINT `FK_curriculums_RT_specialties`
FOREIGN KEY (`specialty_id`)
REFERENCES `specialties`(`id`)
ON UPDATE RESTRICT
ON DELETE RESTRICT;

ALTER TABLE `curriculum_disciplines`
ADD CONSTRAINT `FK_curriculum_disciplines_RT_curriculums`
FOREIGN KEY (`curriculum_id`)
REFERENCES `curriculums`(`id`)
ON UPDATE RESTRICT
ON DELETE RESTRICT;

ALTER TABLE `curriculum_disciplines`
ADD CONSTRAINT `FK_curriculum_disciplines_RT_disciplines`
FOREIGN KEY (`discipline_id`)
REFERENCES `disciplines`(`id`)
ON UPDATE RESTRICT
ON DELETE RESTRICT;

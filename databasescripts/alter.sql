ALTER TABLE `epistudy`.`rule_assessment` 
ADD COLUMN `rule_assessment_enhancedlevel` INT(11) NULL DEFAULT NULL AFTER `rule_assessment_frequencyHours`;


ALTER TABLE `epistudy`.`rule` 
ADD COLUMN `rule_enhancedlevel` INT(11) NULL DEFAULT 0 AFTER `hours_question_id`;

INSERT INTO `epistudy`.`study` (`name`, `description`, `status`, `interview_start_note`, `interview_end_note`) VALUES ('preview', '', '', 'this is the preview study', 'thanks for previewing');


ALTER TABLE `epistudy`.`node`  ADD COLUMN `original_id` INT(11) DEFAULT 0;
UPDATE node 
SET node_type = 'ajsm'
WHERE node_description LIKE '%aJSM%' AND node_discriminator = 'F' AND idnode > 0;
ALTER TABLE `epistudy`.`agent` ADD COLUMN `agent_show` INT NULL DEFAULT 1;

ALTER TABLE `epistudy`.`rule` 
ADD COLUMN `weeks_source` VARCHAR(20) NULL,
ADD COLUMN `hours_source` VARCHAR(20) NULL,
ADD COLUMN `weeks_question_id` INT(11) NULL,
ADD COLUMN `hours_question_id` INT(11) NULL;

ALTER TABLE `note` ADD COLUMN `deleted` TINYINT NOT NULL DEFAULT '0';
ALTER TABLE `node` ADD COLUMN `deleted` TINYINT NOT NULL DEFAULT '0';
ALTER TABLE `agent` ADD COLUMN `deleted` TINYINT NOT NULL DEFAULT '0';
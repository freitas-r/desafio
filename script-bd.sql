-- MySQL Workbench Synchronization
-- Generated: 2021-02-28 21:35
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: engre

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

ALTER TABLE `salas-treinamento`.`sala` 
DROP COLUMN `qtdeinscritos`;

CREATE TABLE IF NOT EXISTS `salas-treinamento`.`etapa` (
  `participante_idparticipante` INT(11) NOT NULL,
  `sala_idsala` INT(11) NOT NULL,
  `cafe_idcafe` INT(11) NOT NULL,
  PRIMARY KEY (`participante_idparticipante`, `sala_idsala`, `cafe_idcafe`),
  INDEX `fk_etapa_sala1_idx` (`sala_idsala` ASC) VISIBLE,
  INDEX `fk_etapa_cafe1_idx` (`cafe_idcafe` ASC) VISIBLE,
  CONSTRAINT `fk_etapa_participante`
    FOREIGN KEY (`participante_idparticipante`)
    REFERENCES `salas-treinamento`.`participante` (`idparticipante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_etapa_sala1`
    FOREIGN KEY (`sala_idsala`)
    REFERENCES `salas-treinamento`.`sala` (`idsala`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_etapa_cafe1`
    FOREIGN KEY (`cafe_idcafe`)
    REFERENCES `salas-treinamento`.`cafe` (`idcafe`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

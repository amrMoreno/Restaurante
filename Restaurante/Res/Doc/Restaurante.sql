-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Restaurante
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Restaurante
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Restaurante` DEFAULT CHARACTER SET utf8 ;
USE `Restaurante` ;

-- -----------------------------------------------------
-- Table `Restaurante`.`Restaurante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Restaurante`.`Restaurante` (
  `id` INT NOT NULL,
  `Nombre` VARCHAR(45) NULL,
  `Direccion` VARCHAR(45) NULL,
  `NumeroMesas` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Restaurante`.`Mesa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Restaurante`.`Mesa` (
  `idMesa` INT NOT NULL,
  `Fecha` DATE NULL,
  `Camarero` VARCHAR(45) NULL,
  `Poductos` VARCHAR(45) NULL,
  `Restaurante_id` INT NOT NULL,
  PRIMARY KEY (`idMesa`, `Restaurante_id`),
  INDEX `fk_Mesa_Restaurante1_idx` (`Restaurante_id` ASC),
  CONSTRAINT `fk_Mesa_Restaurante1`
    FOREIGN KEY (`Restaurante_id`)
    REFERENCES `Restaurante`.`Restaurante` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Restaurante`.`Productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Restaurante`.`Productos` (
  `Nombre` VARCHAR(45) NOT NULL,
  `Precio` INT NULL,
  `TipoDeProducto` VARCHAR(45) NULL,
  PRIMARY KEY (`Nombre`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Restaurante`.`Mesa_has_Productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Restaurante`.`Mesa_has_Productos` (
  `Mesa_idMesa` INT NOT NULL,
  `Productos_Nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Mesa_idMesa`, `Productos_Nombre`),
  INDEX `fk_Mesa_has_Productos_Productos1_idx` (`Productos_Nombre` ASC),
  INDEX `fk_Mesa_has_Productos_Mesa_idx` (`Mesa_idMesa` ASC) ,
  CONSTRAINT `fk_Mesa_has_Productos_Mesa`
    FOREIGN KEY (`Mesa_idMesa`)
    REFERENCES `Restaurante`.`Mesa` (`idMesa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Mesa_has_Productos_Productos1`
    FOREIGN KEY (`Productos_Nombre`)
    REFERENCES `Restaurante`.`Productos` (`Nombre`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Restaurante`.`Camarero`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Restaurante`.`Camarero` (
  `DNI` INT NOT NULL,
  `Nombre` VARCHAR(45) NULL,
  `FechaNacimiento` VARCHAR(45) NULL,
  `TipoDeCamarero` VARCHAR(45) NULL,
  `Restaurante_id` INT NOT NULL,
  PRIMARY KEY (`DNI`, `Restaurante_id`),
  INDEX `fk_Camarero_Restaurante1_idx` (`Restaurante_id` ASC) ,
  CONSTRAINT `fk_Camarero_Restaurante1`
    FOREIGN KEY (`Restaurante_id`)
    REFERENCES `Restaurante`.`Restaurante` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Restaurante`.`Factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Restaurante`.`Factura` (
  `idFactura` INT NOT NULL,
  `NumeroMesa` INT NULL,
  `Productos` VARCHAR(45) NULL,
  `Fecha` DATETIME NULL,
  `CantidadTotal` INT NULL,
  `Mesa_idMesa` INT NOT NULL,
  `Mesa_Restaurante_id` INT NOT NULL,
  PRIMARY KEY (`idFactura`, `Mesa_idMesa`, `Mesa_Restaurante_id`),
  INDEX `fk_Factura_Mesa1_idx` (`Mesa_idMesa` ASC, `Mesa_Restaurante_id` ASC) ,
  CONSTRAINT `fk_Factura_Mesa1`
    FOREIGN KEY (`Mesa_idMesa` , `Mesa_Restaurante_id`)
    REFERENCES `Restaurante`.`Mesa` (`idMesa` , `Restaurante_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

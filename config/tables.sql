CREATE TABLE `tb_domain` (
  `id_domain` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `mnemonic` varchar(50) NOT NULL,
  PRIMARY KEY (`id_domain`),
  UNIQUE KEY `mnemonic_UNIQUE` (`mnemonic`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `tb_fields` (
  `id_field` int(11) NOT NULL AUTO_INCREMENT,
  `id_domain` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`id_field`),
  KEY `fk_id_domain_fields_idx` (`id_domain`),
  CONSTRAINT `fk_id_domain_fields` FOREIGN KEY (`id_domain`) REFERENCES `tb_domain` (`id_domain`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `tb_register_domain` (
  `id_register_domain` int(11) NOT NULL AUTO_INCREMENT,
  `id_domain` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id_register_domain`),
  KEY `fk_id_domain_register_idx` (`id_domain`),
  CONSTRAINT `fk_id_domain_register` FOREIGN KEY (`id_domain`) REFERENCES `tb_domain` (`id_domain`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `tb_register_fields` (
  `id_register_field` int(11) NOT NULL AUTO_INCREMENT,
  `id_field` int(11) NOT NULL,
  `id_register_domain` int(11) NOT NULL,
  `value` varchar(100) NOT NULL,
  PRIMARY KEY (`id_register_field`),
  KEY `fk_id_register_domain_idx` (`id_register_domain`),
  KEY `fk_id_field_register_idx` (`id_field`),
  CONSTRAINT `fk_id_field_register` FOREIGN KEY (`id_field`) REFERENCES `tb_fields` (`id_field`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_id_register_domain` FOREIGN KEY (`id_register_domain`) REFERENCES `tb_register_domain` (`id_register_domain`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

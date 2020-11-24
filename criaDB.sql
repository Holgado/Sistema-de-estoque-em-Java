create DATABASE	ADM_ELETRONICOS;

USE ADM_ELETRONICOS;

CREATE TABLE `produtos`(
  `idProduto` int unsigned NOT NULL auto_increment,
  `nomeProduto` varchar(255),
  `qntdProduto` int default NULL,
  `precoUnidade` double default NULL,
   PRIMARY KEY (`idProduto`)
)auto_increment = 1;

INSERT INTO `produtos` (`idProduto`,`nomeProduto`,`qntdProduto`,`precoUnidade`) VALUES ('',"DIODO","20","1.90");
INSERT INTO `produtos` (`idProduto`,`nomeProduto`,`qntdProduto`,`precoUnidade`) VALUES ('',"LED","15","2.30");
INSERT INTO `produtos` (`idProduto`,`nomeProduto`,`qntdProduto`,`precoUnidade`) VALUES ('',"CAPACITORES ELETROLITICO","10","4.50");
INSERT INTO `produtos` (`idProduto`,`nomeProduto`,`qntdProduto`, `precoUnidade`)VALUES ('',"RESISTORES","40","1.00");
INSERT INTO `produtos` (`idProduto`,`nomeProduto`,`qntdProduto`,`precoUnidade`) VALUES ('',"TRANSISTORES","80","12.30");

SELECT * FROM `produtos`;
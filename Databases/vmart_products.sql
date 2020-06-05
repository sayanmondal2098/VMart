-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: vmart
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `pid` bigint NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `catID` bigint NOT NULL,
  `sellerID` bigint NOT NULL,
  `seller` bigint DEFAULT NULL,
  `discount` double DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `FK18mpj66od1u7cflcnovrnwc4n` (`catID`),
  KEY `FK9q2nmn0fohc4m5xk5hcjv05v6` (`sellerID`),
  KEY `FK64hndymlemelpy0tjbunybifh` (`seller`),
  KEY `FKoswqnvq54tlxwwu41lh118kdo` (`discount`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (22,'Keep this hip this season with the HRX Men\'s Athleisure T-shirt. This versatile T-shirt can be styled any way you like for the ultimate gym-to-street look.','HRX by Hrithik Roshan',699,8,15,NULL,0.8),(23,'Keep it cool and casual this season with this high-quality Kook N Keech Marvel tee. When you\'re out running errands, you\'ll look your best when you combine this black piece with your favourite pair of sunglasses and trainer shoes.','Kook N Keech Marvel',599,8,15,NULL,0.7),(24,'The feel of this Difference of Opinion tee is absolutely amazing thanks to the designer\'s use of cotton. When you\'re going for a stroll in the park, put this sea green piece with a pair of chinos and sneakers to feel both comfortable and stylish outside.','Difference of Opinion',1249,8,15,NULL,0.35),(26,'Elevate the look of your wardrobe with a few more basic tees like this. You\'ll feel entirely at ease in this grey melange piece on top of a relaxed-fit chino and slip-on tennis shoe when you\'re going out shopping or catching a movie.','Sztori',999,8,15,NULL,0.7),(27,'WROGN brings to you a range of trendy T-shirts to spruce up your wardrobe. Team this piece with a pair of jeans and sneakers for cool, casual look.','WROGN',999,8,15,NULL,0.7),(28,'Pull over this snug tee to keep your style looking fresh. Throw on your favourite pair of chinos and loafers with this grey number for a stroll around the block or casual hangout with friends.','Roadster',799,8,15,NULL,0.6),(29,'Made of cotton, you\'ll love the high-quality fit and feel of this Levis tee. Whether you\'re running errands or meeting friends for coffee, sport this black number with slim black jeans or cutoff shorts for a relaxed style.','Levis',1699,8,15,NULL,0.9),(31,'When you\'re in need of some new tees, opt for this in-style T-shirt made by DILLINGER. You can pair this green piece with slick black jeans and Chelsea boots for a fashionable weekend outfit.','DILLINGER',899,8,15,NULL,0.43),(32,'Soft, well-structured, and durable, you\'ll definitely love being the proud owner of this Mast & Harbour T-shirt. This orange piece is incredibly versatile and can be matched with dark or light denim for an evening out with the guys.','Mast & Harbour',599,8,15,NULL,0.8),(34,'Improve your personal style with a brand new three-quarter sleeve top designed by Ives. For a casual work outfit, all you need to do is pair this olive piece with a bright blazer and neutral-toned pants.','Ives',1099,9,15,NULL,0.5),(35,'Show off your great sense of style with this high-quality top by Harpa. Pair this mustard top with distressed jeans and slip-on sneakers for a lazy weekend outing.','Harpa',1199,9,15,NULL,0.4),(36,'Give yourself a fashion makeover with this classy three-quarter sleeve top from SASSAFRAS. This green piece goes well with darker slim-fit pants and caged heel for a breezy but stylish look for running errands.','SASSAFRAS',999,9,15,NULL,0.52),(37,'Finish off your wardrobe with this high-end shirt from DOROTHY PERKINS. This yellow top is a great option for warmer days and pairs well with dark jeans and a light jacket when shopping with friends or hanging out with family.','DOROTHY PERKINS',2990,9,15,NULL,0.6),(38,'This comfortable and fashionable Tokyo Talkies three-quarter sleeve top is easy to layer. This coral piece can be styled with slick black jeans and leather boots when you\'re going to lunch with your friends.','Tokyo Talkies',699,9,15,NULL,0.47),(39,'You\'ll love the comfort and breathability of this U&F shirt. This purple top with worn jeans and flats is the perfect ensemble for a leisurely midday stroll or casual outing with friends.','U&F',1699,9,15,NULL,0.32),(40,'Improve your personal style with a brand new three-quarter sleeve top designed by Carlton London. Match this piece with a pair of slim jeans and easy loafers for a fashionable date outfit.','Carlton London',1390,9,15,NULL,0.5),(41,'Maintain a trendy style all year long with this stunning dress from SASSAFRAS. Dress to the nines for your party this weekend by styling this printed beige piece with pumps and a cute clutch.','SASSAFRAS',1699,10,15,NULL,0.44),(42,'Look cool in this midi dress by ETHER. You can style it with a pair of contrast pumps and a shimmery clutch to look gorgeous.','ether',1099,10,15,NULL,0.7),(43,'This trendy dress from Mast & Harbour will make a great addition to any wardrobe. Complement this printed black piece with a pair of caged heels, your favourite bag and some minimalistic silver jewellery for a classy date ensemble.','Mast & Harbour',1299,10,15,NULL,0.6),(44,'Maintain a chic appearance all year long with this trendy RARE dress. Create an absolute style high by going with this printed green piece in combination with a killer shoe and trendy bangles for a perfect brunch look.','RARE',2099,10,15,NULL,0.45),(45,'This dress from Athena is both durable and stylish, making it a must-have item. When you need an outfit for work and dinner after work, wear this printed yellow piece with platform heels and some minimalistic silver jewellery.','Athena',1999,10,15,NULL,0.6),(46,'Replace some of your outdated essentials with this beautiful dress from U&F. When you\'re going to an art gallery opening or the theater, wear this printed maroon piece with platform heels and a trendy clutch.','U&F',1699,10,15,NULL,0.4),(47,'Expand your collection of formalwear with these high-quality Mast & Harbour chino trousers. This grey pair can be worn with canvas shoes and a fitted tee for your next date night.','Mast & Harbour',1899,12,15,NULL,0.55),(48,'These chino trousers from HIGHLANDER are perfect for updating your collection of more formal fashion for your busy lifestyle. This grey pair can be matched with an in-style shirt and a lightweight jacket for a night out on the town.','HIGHLANDER',1549,12,15,NULL,0.47),(49,'Add a dash of professional poise to your wardrobe with these chino trousers from WROGN. This olive pair can be matched with an in-style shirt and a lightweight jacket for a night out on the town.','WROGN',1899,12,15,NULL,0.6),(50,'Style yourself silly with a trendy pair of HERE&NOW chino trousers. When you have to give a presentation at work, wear this green pair with a formal tee, a casual blazer, and Oxfords.','HERE&NOW',2199,12,15,NULL,0.5),(51,'Opt for these on-trend Louis Philippe Sport trousers and embrace your new look. This grey pair can be worn with a classic tee and dockers when you\'re meeting your coworkers for after-work drinks.','Louis Philippe Sport',2399,12,15,NULL,0.9),(52,'Sharpen up your overall style with a pair of ether trousers. You can team this white pair with a fitted shirt and a casual blazer for a must-have work ensemble.','ether',1499,12,15,NULL,0.6);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-05 16:40:28

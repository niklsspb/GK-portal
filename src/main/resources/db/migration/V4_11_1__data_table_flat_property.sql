
/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Data for the table `flat_property` */

insert  into `flat_property`(`id`,`description`,`css_style_name`,`position`,`data1_enabled`,`data2_enabled`,`comment_enabled`,`data1_description`,`data2_description`,`type`) values
('3b210521-26b8-4b08-8660-c31134faaaa0','Ремонт','circle_red',2,'','','','Дата начала','Ожидаемая дата конца',1),
('6534ecc6-d920-482e-b1e8-1f36d77289d8','Есть в вотсап','square_green',5,'\0','\0','','','',1),
('910525ae-b9ad-416e-aaac-f1f595908d81','Заселена','circle_green',3,'','\0','','Дата заселения','',1),
('9ad5b241-6722-4f78-8f0d-c5178222bdeb','Есть в телеграм','square_blue',4,'\0','\0','','','',1),
('9f265558-b3ca-4f65-a9d0-6d37553f3c9d','Оплачен мусор','circle_yellow',1,'\0','\0','\0','','',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

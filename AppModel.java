package Model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Main.DataBase;

public class AppModel extends Model{

	public void run()
	{
		String dbQuery = "SET SQL_MODE = \"NO_AUTO_VALUE_ON_ZERO\";" +
				"SET time_zone = \"+00:00\";" +
				"CREATE TABLE `adres` (`KisiID` double(20,0) NOT NULL,`AdresBilgiID` double(11,0) NOT NULL) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;" +
				"INSERT INTO `adres` (`KisiID`, `AdresBilgiID`) VALUES(56, 23),(57, 24),(58, 25),(59, 26),(60, 27),(61, 28),(62, 29),(63, 30),(64, 31),(65, 32),(66, 33),(67, 34),(68, 35),(73, 36);" +
				"CREATE TABLE `adresbilgi` (  `AdresBilgiID` double(20,0) NOT NULL,  `AdresTip` varchar(30) COLLATE utf8_turkish_ci NOT NULL,  `Mahalle` varchar(255) COLLATE utf8_turkish_ci DEFAULT NULL,  `Cadde` varchar(255) COLLATE utf8_turkish_ci DEFAULT NULL,  `Sokak` varchar(255) COLLATE utf8_turkish_ci DEFAULT NULL,`No` int(10) DEFAULT NULL,`Ýl` varchar(30) COLLATE utf8_turkish_ci NOT NULL) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;" +
				"INSERT INTO `adresbilgi` (`AdresBilgiID`, `AdresTip`, `Mahalle`, `Cadde`, `Sokak`, `No`, `Ýl`) VALUES(23, 'Is', 'Seyrantepe', 'Sebil', 'Karanlik', 12, '49'),(24, 'Ev', 'Dereboyu', 'Erdogdu', 'Bostanci', 18, '61'),(25, 'Ev', 'Gumussuyu', 'Capa', 'Carpik', 12, '34'),(26, 'Yazlik', 'Ataturk', 'Gazi Emir', 'Kursuncu', 13, '22'),(27, 'Ev', 'Keskintepe', 'Kerteriz ', 'Bedir', 34, '2'),(28, 'Ev', 'Kurtulus', 'Aydin', 'Armagan', 46, '44'),(29, 'Ev', 'Ivedik', 'Akdeniz', '3123', 1, '6'),(30, 'Is', 'Davutpasa', 'Yildiz', 'Ortabahce', 22, '34'),(31, 'Is', 'Ruzgarlibahce', 'Otoyol', 'Huzur', 7, '34'),(32, 'Ev', 'Odunpazari', 'Hamamyolu', 'Kestaneciler', 26, '26'),(33, 'Ev', 'Ataturk', 'Konak', 'Forum', 23, '35'),(34, 'Is', 'Florya', 'Seyrantepe', 'Arena', 10, '19'),(35, 'Ev', 'Gurpinar', 'Kuzguncuk', 'Korebe', 9, '64'),(36, 'Ev', 'Esentepe', 'Kartepe', '&#350;en', 7, '15');" +
				"CREATE TABLE `adrestipi` (  `Tip` varchar(255) COLLATE utf8_turkish_ci NOT NULL,  `AdresTipiID` int(10) NOT NULL) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;" +
				"CREATE TABLE `comment` (`CommentID` int(11) NOT NULL,`KisiID` varchar(255) COLLATE utf8_turkish_ci NOT NULL,`Comment` varchar(255) COLLATE utf8_turkish_ci DEFAULT NULL) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;" +
				"INSERT INTO `comment` (`CommentID`, `KisiID`, `Comment`) VALUES(25, '56', 'Görüþme saðlanamadý. Baþka bir zaman tekrar iletiþime geçilecek.'),(24, '57', 'Görüþme yapýldý. Olumlu sonuçlandý.'),(23, '57', 'Görüþme baþarýyla sonuçlandýrýlmýþtýr.'),(22, '57', 'Görüþme baþarýyla sonuçlandýrýlmýþtýr.'),(26, '68', 'Görüþme yapýldý ancak müþteri ürünle ilgilenmedi.'),(27, '67', 'Müþteri görüþmesi gerçekleþtirildi. Güncel poliçeler hakkýnda bilgi almak istedi.'),(28, '66', 'Görüþme gerçekleþtirilemedi. Ýleriki bir zamanda tekrar iletiþime geçilecek.'),(29, '66', 'Görüþme gerçekleþtirildi. Müþteri ürünlerle ilgilenmedi.'),(30, '65', 'Müþteri ile görüþme saðlanamadý.'),(31, '65', 'Müþteri ile görüþme saðlanamadý.'),(32, '65', 'Görüþme saðlandý. Müþteri ürün hakkýnda bilgilendirildi.'),(33, '61', 'Görüþme saðlandý. Müþteri ürünle ilgilenmedi.'),(34, '60', 'Müþteri görüþmesi saðlanamadý.'),(35, '59', 'Görüþme yapýldý ancak müþteri ürünle ilgilenmedi.'),(36, '58', 'Görüþme yapýldý. Sigorta poliçeleri hakkýnda detaylý bilgi verildi.'),(37, '64', 'Sigorta poliçeleri anlatýldý. Görüþme saðlandý.'),(38, '63', 'Görüþme saðlanamadý. Ýleriki bir tarihte tekrar görüþme yapýlacak.'),(39, '63', 'Görüþme yapýlamadý.'),(40, '63', 'Müþteri ile görüþme saðlandý. Ürünler hakkýnda bilgi verildi.'),(41, '62', 'Görüþme saðlanamadý.');" +
				"CREATE TABLE `kisi` (`KisiID` double(20,0) NOT NULL,`Tc` double(11,0) NOT NULL,`Ad` varchar(25) COLLATE utf8_turkish_ci NOT NULL,`Soyad` varchar(25) COLLATE utf8_turkish_ci NOT NULL,`Email` varchar(255) COLLATE utf8_turkish_ci NOT NULL) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;" +
				"INSERT INTO `kisi` (`KisiID`, `Tc`, `Ad`, `Soyad`, `Email`) VALUES(56, 22939929399, 'Turgut', 'Alan', 'turgutalan@yahoo.com'),(57, 34586623452, 'Melis', 'Becan', 'mlsbecan@gmail.com'),(58, 23453645634, 'Samet', 'Yilmaz', 'sametylmz@yahoo.com'),(59, 39229393377, 'Berkay', 'Eke', 'bekke@gmail.com'),(60, 25725437435, 'Derya', 'Salt', 'deryasalt@hotmail.com'),(61, 28345633456, 'Mehmet', 'Algan', 'mhmtalgn@hotmail.com'),(62, 43453462234, 'Ayla', 'Dumlupinar', 'dumlupinarayla06@gmail.com'),(63, 22993092322, 'Muhammet', 'Sayar', 'msayar@yahoo.com'),(64, 35632625252, 'Ugur', 'Ucar', 'uucar@gmail.com'),(65, 37654456333, 'Burak', 'Kel', 'burakkk@gmail.com'),(66, 18613547853, 'Selvi', 'Kirim', 'selvikrm@yahoo.com'),(67, 35545453643, 'Dursun', 'Ozberk', 'dursundursun@gmail.com'),(68, 32571228878, 'Destan', 'Yurter', 'destanyurter@hotmail.com'),(73, 32341925212, 'Bilal Deniz', 'Sert', 'bilaldeniz@gmail.com');" +
				"CREATE TABLE `sehir` (`ilID` int(3) NOT NULL,`il` varchar(30) COLLATE utf8_turkish_ci NOT NULL) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;" +
				"INSERT INTO `sehir` (`ilID`, `il`) VALUES(1, 'Adana'),(2, 'Adiyaman'),(3, 'Afyon'),(4, 'Agri'),(5, 'Amasya'),(6, 'Ankara'),(7, 'Antalya'),(8, 'Artvin'),(9, 'Aydin'),(10, 'Balikesir'),(11, 'Bilecik'),(12, 'Bingol'),(13, 'Bitlis'),(14, 'Bolu'),(15, 'Burdur'),(16, 'Bursa'),(17, 'Çanakkale'),(18, 'Çankiri'),(19, 'Çorum'),(20, 'Denizli'),(21, 'Diyarbakir'),(22, 'Edirne'),(23, 'Elazig'),(24, 'Erzincan'),(25, 'Erzurum'),(26, 'Eskisehir'),(27, 'Gaziantep'),(28, 'Giresun'),(29, 'Gumushane'),(30, 'Hakkari'),(31, 'Hatay'),(32, 'Isparta'),(33, 'Icel'),(34, 'Istanbul'),(35, 'Izmir'),(36, 'Kars'),(37, 'Kastamonu'),(38, 'Kayseri'),(39, 'Kirklareli'),(40, 'Kirsehir'),(41, 'Kocaeli'),(42, 'Konya'),(43, 'Kutahya'),(44, 'Malatya'),(45, 'Manisa'),(46, 'K.Maras'),(47, 'Mardin'),(48, 'Mugla'),(49, 'Mus'),(50, 'Nevsehir'),(51, 'Nigde'),(52, 'Ordu'),(53, 'Rize'),(54, 'Sakarya'),(55, 'Samsun'),(56, 'Siirt'),(57, 'Sinop'),(58, 'Sivas'),(59, 'Tekirdag'),(60, 'Tokat'),(61, 'Trabzon'),(62, 'Tunceli'),(63, 'Sanliurfa'),(64, 'Usak'),(65, 'Van'),(66, 'Yozgat'),(67, 'Zonguldak'),(68, 'Aksaray'),(69, 'Bayburt'),(70, 'Karaman'),(71, 'Kirikkale'),(72, 'Batman'),(73, 'Sirnak'),(74, 'Bartin'),(75, 'Ardahan'),(76, 'Igdir'),(77, 'Yalova'),(78, 'Karabuk'),(79, 'Kilis'),(80, 'Osmaniye'),(81, 'Duzce');" +
				"CREATE TABLE `telbilgi` (`TelefonID` int(9) NOT NULL,`TelTip` varchar(20) COLLATE utf8_turkish_ci DEFAULT NULL,`Numara` double(11,0) NOT NULL) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;" +
				"INSERT INTO `telbilgi` (`TelefonID`, `TelTip`, `Numara`) VALUES(52, 'Is', 4362625634),(53, 'Cep', 5613870303),(54, 'Ev', 2163220001),(55, 'Cep', 5348794440),(56, 'Cep', 4164244828),(57, 'Ev', 4224535644),(58, 'Ev', 3123776600),(59, 'Is', 2124326566),(60, 'Is', 2162877499),(61, 'Ev', 2226682334),(62, 'Cep', 5354788654),(63, 'Cep', 5405616616),(64, 'Ev', 2766633563),(65, 'Cep', 5495663355);" +
				"CREATE TABLE `telefon` (`KisiID` int(10) NOT NULL,  `TelefonID` int(10) NOT NULL) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;" +
				"INSERT INTO `telefon` (`KisiID`, `TelefonID`) VALUES(56, 52),(57, 53),(58, 54),(59, 55),(60, 56),(61, 57),(62, 58),(63, 59),(64, 60),(65, 61),(66, 62),(67, 63),(68, 64),(73, 65);" +
				"ALTER TABLE `adresbilgi` ADD PRIMARY KEY (`AdresBilgiID`);" +
				"ALTER TABLE `adrestipi` ADD PRIMARY KEY (`AdresTipiID`) USING BTREE;" +
				"ALTER TABLE `comment` ADD PRIMARY KEY (`CommentID`);" +
				"ALTER TABLE `kisi` ADD PRIMARY KEY (`KisiID`);" +
				"ALTER TABLE `sehir` ADD PRIMARY KEY (`ilID`);" +
				"ALTER TABLE `telbilgi` ADD PRIMARY KEY (`TelefonID`) USING BTREE;" +
				"ALTER TABLE `adresbilgi` MODIFY `AdresBilgiID` double(20,0) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;" +
				"ALTER TABLE `adrestipi` MODIFY `AdresTipiID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;" +
				"ALTER TABLE `comment`  MODIFY `CommentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;" +
				"ALTER TABLE `kisi`  MODIFY `KisiID` double(20,0) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=74;" +
				"ALTER TABLE `telbilgi` MODIFY `TelefonID` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=66;";
		
		try {
			PreparedStatement ps = this.db.prepareStatement(dbQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DataBase.baglantiKapa(this.db);
		}
		
	}
}

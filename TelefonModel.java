package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Entity.Kisi;
import Entity.TelBilgi;
import Main.DataBase;

public class TelefonModel extends Model {

	public TelBilgi getTelefonID(int telId, int kisiId) {

		TelBilgi tb = new TelBilgi();
		Kisi k = new Kisi();

		try {

			PreparedStatement ps = this.db.prepareStatement("INSERT INTO `wic`.`telefon`(`KisiID`, `TelefonID`) VALUES (?, ?)");
			
			ps.setInt(1, kisiId);
			ps.setInt(2, telId);
			ps.executeUpdate();	
			this.db.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBase.baglantiKapa(this.db);
		}
		return tb;
	}
}

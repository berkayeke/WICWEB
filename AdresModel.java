package Model;

import java.sql.PreparedStatement;

import Entity.AdresBilgi;
import Main.DataBase;

public class AdresModel extends Model {

	public AdresBilgi record(int adresId, int kisiId) {
		AdresBilgi ab = new AdresBilgi();

		try {

			PreparedStatement ps = this.db.prepareStatement("INSERT INTO `wic`.`adres`(`KisiID`, `AdresBilgiID`) VALUES (?, ?)");
			ps.setInt(1, kisiId);
			ps.setInt(2, adresId);
			ps.executeUpdate();
			this.db.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBase.baglantiKapa(this.db);
		}

		return ab;
	}
}

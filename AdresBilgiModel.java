package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.AdresBilgi;
import Entity.Kisi;
import Main.DataBase;

public class AdresBilgiModel extends Model {

	public ArrayList<AdresBilgi> getKisiAdresler(int id) {

		ArrayList<AdresBilgi> adresList = new ArrayList<AdresBilgi>();

		try {
			PreparedStatement ps = this.db.prepareStatement("SELECT ab.* \r\n" + 
					"\r\n" + 
					"FROM `kisi` k \r\n" + 
					"left join adres a on a.KisiID = k.KisiID\r\n" + 
					"left join adresbilgi ab on ab.AdresBilgiID = a.AdresBilgiID\r\n" + 
					"where k.KisiID=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				AdresBilgi ab = new AdresBilgi();
				ab.setAdresBilgiID(rs.getInt("AdresBilgiID"));
				ab.setAdresTip(rs.getString("AdresTip"));
				ab.setMahalle(rs.getString("Mahalle"));
				ab.setCadde(rs.getString("Cadde"));
				ab.setSokak(rs.getString("Sokak"));
				ab.setNo(rs.getString("No"));
				ab.setIl(rs.getString("il"));
				adresList.add(ab);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBase.baglantiKapa(this.db);
		}

		return adresList;

	}

	// GetKisi-----------------

	public void getAdres(int id) {

		try {

			PreparedStatement ps = this.db.prepareStatement("Select * from kisi where AdresBilgiID =?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				System.out.println(rs.getString("AdresTip"));
				System.out.println(rs.getString("Mahalle"));
				System.out.println(rs.getString("Cadde"));
				System.out.println(rs.getString("Sokak"));
				System.out.println(rs.getString("No"));
				System.out.println(rs.getString("il"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBase.baglantiKapa(this.db);
		}
	}

	// Update---------------------------
	public void UpdateAdres(AdresBilgi a) {

		try {
			DataBase.baglan();
			PreparedStatement ps = this.db.prepareStatement(
					"Update adresbilgi set AdresTip=?, Mahalle=?, Cadde=?, Sokak=?, No=?, il=? where AdresBilgiID =?");

			ps.setString(1, a.getAdresTip());
			ps.setString(2, a.getMahalle());
			ps.setString(3, a.getCadde());
			ps.setString(4, a.getSokak());
			ps.setString(5, a.getNo());
			ps.setString(6, a.getIl());
			ps.executeUpdate();
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			DataBase.baglantiKapa(this.db);
		}

	}

	// Delete---------------------------
	public void DeleteAdres(int id) {

		try {

			PreparedStatement ps = this.db.prepareStatement("Delete from adresbilgi where AdresBilgiID =?");
			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			DataBase.baglantiKapa(this.db);
		}

	}

	// Create------------------------------
	public int CreateAdres(AdresBilgi a) {
		int result = 0;
		try {

			PreparedStatement ps = this.db.prepareStatement(
					"insert into adresbilgi(AdresTip,Mahalle,Cadde,Sokak,No,il) values(?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, a.getAdresTip());
			ps.setString(2, a.getMahalle());
			ps.setString(3, a.getCadde());
			ps.setString(4, a.getSokak());
			ps.setString(5, a.getNo());
			ps.setString(6, a.getIl());
			ps.executeUpdate();
			this.db.commit();

			ResultSet genKeys = ps.getGeneratedKeys();

			if (genKeys.next()) {
				result = genKeys.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBase.baglantiKapa(this.db);
		}

		return result;
	}

}

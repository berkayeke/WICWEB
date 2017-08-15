package Model;

import Main.DataBase;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.AdresBilgi;
import Entity.TelBilgi;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TelBilgiModel extends Model {

	public ArrayList<TelBilgi> getKisiTelefonlar(int id) {

		ArrayList<TelBilgi> telList = new ArrayList<TelBilgi>();
		try {
			PreparedStatement ps = this.db.prepareStatement("SELECT tb.* FROM `kisi` k \r\n" + 
					"left join telefon t on t.KisiID = k.KisiID\r\n" + 
					"left join telbilgi tb on t.TelefonID = tb.TelefonID\r\n" + 
					"where k.KisiID=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				TelBilgi tb = new TelBilgi();
				tb.setTelefonID(rs.getInt("TelefonID"));
				tb.setTelTip(rs.getString("TelTip"));
				tb.setNumara(rs.getString("Numara"));
				telList.add(tb);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBase.baglantiKapa(this.db);
		}

		return telList;
	}

	public void getTelTip(int id) {

		try {
			PreparedStatement ps = this.db.prepareStatement("Select * from telbilgi where TelefonID =?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				System.out.println(rs.getString("telTip"));
				System.out.println(rs.getString("numara"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBase.baglantiKapa(this.db);
		}

	}

	public void UpdateTelTip(TelBilgi tb) {
		try {
			PreparedStatement ps = this.db.prepareStatement("Update TelBilgi set TelTip=?, Numara=? where TelefonID=?");
			ps.setString(1, tb.getTelTip());
			ps.setString(2, tb.getNumara());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBase.baglantiKapa(this.db);
		}

	}

	public void DeleteTelTip(int id) {
		try {
			PreparedStatement ps = this.db.prepareStatement("Delete from telbilgi where TelefonID=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBase.baglantiKapa(this.db);
		}
	}

	public int CreateTelTip(TelBilgi tb) {
		int result = 0;
		try {
			PreparedStatement ps = this.db.prepareStatement("insert into telbilgi(TelTip,Numara) values(?,?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, tb.getTelTip());
			ps.setString(2, tb.getNumara());
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

	public boolean isUniqueTel(String tel) {

		boolean telVar = false;
		Statement stmt = null;

		try {
			stmt = db.createStatement();

			PreparedStatement ps = this.db.prepareStatement("Select count(Numara) as c from telbilgi where Numara = ?");
			ps.setDouble(1, Double.parseDouble(tel));
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				if (rs.getDouble("c") == 0) {
					telVar = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBase.baglantiKapa(db);
		}

		return telVar;
	}

}

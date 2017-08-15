package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.Sehir;
import Main.DataBase;

public class SehirModel extends Model {

	public ArrayList<Sehir> getAllSehir() {

		ArrayList<Sehir> sehirList = new ArrayList<Sehir>();
		Statement stmt = null;

		try {
			stmt = db.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from sehir");

			while (rs.next()) {

				Sehir s = new Sehir();

				s.setIl(rs.getString("il"));
				s.setIlID(rs.getInt("ilID"));
				sehirList.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBase.baglantiKapa(db);
		}

		return sehirList;

	}

	public boolean isSehirValid(int id) {
		boolean valid = false;
		Statement stmt = null;

		try {
			stmt = db.createStatement();
			PreparedStatement ps=this.db.prepareStatement("Select count(*) as c from sehir where ilID=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				if (rs.getInt("c") == 1) {
					valid = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBase.baglantiKapa(db);
		}
		
		return valid;
	}
}

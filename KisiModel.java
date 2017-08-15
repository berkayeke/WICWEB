package Model;

import Main.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.AdresBilgi;
import Entity.Kisi;

public class KisiModel extends Model {

	public ArrayList<Kisi> getAllKisiler() {

		ArrayList<Kisi> kisiList = new ArrayList<Kisi>();
		Connection con = null;
		Statement stmt = null;

		try {
			con = DataBase.baglan();
			stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("Select * from kisi");

			while (rs.next()) {

				Kisi k = new Kisi();
				k.setKisiID(rs.getInt("KisiID"));
				k.setTc(rs.getString("Tc"));
				k.setAd(rs.getString("Ad"));
				k.setSoyad(rs.getString("Soyad"));
				k.setEmail(rs.getString("Email"));
				kisiList.add(k);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBase.baglantiKapa(con);
		}

		return kisiList;

	}

	// GetKisi-----------------

	public void getKisi(int id) {

		try {

			PreparedStatement ps = this.db.prepareStatement("Select * from kisi where KisiID =?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				System.out.println(rs.getString("Tc"));
				System.out.println(rs.getString("Ad"));
				System.out.println(rs.getString("Soyad"));
				System.out.println(rs.getString("Email"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBase.baglantiKapa(this.db);
		}
	}

	// Update---------------------------
	public void UpdateKisi(Kisi k) {

		try {
			DataBase.baglan();

			PreparedStatement ps = this.db
					.prepareStatement("Update Kisi set Tc=?, Ad=?, Soyad=?, Email=? where KisiID =?");
			ps.setString(1, k.getTc());
			ps.setString(2, k.getAd());
			ps.setString(3, k.getSoyad());
			ps.setString(4, k.getEmail());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBase.baglantiKapa(this.db);
		}

	}

	// Delete---------------------------
	public void DeleteKisi(int id) {

		try {

			PreparedStatement ps = this.db.prepareStatement("Delete from kisi where KisiID =?");
			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBase.baglantiKapa(this.db);
		}
	}

	// Create------------------------------
	public int CreateKisi(Kisi k) {
		
		int result = 0;

		try {

			PreparedStatement ps = this.db.prepareStatement("insert into kisi(Tc,Ad,Soyad,email) values(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, k.getTc());
			ps.setString(2, k.getAd());
			ps.setString(3, k.getSoyad());
			ps.setString(4, k.getEmail());
			ps.executeUpdate();
			this.db.commit();
			
			ResultSet genKeys = ps.getGeneratedKeys();
			
			if ( genKeys.next() ) {
				result = genKeys.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBase.baglantiKapa(this.db);
		}
		
		return result;
	}

	public boolean isTcRecorded(String tc) {

		boolean var = false;
		Statement stmt = null;

		try {
			stmt = db.createStatement();

			PreparedStatement ps = this.db.prepareStatement("Select count(*) as c from kisi where Tc=?");
			ps.setString(1, tc);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				if (rs.getLong("c") == 1) {
					var = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBase.baglantiKapa(db);
		}

		return var;

	}
	
	public Kisi getKisibyTc(String tc) {
		
		Kisi k = new Kisi();
		
		try {
			PreparedStatement ps = this.db.prepareStatement("Select KisiID from kisi where Tc=?");
			ps.setString(1, tc);
			ResultSet rs= ps.executeQuery();
			
			if (rs.next()) {
				k.setKisiID(rs.getInt("KisiID"));
				k.setAd(rs.getString("Ad"));
				k.setSoyad(rs.getString("Soyad"));
				k.setEmail(rs.getString("Email"));
			} else {
				k=null;
			}
			
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			DataBase.baglantiKapa(db);
		}
		
		return k;
	}
	
	public Kisi getKisiById(int id)
	{
		Kisi k=new Kisi();
		
		try {
			PreparedStatement ps = this.db.prepareStatement("Select * from kisi where KisiID=?");
			ps.setInt(1, id);
	
			ResultSet rs= ps.executeQuery();
				
			if(rs.next())
			{
				k.setTc(rs.getString("Tc"));
				k.setAd(rs.getString("Ad"));
				k.setSoyad(rs.getString("Soyad"));
				k.setEmail(rs.getString("Email"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DataBase.baglantiKapa(db);
		}
		
		return k;
	}

	
}
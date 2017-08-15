 package Entity;
import java.util.ArrayList;
public class Kisi {
	int kisiID;
	String tc;
	String ad;
	String soyad;
	String email;
	ArrayList<AdresBilgi> adres;
	ArrayList<TelBilgi> telefon;
	public ArrayList<AdresBilgi> getAdres() {
		return adres;
	}
	public void setAdres(ArrayList<AdresBilgi> adres) {
		this.adres = adres;
	}
	public ArrayList<TelBilgi> getTelefon() {
		return telefon;
	}	
	public void setTelefon(ArrayList<TelBilgi> telefon) {
		this.telefon = telefon;
	}	
	public int getKisiID() {
		return kisiID;
	}	
	public void setKisiID(int kisiID) {
		this.kisiID = kisiID;
	}	
	public String getTc() {
		return tc;
	}	
	public void setTc(String tc) {
		this.tc = tc;
	}	
	public String getAd() {
		return ad;
	}	
	public void setAd(String ad) {
		this.ad = ad;
	}	
	public String getSoyad() {
		return soyad;
	}	
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}	
	public String getEmail() {
		return email;
	}	
	public void setEmail(String email) {
		this.email = email;
	}	
	public String toString()
	{
		return ad+ " " + telefon.size();
	}
}

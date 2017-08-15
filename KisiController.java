package Controller;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Model.AdresBilgiModel;
import Model.KisiModel;
import Model.TelBilgiModel;
import Entity.Kisi;

public class KisiController extends Controller {

	public boolean isTcRecorded(String tcNo) {

		KisiModel km = new KisiModel();
		return km.isTcRecorded(tcNo);

	}

	public boolean isEmailValid(String email) {
		final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public boolean isNameSurnameValid(Kisi k) {

		boolean result = false;
		final String NAMESURNAME_PATTERN = "^[A-Za-z\\sðüiþçöÐÜÝÞÇÖI]{2,20}$";

		Pattern pattern = Pattern.compile(NAMESURNAME_PATTERN);
		Matcher matcher = pattern.matcher(k.getAd());

		if (matcher.matches()) {
			matcher = pattern.matcher(k.getSoyad());
			if (matcher.matches()) {
				result = true;
			}
		}
		return result;

	}

	public Kisi getKisibyTc(String tc) {
		KisiModel km = new KisiModel();
		return km.getKisibyTc(tc);

	}

	public Kisi getKisiById(int id) {
		KisiModel km = new KisiModel();
		Kisi k = new Kisi();
		AdresBilgiModel abm=new AdresBilgiModel();
		TelBilgiModel tbm=new TelBilgiModel();
		if (id == 0) {
			System.out.println("Hata");
		} else {

			k = km.getKisiById(id);
			k.setAdres(abm.getKisiAdresler(id));
			k.setTelefon(tbm.getKisiTelefonlar(id));
		}
		return k;
	}

	public int record(Kisi k) {
		int result = 0;
		KisiModel km = new KisiModel();
		if (isEmailValid(k.getEmail())) {
			if (isNameSurnameValid(k)) {
				if (!isTcRecorded(k.getTc())) {
					result = km.CreateKisi(k);
				}
			}
		}

		return result;
	}

	public ArrayList<Kisi> getAllKisiler() {
		KisiModel km = new KisiModel();
		return km.getAllKisiler();
	}

}

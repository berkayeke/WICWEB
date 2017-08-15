package Controller;

import Entity.AdresBilgi;
import Model.AdresModel;

public class AdresController {

	public AdresBilgi record(int adresId, int kisiId) {
		AdresBilgi result = null;
		AdresModel am = new AdresModel();
		result = am.record(adresId, kisiId);

		return result;
	}
}
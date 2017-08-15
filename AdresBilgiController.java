package Controller;

import java.util.ArrayList;

import Entity.AdresBilgi;
import Entity.Kisi;
import Model.AdresBilgiModel;
import Model.KisiModel;


public class AdresBilgiController extends Controller {

	public int record(AdresBilgi a) {

		int result = 0;
		AdresBilgiModel abm = new AdresBilgiModel();
		result = abm.CreateAdres(a);

		return result;
	}

}
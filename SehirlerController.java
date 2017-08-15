package Controller;


import java.util.ArrayList;

import Entity.Sehir;
import Model.SehirModel;

public class SehirlerController extends Controller {

	

	public boolean isSehirValid(int id) {

		SehirModel sm = new SehirModel();
		return sm.isSehirValid(id);

	}
	
	public ArrayList<Sehir> getAllSehir()
	{
		SehirModel sm=new SehirModel();
		return sm.getAllSehir();
	}
}

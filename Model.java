package Model;

import java.sql.Connection;
import Main.DataBase;

public class Model {
	
	public Connection db;
	
	public Model()
	{
		db=DataBase.baglan();
	}

}
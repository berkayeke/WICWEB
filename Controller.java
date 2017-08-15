package Controller;

import java.sql.Connection;

import Main.DataBase;

public class Controller {

	public Connection db;

	public Controller() {
		db = DataBase.baglan();
	}

}

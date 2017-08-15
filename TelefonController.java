package Controller;

import Entity.TelBilgi;
import Model.TelefonModel;

public class TelefonController {

	public TelBilgi record(int telId, int kisiId) {
		TelBilgi result = null;

		TelefonModel tm = new TelefonModel();
		result = tm.getTelefonID(telId, kisiId);
		return result;
	}
}

package Controller;
import Entity.TelBilgi;
import Model.TelBilgiModel;

public class TelBilgiController extends Controller {
	public boolean validatePhoneNumber(String tel) {
		if (tel == null)
			return false;
		if (tel.matches("\\d{10}"))
			return true;
		else if (tel.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}"))
			return true;
		else if (tel.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}"))
			return true;
		else if (tel.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}"))
			return true;
		else
			return false;
	}
	public boolean isUniqueTel(String tel) {

		TelBilgiModel tbm = new TelBilgiModel();
		return tbm.isUniqueTel(tel);
	}

	public int record(TelBilgi tb) {
		int result = 0;
		TelBilgiModel tbm = new TelBilgiModel();
		if (validatePhoneNumber(tb.getNumara())) {
			if (isUniqueTel(tb.getNumara())) {
				result = tbm.CreateTelTip(tb);
			}
		}
		return result;
	}

}

package linguagil.cassandra.temperatura.service;

import java.util.Calendar;
import java.util.Date;

public class AbstractService {
	public Date limparDia(Date dia){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dia);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.HOUR, 0);
		return calendar.getTime();
	}
}

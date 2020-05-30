import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class Executar {
	static int delay = 1000;
	static int period = 10000;
	static SimpleDateFormat sdhora = new SimpleDateFormat("HH");
	static Timer timer = new Timer();
	static Integer parametroHoraParaExecutarTarefa = 14;

	public static void tarefa() {
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {

				String horaCorrenteDoSistema = obtemHoraCorrenteSistema();
				CompararHoraComParametroHoraExecutar.compararHora(horaCorrenteDoSistema
						,String.valueOf(parametroHoraParaExecutarTarefa));
				horaCorrenteDoSistema = atribuiHoraCorrenteZerada();
				parametroHoraParaExecutarTarefa++;
			}

		}, delay, period);

	}
	private static String obtemHoraCorrenteSistema() {
		return sdhora.format(Calendar.getInstance().getTime());
	}
	private static String atribuiHoraCorrenteZerada() {
		return "00:00:00";
	}
}

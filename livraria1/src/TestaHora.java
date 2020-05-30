import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class TestaHora {
//cria o obj calendar e atribui a hora e data do sistema	
Calendar calendar =  Calendar.getInstance();
//transforma o obj calendar em obj Date
Date data = calendar.getTime();
//cria um obj de formatação de data
SimpleDateFormat sddia = new SimpleDateFormat("dd-MM-yyyy");
//cria um obj de formatação de hora
SimpleDateFormat sdhora = new SimpleDateFormat("HH:mm:ss");
	
	@Test
	public void testHoraDoSO() {
		//gera a string final formatada no estilo "dd-MM-yyyy"
		String dia = sddia.format(data);
		System.out.printf("Data  :" + data);
		//gera a string final formatada no estilo "HH:mm:ss"
		String hora = sdhora.format(data);
		System.out.printf("\nHora:  " + hora);
		assertTrue("Igual", hora=="12:25:50" );
	}

}

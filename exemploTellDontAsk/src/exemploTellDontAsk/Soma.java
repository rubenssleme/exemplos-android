package exemploTellDontAsk;

public class Soma {

	private double resultadoSoma;
	private double valor1 = 10.0; 
	private double valor2 = 15.0;
	
	public double calculaSoma() {
		return resultadoSoma = (valor1+valor2);
	}

	@Override
	public String toString() {
		return "Soma [resultadoSoma=" + resultadoSoma + ", valor1=" + valor1 + ", valor2=" + valor2 + "]";
	}
}

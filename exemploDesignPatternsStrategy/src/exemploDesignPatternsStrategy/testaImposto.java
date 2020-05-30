package exemploDesignPatternsStrategy;

public class testaImposto {

	public static void main(String[] args) {
		ICMS icms = new ICMS();
		ISS iss = new ISS();
		Orcamento orcamento = new Orcamento(500.0);
		CalculadorDeImposto calculador = new CalculadorDeImposto();
		
		calculador.realizaCalculo(orcamento, iss);
		calculador.realizaCalculo(orcamento, icms);
	} 

}

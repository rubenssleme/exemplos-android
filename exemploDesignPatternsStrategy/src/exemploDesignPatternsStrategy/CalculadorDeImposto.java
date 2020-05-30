package exemploDesignPatternsStrategy;

public class CalculadorDeImposto {

	public void realizaCalculo(Orcamento orcamento, Imposto impostoQualquer) {
		double imposto = impostoQualquer.calcula(orcamento);
		System.out.println(impostoQualquer.getClass().toString() +" - "+ imposto);
	}
}



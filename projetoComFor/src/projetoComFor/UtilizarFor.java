package projetoComFor;

public class UtilizarFor{

	private int incremento = 0;

	public void contador() {
		for(int i=0;i<10;i++) {
			incremento = incremento + 2;
			System.out.println("O valor do incremente � " + incremento + 
					"e o valor de <i> �"+ i);
		}
	}
}

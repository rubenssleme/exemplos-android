package projetoComFor_A;

public class Contador {
	
	
	
	private int incremento = 0;

	public void  contar() {
		for(int i=0;i<10;i++){
			
			System.out.println("O valor de incremento � " + incremento +
					"o valor de <i> � " + i);
			incremento = incremento + 2;
		}
		
	}
	

}

import javax.swing.JOptionPane;

public class Calculadora {

	private int valor1 ;
	private int valor2;
	
	
	public Calculadora() {
		
	}
	public int getValor1() {
		return valor1;
	}
	public void setValor1(int valor1) {
		this.valor1 = valor1;
	}
	public int getValor2() {
		return valor2;
	}
	public void setValor2(int valor2) {
		this.valor2 = valor2;
	}
	
	public void somar() {
		valor1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor1"));	
		valor2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor2"));
  
		System.out.println("A soma dos valores eh " + (valor1 + valor2));
	}
	
	
	
	
}

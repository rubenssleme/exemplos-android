package br.com.stefanini.utilitarios;

import javax.swing.JOptionPane;

/**
 *
 * @author Rubens Leme
 */
public class Mensagem {
    
    public static void exbirMensagem(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }
    
    public static String exbirPergunta(String msg){
       return  JOptionPane.showInputDialog(msg);
    }
   
}

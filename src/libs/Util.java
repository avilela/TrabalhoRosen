/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package libs;

import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Augusto-PC
 */
public class Util {
   public void LimpaTabela(DefaultTableModel table){
        int i = table.getRowCount();
        if(i > 0){
           for(int j=0;j<i;j++){
                table.removeRow(0);
            }
        }
    }
   
   public boolean Valida(ArrayList<JTextField> fields){
        boolean retorno = true;
        for (JTextField field : fields) {
            if(field.getText().equals("")){
                retorno = false;
            }
        }
        
        return retorno;
   }
   
   public void LimpaCampos(ArrayList<JTextField> fields){
        for (JTextField field : fields) {
            field.setText("");
        }
   }
   
   public void SomenteNumeros(java.awt.event.KeyEvent evt){
       String caracteres = "1234567890";
        if(!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }
   }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelDao;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author kasil
 */
public class Table extends AbstractTableModel{
    private ArrayList linhas = null;
    private String[] colunas = null;
    
    public Table(ArrayList lin, String[] col){
        setLinhas(lin);
        setColunas(col);
    }
    public ArrayList getLinhas(){
        return linhas;
    }
    public void setLinhas(ArrayList dados){
        linhas = dados;
    }
    public String[] getColunas(){
        return colunas;
    }
    public void setColunas(String[] nomes){
        colunas = nomes;
    }
    public int getColumnCount(){
        return colunas.length; //contar qtd de colunas
        
    }
    public int getRowCount(){//contar qtd de linhas
        return linhas.size();
        //return dados.size();
    }
    public String getColumnName(int numCol){ //nome da coluna
        return colunas[numCol];
    }
    public Object getValueAt(int numLin,int numCol){
        Object[] linha = (Object[])getLinhas().get(numLin);
        return linha[numCol];
    }

    /*public int getSelectedRow() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}

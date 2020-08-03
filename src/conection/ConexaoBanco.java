
package conection;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kasil
 */
public class ConexaoBanco {
    
    public Statement stm; //realizar pesquisa no bd
    public ResultSet rs; //armazenar resultado da pesquisa
    private final String driver = "org.postgresql.Driver"; //servico de banco
    private final String caminho = "jdbc:postgresql://localhost:5432/medclin"; //onde ta alocado
    private final String usuario = "postgres"; //postgres
    private final String senha = "28031970"; //senha do post
    public Connection conn; //conexao com o banco
    
    public void conexao(){ //conectar com o banco
        
        try {
            System.setProperty("jdbc.Drivers", driver);
            conn = DriverManager.getConnection(caminho, usuario, senha);
            //JOptionPane.showMessageDialog(null, "Conexão efetuada com sucesso!");
           
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showConfirmDialog(null, "ERROR: Conexão não efetuada!\n"+e.getMessage());
        }
        
    }
    
    public void executaSql(String sql){
        try {
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);  // o type scroll insentitive serve para diferenciar algo seja ele maiusculo ou não. O concur read only vai pecorrer tanto do inicio ao fim quanto o contrario
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: Executa sql\n" + ex.getMessage());
        }
        
    }
    
    public void desconecta(){ //desconctar do banco
        
        try {
            conn.close();
            //JOptionPane.showMessageDialog(null, "Banco desconectado com sucesso!");
        } catch (HeadlessException | SQLException e) {
        
            JOptionPane.showMessageDialog(null, "ERROR: Desconexão não efetuada"+e.getMessage());
        }
        
    }
    
}

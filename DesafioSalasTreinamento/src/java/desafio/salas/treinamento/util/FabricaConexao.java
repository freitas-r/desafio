//Classe criada para gerenciar as conexões ao banco de dados, assim quando um metodo necessida acessar o banco basta chamar estes métodos
package desafio.salas.treinamento.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FabricaConexao {
    //Configuração de acesso ao banco
    private static Connection conexao;
    private static final String URL_CONEXAO = "jdbc:mysql://localhost/salas-treinamento";
    private static final String USUARIO = "root";
    private static final String SENHA = "root";
    
    //Método para abrir uma conexão
    public static Connection getConexao(){
        if(conexao == null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conexao = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(FabricaConexao.class.getName()).log(Level.SEVERE, null, ex);  
                
            }
    }
    return conexao;
}
    //Método para fechar a conexão
    public static void fecharConexao(){
        if(conexao != null){
            try {
                conexao.close();
                conexao = null;
            } catch (SQLException ex) {
                Logger.getLogger(FabricaConexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
   
    }
}
    
    

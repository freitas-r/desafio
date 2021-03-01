//Classe responsável por realizar a interface com o banco de dados
package desafio.salas.treinamento.DAO;

import desafio.salas.treinamento.entidade.Cafe;
import desafio.salas.treinamento.util.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CafeDAO {
    //Método para salavar o espaço de café no banco de dados
    public void salvar(Cafe cafe) {
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareCall("INSERT INTO cafe(nome,lotacao) VALUES (?,?)");
            ps.setString(1, cafe.getNome());
            ps.setInt(2, cafe.getLotacao());
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(CafeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //Método para gerar a lista de espaços de café salvos no banco de dados
    public  List<Cafe> buscar(){
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM cafe");
            ResultSet resultSet = ps.executeQuery();
            List<Cafe> cafes = new ArrayList<>();
            while(resultSet.next()){//Percorre o array de participantes enquanto o próximo elemento não seja nulo
                Cafe cafe = new Cafe();
                cafe.setId(resultSet.getInt("idcafe"));
                cafe.setNome(resultSet.getString("nome"));
                cafe.setLotacao(resultSet.getInt("lotacao"));
                cafes.add(cafe);
            }
            return cafes;
            
        }catch (SQLException ex){
            Logger.getLogger(ParticipanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
    }
    
    
}

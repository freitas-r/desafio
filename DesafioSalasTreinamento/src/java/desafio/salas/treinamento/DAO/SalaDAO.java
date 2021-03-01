//Classe responsável por realizar a interface com o banco de dados
package desafio.salas.treinamento.DAO;

import desafio.salas.treinamento.entidade.Sala;
import desafio.salas.treinamento.util.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SalaDAO {
    
    //Método para salavar sala no banco de dados
    public void salvar(Sala sala) {
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareCall("INSERT INTO sala(nome,lotacao) VALUES (?,?)");
            ps.setString(1, sala.getNome());
            ps.setInt(2, sala.getLotacao());
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(SalaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
        //Método para gerar a lista de salas  salvas no banco de dados
        public  List<Sala> buscar(){
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM sala");
            ResultSet resultSet = ps.executeQuery();
            List<Sala> salas = new ArrayList<>();
            while(resultSet.next()){//Percorre o array de salas enquanto o próximo elemento não seja nulo
                Sala sala = new Sala();
                sala.setId(resultSet.getInt("idsala"));
                sala.setNome(resultSet.getString("nome"));
                sala.setLotacao(resultSet.getInt("lotacao"));
                salas.add(sala);
            }
            return salas;
            
        }catch (SQLException ex){
            Logger.getLogger(ParticipanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
    }
    
    
}


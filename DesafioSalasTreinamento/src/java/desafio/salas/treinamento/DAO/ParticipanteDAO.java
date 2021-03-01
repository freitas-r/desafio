//Classe responsável por realizar a interface com o banco de dados
package desafio.salas.treinamento.DAO;

import desafio.salas.treinamento.entidade.Participante;
import desafio.salas.treinamento.util.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ParticipanteDAO {
    
    //Método para salavar participante no banco de dados
    public void salvar(Participante participante){
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareCall("INSERT INTO participante(nome,sobrenome) VALUES (?,?)");
            ps.setString(1, participante.getNome());
            ps.setString(2, participante.getSobrenome());
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ParticipanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Método para gerar a lista de participantes salvos no banco de dados
    public  List<Participante> buscar(){
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM participante");
            ResultSet resultSet = ps.executeQuery();
            List<Participante> participantes = new ArrayList<>();
            while(resultSet.next()){//Percorre o array de participantes enquanto o próximo elemento não seja nulo
                Participante participante = new Participante();
                participante.setId(resultSet.getInt("idparticipante"));
                participante.setNome(resultSet.getString("nome"));
                participante.setSobrenome(resultSet.getString("sobrenome"));
                participantes.add(participante);
            }
            return participantes;
            
        }catch (SQLException ex){
            Logger.getLogger(ParticipanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
    }
    
}

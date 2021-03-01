//Classe manegedbean responsável por fazer o intermédio entre a interface e a classe DAO

package desafio.salas.treinamento.bean;

import desafio.salas.treinamento.DAO.ParticipanteDAO;
import desafio.salas.treinamento.entidade.Participante;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class ParticipantesBean {
    //Cria o objeto participante e a lista de participantes
    private Participante participante = new Participante();
    private List<Participante> participantes = new ArrayList<>();
    private final ParticipanteDAO participanteDAO = new ParticipanteDAO();
    
    //Método para enviar ao DAO e ao banco e adicionar a lista de participantes
    public void adicionar(){
        try{
            participanteDAO.salvar(participante);
            participantes.add(participante);
            participante = new Participante();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Metodo para listar os participantes cadastrados no banco através do DAO
    
    public void listar(){
        participantes = participanteDAO.buscar();
    }

    //Métodos get e set
    
    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }
    
    
    
    
}

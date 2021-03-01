//Classe manegedbean responsável por fazer o intermédio entre a interface e a classe DAO

package desafio.salas.treinamento.bean;

import desafio.salas.treinamento.DAO.SalaDAO;
import desafio.salas.treinamento.entidade.Sala;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class SalasBean {
    //Cria o objeto sala e a lista de salas
    private Sala sala = new Sala();
    private List<Sala> salas = new ArrayList<>();
    private final SalaDAO salaDAO = new SalaDAO();
    
    //Método para enviar ao DAO e ao banco e adicionar a lista de salas
    public void adicionar(){
        try {
            salaDAO.salvar(sala);
            salas.add(sala);
            sala = new Sala();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Metodo para listar as salas cadastradas no banco através do DAO
    
    public void listar(){
        salas = salaDAO.buscar();
    }

    //Métodos get e set
    
    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }
    
    
    
}

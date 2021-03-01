//Classe manegedbean responsável por fazer o intermédio entre a interface e a classe DAO

package desafio.salas.treinamento.bean;

import desafio.salas.treinamento.DAO.CafeDAO;
import desafio.salas.treinamento.entidade.Cafe;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class CafesBean {
   //Cria o objeto café e a lista de espaços de café
    private Cafe cafe = new Cafe();
    private List<Cafe> cafes = new ArrayList<>();
    private final CafeDAO cafeDAO = new CafeDAO();
    
    //Método para enviar ao DAO e ao banco e adicionar a lista de cafés
    public void adicionar(){
        try{
            cafeDAO.salvar(cafe);
            cafes.add(cafe);
            cafe = new Cafe();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Metodo para listar os cafés cadastrados no banco através do DAO
    
    public void listar(){
        cafes = cafeDAO.buscar();
    }

    //Métodos get e set
    
    public Cafe getCafe() {
        return cafe;
    }

    public void setCafe(Cafe cafe) {
        this.cafe = cafe;
    }

    public List<Cafe> getCafes() {
        return cafes;
    }

    public void setCafes(List<Cafe> cafes) {
        this.cafes = cafes;
    }
    
    
    
}

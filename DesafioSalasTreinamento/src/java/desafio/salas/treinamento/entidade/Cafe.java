//Cria a entidade café, representa as informações padrões de todos os cafés

package desafio.salas.treinamento.entidade;

import java.util.Objects;

public class Cafe {
    private Integer id;
    private String nome;
    private Integer lotacao;
    
    //Métodos get e set das propriedades da entidade

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getLotacao() {
        return lotacao;
    }

    public void setLotacao(Integer lotacao) {
        this.lotacao = lotacao;
    }
    
    //Metodos equals e hashcode para fins de comparação dos objetos do banco

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cafe other = (Cafe) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}

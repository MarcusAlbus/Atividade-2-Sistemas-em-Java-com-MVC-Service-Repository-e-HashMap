package model.repository;
import model.entity.Locacao;
import java.util.HashMap;

public class LocacaoRepository {

    HashMap <Integer, Locacao> listaLocacao = new HashMap<>();

    public void setListaLocacao(HashMap<Integer, Locacao> listaLocacao) {
        this.listaLocacao = listaLocacao;
    }

    public HashMap<Integer, Locacao> getListaLocacao(){
        return listaLocacao;
    }

    public Locacao salvarLocacao (Locacao locacao){
        listaLocacao.put(locacao.getId(), locacao);
        return locacao;
    }

    public Locacao buscarLocacaoId(int id){
        return listaLocacao.get(id);
    }

    public void removerLocacao(int id){
        listaLocacao.remove(id);
    }

    public Locacao alterarLocacao(Locacao locacao){
        listaLocacao.put(locacao.getId(), locacao);
        return locacao;
    }

}

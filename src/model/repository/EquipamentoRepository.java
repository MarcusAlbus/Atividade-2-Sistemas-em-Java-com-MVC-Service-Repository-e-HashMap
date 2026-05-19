package model.repository;
import model.entity.Equipamento;
import java.util.HashMap;

public class EquipamentoRepository {

    HashMap<Integer, Equipamento> listaEquipamento = new HashMap<>();

    public void setListaEquipamento(HashMap<Integer, Equipamento> listaEquipamento){
        this.listaEquipamento = listaEquipamento;
    }
    public HashMap<Integer, Equipamento> getListaEquipamento(){
        return listaEquipamento;
    }

    public Equipamento salvarEquipamento (Equipamento equipamento){
        listaEquipamento.put(equipamento.getId(), equipamento);
        return equipamento;
    }
    public Equipamento buscarEquipamentoId (int id){
        return listaEquipamento.get(id);
    }

    public void removerEquipamento(int id){
        listaEquipamento.remove(id);
    }

    public Equipamento alterarEquipamento (Equipamento equipamento){
        listaEquipamento.put(equipamento.getId(), equipamento);
        return equipamento;
    }
}

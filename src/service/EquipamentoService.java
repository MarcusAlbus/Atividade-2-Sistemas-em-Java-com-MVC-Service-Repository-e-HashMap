package service;

import model.entity.Equipamento;
import model.repository.EquipamentoRepository;

public class EquipamentoService {

     private EquipamentoRepository equipamentoRepository;

     public EquipamentoService(EquipamentoRepository equipamentoRepository){
         this.equipamentoRepository = equipamentoRepository;
     }

     public Equipamento cadastrarEquipamento(Equipamento equipamento){
         return equipamentoRepository.salvarEquipamento(equipamento);
     }
}

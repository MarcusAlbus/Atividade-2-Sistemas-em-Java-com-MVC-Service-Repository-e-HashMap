package controller;

import model.entity.Equipamento;
import model.service.EquipamentoService;

public class EquipamentoController {

    private EquipamentoService service;

    public EquipamentoController(EquipamentoService service) {
        this.service = service;
    }

    public boolean cadastrar (int id, String nome, String tipo, boolean disponivel) {

        try {

            if (id <= 0) {
                return false;
            }

            if (nome == null || nome.isEmpty()) {
                return false;
            }

            if (tipo == null || tipo.isEmpty()) {
                return false;
            }

            Equipamento equipamento = new Equipamento(id, nome, tipo, disponivel);
            return service.cadastrar(equipamento);

        }

            catch(Exception e) {

                System.out.println("Erro ao cadastrar equipamento: " + e.getMessage());
            }

            return false;
        }
    }
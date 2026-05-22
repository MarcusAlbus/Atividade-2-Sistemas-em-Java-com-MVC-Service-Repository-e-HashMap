package controller;

import model.entity.Aluno;
import model.service.AlunoService;

public class AlunoController {

    private AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    public boolean cadastrar(int id, String nome, int matricula)

    {

    try {

        if(id <= 0) {
            return false;
        }

        if(nome == null || nome.isEmpty()) {
            return false;
        }

        if(matricula <= 0) {
            return false;
        }

        Aluno aluno = new Aluno(id, nome, matricula);
        return service.cadastrar(aluno);

    }

    catch(Exception e) {
        System.out.println("Erro ao cadastrar aluno: " + e.getMessage());
    }

    return false;

    }
}
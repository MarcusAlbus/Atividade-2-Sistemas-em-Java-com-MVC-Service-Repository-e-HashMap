package view;

import model.entity.Aluno;
import model.service.AlunoService;

import java.util.Scanner;

public class AlunoView {

    private AlunoService alunoService;

    public AlunoView(AlunoService alunoService){
        this.alunoService = alunoService;
    }

    public void menu(){
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        do{
            System.out.println("+-----------------------------------+");
            System.out.println("|         Gerenciar Alunos          |");
            System.out.println("+-----------------------------------+");
            System.out.println("|                                   |");
            System.out.println("|  1- Cadastrar Alunos              |");
            System.out.println("|  0- Voltar ao menu principal      |");
            System.out.println("|                                   |");
            System.out.println("+-----------------------------------+");

            try{
                opcao = scanner.nextInt();
                scanner.nextLine();

                if(opcao < 0 ){
                    System.out.println("ERRO: Opção não pode ser negativa.");
                    continue;
                }

                switch (opcao){
                    case 1 -> cadastrarAluno();
                    case 0 -> System.out.println("Voltando ...");
                    default -> System.out.println("ERRO: Opção inválida!");
                }
            }catch (Exception e){
                System.out.println("ERRO: Apenas digite números inteiros.");
                scanner.nextLine();
            }
        }while(opcao != 0);
    }
}

private void cadastrarAluno(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("\n ----- Novo Aluno -----");
    int id = -1;
    String nome;
    String matricula;

    while(true){
        System.out.println("Digite o ID do aluno: ");

        try{
            id = scanner.nextInt();
            scanner.nextLine();

            if( id < 0){
                System.out.println("ERRO: O id não pode ser negativo.");
                continue;
            }
            break;
        } catch (Exception e) {
            System.out.println("ERRO: Apenas digite números inteiros");
            scanner.nextLine();
        }
    }

    while(true){
        System.out.println("Digite o Nome do Aluno: ");
        nome = scanner.nextLine().trim();
        if(nome.isEmpty()){
            System.out.println("ERRO: Nome não pode ser vazio.");
            continue;
        }
        break;
    }

    while(true){
        System.out.println("Digite a matrícula do Aluno: ");
        matricula = scanner.nextLine().trim();
        if(matricula.isEmpty()){
            System.out.println("ERRO: Matrícula não pode ser vazia.");
            continue;
        }
    }

    try{
        Aluno novoAluno = new Aluno(id, nome, matricula);
        alunoService.cadastrar(novoAluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }catch (Exception e){
        System.out.println("ERRO: "+ e.getMessage());
    }
}


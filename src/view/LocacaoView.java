package view;

import model.entity.Locacao;

import java.util.Scanner;

public class LocacaoView {

    private  LocacaoController locacaoController;

    public LocacaoView(LocacaoController locacaoController) {
        this.locacaoController = locacaoController;
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;
        do {
            System.out.println("\n--- GERENCIAR LOCAÇÕES ---");
            System.out.println("1. Realizar Locação");
            System.out.println("2. Listar Locações");
            System.out.println("3. Atualizar Dados da Locação");
            System.out.println("4. Finalizar Locação (Devolução)");
            System.out.println("5. Remover Locação");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                if (opcao < 0) {
                    System.out.println("[Erro] Opção não pode ser negativa.");
                    continue;
                }

                switch (opcao) {
                    case 1 -> realizarLocacao();
                    case 2 -> listarLocacoes();
                    case 3 -> atualizarLocacao();
                    case 4 -> finalizarLocacao();
                    case 5 -> removerLocacao();
                    case 0 -> System.out.println("Voltando...");
                    default -> System.out.println("[Erro] Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("[Erro] Digite apenas números inteiros!");
                scanner.nextLine();
            }
        } while (opcao != 0);
    }

    private void realizarLocacao() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n-- Nova Locação --");

        int id = -1;
        int alunoId = -1;
        int equipamentoId = -1;
        String dataLocacao;

        // Leitura passo a passo do ID da Locação
        while (true) {
            System.out.print("Digite o ID da Locação: ");
            try {
                id = scanner.nextInt();
                scanner.nextLine();
                if (id < 0) {
                    System.out.println("[Erro] O ID não pode ser negativo.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("[Erro] Erro de digitação. Digite um número inteiro.");
                scanner.nextLine();
            }
        }


        while (true) {
            System.out.print("Digite o ID do Aluno: ");
            try {
                alunoId = scanner.nextInt();
                scanner.nextLine();
                if (alunoId < 0) {
                    System.out.println("[Erro] O ID não pode ser negativo.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("[Erro] Erro de digitação. Digite um número inteiro.");
                scanner.nextLine();
            }
        }


        while (true) {
            System.out.print("Digite o ID do Equipamento: ");
            try {
                equipamentoId = scanner.nextInt();
                scanner.nextLine();
                if (equipamentoId < 0) {
                    System.out.println("[Erro] O ID não pode ser negativo.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("[Erro] Erro de digitação. Digite um número inteiro.");
                scanner.nextLine();
            }
        }


        while (true) {
            System.out.print("Digite a Data da Locação: ");
            dataLocacao = scanner.nextLine().trim();
            if (dataLocacao.isEmpty()) {
                System.out.println("[Erro] A data não pode ser vazia.");
                continue;
            }
            break;
        }

        try {
            locacaoController.criarLocacao(id, alunoId, equipamentoId, dataLocacao);
            System.out.println("Locação realizada com sucesso! Equipamento reservado.");
        } catch (Exception e) {
            System.out.println("[Erro] " + e.getMessage());
        }
    }

    private void listarLocacoes() {
        System.out.println("\n-- Lista de Locações --");


        if (locacaoController.listarTodas().isEmpty()) {
            System.out.println("Nenhuma locação registrada.");
            return;
        }

        for (Locacao l : locacaoController.listarTodas().values()) {
            System.out.printf("ID Locação: %d | Aluno: %s | Equipamento: %s | Data: %s | Status: %s\n",
                    l.getId(), l.getAluno().getNome(), l.getEquipamento().getNome(), l.getDataLocacao(), l.getStatus());
        }
    }

    private void atualizarLocacao() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n-- Atualizar Locação --");

        int id = -1;
        String novaData;

        // Leitura do ID para atualizar
        while (true) {
            System.out.print("Digite o ID da Locação que deseja alterar: ");
            try {
                id = scanner.nextInt();
                scanner.nextLine();
                if (id < 0) {
                    System.out.println("[Erro] O ID não pode ser negativo.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("[Erro] Erro de digitação. Digite um número inteiro.");
                scanner.nextLine();
            }
        }

        // Leitura da nova data
        while (true) {
            System.out.print("Digite a nova Data da Locação: ");
            novaData = scanner.nextLine().trim();
            if (novaData.isEmpty()) {
                System.out.println("[Erro] A data não pode ser vazia.");
                continue;
            }
            break;
        }

        try {
            locacaoController.atualizarData(id, novaData);
            System.out.println("Locação atualizada com sucesso!");
        } catch (Exception e) {
            System.out.println("[Erro] " + e.getMessage());
        }
    }

    private void finalizarLocacao() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n-- Finalizar Locação (Devolução) --");

        int id = -1;

        while (true) {
            System.out.print("Digite o ID da Locação a ser finalizada: ");
            try {
                id = scanner.nextInt();
                scanner.nextLine();
                if (id < 0) {
                    System.out.println("[Erro] O ID não pode ser negativo.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("[Erro] Erro de digitação. Digite um número inteiro.");
                scanner.nextLine();
            }
        }

        try {
            locacaoController.finalizarLocacao(id);
            System.out.println("Locação finalizada com sucesso! Equipamento liberado.");
        } catch (Exception e) {
            System.out.println("[Erro] " + e.getMessage());
        }
    }

    private void removerLocacao() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n-- Remover Locação --");

        int id = -1;

        while (true) {
            System.out.print("Digite o ID da Locação a ser removida: ");
            try {
                id = scanner.nextInt();
                scanner.nextLine();
                if (id < 0) {
                    System.out.println("[Erro] O ID não pode ser negativo.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("[Erro] Erro de digitação. Digite um número inteiro.");
                scanner.nextLine();
            }
        }

        try {
            locacaoController.removerLocacao(id);
            System.out.println("Locação removida do sistema com sucesso!");
        } catch (Exception e) {
            System.out.println("[Erro] " + e.getMessage());
        }
    }
}
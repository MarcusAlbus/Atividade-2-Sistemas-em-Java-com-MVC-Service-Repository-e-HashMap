package service;
import entity.Aluno;

import entity.Aluno;

public class LocacaoService {

    private LocacaoRepository locacaoRepository;
    private AlunoRepository alunoRepository;
    private EquipamentoRepository equipamentoRepository; //precisa das classes aqui

    public LocacaoService(LocacaoRepository locacaoRepository, AlunoRepository alunoRepository, EquipamentoRepository equipamentoRepository){
        this.locacaoRepository = locacaoRepository;
        this.alunoRepository = alunoRepository;
        this.equipamentoRepository = equipamentoRepository;
    }

    public Locacao cadastrarLocacao(Locacao locacao){
        if(!alunoRepository.verificarExistenciaAluno(locacao.getAluno().getId())){
            throw new RuntimeException("O aluno não existe.");
        }

        if(!equipamentoRepository.verificarExistenciaEquipamento(locacao.getEquipamento().getId())){
            throw new RuntimeException("O equipamento não existe.");
        }

        if(!equipamentoRepository.verificarDisponibilidadeEquipamento(locacao.getEquipamento().getId())){
            throw new RuntimeException("O equipamento está indisponível.");
        }

        locacao.getEquipamento().setDisponivel(false);
        return locacaoRepository.criarLocacao(locacao);
    }

    public List<Locacao> listarLocacao(){
        return locacaoRepository.listarLocacoes();
    }

    public Locacao removerLocacao(int id){
        locacaoRepository.disponibilizarEquipamento(id).setDisponivel(true);
        if(locacaoRepository.devolverLocacao(id).getStatus() == false)
            throw new RuntimeException("Locação finalizada.");
        return locacaoRepository.removerLocacao(id);
    }


}

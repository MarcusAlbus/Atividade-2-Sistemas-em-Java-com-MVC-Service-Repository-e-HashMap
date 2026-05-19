package model.repository;
import model.entity.Aluno;
import java.util.HashMap;

public class AlunoRepository {

    HashMap<Integer, Aluno> listaAluno = new HashMap<>();

    public void setListaAluno(HashMap<Integer, Aluno> listaAluno) {
        this.listaAluno = listaAluno;
    }

    public HashMap<Integer, Aluno> getListaAluno() {
        return listaAluno;
    }

    public Aluno salvarAluno(Aluno aluno){
        listaAluno.put(aluno.getId(), aluno);
        return aluno;
    }

    public Aluno buscarAlunoId(int id){
        return listaAluno.get(id);
    }

    public void removerAluno(int id){
        listaAluno.remove(id);
    }

    public Aluno alterarAluno(Aluno aluno){
        listaAluno.put(aluno.getId(), aluno);
        return aluno;
    }
}

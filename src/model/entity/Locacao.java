package model.entity;
import java.time.LocalDate;

public class Locacao {

    protected int id;
    private Aluno aluno;
    private Equipamento equipamento;
    protected String status;

    public Locacao(int id, Aluno aluno, Equipamento equipamento, String status){

        this.id = id;
        this.aluno = aluno;
        this.equipamento = equipamento;
        this.status = status;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setAluno(Aluno aluno){
        this.aluno = aluno;
    }

    public Aluno getAluno(){
        return aluno;
    }

    public void setEquipamento(Equipamento equipamento){
        this.equipamento = equipamento;
    }

    public Equipamento getEquipamento(){
        return equipamento;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }

}

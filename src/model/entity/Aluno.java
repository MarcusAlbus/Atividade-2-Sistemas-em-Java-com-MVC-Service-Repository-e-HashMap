package model.entity;

public class Aluno {

    protected int id;
    protected String nome;
    protected String matricula;

    public Aluno(int id, String nome, String matricula){

        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    public String getMatricula(){
        return matricula;
    }
}

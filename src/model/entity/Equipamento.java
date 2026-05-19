package model.entity;

public class Equipamento {

    protected int id;
    protected String nome;
    protected String tipo;
    protected boolean disponivel;

    public Equipamento(int id, String nome, String tipo, boolean disponivel){

        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.disponivel = disponivel;
    }

    public void setId(int id){
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

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public String getTipo(){
        return tipo;
    }

    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }

    public boolean getDisponivel(){
        return disponivel;
    }


}

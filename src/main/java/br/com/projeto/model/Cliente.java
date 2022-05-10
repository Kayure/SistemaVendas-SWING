package br.com.projeto.model;

public class Cliente {
    private int id;
    private String nome;
    private String email;
    private String cpf;
    private String celular;
    private String endereco;
    private String obs; 

    

    

    public Cliente(int id, String nome, String email, String cpf, String celular, String endereco, String obs) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.celular = celular;
        this.endereco = endereco;
        this.obs = obs;
    }
    public String getObs() {
        return obs;
    }
    public void setObs(String obs) {
        this.obs = obs;
    }



    public int getId() {
        return id;
    }  

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cliente(String cpf) {
        this.cpf = cpf;
    }


    public Cliente() {
    }

    public Cliente(String nome2, String email2, String cpf2, String celular2, String endereco2, String obs2) {
    }
    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    

    
   
    
    
}

package br.com.hera.model.dto;

import java.time.LocalDateTime;

public class Acompanhante {
    private int id;
    private String nome;
    private Telefone telefone;
    private String parentesco;
    private String email;
    private LocalDateTime dataCadastro;

    public Acompanhante() {
    }

    public Acompanhante(String nome, Telefone telefone, String parentesco, String email, LocalDateTime dataCadastro) {
        this.nome = nome;
        this.telefone = telefone;
        this.parentesco = parentesco;
        this.email = email;
        this.dataCadastro = dataCadastro;
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

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}

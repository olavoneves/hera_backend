package br.com.hera.model.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Paciente {
    private int id;
    private String nome;
    private String email;
    private String sexo;
    private Telefone telefone;
    private String status;
    private int consultasRestantes;
    private int faltas;
    private boolean possuiDeficiencia;
    private String tipoDeficiencia;
    private boolean videoEnviado;
    private LocalDate dataNascimento;
    private String endereco;
    private String preferenciaContato;
    private LocalDateTime dataCadastro;
    private LocalDateTime ultimaAtualizacao;
    private Acompanhante acompanhante;

    public Paciente() {
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getConsultasRestantes() {
        return consultasRestantes;
    }

    public void setConsultasRestantes(int consultasRestantes) {
        this.consultasRestantes = consultasRestantes;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public boolean isPossuiDeficiencia() {
        return possuiDeficiencia;
    }

    public void setPossuiDeficiencia(boolean possuiDeficiencia) {
        this.possuiDeficiencia = possuiDeficiencia;
    }

    public String getTipoDeficiencia() {
        return tipoDeficiencia;
    }

    public void setTipoDeficiencia(String tipoDeficiencia) {
        this.tipoDeficiencia = tipoDeficiencia;
    }

    public boolean isVideoEnviado() {
        return videoEnviado;
    }

    public void setVideoEnviado(boolean videoEnviado) {
        this.videoEnviado = videoEnviado;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getPreferenciaContato() {
        return preferenciaContato;
    }

    public void setPreferenciaContato(String preferenciaContato) {
        this.preferenciaContato = preferenciaContato;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDateTime getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(LocalDateTime ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    public Acompanhante getAcompanhante() {
        return acompanhante;
    }

    public void setAcompanhante(Acompanhante acompanhante) {
        this.acompanhante = acompanhante;
    }
}

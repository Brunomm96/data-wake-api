package br.com.datawake.datawakeapi.service.protheus.dto;

public class ProtheusSavDTO {

    public ProtheusSavDTO() {
    }

    public ProtheusSavDTO(String encerramento, String status, String titulo, Double valor, Double saldo, Integer id_unico, String projeto) {
        this.encerramento = encerramento;
        this.status = status;
        this.titulo = titulo;
        this.valor = valor;
        this.saldo = saldo;
        this.id_unico = id_unico;
        this.projeto = projeto;
    }

    private String encerramento;

    private String status;

    private String titulo;

    private Double valor;

    private Double saldo;

    private Integer id_unico;

    private String projeto;

//    GETTERS AND SETTERS

    public String getEncerramento() {
        return encerramento;
    }

    public void setEncerramento(String encerramento) {
        this.encerramento = encerramento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Integer getId_unico() {
        return id_unico;
    }

    public void setId_unico(Integer id_unico) {
        this.id_unico = id_unico;
    }

    public String getProjeto() {
        return projeto;
    }

    public void setProjeto(String projeto) {
        this.projeto = projeto;
    }
}

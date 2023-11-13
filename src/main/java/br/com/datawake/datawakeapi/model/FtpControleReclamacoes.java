package br.com.datawake.datawakeapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.crypto.Data;

import java.util.Objects;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table(name = "Controle_de_Reclamações_de_Clientes")

public class FtpControleReclamacoes {

    @Id
    @Column(name = "ITEM", nullable = false)
    private String item;

    @Column(name = "MÊS")
    private String mes;

    @Column(name = "Nº_8D")
    private String n8d;

    @Column(name = "DATA_DE_ABERTURA")
    private String data_Abertura;

    @Column(name = "ANALISTA_RESPONSÁVEL")
    private String analista_Responsavel;

    @Column(name = "CLIENTE")
    private String cliente;

    @Column(name = "FORNECEDOR")
    private String fornecedor;

    @Column(name = "PLANTA_DO_CLIENTE")
    private String planta_do_Cliente;

    @Column(name = "RECLAMAÇÃO_OFICIAL")
    private String reclamacao_oficial;

    @Column(name = "REINCIDÊNCIA")
    private String reincidencia;

    @Column(name = "NÚMERO_DA_RECLAMAÇÃO_DO_CLIENTE_só_deve_ser_preenchido_no_caso_de_reclamações_oficiais")
    private String numero_Reclamacao_Cliente;

    @Column(name = "CONTRATAÇÃO_DE_EMPRESA_TERCEIRA")
    private String contratacao_Empresaterceira;

    @Column(name = "DÉBITO_RECEBIDO_VALOR")
    private String debito_Recebido_Valor;

    @Column(name = "PROCEDE")
    private String procede;

    @Column(name = "GP12")
    private String gp12;

    @Column(name = "CLASSIFICAÇÃO_DA_RECLAMAÇÃO")
    private String classificacao_Reclamacao;

    @Column(name = "SOLICITADO_CS1_U_CS2")
    private String solicitacao_Cs1_U_Cs2;

    @Column(name = "ITENS_DE_SEGURANÇA")
    private String itens_Seguranca;

    @Column(name = "CÓDIGO_DA_PEÇA_CLIENTE")
    private String codigo_Peca_Cliente;

    @Column(name = "CÓDIGO_DA_PEÇA_PARANOÁ")
    private String codigo_Peca_Paranoa;

    @Column(name = "QUANTIDADE_DE_PEÇAS_NÃO_CONFORME_DETECTADA_PELO_CLIENTE")
    private String quantidade_Peca_Nao_Conforme;

    @Column(name = "DESCRIÇÃO_DO_PROBLEMA")
    private String descricao_Problema;

    @Column(name = "MODO_DE_FALHA")
    private String modo_Falha;

    @Column(name = "FUNDO_DA_CAUSA")
    private String fundo_Da_Causa;

    @Column(name = "PLANTA_ORIGEM_PROBLEMA")
    private String planta_Origem_Problema;

    @Column(name = "RESPOSTA_NO_SITE_DO_CLIENTE")
    private String resposta_Site_Cliente;

    @Column(name = "PRAZO_PARA_RESPOSTA")
    private String prazo_Resposta;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        FtpControleReclamacoes that = (FtpControleReclamacoes) o;
        return item.equals(that.item);
    }

    public Object clone() throws CloneNotSupportedException {
        return (Object) super.clone();
    }

    @Override
    public int hashCode() {
        return Objects.hash(item);
    }

    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }

    public String getMes() {
        return mes;
    }
    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getN8d() {
        return n8d;
    }

    public void setN8d(String n8d) {
        this.n8d = n8d;
    }

    public String getData_Abertura() {
        return data_Abertura;
    }

    public void setData_Abertura(String data_Abertura) {
        this.data_Abertura = data_Abertura;
    }

    public String getAnalista_Responsavel() {
        return analista_Responsavel;
    }

    public void setAnalista_Responsavel(String analista_Responsavel) {
        this.analista_Responsavel = analista_Responsavel;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getPlanta_do_Cliente() {
        return planta_do_Cliente;
    }

    public void setPlanta_do_Cliente(String planta_do_Cliente) {
        this.planta_do_Cliente = planta_do_Cliente;
    }

    public String getReclamacao_oficial() {
        return reclamacao_oficial;
    }

    public void setReclamacao_oficial(String reclamacao_oficial) {
        this.reclamacao_oficial = reclamacao_oficial;
    }

    public String getReincidencia() {
        return reincidencia;
    }

    public void setReincidencia(String reincidencia) {
        this.reincidencia = reincidencia;
    }

    public String getNumero_Reclamacao_Cliente() {
        return numero_Reclamacao_Cliente;
    }

    public void setNumero_Reclamacao_Cliente(String numero_Reclamacao_Cliente) {
        this.numero_Reclamacao_Cliente = numero_Reclamacao_Cliente;
    }

    public String getContratacao_Empresaterceira() {
        return contratacao_Empresaterceira;
    }

    public void setContratacao_Empresaterceira(String contratacao_Empresaterceira) {
        this.contratacao_Empresaterceira = contratacao_Empresaterceira;
    }

    public String getDebito_Recebido_Valor() {
        return debito_Recebido_Valor;
    }

    public void setDebito_Recebido_Valor(String debito_Recebido_Valor) {
        this.debito_Recebido_Valor = debito_Recebido_Valor;
    }

    public String getProcede() {
        return procede;
    }

    public void setProcede(String procede) {
        this.procede = procede;
    }

    public String getGp12() {
        return gp12;
    }

    public void setGp12(String gp12) {
        this.gp12 = gp12;
    }

    public String getClassificacao_Reclamacao() {
        return classificacao_Reclamacao;
    }

    public void setClassificacao_Reclamacao(String classificacao_Reclamacao) {
        this.classificacao_Reclamacao = classificacao_Reclamacao;
    }

    public String getSolicitacao_Cs1_U_Cs2() {
        return solicitacao_Cs1_U_Cs2;
    }

    public void setSolicitacao_Cs1_U_Cs2(String solicitacao_Cs1_U_Cs2) {
        this.solicitacao_Cs1_U_Cs2 = solicitacao_Cs1_U_Cs2;
    }

    public String getItens_Seguranca() {
        return itens_Seguranca;
    }

    public void setItens_Seguranca(String itens_Seguranca) {
        this.itens_Seguranca = itens_Seguranca;
    }

    public String getCodigo_Peca_Cliente() {
        return codigo_Peca_Cliente;
    }

    public void setCodigo_Peca_Cliente(String codigo_Peca_Cliente) {
        this.codigo_Peca_Cliente = codigo_Peca_Cliente;
    }

    public String getCodigo_Peca_Paranoa() {
        return codigo_Peca_Paranoa;
    }

    public void setCodigo_Peca_Paranoa(String codigo_Peca_Paranoa) {
        this.codigo_Peca_Paranoa = codigo_Peca_Paranoa;
    }

    public String getQuantidade_Peca_Nao_Conforme() {
        return quantidade_Peca_Nao_Conforme;
    }

    public void setQuantidade_Peca_Nao_Conforme(String quantidade_Peca_Nao_Conforme) {
        this.quantidade_Peca_Nao_Conforme = quantidade_Peca_Nao_Conforme;
    }

    public String getDescricao_Problema() {
        return descricao_Problema;
    }

    public void setDescricao_Problema(String descricao_Problema) {
        this.descricao_Problema = descricao_Problema;
    }

    public String getModo_Falha() {
        return modo_Falha;
    }

    public void setModo_Falha(String modo_Falha) {
        this.modo_Falha = modo_Falha;
    }

    public String getFundo_Da_Causa() {
        return fundo_Da_Causa;
    }

    public void setFundo_Da_Causa(String fundo_Da_Causa) {
        this.fundo_Da_Causa = fundo_Da_Causa;
    }

    public String getPlanta_Origem_Problema() {
        return planta_Origem_Problema;
    }

    public void setPlanta_Origem_Problema(String planta_Origem_Problema) {
        this.planta_Origem_Problema = planta_Origem_Problema;
    }

    public String getResposta_Site_Cliente() {
        return resposta_Site_Cliente;
    }

    public void setResposta_Site_Cliente(String resposta_Site_Cliente) {
        this.resposta_Site_Cliente = resposta_Site_Cliente;
    }

    public String getPrazo_Resposta() {
        return prazo_Resposta;
    }

    public void setPrazo_Resposta(String prazo_Resposta) {
        this.prazo_Resposta = prazo_Resposta;
    }

}

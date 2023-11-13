package br.com.datawake.datawakeapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "FTP_PU")
public class FtpPu implements Cloneable {

    @Id
    @Column(name = "Produto", nullable = false)
    private String produto;

    @Column(name = "Temperatura1_H")
    private Float temperatura1h;

    @Column(name = "Temperatura2_H")
    private Float temperatura2h;

    @Column(name = "Temperatura3_H")
    private Float temperatura3h;

    @Column(name = "Temperatura4_H")
    private Float temperatura4h;

    @Column(name = "Temperatura1_L")
    private Float temperatura1l;

    @Column(name = "Temperatura2_L")
    private Float temperatura2l;

    @Column(name = "Temperatura3_L")
    private Float temperatura3l;

    @Column(name = "Temperatura4_L")
    private Float temperatura4l;

    @Column(name = "Pressao1_H")
    private Float pressao1h;

    @Column(name = "Pressao2_H")
    private Float pressao2h;

    @Column(name = "Pressao3_H")
    private Float pressao3h;

    @Column(name = "Pressao4_H")
    private Float pressao4h;

    @Column(name = "Pressao1_L")
    private Float pressao1l;

    @Column(name = "Pressao2_L")
    private Float pressao2l;

    @Column(name = "Pressao3_L")
    private Float pressao3l;

    @Column(name = "Pressao4_L")
    private Float pressao4l;

    @Column(name = "Tempo_Cura")
    private Long tempo_cura;

    @Column(name = "Nro_Molde")
    private Long nro_molde;

    @Column(name = "Temperatura_Circuito_H")
    private Float temperatura_circuitoh;

    @Column(name = "Temperatura_Circuito_L")
    private Float temperatura_circuitol;

    @Column(name = "Pressao_Circuito_H")
    private Float pressao_circuitoh;

    @Column(name = "Pressao_Circuito_L")
    private Float pressao_circuitol;

    @Column(name = "Tempo_Limpeza")
    private Long tempo_limpeza;

    @Column(name = "Tempo_Desmoldante")
    private Long tempo_desmoldante;

    @Column(name = "Tempo_Limpeza_Desmold1")
    private Long tempo_limpeza_desmold1;

    @Column(name = "Tempo_Limpeza_Desmold2")
    private Long tempo_limpeza_desmold2;

    @Column(name = "Tempo_Reg_Pressao")
    private Long tempo_reg_pressao;

    @Column(name = "Tempo_Injecao")
    private Long tempo_injecao;

    @Column(name = "Tempo_Abre_Molde")
    private Long tempo_abre_molde;

    @Column(name = "Tempo_Retira_Peca")
    private Long tempo_retira_peca;

    @Column(name = "Tempo_Espera")
    private Long tempo_espera;

    @Column(name = "Tempo_Injecao_H")
    private Long tempo_injecaoh;

    @Column(name = "Tempo_Injecao_L")
    private Long tempo_injecaol;

    @Column(name = "TAMANHO")
    private String tamanho;

    @Column(name = "PINO")
    private String pino;

    @Column(name = "FECHAMENTO")
    private String fechamento;

    @Column(name = "TIERLINE")
    private String tierline;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FtpPu that = (FtpPu) o;
        return produto.equals(that.produto);
    }
    public Object clone() throws CloneNotSupportedException {
        return (Object) super.clone();
    }

    @Override
    public int hashCode() {
        return Objects.hash(produto);
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Float getTemperatura1h() {
        return temperatura1h;
    }

    public void setTemperatura1h(Float temperatura1h) {
        this.temperatura1h = temperatura1h;
    }

    public Float getTemperatura2h() {
        return temperatura2h;
    }

    public void setTemperatura2h(Float temperatura2h) {
        this.temperatura2h = temperatura2h;
    }

    public Float getTemperatura3h() {
        return temperatura3h;
    }

    public void setTemperatura3h(Float temperatura3h) {
        this.temperatura3h = temperatura3h;
    }

    public Float getTemperatura4h() {
        return temperatura4h;
    }

    public void setTemperatura4h(Float temperatura4h) {
        this.temperatura4h = temperatura4h;
    }

    public Float getTemperatura1l() {
        return temperatura1l;
    }

    public void setTemperatura1l(Float temperatura1l) {
        this.temperatura1l = temperatura1l;
    }

    public Float getTemperatura2l() {
        return temperatura2l;
    }

    public void setTemperatura2l(Float temperatura2l) {
        this.temperatura2l = temperatura2l;
    }

    public Float getTemperatura3l() {
        return temperatura3l;
    }

    public void setTemperatura3l(Float temperatura3l) {
        this.temperatura3l = temperatura3l;
    }

    public Float getTemperatura4l() {
        return temperatura4l;
    }

    public void setTemperatura4l(Float temperatura4l) {
        this.temperatura4l = temperatura4l;
    }

    public Float getPressao1h() {
        return pressao1h;
    }

    public void setPressao1h(Float pressao1h) {
        this.pressao1h = pressao1h;
    }

    public Float getPressao2h() {
        return pressao2h;
    }

    public void setPressao2h(Float pressao2h) {
        this.pressao2h = pressao2h;
    }

    public Float getPressao3h() {
        return pressao3h;
    }

    public void setPressao3h(Float pressao3h) {
        this.pressao3h = pressao3h;
    }

    public Float getPressao4h() {
        return pressao4h;
    }

    public void setPressao4h(Float pressao4h) {
        this.pressao4h = pressao4h;
    }

    public Float getPressao1l() {
        return pressao1l;
    }

    public void setPressao1l(Float pressao1l) {
        this.pressao1l = pressao1l;
    }

    public Float getPressao2l() {
        return pressao2l;
    }

    public void setPressao2l(Float pressao2l) {
        this.pressao2l = pressao2l;
    }

    public Float getPressao3l() {
        return pressao3l;
    }

    public void setPressao3l(Float pressao3l) {
        this.pressao3l = pressao3l;
    }

    public Float getPressao4l() {
        return pressao4l;
    }

    public void setPressao4l(Float pressao4l) {
        this.pressao4l = pressao4l;
    }

    public Long getTempo_cura() {
        return tempo_cura;
    }

    public void setTempo_cura(Long tempo_cura) {
        this.tempo_cura = tempo_cura;
    }

    public Long getNro_molde() {
        return nro_molde;
    }

    public void setNro_molde(Long nro_molde) {
        this.nro_molde = nro_molde;
    }

    public Float getTemperatura_circuitoh() {
        return temperatura_circuitoh;
    }

    public void setTemperatura_circuitoh(Float temperatura_circuitoh) {
        this.temperatura_circuitoh = temperatura_circuitoh;
    }

    public Float getTemperatura_circuitol() {
        return temperatura_circuitol;
    }

    public void setTemperatura_circuitol(Float temperatura_circuitol) {
        this.temperatura_circuitol = temperatura_circuitol;
    }

    public Float getPressao_circuitoh() {
        return pressao_circuitoh;
    }

    public void setPressao_circuitoh(Float pressao_circuitoh) {
        this.pressao_circuitoh = pressao_circuitoh;
    }

    public Float getPressao_circuitol() {
        return pressao_circuitol;
    }

    public void setPressao_circuitol(Float pressao_circuitol) {
        this.pressao_circuitol = pressao_circuitol;
    }

    public Long getTempo_limpeza() {
        return tempo_limpeza;
    }

    public void setTempo_limpeza(Long tempo_limpeza) {
        this.tempo_limpeza = tempo_limpeza;
    }

    public Long getTempo_desmoldante() {
        return tempo_desmoldante;
    }

    public void setTempo_desmoldante(Long tempo_desmoldante) {
        this.tempo_desmoldante = tempo_desmoldante;
    }

    public Long getTempo_limpeza_desmold1() {
        return tempo_limpeza_desmold1;
    }

    public void setTempo_limpeza_desmold1(Long tempo_limpeza_desmold1) {
        this.tempo_limpeza_desmold1 = tempo_limpeza_desmold1;
    }

    public Long getTempo_limpeza_desmold2() {
        return tempo_limpeza_desmold2;
    }

    public void setTempo_limpeza_desmold2(Long tempo_limpeza_desmold2) {
        this.tempo_limpeza_desmold2 = tempo_limpeza_desmold2;
    }

    public Long getTempo_reg_pressao() {
        return tempo_reg_pressao;
    }

    public void setTempo_reg_pressao(Long tempo_reg_pressao) {
        this.tempo_reg_pressao = tempo_reg_pressao;
    }

    public Long getTempo_injecao() {
        return tempo_injecao;
    }

    public void setTempo_injecao(Long tempo_injecao) {
        this.tempo_injecao = tempo_injecao;
    }

    public Long getTempo_abre_molde() {
        return tempo_abre_molde;
    }

    public void setTempo_abre_molde(Long tempo_abre_molde) {
        this.tempo_abre_molde = tempo_abre_molde;
    }

    public Long getTempo_retira_peca() {
        return tempo_retira_peca;
    }

    public void setTempo_retira_peca(Long tempo_retira_peca) {
        this.tempo_retira_peca = tempo_retira_peca;
    }

    public Long getTempo_espera() {
        return tempo_espera;
    }

    public void setTempo_espera(Long tempo_espera) {
        this.tempo_espera = tempo_espera;
    }

    public Long getTempo_injecaoh() {
        return tempo_injecaoh;
    }

    public void setTempo_injecaoh(Long tempo_injecaoh) {
        this.tempo_injecaoh = tempo_injecaoh;
    }

    public Long getTempo_injecaol() {
        return tempo_injecaol;
    }

    public void setTempo_injecaol(Long tempo_injecaol) {
        this.tempo_injecaol = tempo_injecaol;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getPino() {
        return pino;
    }

    public void setPino(String pino) {
        this.pino = pino;
    }

    public String getFechamento() {
        return fechamento;
    }

    public void setFechamento(String fechamento) {
        this.fechamento = fechamento;
    }

    public String getTierline() {
        return tierline;
    }

    public void setTierline(String tierline) {
        this.tierline = tierline;
    }
}

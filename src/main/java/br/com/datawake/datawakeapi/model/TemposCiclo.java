package br.com.datawake.datawakeapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "TPO_TERMO_TEMPOS_CICLO")
public class TemposCiclo implements Cloneable {

    @Id
    @Column(name = "ID_FTP", unique = true, nullable = false)
    private Long id;

    @Column(name = "ID_UNIDADE_PRODUCAO")
    private int idUnidadeProducao;

    @Column(name = "SUBIR_CORRENTE")
    private int subirCorrente;

    @Column(name = "AVANCAR_CORTE")
    private int avancarCorte;

    @Column(name = "RECUAR_CORTE")
    private int recuarCorte;

    @Column(name = "DESCER_CORRENTE")
    private int descerCorrente;

    @Column(name = "DESCER_QUADRO")
    private int descerQuadro;

    @Column(name = "AVANCAR_FORNO_SUPERIOR")
    private int avancarFornoSuperior;

    @Column(name = "AVANCAR_FORNO_INFERIOR")
    private int avancarFornoInferior;

    @Column(name = "RECUAR_FORNO_SUPERIOR")
    private int recuarFornoSuperior;

    @Column(name = "RECUAR_FORNO_INFERIOR")
    private int recuarFornoInferior;

    @Column(name = "DESCER_PLUG")
    private int descerPlug;

    @Column(name = "SUBIR_MOLDE")
    private int subirMolde;

    @Column(name = "VACUO")
    private int vacuo;

    @Column(name = "RESFRIAMENTO")
    private int resfriamento;

    @Column(name = "SUBIR_PLUG")
    private int subirPlug;

    @Column(name = "DESCER_MOLDE")
    private int descerMolde;

    @Column(name = "SUBIR_QUADRO")
    private int subirQuadro;

    @Column(name = "RETIRA_PECA_BASE")
    private int retiraPecaBase;

    @Column(name = "PESAGEM_PECA_BASE")
    private int pesagemPecaBase;

    @Column(name = "PRE_REFILE")
    private int preRefile;

    @Column(name = "PESAGEM_PECA_01")
    private int pesagemPeca01;

    @Column(name = "ETIQUETAR_ALOCAR_PECA_01")
    private int etiquetarAlocarPeca01;

    @Column(name = "PESAGEM_PECA_02")
    private int pesagemPeca02;

    @Column(name = "ETIQUETAR_ALOCAR_PECA_02")
    private int etiquetarAlocarPeca02;

    @Column(name = "PESAGEM_PECA_03")
    private int pesagemPeca03;

    @Column(name = "ETIQUETAR_ALOCAR_PECA_03")
    private int etiquetarAlocarPeca03;

    @Column(name = "PERMANENCIA_FORNO")
    private int permanenciaForno;

    @Column(name = "CICLO_MOLDAGEM")
    private int cicloMoldagem;

    @Column(name = "AVANCAR_CORRENTE_F1")
    private int avancarCorrenteF1;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIdUnidadeProducao() {
        return idUnidadeProducao;
    }

    public void setIdUnidadeProducao(int idUnidadeProducao) {
        this.idUnidadeProducao = idUnidadeProducao;
    }

    public int getSubirCorrente() {
        return subirCorrente;
    }

    public void setSubirCorrente(int subirCorrente) {
        this.subirCorrente = subirCorrente;
    }

    public int getAvancarCorte() {
        return avancarCorte;
    }

    public void setAvancarCorte(int avancarCorte) {
        this.avancarCorte = avancarCorte;
    }

    public int getRecuarCorte() {
        return recuarCorte;
    }

    public void setRecuarCorte(int recuarCorte) {
        this.recuarCorte = recuarCorte;
    }

    public int getDescerCorrente() {
        return descerCorrente;
    }

    public void setDescerCorrente(int descerCorrente) {
        this.descerCorrente = descerCorrente;
    }

    public int getDescerQuadro() {
        return descerQuadro;
    }

    public void setDescerQuadro(int descerQuadro) {
        this.descerQuadro = descerQuadro;
    }

    public int getAvancarFornoSuperior() {
        return avancarFornoSuperior;
    }

    public void setAvancarFornoSuperior(int avancarFornoSuperior) {
        this.avancarFornoSuperior = avancarFornoSuperior;
    }

    public int getAvancarFornoInferior() {
        return avancarFornoInferior;
    }

    public void setAvancarFornoInferior(int avancarFornoInferior) {
        this.avancarFornoInferior = avancarFornoInferior;
    }

    public int getRecuarFornoSuperior() {
        return recuarFornoSuperior;
    }

    public void setRecuarFornoSuperior(int recuarFornoSuperior) {
        this.recuarFornoSuperior = recuarFornoSuperior;
    }

    public int getRecuarFornoInferior() {
        return recuarFornoInferior;
    }

    public void setRecuarFornoInferior(int recuarFornoInferior) {
        this.recuarFornoInferior = recuarFornoInferior;
    }

    public int getDescerPlug() {
        return descerPlug;
    }

    public void setDescerPlug(int descerPlug) {
        this.descerPlug = descerPlug;
    }

    public int getSubirMolde() {
        return subirMolde;
    }

    public void setSubirMolde(int subirMolde) {
        this.subirMolde = subirMolde;
    }

    public int getVacuo() {
        return vacuo;
    }

    public void setVacuo(int vacuo) {
        this.vacuo = vacuo;
    }

    public int getResfriamento() {
        return resfriamento;
    }

    public void setResfriamento(int resfriamento) {
        this.resfriamento = resfriamento;
    }

    public int getSubirPlug() {
        return subirPlug;
    }

    public void setSubirPlug(int subirPlug) {
        this.subirPlug = subirPlug;
    }

    public int getDescerMolde() {
        return descerMolde;
    }

    public void setDescerMolde(int descerMolde) {
        this.descerMolde = descerMolde;
    }

    public int getSubirQuadro() {
        return subirQuadro;
    }

    public void setSubirQuadro(int subirQuadro) {
        this.subirQuadro = subirQuadro;
    }

    public int getRetiraPecaBase() {
        return retiraPecaBase;
    }

    public void setRetiraPecaBase(int retiraPecaBase) {
        this.retiraPecaBase = retiraPecaBase;
    }

    public int getPesagemPecaBase() {
        return pesagemPecaBase;
    }

    public void setPesagemPecaBase(int pesagemPecaBase) {
        this.pesagemPecaBase = pesagemPecaBase;
    }

    public int getPreRefile() {
        return preRefile;
    }

    public void setPreRefile(int preRefile) {
        this.preRefile = preRefile;
    }

    public int getPesagemPeca01() {
        return pesagemPeca01;
    }

    public void setPesagemPeca01(int pesagemPeca01) {
        this.pesagemPeca01 = pesagemPeca01;
    }

    public int getEtiquetarAlocarPeca01() {
        return etiquetarAlocarPeca01;
    }

    public void setEtiquetarAlocarPeca01(int etiquetarAlocarPeca01) {
        this.etiquetarAlocarPeca01 = etiquetarAlocarPeca01;
    }

    public int getPesagemPeca02() {
        return pesagemPeca02;
    }

    public void setPesagemPeca02(int pesagemPeca02) {
        this.pesagemPeca02 = pesagemPeca02;
    }

    public int getEtiquetarAlocarPeca02() {
        return etiquetarAlocarPeca02;
    }

    public void setEtiquetarAlocarPeca02(int etiquetarAlocarPeca02) {
        this.etiquetarAlocarPeca02 = etiquetarAlocarPeca02;
    }

    public int getPesagemPeca03() {
        return pesagemPeca03;
    }

    public void setPesagemPeca03(int pesagemPeca03) {
        this.pesagemPeca03 = pesagemPeca03;
    }

    public int getEtiquetarAlocarPeca03() {
        return etiquetarAlocarPeca03;
    }

    public void setEtiquetarAlocarPeca03(int etiquetarAlocarPeca03) {
        this.etiquetarAlocarPeca03 = etiquetarAlocarPeca03;
    }

    public int getPermanenciaForno() {
        return permanenciaForno;
    }

    public void setPermanenciaForno(int permanenciaForno) {
        this.permanenciaForno = permanenciaForno;
    }

    public int getCicloMoldagem() {
        return cicloMoldagem;
    }

    public void setCicloMoldagem(int cicloMoldagem) {
        this.cicloMoldagem = cicloMoldagem;
    }

    public Object clone() throws CloneNotSupportedException {
        return (Object) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TemposCiclo that = (TemposCiclo) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getAvancarCorrenteF1() {
        return avancarCorrenteF1;
    }

    public void setAvancarCorrenteF1(int avancarCorrenteF1) {
        this.avancarCorrenteF1 = avancarCorrenteF1;
    }
}

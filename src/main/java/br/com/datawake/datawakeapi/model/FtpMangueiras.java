package br.com.datawake.datawakeapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Objects;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "MQB_Ext_Specs")
public class FtpMangueiras {

    @Column(name = "Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Pi")
    private String pi;

    @Column(name = "Geral_Sp_velocidade_linha")
    private double geralSpVelocidadeLinha;

    @Column(name = "Geral_Lim_Min_Velocidade_Linha")
    private double geralLimMinVelocidadeLinha;

    @Column(name = "Geral_Lim_Max_Velocidade_Linha")
    private double geralLimMaxVelocidadeLinha;

    @Column(name = "Geral_Sp_Comprimento_Mangueira")
    private double geralSpComprimentoMangueira;

    @Column(name = "Geral_Lim_Min_Comprimento_Mangueira")
    private double geralLimMinComprimentoMangueira;

    @Column(name = "Geral_Lim_Max_Comprimento_Mangueira")
    private double geralLimMaxComprimentoMangueira;

    @Column(name = "Geral_Espessura_Mangueira_Lim_Min")
    private double geralEspessuraMangueiraLimMin;

    @Column(name = "Geral_Espessura_Mangueira_Lim_Max")
    private double geralEspessuraMangueiraLimMax;

    @Column(name = "Geral_Embalagem_Tipo")
    private String geralEmbalagemTipo;

    @Column(name = "Geral_Embalagem_Qtde_peca")
    private int geralEmbalagemQtdePeca;

    @Column(name = "Ferramenta_Tubo_Diametro_Pino")
    private String ferramentaTuboDiametroPino;

    @Column(name = "Ferramenta_Tubo_Diametro_Matriz")
    private String ferramentaTuboDiametroMatriz;

    @Column(name = "Ferramenta_Malhadeira_Diametro_Cabecote")
    private String ferramentaMalhadeiraDiametroCabecote;

    @Column(name = "Ferramenta_Malhadeira_Tipo_Agulha")
    private String ferramentaMalhadeiraTipoAgulha;

    @Column(name = "Ferramenta_Malhadeira_Qtde_Agulha")
    private String ferramentaMalhadeiraQtdeAgulha;

    @Column(name = "Ferramenta_Capa_Diametro_Pino_Vacuo")
    private String ferramentaCapaDiametroPinoVacuo;

    @Column(name = "Ferramenta_Capa_Diametro_Pino_Massa")
    private String ferramentaCapaDiametroPinoMassa;

    @Column(name = "Ferramenta_Capa_Diametro_Matriz")
    private String ferramentaCapaDiametroMatriz;

    @Column(name = "Ferramenta_Capa_Estearato_Zinco")
    private String ferramentaCapaEstearatoZinco;

    @Column(name = "Tubo_Sp_Zona_Extrusao")
    private double tuboSpZonaExtrusao;

    @Column(name = "Tubo_Lim_Min_Zona_Extrusao")
    private double tuboLimMinZonaExtrusao;

    @Column(name = "Tubo_Lim_Max_Zona_Extrusao")
    private double tuboLimMaxZonaExtrusao;

    @Column(name = "Tubo_Sp_Cabecote")
    private double tuboSpCabecote;

    @Column(name = "Tubo_Lim_Min_Cabecote")
    private double tuboLimMinCabecote;

    @Column(name = "Tubo_Lim_Max_Cabecote")
    private double tuboLimMaxCabecote;

    @Column(name = "Tubo_Sp_Temp_Borracha")
    private double tuboSpTempBorracha;

    @Column(name = "Tubo_Lim_Min_Temp_Borracha")
    private double tuboLimMinTempBorracha;

    @Column(name = "Tubo_Lim_Max_Temp_Borracha")
    private double tuboLimMaxTempBorracha;

    @Column(name = "Tubo_Lim_Min_Espessura_parede")
    private double tuboLimMinEspessuraParede;

    @Column(name = "Tubo_Lim_Max_Espessura_parede")
    private double tuboLimMaxEspessuraParede;

    @Column(name = "Tubo_Sp_Diametro_Externo")
    private double tuboSpDiametroExterno;

    @Column(name = "Tubo_Lim_Min_Diametro_Externo")
    private double tuboLimMinDiametroExterno;

    @Column(name = "Tubo_Lim_Max_Diametro_Externo")
    private double tuboLimMaxDiametroExterno;

    @Column(name = "Tubo_Toluol")
    private String tuboToluol;

    @Column(name = "Tubo_Codigo_Composto")
    private String tuboCodigoComposto;

    @Column(name = "Malhadeira_Lim_Min_passo")
    private double malhadeiraLimMinPasso;

    @Column(name = "Malhadeira_Lim_Max_passo")
    private double malhadeiraLimMaxPasso;

    @Column(name = "Malhadeira_Tipo_Fio")
    private String malhadeiraTipoFio;

    @Column(name = "Capa_Sp_Zona_Extrusao")
    private double capaSpZonaExtrusao;

    @Column(name = "Capa_Lim_Min_Zona_Extrusao")
    private double capaLimMinZonaExtrusao;

    @Column(name = "Capa_Lim_Max_Zona_Extrusao")
    private double capaLimMaxZonaExtrusao;

    @Column(name = "Capa_Sp_Cabecote")
    private double capaSpCabecote;

    @Column(name = "Capa_Lim_Min_Cabecote")
    private double capaLimMinCabecote;

    @Column(name = "Capa_Lim_Max_Cabecote")
    private double capaLimMaxCabecote;

    @Column(name = "Capa_Sp_Temp_Borracha")
    private double capaSpTempBorracha;

    @Column(name = "Capa_Lim_Min_Temp_Borracha")
    private double capaLimMinTempBorracha;

    @Column(name = "Capa_Lim_Max_Temp_Borracha")
    private double capaLimMaxTempBorracha;

    @Column(name = "Capa_Sp_pressao_Vacuo")
    private double capaSpPressaoVacuo;

    @Column(name = "Capa_Lim_Min_pressao_Vacuo")
    private double capaLimMinPressaoVacuo;

    @Column(name = "Capa_Lim_Max_pressao_Vacuo")
    private double capaLimMaxPressaoVacuo;

    @Column(name = "Capa_Lim_Min_Espessura_parede")
    private double capaLimMinEspessuraParede;

    @Column(name = "Capa_Lim_Max_Espessura_parede")
    private double capaLimMaxEspessuraParede;

    @Column(name = "Tubo_Lim_Min_Diametro_Interno")
    private double tuboLimMinDiametroInterno;

    @Column(name = "Tubo_Lim_Max_Diametro_Interno")
    private double tuboLimMaxDiametroInterno;

    @Column(name = "Capa_Sp_Diametro_Externo")
    private double capaSpDiametroExterno;

    @Column(name = "Capa_Lim_Min_Diametro_Externo")
    private double capaLimMinDiametroExterno;

    @Column(name = "Capa_Lim_Max_Diametro_Externo")
    private double capaLimMaxDiametroExterno;

    @Column(name = "Capa_Codigo_Composto")
    private String capaCodigoComposto;

    @Column(name = "Id_Unidade_Producao")
    private String idUnidadeProducao;

    public String getCapaCodigoComposto() {   return capaCodigoComposto;   }

    public void setCapaCodigoComposto(String capaCodigoComposto) { this.capaCodigoComposto = capaCodigoComposto;    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FtpMangueiras that = (FtpMangueiras) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    
    public String getIdUnidadeProducao() {   
        return idUnidadeProducao;   
    }

    public void setIdUnidadeProducao(String idUnidadeProducao) { 
        this.idUnidadeProducao = idUnidadeProducao;    
    }

    public double getCapaLimMaxDiametroExterno() {
        return capaLimMaxDiametroExterno;
    }

    public void setCapaLimMaxDiametroExterno(double capaLimMaxDiametroExterno) {
        this.capaLimMaxDiametroExterno = capaLimMaxDiametroExterno;
    }

    public double getCapaLimMinDiametroExterno() {
        return capaLimMinDiametroExterno;
    }

    public void setCapaLimMinDiametroExterno(double capaLimMinDiametroExterno) {
        this.capaLimMinDiametroExterno = capaLimMinDiametroExterno;
    }

    public double getCapaSpDiametroExterno() {
        return capaSpDiametroExterno;
    }

    public void setCapaSpDiametroExterno(double capaSpDiametroExterno) {
        this.capaSpDiametroExterno = capaSpDiametroExterno;
    }

    public double getCapaLimMaxEspessuraParede() {
        return capaLimMaxEspessuraParede;
    }

    public void setCapaLimMaxEspessuraParede(double capaLimMaxEspessuraParede) {
        this.capaLimMaxEspessuraParede = capaLimMaxEspessuraParede;
    }

    public double getCapaLimMinEspessuraParede() {
        return capaLimMinEspessuraParede;
    }

    public void setCapaLimMinEspessuraParede(double capaLimMinEspessuraParede) {
        this.capaLimMinEspessuraParede = capaLimMinEspessuraParede;
    }

    public double getCapaLimMaxPressaoVacuo() {
        return capaLimMaxPressaoVacuo;
    }

    public void setCapaLimMaxPressaoVacuo(double capaLimMaxPressaoVacuo) {
        this.capaLimMaxPressaoVacuo = capaLimMaxPressaoVacuo;
    }

    public double getCapaLimMinPressaoVacuo() {
        return capaLimMinPressaoVacuo;
    }

    public void setCapaLimMinPressaoVacuo(double capaLimMinPressaoVacuo) {
        this.capaLimMinPressaoVacuo = capaLimMinPressaoVacuo;
    }

    public double getCapaSpPressaoVacuo() {
        return capaSpPressaoVacuo;
    }

    public void setCapaSpPressaoVacuo(double capaSpPressaoVacuo) {
        this.capaSpPressaoVacuo = capaSpPressaoVacuo;
    }

    public double getCapaLimMaxTempBorracha() {
        return capaLimMaxTempBorracha;
    }

    public void setCapaLimMaxTempBorracha(double capaLimMaxTempBorracha) {
        this.capaLimMaxTempBorracha = capaLimMaxTempBorracha;
    }

    public double getCapaLimMinTempBorracha() {
        return capaLimMinTempBorracha;
    }

    public void setCapaLimMinTempBorracha(double capaLimMinTempBorracha) {
        this.capaLimMinTempBorracha = capaLimMinTempBorracha;
    }

    public double getCapaSpTempBorracha() {
        return capaSpTempBorracha;
    }

    public void setCapaSpTempBorracha(double capaSpTempBorracha) {
        this.capaSpTempBorracha = capaSpTempBorracha;
    }

    public double getCapaLimMaxCabecote() {
        return capaLimMaxCabecote;
    }

    public void setCapaLimMaxCabecote(double capaLimMaxCabecote) {
        this.capaLimMaxCabecote = capaLimMaxCabecote;
    }

    public double getCapaLimMinCabecote() {
        return capaLimMinCabecote;
    }

    public void setCapaLimMinCabecote(double capaLimMinCabecote) {
        this.capaLimMinCabecote = capaLimMinCabecote;
    }

    public double getCapaSpCabecote() {
        return capaSpCabecote;
    }

    public void setCapaSpCabecote(double capaSpCabecote) {
        this.capaSpCabecote = capaSpCabecote;
    }

    public double getCapaLimMaxZonaExtrusao() {
        return capaLimMaxZonaExtrusao;
    }

    public void setCapaLimMaxZonaExtrusao(double capaLimMaxZonaExtrusao) {
        this.capaLimMaxZonaExtrusao = capaLimMaxZonaExtrusao;
    }

    public double getCapaLimMinZonaExtrusao() {
        return capaLimMinZonaExtrusao;
    }

    public void setCapaLimMinZonaExtrusao(double capaLimMinZonaExtrusao) {
        this.capaLimMinZonaExtrusao = capaLimMinZonaExtrusao;
    }

    public double getCapaSpZonaExtrusao() {
        return capaSpZonaExtrusao;
    }

    public void setCapaSpZonaExtrusao(double capaSpZonaExtrusao) {
        this.capaSpZonaExtrusao = capaSpZonaExtrusao;
    }

    public String getMalhadeiraTipoFio() {
        return malhadeiraTipoFio;
    }

    public void setMalhadeiraTipoFio(String malhadeiraTipoFio) {
        this.malhadeiraTipoFio = malhadeiraTipoFio;
    }

    public double getMalhadeiraLimMaxPasso() {
        return malhadeiraLimMaxPasso;
    }

    public void setMalhadeiraLimMaxPasso(double malhadeiraLimMaxPasso) {
        this.malhadeiraLimMaxPasso = malhadeiraLimMaxPasso;
    }

    public double getMalhadeiraLimMinPasso() {
        return malhadeiraLimMinPasso;
    }

    public void setMalhadeiraLimMinPasso(double malhadeiraLimMinPasso) {
        this.malhadeiraLimMinPasso = malhadeiraLimMinPasso;
    }

    public String getTuboCodigoComposto() {
        return tuboCodigoComposto;
    }

    public void setTuboCodigoComposto(String tuboCodigoComposto) {
        this.tuboCodigoComposto = tuboCodigoComposto;
    }

    public String getTuboToluol() {
        return tuboToluol;
    }

    public void setTuboToluol(String tuboToluol) {
        this.tuboToluol = tuboToluol;
    }

    public double getTuboLimMaxDiametroExterno() {
        return tuboLimMaxDiametroExterno;
    }

    public void setTuboLimMaxDiametroExterno(double tuboLimMaxDiametroExterno) {
        this.tuboLimMaxDiametroExterno = tuboLimMaxDiametroExterno;
    }

    public double gettuboLimMinDiametroExterno() {
        return tuboLimMinDiametroExterno;
    }

    public void settuboLimMinDiametroExterno(double tuboLimMinDiametroExterno) {
        this.tuboLimMinDiametroExterno = tuboLimMinDiametroExterno;
    }

    public double getTuboSpDiametroExterno() {
        return tuboSpDiametroExterno;
    }

    public void setTuboSpDiametroExterno(double tuboSpDiametroExterno) {
        this.tuboSpDiametroExterno = tuboSpDiametroExterno;
    }

    public double getTuboLimMaxEspessuraParede() {
        return tuboLimMaxEspessuraParede;
    }

    public void setTuboLimMaxEspessuraParede(double tuboLimMaxEspessuraParede) {
        this.tuboLimMaxEspessuraParede = tuboLimMaxEspessuraParede;
    }

    public double getTuboLimMinEspessuraParede() {
        return tuboLimMinEspessuraParede;
    }

    public void setTuboLimMinEspessuraParede(double tuboLimMinEspessuraParede) {
        this.tuboLimMinEspessuraParede = tuboLimMinEspessuraParede;
    }

    public double getTuboLimMaxTempBorracha() {
        return tuboLimMaxTempBorracha;
    }

    public void setTuboLimMaxTempBorracha(double tuboLimMaxTempBorracha) {
        this.tuboLimMaxTempBorracha = tuboLimMaxTempBorracha;
    }

    public double getTuboLimMinTempBorracha() {
        return tuboLimMinTempBorracha;
    }

    public void setTuboLimMinTempBorracha(double tuboLimMinTempBorracha) {
        this.tuboLimMinTempBorracha = tuboLimMinTempBorracha;
    }

    public double getTuboSpTempBorracha() {
        return tuboSpTempBorracha;
    }

    public void setTuboSpTempBorracha(double tuboSpTempBorracha) {
        this.tuboSpTempBorracha = tuboSpTempBorracha;
    }

    public double getTuboLimMaxCabecote() {
        return tuboLimMaxCabecote;
    }

    public void setTuboLimMaxCabecote(double tuboLimMaxCabecote) {
        this.tuboLimMaxCabecote = tuboLimMaxCabecote;
    }

    public double getTuboLimMinCabecote() {
        return tuboLimMinCabecote;
    }

    public void setTuboLimMinCabecote(double tuboLimMinCabecote) {
        this.tuboLimMinCabecote = tuboLimMinCabecote;
    }

    public double getTuboSpCabecote() {
        return tuboSpCabecote;
    }

    public void setTuboSpCabecote(double tuboSpCabecote) {
        this.tuboSpCabecote = tuboSpCabecote;
    }

    public double getTuboLimMaxZonaExtrusao() {
        return tuboLimMaxZonaExtrusao;
    }

    public void setTuboLimMaxZonaExtrusao(double tuboLimMaxZonaExtrusao) {
        this.tuboLimMaxZonaExtrusao = tuboLimMaxZonaExtrusao;
    }

    public double getTuboLimMinZonaExtrusao() {
        return tuboLimMinZonaExtrusao;
    }

    public void setTuboLimMinZonaExtrusao(double tuboLimMinZonaExtrusao) {
        this.tuboLimMinZonaExtrusao = tuboLimMinZonaExtrusao;
    }

    public double getTuboSpZonaExtrusao() {
        return tuboSpZonaExtrusao;
    }

    public void setTuboSpZonaExtrusao(double tuboSpZonaExtrusao) {
        this.tuboSpZonaExtrusao = tuboSpZonaExtrusao;
    }

    public String getFerramentaCapaEstearatoZinco() {
        return ferramentaCapaEstearatoZinco;
    }

    public void setFerramentaCapaEstearatoZinco(String ferramentaCapaEstearatoZinco) {
        this.ferramentaCapaEstearatoZinco = ferramentaCapaEstearatoZinco;
    }

    public String getFerramentaCapaDiametroMatriz() {
        return ferramentaCapaDiametroMatriz;
    }

    public void setFerramentaCapaDiametroMatriz(String ferramentaCapaDiametroMatriz) {
        this.ferramentaCapaDiametroMatriz = ferramentaCapaDiametroMatriz;
    }

    public String getFerramentaCapaDiametroPinoMassa() {
        return ferramentaCapaDiametroPinoMassa;
    }

    public void setFerramentaCapaDiametroPinoMassa(String ferramentaCapaDiametroPinoMassa) {
        this.ferramentaCapaDiametroPinoMassa = ferramentaCapaDiametroPinoMassa;
    }

    public String getFerramentaCapaDiametroPinoVacuo() {
        return ferramentaCapaDiametroPinoVacuo;
    }

    public void setFerramentaCapaDiametroPinoVacuo(String ferramentaCapaDiametroPinoVacuo) {
        this.ferramentaCapaDiametroPinoVacuo = ferramentaCapaDiametroPinoVacuo;
    }

    public String getFerramentaMalhadeiraQtdeAgulha() {
        return ferramentaMalhadeiraQtdeAgulha;
    }

    public void setFerramentaMalhadeiraQtdeAgulha(String ferramentaMalhadeiraQtdeAgulha) {
        this.ferramentaMalhadeiraQtdeAgulha = ferramentaMalhadeiraQtdeAgulha;
    }

    public String getFerramentaMalhadeiraTipoAgulha() {
        return ferramentaMalhadeiraTipoAgulha;
    }

    public void setFerramentaMalhadeiraTipoAgulha(String ferramentaMalhadeiraTipoAgulha) {
        this.ferramentaMalhadeiraTipoAgulha = ferramentaMalhadeiraTipoAgulha;
    }

    public String getFerramentaMalhadeiraDiametroCabecote() {
        return ferramentaMalhadeiraDiametroCabecote;
    }

    public void setFerramentaMalhadeiraDiametroCabecote(String ferramentaMalhadeiraDiametroCabecote) {
        this.ferramentaMalhadeiraDiametroCabecote = ferramentaMalhadeiraDiametroCabecote;
    }

    public String getFerramentaTuboDiametroMatriz() {
        return ferramentaTuboDiametroMatriz;
    }

    public void setFerramentaTuboDiametroMatriz(String ferramentaTuboDiametroMatriz) {
        this.ferramentaTuboDiametroMatriz = ferramentaTuboDiametroMatriz;
    }

    public String getFerramentaTuboDiametroPino() {
        return ferramentaTuboDiametroPino;
    }

    public void setFerramentaTuboDiametroPino(String ferramentaTuboDiametroPino) {
        this.ferramentaTuboDiametroPino = ferramentaTuboDiametroPino;
    }

    public int getGeralEmbalagemQtdePeca() {
        return geralEmbalagemQtdePeca;
    }

    public void setGeralEmbalagemQtdePeca(int geralEmbalagemQtdePeca) {
        this.geralEmbalagemQtdePeca = geralEmbalagemQtdePeca;
    }

    public String getGeralEmbalagemTipo() {
        return geralEmbalagemTipo;
    }

    public void setGeralEmbalagemTipo(String geralEmbalagemTipo) {
        this.geralEmbalagemTipo = geralEmbalagemTipo;
    }

    public double getGeralEspessuraMangueiraLimMax() {
        return geralEspessuraMangueiraLimMax;
    }

    public void setGeralEspessuraMangueiraLimMax(double geralEspessuraMangueiraLimMax) {
        this.geralEspessuraMangueiraLimMax = geralEspessuraMangueiraLimMax;
    }

    public double getGeralEspessuraMangueiraLimMin() {
        return geralEspessuraMangueiraLimMin;
    }

    public void setGeralEspessuraMangueiraLimMin(double geralEspessuraMangueiraLimMin) {
        this.geralEspessuraMangueiraLimMin = geralEspessuraMangueiraLimMin;
    }

    public double getGeralLimMaxComprimentoMangueira() {
        return geralLimMaxComprimentoMangueira;
    }

    public void setGeralLimMaxComprimentoMangueira(double geralLimMaxComprimentoMangueira) {
        this.geralLimMaxComprimentoMangueira = geralLimMaxComprimentoMangueira;
    }

    public double getGeralLimMinComprimentoMangueira() {
        return geralLimMinComprimentoMangueira;
    }

    public void setGeralLimMinComprimentoMangueira(double geralLimMinComprimentoMangueira) {
        this.geralLimMinComprimentoMangueira = geralLimMinComprimentoMangueira;
    }

    public double getGeralSpComprimentoMangueira() {
        return geralSpComprimentoMangueira;
    }

    public void setGeralSpComprimentoMangueira(double geralSpComprimentoMangueira) {
        this.geralSpComprimentoMangueira = geralSpComprimentoMangueira;
    }

    public double getGeralLimMaxVelocidadeLinha() {
        return geralLimMaxVelocidadeLinha;
    }

    public void setGeralLimMaxVelocidadeLinha(double geralLimMaxVelocidadeLinha) {
        this.geralLimMaxVelocidadeLinha = geralLimMaxVelocidadeLinha;
    }

    public double getGeralLimMinVelocidadeLinha() {
        return geralLimMinVelocidadeLinha;
    }

    public void setGeralLimMinVelocidadeLinha(double geralLimMinVelocidadeLinha) {
        this.geralLimMinVelocidadeLinha = geralLimMinVelocidadeLinha;
    }

    public double getGeralSpVelocidadeLinha() {
        return geralSpVelocidadeLinha;
    }

    public void setGeralSpVelocidadeLinha(double geralSpVelocidadeLinha) {
        this.geralSpVelocidadeLinha = geralSpVelocidadeLinha;
    }

    public String getPi() {
        return pi;
    }

    public void setPi(String pi) {
        this.pi = pi;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public double getTuboLimMaxDiametroInterno() {
        return tuboLimMaxDiametroInterno;
    }

    public void setTuboLimMaxDiametroInterno(double tuboLimMaxDiametroInterno) {
        this.tuboLimMaxDiametroInterno = tuboLimMaxDiametroInterno;
    }

    public double getTuboLimMinDiametroInterno() {
        return tuboLimMinDiametroInterno;
    }

    public void setTuboLimMinDiametroInterno(double tuboLimMinDiametroInterno) {
        this.tuboLimMinDiametroInterno = tuboLimMinDiametroInterno;
    }
}

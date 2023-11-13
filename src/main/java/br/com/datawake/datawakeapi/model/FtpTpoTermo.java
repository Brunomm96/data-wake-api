package br.com.datawake.datawakeapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Objects;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "TPO_TERMO_FTP")
public class FtpTpoTermo {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_FTP",unique=true, nullable = false)
    @Id
    private Long id;
    @Column(name = "CLIENTE")
    private String cliente;

    @Column(name = "ID_UNIDADE_PRODUCAO")
    private int idUnidadeProducao;

    @Column(name = "CODIGO_CLIENTE_01")
    private String cliente01;

    @Column(name = "CODIGO_CLIENTE_02")
    private String cliente02;

    @Column(name = "CODIGO_CLIENTE_03")
    private String cliente03;

    @Column(name = "CODIGO_PRODUTO_01")
    private String produto01;

    @Column(name = "CODIGO_PRODUTO_02")
    private String produto02;

    @Column(name = "CODIGO_PRODUTO_03")
    private String produto03;

    @Column(name = "PROJETO")
    private String projeto;

    @Column(name = "LIGA_RESISTENCIA_REQ")
    private boolean ligaResistencia;

    @Column(name = "MODO_AQUECIMENTO_REQ")
    private int modoAquecimento;

    @Column(name = "BALAO_REQ")
    private boolean balao;

    @Column(name = "CONTRA_MOLDE_REQ")
    private boolean contraMolde;

    @Column(name = "MOLDE_POSTICO_REQ")
    private boolean moldePostico;

    @Column(name = "PLUG_POSTICO_REQ")
    private boolean plugPostico;

    @Column(name = "HABILITA_SENSOR_MEDE_BALAO_REQ")
    private boolean habilitaSensorMedeBalao;

    @Column(name = "PRE_IMPRESSAO_REQ")
    private boolean preImpressao;

    @Column(name = "PECAS_MOLDE_REQ")
    private int pecasMolde;

    @Column(name = "MOLDE_POSTICO_MANUAL_REQ")
    private boolean moldePosticoManual;

    @Column(name = "ABRE_CAIXA_REQ")
    private boolean abraCaixa;

    @Column(name = "CONTROLE_ALTURA_BALAO_REQ")
    private int controleAlturaBalao;

    @Column(name = "CONTROLE_FORNO_INFERIOR_REQ")
    private int controleFornoInferior;

    @Column(name = "PRENSA_QUADRO_REQ")
    private boolean prensaQuadro;

    @Column(name = "SEGUNDA_VALVULA_VACUO_REQ")
    private boolean segundaValvulaVacuo;

    @Column(name = "TEMPERATURA_MOLDE_REQ")
    private int temperaturaModel; //TODO: Verificar com Jorge as opções ou limites

    @Column(name = "BALAO_SAG_01_MAX")
    @Min(0)
    @Max(20)
    private int balaoSag01Max;

    @Column(name = "BALAO_SAG_01_MIN")
    @Min(0)
    @Max(20)
    private int balaoSag01Min;

    @Column(name = "BALAO_SAG_01_SP")
    @Min(0)
    @Max(20)
    private int balaoSag01SP;

    @Column(name = "BALAO_SAG_02_MAX")
    @Min(0)
    @Max(20)
    private int balaoSag02Max;

    @Column(name = "BALAO_SAG_02_MIN")
    @Min(0)
    @Max(20)
    private int balaoSag02Min;

    @Column(name = "BALAO_SAG_02_SP")
    @Min(0)
    @Max(20)
    private int balaoSag02SP;

    @Column(name = "BALAO_SAG_03_MAX")
    @Min(0)
    @Max(20)
    private int balaoSag03Max;

    @Column(name = "BALAO_SAG_03_MIN")
    @Min(0)
    @Max(20)
    private int balaoSag03Min;

    @Column(name = "BALAO_SAG_03_SP")
    @Min(0)
    @Max(20)
    private int balaoSag03SP;

    @Column(name = "BALAO_SAG_04_MAX")
    @Min(0)
    @Max(20)
    private int balaoSag04Max;

    @Column(name = "BALAO_SAG_04_MIN")
    @Min(0)
    @Max(20)
    private int balaoSag04Min;

    @Column(name = "BALAO_SAG_04_SP")
    @Min(0)
    @Max(20)
    private int balaoSag04SP;

    @Column(name = "AQUECIMENTO_CIMA_MAX")
    @Min(750)
    @Max(1600)
    private int aquecimentoCimaMax;

    @Column(name = "AQUECIMENTO_CIMA_MIN")
    @Min(750)
    @Max(1600)
    private int aquecimentoCimaMin;

    @Column(name = "AQUECIMENTO_CIMA_SP")
    @Min(750)
    @Max(1600)
    private int aquecimentoCimaSP;

    @Column(name = "AQUECIMENTO_BAIXO_MAX")
    @Min(750)
    @Max(1600)
    private int aquecimentoBaixoMax;

    @Column(name = "AQUECIMENTO_BAIXO_MIN")
    @Min(750)
    @Max(1600)
    private int aquecimentoBaixoMin;

    @Column(name = "AQUECIMENTO_BAIXO_SP")
    @Min(750)
    @Max(1600)
    private int aquecimentoBaixoSP;

    @Column(name = "DESLIGA_BALAO_MAX")
    @Min(5)
    @Max(50)
    private int desligaBalaoMax;

    @Column(name = "DESLIGA_BALAO_MIN")
    @Min(5)
    @Max(50)
    private int desligaBalaoMin;

    @Column(name = "DESLIGA_BALAO_SP")
    @Min(5)
    @Max(50)
    private int desligaBalaoSP;

    @Column(name = "LIGA_BALAO_MAX")
    @Min(0)
    @Max(10)
    private int ligaBalaoMax;

    @Column(name = "LIGA_BALAO_MIN")
    @Min(0)
    @Max(10)
    private int ligaBalaoMin;

    @Column(name = "LIGA_BALAO_SP")
    @Min(0)
    @Max(10)
    private int ligaBalaoSP;

    @Column(name = "ATRASA_SOBE_MOLDE_MAX")
    @Min(0)
    @Max(40)
    private int atrasaSobeMoldeMax;

    @Column(name = "ATRASA_SOBE_MOLDE_MIN")
    @Min(0)
    @Max(40)
    private int atrasaSobeMoldeMin;

    @Column(name = "ATRASA_SOBE_MOLDE_SP")
    @Min(0)
    @Max(40)
    private int atrasaSobeMoldeSP;

    @Column(name = "ATRASA_BAIXA_PLUG_MAX")
    @Min(0)
    @Max(20)
    private int atrasaBaixaPlugMax;

    @Column(name = "ATRASA_BAIXA_PLUG_MIN")
    @Min(0)
    @Max(20)
    private int atrasaBaixaPlugMin;

    @Column(name = "ATRASA_BAIXA_PLUG_SP")
    @Min(0)
    @Max(20)
    private int atrasaBaixaPlugSP;

    @Column(name = "ATRASA_BALAO_MAX")
    private int atrasaBalaoMax;

    @Column(name = "ATRASA_BALAO_MIN")
    private int atrasaBalaoMin;

    @Column(name = "ATRASA_BALAO_SP")
    private int atrasaBalaoSP;

    @Column(name = "BALAO_MAX")
    @Min(0)
    @Max(10)
    private int balaoMax;

    @Column(name = "BALAO_MIN")
    @Min(0)
    @Max(10)
    private int balaoMin;

    @Column(name = "BALAO_SP")
    @Min(0)
    @Max(10)
    private int balaoSP;

    @Column(name = "ATRASA_TIRA_RUGA_MAX")
    private int atrasaTiraRugasMax;

    @Column(name = "ATRASA_TIRA_RUGA_MIN")
    private int atrasaTiraRugasMin;

    @Column(name = "ATRASA_TIRA_RUGA_SP")
    private int atrasaTiraRugasSP;

    @Column(name = "TIRA_RUGA_MAX")
    private int tiraRugasMax;

    @Column(name = "TIRA_RUGA_MIN")
    private int tiraRugasMin;

    @Column(name = "TIRA_RUGA_SP")
    private int tiraRugasSP;

    @Column(name = "ATRASA_SOBE_PLUG_MAX")
    @Min(150)
    @Max(400)
    private int atrasaSobePlugMax;

    @Column(name = "ATRASA_SOBE_PLUG_MIN")
    @Min(150)
    @Max(400)
    private int atrasaSobePlugMin;

    @Column(name = "ATRASA_SOBE_PLUG_SP")
    @Min(150)
    @Max(400)
    private int atrasaSobePlugSP;

    @Column(name = "ATRASA_VACUO_MAX")
    private int atrasaVacuoMax;

    @Column(name = "ATRASA_VACUO_MIN")
    private int atrasaVacuoMin;

    @Column(name = "ATRASA_VACUO_SP")
    private int atrasaVacuoSP;

    @Column(name = "ATRASA_MOLDE_POSTICO_MAX")
    private int atrasaMoldePosticoMax;

    @Column(name = "ATRASA_MOLDE_POSTICO_MIN")
    private int atrasaMoldePosticoMin;

    @Column(name = "ATRASA_MOLDE_POSTICO_SP")
    private int atrasaMoldePosticoSP;

    @Column(name = "ATRASA_PLUG_POSTICO_MAX")
    private int atrasaPlugPosticoMax;

    @Column(name = "ATRASA_PLUG_POSTICO_MIN")
    private int atrasaPlugPosticoMin;

    @Column(name = "ATRASA_PLUG_POSTICO_SP")
    private int atrasaPlugPosticoSP;

    @Column(name = "PLUG_POSTICO_MAX")
    private int plugPosticoMax;

    @Column(name = "PLUG_POSTICO_MIN")
    private int plugPosticoMin;

    @Column(name = "PLUG_POSTICO_SP")
    private int plugPosticoSP;

    @Column(name = "VACUO_LENTO_MAX")
    @Min(10)
    @Max(60)
    private int vacuoLentoMax;

    @Column(name = "VACUO_LENTO_MIN")
    @Min(10)
    @Max(60)
    private int vacuoLentoMin;

    @Column(name = "VACUO_LENTO_SP")
    @Min(10)
    @Max(60)
    private int vacuoLentoSP;

    @Column(name = "VACUO_RAPIDO_MAX")
    @Min(10)
    @Max(60)
    private int vacuoRapidoMax;

    @Column(name = "VACUO_RAPIDO_MIN")
    @Min(10)
    @Max(60)
    private int vacuoRapidoMin;

    @Column(name = "VACUO_RAPIDO_SP")
    @Min(10)
    @Max(60)
    private int vacuoRapidoSP;

    @Column(name = "RESFRIAMENTO_VENTILADOR_MAX")
    @Min(300)
    @Max(1300)
    private int resfriamentoVentiladorMax;

    @Column(name = "RESFRIAMENTO_VENTILADOR_MIN")
    @Min(300)
    @Max(1300)
    private int resfriamentoVentiladorMin;

    @Column(name = "RESFRIAMENTO_VENTILADOR_SP")
    @Min(300)
    @Max(1300)
    private int resfriamentoVentiladorSP;

    @Column(name = "EXTRACAO_MAX")
    @Min(3)
    @Max(7)
    private int extracaoMax;

    @Column(name = "EXTRACAO_MIN")
    @Min(3)
    @Max(7)
    private int extracaoMin;

    @Column(name = "EXTRACAO_SP")
    @Min(3)
    @Max(7)
    private int extracaoSP;

    @Column(name = "EXTRACAO_DESCE_MOLDE_MAX")
    @Min(3)
    @Max(7)
    private int extracaoDesceModelMax;

    @Column(name = "EXTRACAO_DESCE_MOLDE_MIN")
    @Min(3)
    @Max(7)
    private int extracaoDesceModelMin;

    @Column(name = "EXTRACAO_DESCE_MOLDE_SP")
    @Min(3)
    @Max(7)
    private int extracaoDesceModelSP;

    @Column(name = "ATRASA_ABRE_CAIXA_MAX")
    private int atrasaAbreCaixaMax;

    @Column(name = "ATRASA_ABRE_CAIXA_MIN")
    private int atrasaAbreCaixaMin;

    @Column(name = "ATRASA_ABRE_CAIXA_SP")
    private int atrasaAbreCaixaSP;

    @Column(name = "ABRE_CAIXA_MAX")
    private int abreCaixaMax;

    @Column(name = "ABRE_CAIXA_MIN")
    private int abreCaixaMin;

    @Column(name = "ABRE_CAIXA_SP")
    private int abreCaixaSP;

    @Column(name = "ALARME_FORNO_INFERIOR_MAX")
    @Min(9948)
    @Max(9998)
    private int alarmeFornoInferiorMax;

    @Column(name = "ALARME_FORNO_INFERIOR_MIN")
    @Min(9948)
    @Max(9998)
    private int alarmeFornoInferiorMin;

    @Column(name = "ALARME_FORNO_INFERIOR_SP")
    @Min(9948)
    @Max(9998)
    private int alarmeFornoInferiorSP;

    @Column(name = "TEMPERATURA_MANTA_MAX")
    private int temperaturaMantaMax; // TODO: Verificar com Jorge o tipo de dado e se tem limites a serem considerados

    @Column(name = "TEMPERATURA_MANTA_MIN")
    private int temperaturaMantaMin; // TODO: Verificar com Jorge o tipo de dado e se tem limites a serem considerados

    @Column(name = "TEMPERATURA_MANTA_SP")
    private int temperaturaMantaSP; // TODO: Verificar com Jorge o tipo de dado e se tem limites a serem considerados

    @Column(name = "CORTE_BLANK_MAX")
    @Min(1200)
    @Max(1600)
    private int corteBlankMax;

    @Column(name = "CORTE_BLANK_MIN")
    @Min(1200)
    @Max(1600)
    private int corteBlankMin;

    @Column(name = "CORTE_BLANK_SP")
    @Min(1200)
    @Max(1600)
    private int corteBlankSP;

    @Column(name = "ANTES_MOLDAR_MAX")
    @Min(1900)
    @Max(2600)
    private int antesMoldarMax;

    @Column(name = "ANTES_MOLDAR_MIN")
    @Min(1900)
    @Max(2600)
    private int antesMoldarMin;

    @Column(name = "ANTES_MOLDAR_SP")
    @Min(1900)
    @Max(2600)
    private int antesMoldarSP;

    @Column(name = "POSICAO_TRAS_MAX")
    @Min(-25)
    @Max(30)
    private int posicaoTrasMax;

    @Column(name = "POSICAO_TRAS_MIN")
    @Min(-25)
    @Max(30)
    private int posicaoTrasMin;

    @Column(name = "POSICAO_TRAS_SP")
    @Min(-25)
    @Max(30)
    private int posicaoTrasSP;

    @Column(name = "TEMPERATURA_PROGRAMADA_MOLDE_MAX")
    @Min(5)
    @Max(40)
    private int temperaturaProgramadaMoldeMax;

    @Column(name = "TEMPERATURA_PROGRAMADA_MOLDE_MIN")
    @Min(5)
    @Max(40)
    private int temperaturaProgramadaMoldeMin;

    @Column(name = "TEMPERATURA_PROGRAMADA_MOLDE_SP")
    @Min(5)
    @Max(40)
    private int temperaturaProgramadaMoldeSP;

    @Column(name = "TEMPERATURA_SAIDA_TERMORREGULADOR_MAX")
    @Min(10)
    @Max(65)
    private double temperaturaSaidaTermorReguladorMax;

    @Column(name = "TEMPERATURA_SAIDA_TERMORREGULADOR_MIN")
    @Min(10)
    @Max(65)
    private double temperaturaSaidaTermorReguladorMin;

    @Column(name = "TEMPERATURA_SAIDA_TERMORREGULADOR_SP")
    @Min(10)
    @Max(65)
    private double temperaturaSaidaTermorReguladorSP;

    @Column(name = "ALTURA_PARAFUSO_MAX")
    @Min(60)
    @Max(70)
    private int alturaParafusoMax;

    @Column(name = "ALTURA_PARAFUSO_MIN")
    @Min(60)
    @Max(70)
    private int alturaParafusoMin;

    @Column(name = "ALTURA_PARAFUSO_SP")
    @Min(60)
    @Max(70)
    private int alturaParafusoSP;

    @Column(name = "PRESSAO_VACUO_MAX")
    @Min(-2)
    @Max(700)
    private double pressaoVacuoMax;

    @Column(name = "PRESSAO_VACUO_MIN")
    @Min(-1)
    @Max(700)
    private double pressaoVacuoMin;

    @Column(name = "PRESSAO_VACUO_SP")
    @Min(-1)
    @Max(700)
    private double pressaoVacuoSP;

    @Column(name = "PRESSAO_SAIDA_TERMORREGULADOR_MAX")
    @Min(-2)
    @Max(9999)
    private double pressaoSaidaMax;

    @Column(name = "PRESSAO_SAIDA_TERMORREGULADOR_MIN")
    @Min(-1)
    @Max(700)
    private double pressaoSaidaMin;

    @Column(name = "PRESSAO_SAIDA_TERMORREGULADOR_SP")
    @Min(-1)
    @Max(9999)
    private double pressaoSaidaSP;

    @Column(name = "PRESSAO_AR_COMPRIMIDO_01_MAX")
    @Min(-2)
    @Max(9999)
    private double pressaoAr01Max;

    @Column(name = "PRESSAO_AR_COMPRIMIDO_01_MIN")
    @Min(-1)
    @Max(700)
    private double pressaoAr01Min;

    @Column(name = "PRESSAO_AR_COMPRIMIDO_01_SP")
    @Min(-1)
    @Max(9999)
    private double pressaoAr01SP;

    @Column(name = "PRESSAO_AR_COMPRIMIDO_02_MAX")
    @Min(-2)
    @Max(9999)
    private double pressaoAr02Max;

    @Column(name = "PRESSAO_AR_COMPRIMIDO_02_MIN")
    @Min(-1)
    @Max(700)
    private double pressaoAr02Min;

    @Column(name = "PRESSAO_AR_COMPRIMIDO_02_SP")
    @Min(-1)
    @Max(9999)
    private double pressaoAr02SP;

    @Column(name = "PRESSAO_AR_COMPRIMIDO_03_MAX")
    @Min(-2)
    @Max(9999)
    private double pressaoAr03Max;

    @Column(name = "PRESSAO_AR_COMPRIMIDO_03_MIN")
    @Min(-1)
    @Max(700)
    private double pressaoAr03Min;

    @Column(name = "PRESSAO_AR_COMPRIMIDO_03_SP")
    @Min(-1)
    @Max(9999)
    private double pressaoAr03SP;

    @Column(name = "ZONA_01_MAX")
    @Min(0)
    @Max(10000)
    private int zona01Max;

    @Column(name = "ZONA_01_MIN")
    @Min(0)
    @Max(10000)
    private int zona01Min;

    @Column(name = "ZONA_01_SP")
    @Min(0)
    @Max(10000)
    private int zona01SP;


    @Column(name = "ZONA_02_MAX")
    @Min(0)
    @Max(10000)
    private int zona02Max;

    @Column(name = "ZONA_02_MIN")
    @Min(0)
    @Max(10000)
    private int zona02Min;

    @Column(name = "ZONA_02_SP")
    @Min(0)
    @Max(10000)
    private int zona02SP;


    @Column(name = "ZONA_03_MAX")
    @Min(0)
    @Max(10000)
    private int zona03Max;

    @Column(name = "ZONA_03_MIN")
    @Min(0)
    @Max(10000)
    private int zona03Min;

    @Column(name = "ZONA_03_SP")
    @Min(0)
    @Max(10000)
    private int zona03SP;


    @Column(name = "ZONA_04_MAX")
    @Min(0)
    @Max(10000)
    private int zona04Max;

    @Column(name = "ZONA_04_MIN")
    @Min(0)
    @Max(10000)
    private int zona04Min;

    @Column(name = "ZONA_04_SP")
    @Min(0)
    @Max(10000)
    private int zona04SP;


    @Column(name = "ZONA_05_MAX")
    @Min(0)
    @Max(10000)
    private int zona05Max;

    @Column(name = "ZONA_05_MIN")
    @Min(0)
    @Max(10000)
    private int zona05Min;

    @Column(name = "ZONA_05_SP")
    @Min(0)
    @Max(10000)
    private int zona05SP;


    @Column(name = "ZONA_06_MAX")
    @Min(0)
    @Max(10000)
    private int zona06Max;

    @Column(name = "ZONA_06_MIN")
    @Min(0)
    @Max(10000)
    private int zona06Min;

    @Column(name = "ZONA_06_SP")
    @Min(0)
    @Max(10000)
    private int zona06SP;


    @Column(name = "ZONA_07_MAX")
    @Min(0)
    @Max(10000)
    private int zona07Max;

    @Column(name = "ZONA_07_MIN")
    @Min(0)
    @Max(10000)
    private int zona07Min;

    @Column(name = "ZONA_07_SP")
    @Min(0)
    @Max(10000)
    private int zona07SP;


    @Column(name = "ZONA_08_MAX")
    @Min(0)
    @Max(10000)
    private int zona08Max;

    @Column(name = "ZONA_08_MIN")
    @Min(0)
    @Max(10000)
    private int zona08Min;

    @Column(name = "ZONA_08_SP")
    @Min(0)
    @Max(10000)
    private int zona08SP;


    @Column(name = "ZONA_09_MAX")
    @Min(0)
    @Max(10000)
    private int zona09Max;

    @Column(name = "ZONA_09_MIN")
    @Min(0)
    @Max(10000)
    private int zona09Min;

    @Column(name = "ZONA_09_SP")
    @Min(0)
    @Max(10000)
    private int zona09SP;


    @Column(name = "ZONA_10_MAX")
    @Min(0)
    @Max(10000)
    private int zona10Max;

    @Column(name = "ZONA_10_MIN")
    @Min(0)
    @Max(10000)
    private int zona10Min;

    @Column(name = "ZONA_10_SP")
    @Min(0)
    @Max(10000)
    private int zona10SP;


    @Column(name = "ZONA_11_MAX")
    @Min(0)
    @Max(10000)
    private int zona11Max;

    @Column(name = "ZONA_11_MIN")
    @Min(0)
    @Max(10000)
    private int zona11Min;

    @Column(name = "ZONA_11_SP")
    @Min(0)
    @Max(10000)
    private int zona11SP;


    @Column(name = "ZONA_12_MAX")
    @Min(0)
    @Max(10000)
    private int zona12Max;

    @Column(name = "ZONA_12_MIN")
    @Min(0)
    @Max(10000)
    private int zona12Min;

    @Column(name = "ZONA_12_SP")
    @Min(0)
    @Max(10000)
    private int zona12SP;


    @Column(name = "ZONA_13_MAX")
    @Min(0)
    @Max(10000)
    private int zona13Max;

    @Column(name = "ZONA_13_MIN")
    @Min(0)
    @Max(10000)
    private int zona13Min;

    @Column(name = "ZONA_13_SP")
    @Min(0)
    @Max(10000)
    private int zona13SP;


    @Column(name = "ZONA_14_MAX")
    @Min(0)
    @Max(10000)
    private int zona14Max;

    @Column(name = "ZONA_14_MIN")
    @Min(0)
    @Max(10000)
    private int zona14Min;

    @Column(name = "ZONA_14_SP")
    @Min(0)
    @Max(10000)
    private int zona14SP;


    @Column(name = "ZONA_15_MAX")
    @Min(0)
    @Max(10000)
    private int zona15Max;

    @Column(name = "ZONA_15_MIN")
    @Min(0)
    @Max(10000)
    private int zona15Min;

    @Column(name = "ZONA_15_SP")
    @Min(0)
    @Max(10000)
    private int zona15SP;


    @Column(name = "ZONA_16_MAX")
    @Min(0)
    @Max(10000)
    private int zona16Max;

    @Column(name = "ZONA_16_MIN")
    @Min(0)
    @Max(10000)
    private int zona16Min;

    @Column(name = "ZONA_16_SP")
    @Min(0)
    @Max(10000)
    private int zona16SP;


    @Column(name = "ZONA_17_MAX")
    @Min(0)
    @Max(10000)
    private int zona17Max;

    @Column(name = "ZONA_17_MIN")
    @Min(0)
    @Max(10000)
    private int zona17Min;

    @Column(name = "ZONA_17_SP")
    @Min(0)
    @Max(10000)
    private int zona17SP;


    @Column(name = "ZONA_18_MAX")
    @Min(0)
    @Max(10000)
    private int zona18Max;

    @Column(name = "ZONA_18_MIN")
    @Min(0)
    @Max(10000)
    private int zona18Min;

    @Column(name = "ZONA_18_SP")
    @Min(0)
    @Max(10000)
    private int zona18SP;


    @Column(name = "ZONA_19_MAX")
    @Min(0)
    @Max(10000)
    private int zona19Max;

    @Column(name = "ZONA_19_MIN")
    @Min(0)
    @Max(10000)
    private int zona19Min;

    @Column(name = "ZONA_19_SP")
    @Min(0)
    @Max(10000)
    private int zona19SP;


    @Column(name = "ZONA_20_MAX")
    @Min(0)
    @Max(10000)
    private int zona20Max;

    @Column(name = "ZONA_20_MIN")
    @Min(0)
    @Max(10000)
    private int zona20Min;

    @Column(name = "ZONA_20_SP")
    @Min(0)
    @Max(10000)
    private int zona20SP;


    @Column(name = "ZONA_21_MAX")
    @Min(0)
    @Max(10000)
    private int zona21Max;

    @Column(name = "ZONA_21_MIN")
    @Min(0)
    @Max(10000)
    private int zona21Min;

    @Column(name = "ZONA_21_SP")
    @Min(0)
    @Max(10000)
    private int zona21SP;


    @Column(name = "ZONA_22_MAX")
    @Min(0)
    @Max(10000)
    private int zona22Max;

    @Column(name = "ZONA_22_MIN")
    @Min(0)
    @Max(10000)
    private int zona22Min;

    @Column(name = "ZONA_22_SP")
    @Min(0)
    @Max(10000)
    private int zona22SP;


    @Column(name = "ZONA_23_MAX")
    @Min(0)
    @Max(10000)
    private int zona23Max;

    @Column(name = "ZONA_23_MIN")
    @Min(0)
    @Max(10000)
    private int zona23Min;

    @Column(name = "ZONA_23_SP")
    @Min(0)
    @Max(10000)
    private int zona23SP;


    @Column(name = "ZONA_24_MAX")
    @Min(0)
    @Max(10000)
    private int zona24Max;

    @Column(name = "ZONA_24_MIN")
    @Min(0)
    @Max(10000)
    private int zona24Min;

    @Column(name = "ZONA_24_SP")
    @Min(0)
    @Max(10000)
    private int zona24SP;


    @Column(name = "ZONA_25_MAX")
    @Min(0)
    @Max(10000)
    private int zona25Max;

    @Column(name = "ZONA_25_MIN")
    @Min(0)
    @Max(10000)
    private int zona25Min;

    @Column(name = "ZONA_25_SP")
    @Min(0)
    @Max(10000)
    private int zona25SP;


    @Column(name = "ZONA_26_MAX")
    @Min(0)
    @Max(10000)
    private int zona26Max;

    @Column(name = "ZONA_26_MIN")
    @Min(0)
    @Max(10000)
    private int zona26Min;

    @Column(name = "ZONA_26_SP")
    @Min(0)
    @Max(10000)
    private int zona26SP;


    @Column(name = "ZONA_27_MAX")
    @Min(0)
    @Max(10000)
    private int zona27Max;

    @Column(name = "ZONA_27_MIN")
    @Min(0)
    @Max(10000)
    private int zona27Min;

    @Column(name = "ZONA_27_SP")
    @Min(0)
    @Max(10000)
    private int zona27SP;


    @Column(name = "ZONA_28_MAX")
    @Min(0)
    @Max(10000)
    private int zona28Max;

    @Column(name = "ZONA_28_MIN")
    @Min(0)
    @Max(10000)
    private int zona28Min;

    @Column(name = "ZONA_28_SP")
    @Min(0)
    @Max(10000)
    private int zona28SP;


    @Column(name = "ZONA_29_MAX")
    @Min(0)
    @Max(10000)
    private int zona29Max;

    @Column(name = "ZONA_29_MIN")
    @Min(0)
    @Max(10000)
    private int zona29Min;

    @Column(name = "ZONA_29_SP")
    @Min(0)
    @Max(10000)
    private int zona29SP;


    @Column(name = "ZONA_30_MAX")
    @Min(0)
    @Max(10000)
    private int zona30Max;

    @Column(name = "ZONA_30_MIN")
    @Min(0)
    @Max(10000)
    private int zona30Min;

    @Column(name = "ZONA_30_SP")
    @Min(0)
    @Max(10000)
    private int zona30SP;


    @Column(name = "ZONA_31_MAX")
    @Min(0)
    @Max(10000)
    private int zona31Max;

    @Column(name = "ZONA_31_MIN")
    @Min(0)
    @Max(10000)
    private int zona31Min;

    @Column(name = "ZONA_31_SP")
    @Min(0)
    @Max(10000)
    private int zona31SP;


    @Column(name = "ZONA_32_MAX")
    @Min(0)
    @Max(10000)
    private int zona32Max;

    @Column(name = "ZONA_32_MIN")
    @Min(0)
    @Max(10000)
    private int zona32Min;

    @Column(name = "ZONA_32_SP")
    @Min(0)
    @Max(10000)
    private int zona32SP;


    @Column(name = "ZONA_33_MAX")
    @Min(0)
    @Max(10000)
    private int zona33Max;

    @Column(name = "ZONA_33_MIN")
    @Min(0)
    @Max(10000)
    private int zona33Min;

    @Column(name = "ZONA_33_SP")
    @Min(0)
    @Max(10000)
    private int zona33SP;


    @Column(name = "ZONA_34_MAX")
    @Min(0)
    @Max(10000)
    private int zona34Max;

    @Column(name = "ZONA_34_MIN")
    @Min(0)
    @Max(10000)
    private int zona34Min;

    @Column(name = "ZONA_34_SP")
    @Min(0)
    @Max(10000)
    private int zona34SP;


    @Column(name = "ZONA_35_MAX")
    @Min(0)
    @Max(10000)
    private int zona35Max;

    @Column(name = "ZONA_35_MIN")
    @Min(0)
    @Max(10000)
    private int zona35Min;

    @Column(name = "ZONA_35_SP")
    @Min(0)
    @Max(10000)
    private int zona35SP;


    @Column(name = "ZONA_36_MAX")
    @Min(0)
    @Max(10000)
    private int zona36Max;

    @Column(name = "ZONA_36_MIN")
    @Min(0)
    @Max(10000)
    private int zona36Min;

    @Column(name = "ZONA_36_SP")
    @Min(0)
    @Max(10000)
    private int zona36SP;


    @Column(name = "ZONA_37_MAX")
    @Min(0)
    @Max(10000)
    private int zona37Max;

    @Column(name = "ZONA_37_MIN")
    @Min(0)
    @Max(10000)
    private int zona37Min;

    @Column(name = "ZONA_37_SP")
    @Min(0)
    @Max(10000)
    private int zona37SP;


    @Column(name = "ZONA_38_MAX")
    @Min(0)
    @Max(10000)
    private int zona38Max;

    @Column(name = "ZONA_38_MIN")
    @Min(0)
    @Max(10000)
    private int zona38Min;

    @Column(name = "ZONA_38_SP")
    @Min(0)
    @Max(10000)
    private int zona38SP;


    @Column(name = "ZONA_39_MAX")
    @Min(0)
    @Max(10000)
    private int zona39Max;

    @Column(name = "ZONA_39_MIN")
    @Min(0)
    @Max(10000)
    private int zona39Min;

    @Column(name = "ZONA_39_SP")
    @Min(0)
    @Max(10000)
    private int zona39SP;


    @Column(name = "ZONA_40_MAX")
    @Min(0)
    @Max(10000)
    private int zona40Max;

    @Column(name = "ZONA_40_MIN")
    @Min(0)
    @Max(10000)
    private int zona40Min;

    @Column(name = "ZONA_40_SP")
    @Min(0)
    @Max(10000)
    private int zona40SP;


    @Column(name = "ZONA_41_MAX")
    @Min(0)
    @Max(10000)
    private int zona41Max;

    @Column(name = "ZONA_41_MIN")
    @Min(0)
    @Max(10000)
    private int zona41Min;

    @Column(name = "ZONA_41_SP")
    @Min(0)
    @Max(10000)
    private int zona41SP;


    @Column(name = "ZONA_42_MAX")
    @Min(0)
    @Max(10000)
    private int zona42Max;

    @Column(name = "ZONA_42_MIN")
    @Min(0)
    @Max(10000)
    private int zona42Min;

    @Column(name = "ZONA_42_SP")
    @Min(0)
    @Max(10000)
    private int zona42SP;


    @Column(name = "ZONA_43_MAX")
    @Min(0)
    @Max(10000)
    private int zona43Max;

    @Column(name = "ZONA_43_MIN")
    @Min(0)
    @Max(10000)
    private int zona43Min;

    @Column(name = "ZONA_43_SP")
    @Min(0)
    @Max(10000)
    private int zona43SP;


    @Column(name = "ZONA_44_MAX")
    @Min(0)
    @Max(10000)
    private int zona44Max;

    @Column(name = "ZONA_44_MIN")
    @Min(0)
    @Max(10000)
    private int zona44Min;

    @Column(name = "ZONA_44_SP")
    @Min(0)
    @Max(10000)
    private int zona44SP;


    @Column(name = "ZONA_45_MAX")
    @Min(0)
    @Max(10000)
    private int zona45Max;

    @Column(name = "ZONA_45_MIN")
    @Min(0)
    @Max(10000)
    private int zona45Min;

    @Column(name = "ZONA_45_SP")
    @Min(0)
    @Max(10000)
    private int zona45SP;


    @Column(name = "ZONA_46_MAX")
    @Min(0)
    @Max(10000)
    private int zona46Max;

    @Column(name = "ZONA_46_MIN")
    @Min(0)
    @Max(10000)
    private int zona46Min;

    @Column(name = "ZONA_46_SP")
    @Min(0)
    @Max(10000)
    private int zona46SP;

    @Column(name = "ZONA_47_MAX")
    @Min(0)
    @Max(10000)
    private int zona47Max;

    @Column(name = "ZONA_47_MIN")
    @Min(0)
    @Max(10000)
    private int zona47Min;

    @Column(name = "ZONA_47_SP")
    @Min(0)
    @Max(10000)
    private int zona47SP;

    @Column(name = "ZONA_48_MAX")
    @Min(0)
    @Max(10000)
    private int zona48Max;

    @Column(name = "ZONA_48_MIN")
    @Min(0)
    @Max(10000)
    private int zona48Min;

    @Column(name = "ZONA_48_SP")
    @Min(0)
    @Max(10000)
    private int zona48SP;

    @Column(name = "ZONA_49_MAX")
    @Min(0)
    @Max(10000)
    private int zona49Max;

    @Column(name = "ZONA_49_MIN")
    @Min(0)
    @Max(10000)
    private int zona49Min;

    @Column(name = "ZONA_49_SP")
    @Min(0)
    @Max(10000)
    private int zona49SP;

    @Column(name = "ZONA_50_MAX")
    @Min(0)
    @Max(10000)
    private int zona50Max;

    @Column(name = "ZONA_50_MIN")
    @Min(0)
    @Max(10000)
    private int zona50Min;

    @Column(name = "ZONA_50_SP")
    @Min(0)
    @Max(10000)
    private int zona50SP;

    @Column(name = "ZONA_51_MAX")
    @Min(0)
    @Max(10000)
    private int zona51Max;

    @Column(name = "ZONA_51_MIN")
    @Min(0)
    @Max(10000)
    private int zona51Min;

    @Column(name = "ZONA_51_SP")
    @Min(0)
    @Max(10000)
    private int zona51SP;

    @Column(name = "ZONA_52_MAX")
    @Min(0)
    @Max(10000)
    private int zona52Max;

    @Column(name = "ZONA_52_MIN")
    @Min(0)
    @Max(10000)
    private int zona52Min;

    @Column(name = "ZONA_52_SP")
    @Min(0)
    @Max(10000)
    private int zona52SP;

    @Column(name = "ZONA_53_MAX")
    @Min(0)
    @Max(10000)
    private int zona53Max;

    @Column(name = "ZONA_53_MIN")
    @Min(0)
    @Max(10000)
    private int zona53Min;

    @Column(name = "ZONA_53_SP")
    @Min(0)
    @Max(10000)
    private int zona53SP;

    @Column(name = "ZONA_54_MAX")
    @Min(0)
    @Max(10000)
    private int zona54Max;

    @Column(name = "ZONA_54_MIN")
    @Min(0)
    @Max(10000)
    private int zona54Min;

    @Column(name = "ZONA_54_SP")
    @Min(0)
    @Max(10000)
    private int zona54SP;

    @Column(name = "ZONA_55_MAX")
    @Min(0)
    @Max(10000)
    private int zona55Max;

    @Column(name = "ZONA_55_MIN")
    @Min(0)
    @Max(10000)
    private int zona55Min;

    @Column(name = "ZONA_55_SP")
    @Min(0)
    @Max(10000)
    private int zona55SP;

    @Column(name = "ZONA_56_MAX")
    @Min(0)
    @Max(10000)
    private int zona56Max;

    @Column(name = "ZONA_56_MIN")
    @Min(0)
    @Max(10000)
    private int zona56Min;

    @Column(name = "ZONA_56_SP")
    @Min(0)
    @Max(10000)
    private int zona56SP;

    @Column(name = "ZONA_57_MAX")
    @Min(0)
    @Max(10000)
    private int zona57Max;

    @Column(name = "ZONA_57_MIN")
    @Min(0)
    @Max(10000)
    private int zona57Min;

    @Column(name = "ZONA_57_SP")
    @Min(0)
    @Max(10000)
    private int zona57SP;

    @Column(name = "ZONA_58_MAX")
    @Min(0)
    @Max(10000)
    private int zona58Max;

    @Column(name = "ZONA_58_MIN")
    @Min(0)
    @Max(10000)
    private int zona58Min;

    @Column(name = "ZONA_58_SP")
    @Min(0)
    @Max(10000)
    private int zona58SP;

    @Column(name = "ZONA_59_MAX")
    @Min(0)
    @Max(10000)
    private int zona59Max;

    @Column(name = "ZONA_59_MIN")
    @Min(0)
    @Max(10000)
    private int zona59Min;

    @Column(name = "ZONA_59_SP")
    @Min(0)
    @Max(10000)
    private int zona59SP;

    @Column(name = "ZONA_60_MAX")
    @Min(0)
    @Max(10000)
    private int zona60Max;

    @Column(name = "ZONA_60_MIN")
    @Min(0)
    @Max(10000)
    private int zona60Min;

    @Column(name = "ZONA_60_SP")
    @Min(0)
    @Max(10000)
    private int zona60SP;

    @Column(name = "ZONA_61_MAX")
    @Min(0)
    @Max(10000)
    private int zona61Max;

    @Column(name = "ZONA_61_MIN")
    @Min(0)
    @Max(10000)
    private int zona61Min;

    @Column(name = "ZONA_61_SP")
    @Min(0)
    @Max(10000)
    private int zona61SP;

    @Column(name = "ZONA_62_MAX")
    @Min(0)
    @Max(10000)
    private int zona62Max;

    @Column(name = "ZONA_62_MIN")
    @Min(0)
    @Max(10000)
    private int zona62Min;

    @Column(name = "ZONA_62_SP")
    @Min(0)
    @Max(10000)
    private int zona62SP;

    @Column(name = "ZONA_63_MAX")
    @Min(0)
    @Max(10000)
    private int zona63Max;

    @Column(name = "ZONA_63_MIN")
    @Min(0)
    @Max(10000)
    private int zona63Min;

    @Column(name = "ZONA_63_SP")
    @Min(0)
    @Max(10000)
    private int zona63SP;

    @Column(name = "ZONA_64_MAX")
    @Min(0)
    @Max(10000)
    private int zona64Max;

    @Column(name = "ZONA_64_MIN")
    @Min(0)
    @Max(10000)
    private int zona64Min;

    @Column(name = "ZONA_64_SP")
    @Min(0)
    @Max(10000)
    private int zona64SP;

    @Column(name = "ZONA_65_MAX")
    @Min(0)
    @Max(10000)
    private int zona65Max;

    @Column(name = "ZONA_65_MIN")
    @Min(0)
    @Max(10000)
    private int zona65Min;

    @Column(name = "ZONA_65_SP")
    @Min(0)
    @Max(10000)
    private int zona65SP;

    @Column(name = "ZONA_66_MAX")
    @Min(0)
    @Max(10000)
    private int zona66Max;

    @Column(name = "ZONA_66_MIN")
    @Min(0)
    @Max(10000)
    private int zona66Min;

    @Column(name = "ZONA_66_SP")
    @Min(0)
    @Max(10000)
    private int zona66SP;

    @Column(name = "ZONA_67_MAX")
    @Min(0)
    @Max(10000)
    private int zona67Max;

    @Column(name = "ZONA_67_MIN")
    @Min(0)
    @Max(10000)
    private int zona67Min;

    @Column(name = "ZONA_67_SP")
    @Min(0)
    @Max(10000)
    private int zona67SP;

    @Column(name = "ZONA_68_MAX")
    @Min(0)
    @Max(10000)
    private int zona68Max;

    @Column(name = "ZONA_68_MIN")
    @Min(0)
    @Max(10000)
    private int zona68Min;

    @Column(name = "ZONA_68_SP")
    @Min(0)
    @Max(10000)
    private int zona68SP;

    @Column(name = "ZONA_69_MAX")
    @Min(0)
    @Max(10000)
    private int zona69Max;

    @Column(name = "ZONA_69_MIN")
    @Min(0)
    @Max(10000)
    private int zona69Min;

    @Column(name = "ZONA_69_SP")
    @Min(0)
    @Max(10000)
    private int zona69SP;

    @Column(name = "ZONA_70_MAX")
    @Min(0)
    @Max(10000)
    private int zona70Max;

    @Column(name = "ZONA_70_MIN")
    @Min(0)
    @Max(10000)
    private int zona70Min;

    @Column(name = "ZONA_70_SP")
    @Min(0)
    @Max(10000)
    private int zona70SP;

    @Column(name = "ZONA_71_MAX")
    @Min(0)
    @Max(10000)
    private int zona71Max;

    @Column(name = "ZONA_71_MIN")
    @Min(0)
    @Max(10000)
    private int zona71Min;

    @Column(name = "ZONA_71_SP")
    @Min(0)
    @Max(10000)
    private int zona71SP;

    @Column(name = "ZONA_72_MAX")
    @Min(0)
    @Max(10000)
    private int zona72Max;

    @Column(name = "ZONA_72_MIN")
    @Min(0)
    @Max(10000)
    private int zona72Min;

    @Column(name = "ZONA_72_SP")
    @Min(0)
    @Max(10000)
    private int zona72SP;

    @Column(name = "ZONA_73_MAX")
    @Min(0)
    @Max(10000)
    private int zona73Max;

    @Column(name = "ZONA_73_MIN")
    @Min(0)
    @Max(10000)
    private int zona73Min;

    @Column(name = "ZONA_73_SP")
    @Min(0)
    @Max(10000)
    private int zona73SP;

    @Column(name = "ZONA_74_MAX")
    @Min(0)
    @Max(10000)
    private int zona74Max;

    @Column(name = "ZONA_74_MIN")
    @Min(0)
    @Max(10000)
    private int zona74Min;

    @Column(name = "ZONA_74_SP")
    @Min(0)
    @Max(10000)
    private int zona74SP;

    @Column(name = "ZONA_75_MAX")
    @Min(0)
    @Max(10000)
    private int zona75Max;

    @Column(name = "ZONA_75_MIN")
    @Min(0)
    @Max(10000)
    private int zona75Min;

    @Column(name = "ZONA_75_SP")
    @Min(0)
    @Max(10000)
    private int zona75SP;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "ID_FTP")
    @JsonProperty("temposCiclo")
    private TemposCiclo temposCiclo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCliente01() {
        return cliente01;
    }

    public void setCliente01(String cliente01) {
        this.cliente01 = cliente01;
    }

    public String getCliente02() {
        return cliente02;
    }

    public void setCliente02(String cliente02) {
        this.cliente02 = cliente02;
    }

    public String getCliente03() {
        return cliente03;
    }

    public void setCliente03(String cliente03) {
        this.cliente03 = cliente03;
    }

    public String getProduto01() {
        return produto01;
    }

    public void setProduto01(String produto01) {
        this.produto01 = produto01;
    }

    public String getProduto02() {
        return produto02;
    }

    public void setProduto02(String produto02) {
        this.produto02 = produto02;
    }

    public String getProduto03() {
        return produto03;
    }

    public void setProduto03(String produto03) {
        this.produto03 = produto03;
    }

    public String getProjeto() {
        return projeto;
    }

    public void setProjeto(String projeto) {
        this.projeto = projeto;
    }

    public boolean isLigaResistencia() {
        return ligaResistencia;
    }

    public void setLigaResistencia(boolean ligaResistencia) {
        this.ligaResistencia = ligaResistencia;
    }

    public int getModoAquecimento() {
        return modoAquecimento;
    }

    public void setModoAquecimento(int modoAquecimento) {
        this.modoAquecimento = modoAquecimento;
    }

    public boolean isBalao() {
        return balao;
    }

    public void setBalao(boolean balao) {
        this.balao = balao;
    }

    public boolean isContraMolde() {
        return contraMolde;
    }

    public void setContraMolde(boolean contraMolde) {
        this.contraMolde = contraMolde;
    }

    public boolean isMoldePostico() {
        return moldePostico;
    }

    public void setMoldePostico(boolean moldePostico) {
        this.moldePostico = moldePostico;
    }

    public boolean isPlugPostico() {
        return plugPostico;
    }

    public void setPlugPostico(boolean plugPostico) {
        this.plugPostico = plugPostico;
    }

    public boolean isHabilitaSensorMedeBalao() {
        return habilitaSensorMedeBalao;
    }

    public void setHabilitaSensorMedeBalao(boolean habilitaSensorMedeBalao) {
        this.habilitaSensorMedeBalao = habilitaSensorMedeBalao;
    }

    public boolean isPreImpressao() {
        return preImpressao;
    }

    public void setPreImpressao(boolean preImpressao) {
        this.preImpressao = preImpressao;
    }

    public int getPecasMolde() {
        return pecasMolde;
    }

    public void setPecasMolde(int pecasMolde) {
        this.pecasMolde = pecasMolde;
    }

    public boolean isMoldePosticoManual() {
        return moldePosticoManual;
    }

    public void setMoldePosticoManual(boolean moldePosticoManual) {
        this.moldePosticoManual = moldePosticoManual;
    }

    public boolean isAbraCaixa() {
        return abraCaixa;
    }

    public void setAbraCaixa(boolean abraCaixa) {
        this.abraCaixa = abraCaixa;
    }

    public int getControleAlturaBalao() {
        return controleAlturaBalao;
    }

    public void setControleAlturaBalao(int controleAlturaBalao) {
        this.controleAlturaBalao = controleAlturaBalao;
    }

    public int getControleFornoInferior() {
        return controleFornoInferior;
    }

    public void setControleFornoInferior(int controleFornoInferior) {
        this.controleFornoInferior = controleFornoInferior;
    }

    public boolean isPrensaQuadro() {
        return prensaQuadro;
    }

    public void setPrensaQuadro(boolean prensaQuadro) {
        this.prensaQuadro = prensaQuadro;
    }

    public boolean isSegundaValvulaVacuo() {
        return segundaValvulaVacuo;
    }

    public void setSegundaValvulaVacuo(boolean segundaValvulaVacuo) {
        this.segundaValvulaVacuo = segundaValvulaVacuo;
    }

    public int getTemperaturaModel() {
        return temperaturaModel;
    }

    public void setTemperaturaModel(int temperaturaModel) {
        this.temperaturaModel = temperaturaModel;
    }

    public int getBalaoSag01Max() {
        return balaoSag01Max;
    }

    public void setBalaoSag01Max(int balaoSag01Max) {
        this.balaoSag01Max = balaoSag01Max;
    }

    public int getBalaoSag01Min() {
        return balaoSag01Min;
    }

    public void setBalaoSag01Min(int balaoSag01Min) {
        this.balaoSag01Min = balaoSag01Min;
    }

    public int getBalaoSag01SP() {
        return balaoSag01SP;
    }

    public void setBalaoSag01SP(int balaoSag01SP) {
        this.balaoSag01SP = balaoSag01SP;
    }

    public int getBalaoSag02Max() {
        return balaoSag02Max;
    }

    public void setBalaoSag02Max(int balaoSag02Max) {
        this.balaoSag02Max = balaoSag02Max;
    }

    public int getBalaoSag02Min() {
        return balaoSag02Min;
    }

    public void setBalaoSag02Min(int balaoSag02Min) {
        this.balaoSag02Min = balaoSag02Min;
    }

    public int getBalaoSag02SP() {
        return balaoSag02SP;
    }

    public void setBalaoSag02SP(int balaoSag02SP) {
        this.balaoSag02SP = balaoSag02SP;
    }

    public int getBalaoSag03Max() {
        return balaoSag03Max;
    }

    public void setBalaoSag03Max(int balaoSag03Max) {
        this.balaoSag03Max = balaoSag03Max;
    }

    public int getBalaoSag03Min() {
        return balaoSag03Min;
    }

    public void setBalaoSag03Min(int balaoSag03Min) {
        this.balaoSag03Min = balaoSag03Min;
    }

    public int getBalaoSag03SP() {
        return balaoSag03SP;
    }

    public void setBalaoSag03SP(int balaoSag03SP) {
        this.balaoSag03SP = balaoSag03SP;
    }

    public int getBalaoSag04Max() {
        return balaoSag04Max;
    }

    public void setBalaoSag04Max(int balaoSag04Max) {
        this.balaoSag04Max = balaoSag04Max;
    }

    public int getBalaoSag04Min() {
        return balaoSag04Min;
    }

    public void setBalaoSag04Min(int balaoSag04Min) {
        this.balaoSag04Min = balaoSag04Min;
    }

    public int getBalaoSag04SP() {
        return balaoSag04SP;
    }

    public void setBalaoSag04SP(int balaoSag04SP) {
        this.balaoSag04SP = balaoSag04SP;
    }

    public int getAquecimentoCimaMax() {
        return aquecimentoCimaMax;
    }

    public void setAquecimentoCimaMax(int aquecimentoCimaMax) {
        this.aquecimentoCimaMax = aquecimentoCimaMax;
    }

    public int getAquecimentoCimaMin() {
        return aquecimentoCimaMin;
    }

    public void setAquecimentoCimaMin(int aquecimentoCimaMin) {
        this.aquecimentoCimaMin = aquecimentoCimaMin;
    }

    public int getAquecimentoCimaSP() {
        return aquecimentoCimaSP;
    }

    public void setAquecimentoCimaSP(int aquecimentoCimaSP) {
        this.aquecimentoCimaSP = aquecimentoCimaSP;
    }

    public int getAquecimentoBaixoMax() {
        return aquecimentoBaixoMax;
    }

    public void setAquecimentoBaixoMax(int aquecimentoBaixoMax) {
        this.aquecimentoBaixoMax = aquecimentoBaixoMax;
    }

    public int getAquecimentoBaixoMin() {
        return aquecimentoBaixoMin;
    }

    public void setAquecimentoBaixoMin(int aquecimentoBaixoMin) {
        this.aquecimentoBaixoMin = aquecimentoBaixoMin;
    }

    public int getAquecimentoBaixoSP() {
        return aquecimentoBaixoSP;
    }

    public void setAquecimentoBaixoSP(int aquecimentoBaixoSP) {
        this.aquecimentoBaixoSP = aquecimentoBaixoSP;
    }

    public int getDesligaBalaoMax() {
        return desligaBalaoMax;
    }

    public void setDesligaBalaoMax(int desligaBalaoMax) {
        this.desligaBalaoMax = desligaBalaoMax;
    }

    public int getDesligaBalaoMin() {
        return desligaBalaoMin;
    }

    public void setDesligaBalaoMin(int desligaBalaoMin) {
        this.desligaBalaoMin = desligaBalaoMin;
    }

    public int getDesligaBalaoSP() {
        return desligaBalaoSP;
    }

    public void setDesligaBalaoSP(int desligaBalaoSP) {
        this.desligaBalaoSP = desligaBalaoSP;
    }

    public int getLigaBalaoMax() {
        return ligaBalaoMax;
    }

    public void setLigaBalaoMax(int ligaBalaoMax) {
        this.ligaBalaoMax = ligaBalaoMax;
    }

    public int getLigaBalaoMin() {
        return ligaBalaoMin;
    }

    public void setLigaBalaoMin(int ligaBalaoMin) {
        this.ligaBalaoMin = ligaBalaoMin;
    }

    public int getLigaBalaoSP() {
        return ligaBalaoSP;
    }

    public void setLigaBalaoSP(int ligaBalaoSP) {
        this.ligaBalaoSP = ligaBalaoSP;
    }

    public int getAtrasaSobeMoldeMax() {
        return atrasaSobeMoldeMax;
    }

    public void setAtrasaSobeMoldeMax(int atrasaSobeMoldeMax) {
        this.atrasaSobeMoldeMax = atrasaSobeMoldeMax;
    }

    public int getAtrasaSobeMoldeMin() {
        return atrasaSobeMoldeMin;
    }

    public void setAtrasaSobeMoldeMin(int atrasaSobeMoldeMin) {
        this.atrasaSobeMoldeMin = atrasaSobeMoldeMin;
    }

    public int getAtrasaSobeMoldeSP() {
        return atrasaSobeMoldeSP;
    }

    public void setAtrasaSobeMoldeSP(int atrasaSobeMoldeSP) {
        this.atrasaSobeMoldeSP = atrasaSobeMoldeSP;
    }

    public int getAtrasaBaixaPlugMax() {
        return atrasaBaixaPlugMax;
    }

    public void setAtrasaBaixaPlugMax(int atrasaBaixaPlugMax) {
        this.atrasaBaixaPlugMax = atrasaBaixaPlugMax;
    }

    public int getAtrasaBaixaPlugMin() {
        return atrasaBaixaPlugMin;
    }

    public void setAtrasaBaixaPlugMin(int atrasaBaixaPlugMin) {
        this.atrasaBaixaPlugMin = atrasaBaixaPlugMin;
    }

    public int getAtrasaBaixaPlugSP() {
        return atrasaBaixaPlugSP;
    }

    public void setAtrasaBaixaPlugSP(int atrasaBaixaPlugSP) {
        this.atrasaBaixaPlugSP = atrasaBaixaPlugSP;
    }

    public int getAtrasaBalaoMax() {
        return atrasaBalaoMax;
    }

    public void setAtrasaBalaoMax(int atrasaBalaoMax) {
        this.atrasaBalaoMax = atrasaBalaoMax;
    }

    public int getAtrasaBalaoMin() {
        return atrasaBalaoMin;
    }

    public void setAtrasaBalaoMin(int atrasaBalaoMin) {
        this.atrasaBalaoMin = atrasaBalaoMin;
    }

    public int getAtrasaBalaoSP() {
        return atrasaBalaoSP;
    }

    public void setAtrasaBalaoSP(int atrasaBalaoSP) {
        this.atrasaBalaoSP = atrasaBalaoSP;
    }

    public int getBalaoMax() {
        return balaoMax;
    }

    public void setBalaoMax(int balaoMax) {
        this.balaoMax = balaoMax;
    }

    public int getBalaoMin() {
        return balaoMin;
    }

    public void setBalaoMin(int balaoMin) {
        this.balaoMin = balaoMin;
    }

    public int getBalaoSP() {
        return balaoSP;
    }

    public void setBalaoSP(int balaoSP) {
        this.balaoSP = balaoSP;
    }

    public int getAtrasaTiraRugasMax() {
        return atrasaTiraRugasMax;
    }

    public void setAtrasaTiraRugasMax(int atrasaTiraRugasMax) {
        this.atrasaTiraRugasMax = atrasaTiraRugasMax;
    }

    public int getAtrasaTiraRugasMin() {
        return atrasaTiraRugasMin;
    }

    public void setAtrasaTiraRugasMin(int atrasaTiraRugasMin) {
        this.atrasaTiraRugasMin = atrasaTiraRugasMin;
    }

    public int getAtrasaTiraRugasSP() {
        return atrasaTiraRugasSP;
    }

    public void setAtrasaTiraRugasSP(int atrasaTiraRugasSP) {
        this.atrasaTiraRugasSP = atrasaTiraRugasSP;
    }

    public int getTiraRugasMax() {
        return tiraRugasMax;
    }

    public void setTiraRugasMax(int tiraRugasMax) {
        this.tiraRugasMax = tiraRugasMax;
    }

    public int getTiraRugasMin() {
        return tiraRugasMin;
    }

    public void setTiraRugasMin(int tiraRugasMin) {
        this.tiraRugasMin = tiraRugasMin;
    }

    public int getTiraRugasSP() {
        return tiraRugasSP;
    }

    public void setTiraRugasSP(int tiraRugasSP) {
        this.tiraRugasSP = tiraRugasSP;
    }

    public int getAtrasaSobePlugMax() {
        return atrasaSobePlugMax;
    }

    public void setAtrasaSobePlugMax(int atrasaSobePlugMax) {
        this.atrasaSobePlugMax = atrasaSobePlugMax;
    }

    public int getAtrasaSobePlugMin() {
        return atrasaSobePlugMin;
    }

    public void setAtrasaSobePlugMin(int atrasaSobePlugMin) {
        this.atrasaSobePlugMin = atrasaSobePlugMin;
    }

    public int getAtrasaSobePlugSP() {
        return atrasaSobePlugSP;
    }

    public void setAtrasaSobePlugSP(int atrasaSobePlugSP) {
        this.atrasaSobePlugSP = atrasaSobePlugSP;
    }

    public int getAtrasaVacuoMax() {
        return atrasaVacuoMax;
    }

    public void setAtrasaVacuoMax(int atrasaVacuoMax) {
        this.atrasaVacuoMax = atrasaVacuoMax;
    }

    public int getAtrasaVacuoMin() {
        return atrasaVacuoMin;
    }

    public void setAtrasaVacuoMin(int atrasaVacuoMin) {
        this.atrasaVacuoMin = atrasaVacuoMin;
    }

    public int getAtrasaVacuoSP() {
        return atrasaVacuoSP;
    }

    public void setAtrasaVacuoSP(int atrasaVacuoSP) {
        this.atrasaVacuoSP = atrasaVacuoSP;
    }

    public int getAtrasaMoldePosticoMax() {
        return atrasaMoldePosticoMax;
    }

    public void setAtrasaMoldePosticoMax(int atrasaMoldePosticoMax) {
        this.atrasaMoldePosticoMax = atrasaMoldePosticoMax;
    }

    public int getAtrasaMoldePosticoMin() {
        return atrasaMoldePosticoMin;
    }

    public void setAtrasaMoldePosticoMin(int atrasaMoldePosticoMin) {
        this.atrasaMoldePosticoMin = atrasaMoldePosticoMin;
    }

    public int getAtrasaMoldePosticoSP() {
        return atrasaMoldePosticoSP;
    }

    public void setAtrasaMoldePosticoSP(int atrasaMoldePosticoSP) {
        this.atrasaMoldePosticoSP = atrasaMoldePosticoSP;
    }

    public int getAtrasaPlugPosticoMax() {
        return atrasaPlugPosticoMax;
    }

    public void setAtrasaPlugPosticoMax(int atrasaPlugPosticoMax) {
        this.atrasaPlugPosticoMax = atrasaPlugPosticoMax;
    }

    public int getAtrasaPlugPosticoMin() {
        return atrasaPlugPosticoMin;
    }

    public void setAtrasaPlugPosticoMin(int atrasaPlugPosticoMin) {
        this.atrasaPlugPosticoMin = atrasaPlugPosticoMin;
    }

    public int getAtrasaPlugPosticoSP() {
        return atrasaPlugPosticoSP;
    }

    public void setAtrasaPlugPosticoSP(int atrasaPlugPosticoSP) {
        this.atrasaPlugPosticoSP = atrasaPlugPosticoSP;
    }

    public int getPlugPosticoMax() {
        return plugPosticoMax;
    }

    public void setPlugPosticoMax(int plugPosticoMax) {
        this.plugPosticoMax = plugPosticoMax;
    }

    public int getPlugPosticoMin() {
        return plugPosticoMin;
    }

    public void setPlugPosticoMin(int plugPosticoMin) {
        this.plugPosticoMin = plugPosticoMin;
    }

    public int getPlugPosticoSP() {
        return plugPosticoSP;
    }

    public void setPlugPosticoSP(int plugPosticoSP) {
        this.plugPosticoSP = plugPosticoSP;
    }

    public int getVacuoLentoMax() {
        return vacuoLentoMax;
    }

    public void setVacuoLentoMax(int vacuoLentoMax) {
        this.vacuoLentoMax = vacuoLentoMax;
    }

    public int getVacuoLentoMin() {
        return vacuoLentoMin;
    }

    public void setVacuoLentoMin(int vacuoLentoMin) {
        this.vacuoLentoMin = vacuoLentoMin;
    }

    public int getVacuoLentoSP() {
        return vacuoLentoSP;
    }

    public void setVacuoLentoSP(int vacuoLentoSP) {
        this.vacuoLentoSP = vacuoLentoSP;
    }

    public int getVacuoRapidoMax() {
        return vacuoRapidoMax;
    }

    public void setVacuoRapidoMax(int vacuoRapidoMax) {
        this.vacuoRapidoMax = vacuoRapidoMax;
    }

    public int getVacuoRapidoMin() {
        return vacuoRapidoMin;
    }

    public void setVacuoRapidoMin(int vacuoRapidoMin) {
        this.vacuoRapidoMin = vacuoRapidoMin;
    }

    public int getVacuoRapidoSP() {
        return vacuoRapidoSP;
    }

    public void setVacuoRapidoSP(int vacuoRapidoSP) {
        this.vacuoRapidoSP = vacuoRapidoSP;
    }

    public int getResfriamentoVentiladorMax() {
        return resfriamentoVentiladorMax;
    }

    public void setResfriamentoVentiladorMax(int resfriamentoVentiladorMax) {
        this.resfriamentoVentiladorMax = resfriamentoVentiladorMax;
    }

    public int getResfriamentoVentiladorMin() {
        return resfriamentoVentiladorMin;
    }

    public void setResfriamentoVentiladorMin(int resfriamentoVentiladorMin) {
        this.resfriamentoVentiladorMin = resfriamentoVentiladorMin;
    }

    public int getResfriamentoVentiladorSP() {
        return resfriamentoVentiladorSP;
    }

    public void setResfriamentoVentiladorSP(int resfriamentoVentiladorSP) {
        this.resfriamentoVentiladorSP = resfriamentoVentiladorSP;
    }

    public int getExtracaoMax() {
        return extracaoMax;
    }

    public void setExtracaoMax(int extracaoMax) {
        this.extracaoMax = extracaoMax;
    }

    public int getExtracaoMin() {
        return extracaoMin;
    }

    public void setExtracaoMin(int extracaoMin) {
        this.extracaoMin = extracaoMin;
    }

    public int getExtracaoSP() {
        return extracaoSP;
    }

    public void setExtracaoSP(int extracaoSP) {
        this.extracaoSP = extracaoSP;
    }

    public int getExtracaoDesceModelMax() {
        return extracaoDesceModelMax;
    }

    public void setExtracaoDesceModelMax(int extracaoDesceModelMax) {
        this.extracaoDesceModelMax = extracaoDesceModelMax;
    }

    public int getExtracaoDesceModelMin() {
        return extracaoDesceModelMin;
    }

    public void setExtracaoDesceModelMin(int extracaoDesceModelMin) {
        this.extracaoDesceModelMin = extracaoDesceModelMin;
    }

    public int getExtracaoDesceModelSP() {
        return extracaoDesceModelSP;
    }

    public void setExtracaoDesceModelSP(int extracaoDesceModelSP) {
        this.extracaoDesceModelSP = extracaoDesceModelSP;
    }

    public int getAtrasaAbreCaixaMax() {
        return atrasaAbreCaixaMax;
    }

    public void setAtrasaAbreCaixaMax(int atrasaAbreCaixaMax) {
        this.atrasaAbreCaixaMax = atrasaAbreCaixaMax;
    }

    public int getAtrasaAbreCaixaMin() {
        return atrasaAbreCaixaMin;
    }

    public void setAtrasaAbreCaixaMin(int atrasaAbreCaixaMin) {
        this.atrasaAbreCaixaMin = atrasaAbreCaixaMin;
    }

    public int getAtrasaAbreCaixaSP() {
        return atrasaAbreCaixaSP;
    }

    public void setAtrasaAbreCaixaSP(int atrasaAbreCaixaSP) {
        this.atrasaAbreCaixaSP = atrasaAbreCaixaSP;
    }

    public int getAbreCaixaMax() {
        return abreCaixaMax;
    }

    public void setAbreCaixaMax(int abreCaixaMax) {
        this.abreCaixaMax = abreCaixaMax;
    }

    public int getAbreCaixaMin() {
        return abreCaixaMin;
    }

    public void setAbreCaixaMin(int abreCaixaMin) {
        this.abreCaixaMin = abreCaixaMin;
    }

    public int getAbreCaixaSP() {
        return abreCaixaSP;
    }

    public void setAbreCaixaSP(int abreCaixaSP) {
        this.abreCaixaSP = abreCaixaSP;
    }

    public int getAlarmeFornoInferiorMax() {
        return alarmeFornoInferiorMax;
    }

    public void setAlarmeFornoInferiorMax(int alarmeFornoInferiorMax) {
        this.alarmeFornoInferiorMax = alarmeFornoInferiorMax;
    }

    public int getAlarmeFornoInferiorMin() {
        return alarmeFornoInferiorMin;
    }

    public void setAlarmeFornoInferiorMin(int alarmeFornoInferiorMin) {
        this.alarmeFornoInferiorMin = alarmeFornoInferiorMin;
    }

    public int getAlarmeFornoInferiorSP() {
        return alarmeFornoInferiorSP;
    }

    public void setAlarmeFornoInferiorSP(int alarmeFornoInferiorSP) {
        this.alarmeFornoInferiorSP = alarmeFornoInferiorSP;
    }

    public int getTemperaturaMantaMax() {
        return temperaturaMantaMax;
    }

    public void setTemperaturaMantaMax(int temperaturaMantaMax) {
        this.temperaturaMantaMax = temperaturaMantaMax;
    }

    public int getTemperaturaMantaMin() {
        return temperaturaMantaMin;
    }

    public void setTemperaturaMantaMin(int temperaturaMantaMin) {
        this.temperaturaMantaMin = temperaturaMantaMin;
    }

    public int getTemperaturaMantaSP() {
        return temperaturaMantaSP;
    }

    public void setTemperaturaMantaSP(int temperaturaMantaSP) {
        this.temperaturaMantaSP = temperaturaMantaSP;
    }

    public int getCorteBlankMax() {
        return corteBlankMax;
    }

    public void setCorteBlankMax(int corteBlankMax) {
        this.corteBlankMax = corteBlankMax;
    }

    public int getCorteBlankMin() {
        return corteBlankMin;
    }

    public void setCorteBlankMin(int corteBlankMin) {
        this.corteBlankMin = corteBlankMin;
    }

    public int getCorteBlankSP() {
        return corteBlankSP;
    }

    public void setCorteBlankSP(int corteBlankSP) {
        this.corteBlankSP = corteBlankSP;
    }

    public int getAntesMoldarMax() {
        return antesMoldarMax;
    }

    public void setAntesMoldarMax(int antesMoldarMax) {
        this.antesMoldarMax = antesMoldarMax;
    }

    public int getAntesMoldarMin() {
        return antesMoldarMin;
    }

    public void setAntesMoldarMin(int antesMoldarMin) {
        this.antesMoldarMin = antesMoldarMin;
    }

    public int getAntesMoldarSP() {
        return antesMoldarSP;
    }

    public void setAntesMoldarSP(int antesMoldarSP) {
        this.antesMoldarSP = antesMoldarSP;
    }

    public int getPosicaoTrasMax() {
        return posicaoTrasMax;
    }

    public void setPosicaoTrasMax(int posicaoTrasMax) {
        this.posicaoTrasMax = posicaoTrasMax;
    }

    public int getPosicaoTrasMin() {
        return posicaoTrasMin;
    }

    public void setPosicaoTrasMin(int posicaoTrasMin) {
        this.posicaoTrasMin = posicaoTrasMin;
    }

    public int getPosicaoTrasSP() {
        return posicaoTrasSP;
    }

    public void setPosicaoTrasSP(int posicaoTrasSP) {
        this.posicaoTrasSP = posicaoTrasSP;
    }

    public int getTemperaturaProgramadaMoldeMax() {
        return temperaturaProgramadaMoldeMax;
    }

    public void setTemperaturaProgramadaMoldeMax(int temperaturaProgramadaMoldeMax) {
        this.temperaturaProgramadaMoldeMax = temperaturaProgramadaMoldeMax;
    }

    public int getTemperaturaProgramadaMoldeMin() {
        return temperaturaProgramadaMoldeMin;
    }

    public void setTemperaturaProgramadaMoldeMin(int temperaturaProgramadaMoldeMin) {
        this.temperaturaProgramadaMoldeMin = temperaturaProgramadaMoldeMin;
    }

    public int getTemperaturaProgramadaMoldeSP() {
        return temperaturaProgramadaMoldeSP;
    }

    public void setTemperaturaProgramadaMoldeSP(int temperaturaProgramadaMoldeSP) {
        this.temperaturaProgramadaMoldeSP = temperaturaProgramadaMoldeSP;
    }

    public double getTemperaturaSaidaTermorReguladorMax() {
        return temperaturaSaidaTermorReguladorMax;
    }

    public void setTemperaturaSaidaTermorReguladorMax(double temperaturaSaidaTermorReguladorMax) {
        this.temperaturaSaidaTermorReguladorMax = temperaturaSaidaTermorReguladorMax;
    }

    public double getTemperaturaSaidaTermorReguladorMin() {
        return temperaturaSaidaTermorReguladorMin;
    }

    public void setTemperaturaSaidaTermorReguladorMin(double temperaturaSaidaTermorReguladorMin) {
        this.temperaturaSaidaTermorReguladorMin = temperaturaSaidaTermorReguladorMin;
    }

    public double getTemperaturaSaidaTermorReguladorSP() {
        return temperaturaSaidaTermorReguladorSP;
    }

    public void setTemperaturaSaidaTermorReguladorSP(double temperaturaSaidaTermorReguladorSP) {
        this.temperaturaSaidaTermorReguladorSP = temperaturaSaidaTermorReguladorSP;
    }

    public int getAlturaParafusoMax() {
        return alturaParafusoMax;
    }

    public void setAlturaParafusoMax(int alturaParafusoMax) {
        this.alturaParafusoMax = alturaParafusoMax;
    }

    public int getAlturaParafusoMin() {
        return alturaParafusoMin;
    }

    public void setAlturaParafusoMin(int alturaParafusoMin) {
        this.alturaParafusoMin = alturaParafusoMin;
    }

    public int getAlturaParafusoSP() {
        return alturaParafusoSP;
    }

    public void setAlturaParafusoSP(int alturaParafusoSP) {
        this.alturaParafusoSP = alturaParafusoSP;
    }

    public double getPressaoVacuoMax() {
        return pressaoVacuoMax;
    }

    public void setPressaoVacuoMax(double pressaoVacuoMax) {
        this.pressaoVacuoMax = pressaoVacuoMax;
    }

    public double getPressaoVacuoMin() {
        return pressaoVacuoMin;
    }

    public void setPressaoVacuoMin(double pressaoVacuoMin) {
        this.pressaoVacuoMin = pressaoVacuoMin;
    }

    public double getPressaoVacuoSP() {
        return pressaoVacuoSP;
    }

    public void setPressaoVacuoSP(double pressaoVacuoSP) {
        this.pressaoVacuoSP = pressaoVacuoSP;
    }

    public double getPressaoSaidaMax() {
        return pressaoSaidaMax;
    }

    public void setPressaoSaidaMax(double pressaoSaidaMax) {
        this.pressaoSaidaMax = pressaoSaidaMax;
    }

    public double getPressaoSaidaMin() {
        return pressaoSaidaMin;
    }

    public void setPressaoSaidaMin(double pressaoSaidaMin) {
        this.pressaoSaidaMin = pressaoSaidaMin;
    }

    public double getPressaoSaidaSP() {
        return pressaoSaidaSP;
    }

    public void setPressaoSaidaSP(double pressaoSaidaSP) {
        this.pressaoSaidaSP = pressaoSaidaSP;
    }

    public double getPressaoAr01Max() {
        return pressaoAr01Max;
    }

    public void setPressaoAr01Max(double pressaoAr01Max) {
        this.pressaoAr01Max = pressaoAr01Max;
    }

    public double getPressaoAr01Min() {
        return pressaoAr01Min;
    }

    public void setPressaoAr01Min(double pressaoAr01Min) {
        this.pressaoAr01Min = pressaoAr01Min;
    }

    public double getPressaoAr01SP() {
        return pressaoAr01SP;
    }

    public void setPressaoAr01SP(double pressaoAr01SP) {
        this.pressaoAr01SP = pressaoAr01SP;
    }

    public double getPressaoAr02Max() {
        return pressaoAr02Max;
    }

    public void setPressaoAr02Max(double pressaoAr02Max) {
        this.pressaoAr02Max = pressaoAr02Max;
    }

    public double getPressaoAr02Min() {
        return pressaoAr02Min;
    }

    public void setPressaoAr02Min(double pressaoAr02Min) {
        this.pressaoAr02Min = pressaoAr02Min;
    }

    public double getPressaoAr02SP() {
        return pressaoAr02SP;
    }

    public void setPressaoAr02SP(double pressaoAr02SP) {
        this.pressaoAr02SP = pressaoAr02SP;
    }

    public double getPressaoAr03Max() {
        return pressaoAr03Max;
    }

    public void setPressaoAr03Max(double pressaoAr03Max) {
        this.pressaoAr03Max = pressaoAr03Max;
    }

    public double getPressaoAr03Min() {
        return pressaoAr03Min;
    }

    public void setPressaoAr03Min(double pressaoAr03Min) {
        this.pressaoAr03Min = pressaoAr03Min;
    }

    public double getPressaoAr03SP() {
        return pressaoAr03SP;
    }

    public void setPressaoAr03SP(double pressaoAr03SP) {
        this.pressaoAr03SP = pressaoAr03SP;
    }

    public int getZona01Max() {
        return zona01Max;
    }

    public void setZona01Max(int zona01Max) {
        this.zona01Max = zona01Max;
    }

    public int getZona01Min() {
        return zona01Min;
    }

    public void setZona01Min(int zona01Min) {
        this.zona01Min = zona01Min;
    }

    public int getZona01SP() {
        return zona01SP;
    }

    public void setZona01SP(int zona01SP) {
        this.zona01SP = zona01SP;
    }

    public int getZona02Max() {
        return zona02Max;
    }

    public void setZona02Max(int zona02Max) {
        this.zona02Max = zona02Max;
    }

    public int getZona02Min() {
        return zona02Min;
    }

    public void setZona02Min(int zona02Min) {
        this.zona02Min = zona02Min;
    }

    public int getZona02SP() {
        return zona02SP;
    }

    public void setZona02SP(int zona02SP) {
        this.zona02SP = zona02SP;
    }

    public int getZona03Max() {
        return zona03Max;
    }

    public void setZona03Max(int zona03Max) {
        this.zona03Max = zona03Max;
    }

    public int getZona03Min() {
        return zona03Min;
    }

    public void setZona03Min(int zona03Min) {
        this.zona03Min = zona03Min;
    }

    public int getZona03SP() {
        return zona03SP;
    }

    public void setZona03SP(int zona03SP) {
        this.zona03SP = zona03SP;
    }

    public int getZona04Max() {
        return zona04Max;
    }

    public void setZona04Max(int zona04Max) {
        this.zona04Max = zona04Max;
    }

    public int getZona04Min() {
        return zona04Min;
    }

    public void setZona04Min(int zona04Min) {
        this.zona04Min = zona04Min;
    }

    public int getZona04SP() {
        return zona04SP;
    }

    public void setZona04SP(int zona04SP) {
        this.zona04SP = zona04SP;
    }

    public int getZona05Max() {
        return zona05Max;
    }

    public void setZona05Max(int zona05Max) {
        this.zona05Max = zona05Max;
    }

    public int getZona05Min() {
        return zona05Min;
    }

    public void setZona05Min(int zona05Min) {
        this.zona05Min = zona05Min;
    }

    public int getZona05SP() {
        return zona05SP;
    }

    public void setZona05SP(int zona05SP) {
        this.zona05SP = zona05SP;
    }

    public int getZona06Max() {
        return zona06Max;
    }

    public void setZona06Max(int zona06Max) {
        this.zona06Max = zona06Max;
    }

    public int getZona06Min() {
        return zona06Min;
    }

    public void setZona06Min(int zona06Min) {
        this.zona06Min = zona06Min;
    }

    public int getZona06SP() {
        return zona06SP;
    }

    public void setZona06SP(int zona06SP) {
        this.zona06SP = zona06SP;
    }

    public int getZona07Max() {
        return zona07Max;
    }

    public void setZona07Max(int zona07Max) {
        this.zona07Max = zona07Max;
    }

    public int getZona07Min() {
        return zona07Min;
    }

    public void setZona07Min(int zona07Min) {
        this.zona07Min = zona07Min;
    }

    public int getZona07SP() {
        return zona07SP;
    }

    public void setZona07SP(int zona07SP) {
        this.zona07SP = zona07SP;
    }

    public int getZona08Max() {
        return zona08Max;
    }

    public void setZona08Max(int zona08Max) {
        this.zona08Max = zona08Max;
    }

    public int getZona08Min() {
        return zona08Min;
    }

    public void setZona08Min(int zona08Min) {
        this.zona08Min = zona08Min;
    }

    public int getZona08SP() {
        return zona08SP;
    }

    public void setZona08SP(int zona08SP) {
        this.zona08SP = zona08SP;
    }

    public int getZona09Max() {
        return zona09Max;
    }

    public void setZona09Max(int zona09Max) {
        this.zona09Max = zona09Max;
    }

    public int getZona09Min() {
        return zona09Min;
    }

    public void setZona09Min(int zona09Min) {
        this.zona09Min = zona09Min;
    }

    public int getZona09SP() {
        return zona09SP;
    }

    public void setZona09SP(int zona09SP) {
        this.zona09SP = zona09SP;
    }

    public int getZona10Max() {
        return zona10Max;
    }

    public void setZona10Max(int zona10Max) {
        this.zona10Max = zona10Max;
    }

    public int getZona10Min() {
        return zona10Min;
    }

    public void setZona10Min(int zona10Min) {
        this.zona10Min = zona10Min;
    }

    public int getZona10SP() {
        return zona10SP;
    }

    public void setZona10SP(int zona10SP) {
        this.zona10SP = zona10SP;
    }

    public int getZona11Max() {
        return zona11Max;
    }

    public void setZona11Max(int zona11Max) {
        this.zona11Max = zona11Max;
    }

    public int getZona11Min() {
        return zona11Min;
    }

    public void setZona11Min(int zona11Min) {
        this.zona11Min = zona11Min;
    }

    public int getZona11SP() {
        return zona11SP;
    }

    public void setZona11SP(int zona11SP) {
        this.zona11SP = zona11SP;
    }

    public int getZona12Max() {
        return zona12Max;
    }

    public void setZona12Max(int zona12Max) {
        this.zona12Max = zona12Max;
    }

    public int getZona12Min() {
        return zona12Min;
    }

    public void setZona12Min(int zona12Min) {
        this.zona12Min = zona12Min;
    }

    public int getZona12SP() {
        return zona12SP;
    }

    public void setZona12SP(int zona12SP) {
        this.zona12SP = zona12SP;
    }

    public int getZona13Max() {
        return zona13Max;
    }

    public void setZona13Max(int zona13Max) {
        this.zona13Max = zona13Max;
    }

    public int getZona13Min() {
        return zona13Min;
    }

    public void setZona13Min(int zona13Min) {
        this.zona13Min = zona13Min;
    }

    public int getZona13SP() {
        return zona13SP;
    }

    public void setZona13SP(int zona13SP) {
        this.zona13SP = zona13SP;
    }

    public int getZona14Max() {
        return zona14Max;
    }

    public void setZona14Max(int zona14Max) {
        this.zona14Max = zona14Max;
    }

    public int getZona14Min() {
        return zona14Min;
    }

    public void setZona14Min(int zona14Min) {
        this.zona14Min = zona14Min;
    }

    public int getZona14SP() {
        return zona14SP;
    }

    public void setZona14SP(int zona14SP) {
        this.zona14SP = zona14SP;
    }

    public int getZona15Max() {
        return zona15Max;
    }

    public void setZona15Max(int zona15Max) {
        this.zona15Max = zona15Max;
    }

    public int getZona15Min() {
        return zona15Min;
    }

    public void setZona15Min(int zona15Min) {
        this.zona15Min = zona15Min;
    }

    public int getZona15SP() {
        return zona15SP;
    }

    public void setZona15SP(int zona15SP) {
        this.zona15SP = zona15SP;
    }

    public int getZona16Max() {
        return zona16Max;
    }

    public void setZona16Max(int zona16Max) {
        this.zona16Max = zona16Max;
    }

    public int getZona16Min() {
        return zona16Min;
    }

    public void setZona16Min(int zona16Min) {
        this.zona16Min = zona16Min;
    }

    public int getZona16SP() {
        return zona16SP;
    }

    public void setZona16SP(int zona16SP) {
        this.zona16SP = zona16SP;
    }

    public int getZona17Max() {
        return zona17Max;
    }

    public void setZona17Max(int zona17Max) {
        this.zona17Max = zona17Max;
    }

    public int getZona17Min() {
        return zona17Min;
    }

    public void setZona17Min(int zona17Min) {
        this.zona17Min = zona17Min;
    }

    public int getZona17SP() {
        return zona17SP;
    }

    public void setZona17SP(int zona17SP) {
        this.zona17SP = zona17SP;
    }

    public int getZona18Max() {
        return zona18Max;
    }

    public void setZona18Max(int zona18Max) {
        this.zona18Max = zona18Max;
    }

    public int getZona18Min() {
        return zona18Min;
    }

    public void setZona18Min(int zona18Min) {
        this.zona18Min = zona18Min;
    }

    public int getZona18SP() {
        return zona18SP;
    }

    public void setZona18SP(int zona18SP) {
        this.zona18SP = zona18SP;
    }

    public int getZona19Max() {
        return zona19Max;
    }

    public void setZona19Max(int zona19Max) {
        this.zona19Max = zona19Max;
    }

    public int getZona19Min() {
        return zona19Min;
    }

    public void setZona19Min(int zona19Min) {
        this.zona19Min = zona19Min;
    }

    public int getZona19SP() {
        return zona19SP;
    }

    public void setZona19SP(int zona19SP) {
        this.zona19SP = zona19SP;
    }

    public int getZona20Max() {
        return zona20Max;
    }

    public void setZona20Max(int zona20Max) {
        this.zona20Max = zona20Max;
    }

    public int getZona20Min() {
        return zona20Min;
    }

    public void setZona20Min(int zona20Min) {
        this.zona20Min = zona20Min;
    }

    public int getZona20SP() {
        return zona20SP;
    }

    public void setZona20SP(int zona20SP) {
        this.zona20SP = zona20SP;
    }

    public int getZona21Max() {
        return zona21Max;
    }

    public void setZona21Max(int zona21Max) {
        this.zona21Max = zona21Max;
    }

    public int getZona21Min() {
        return zona21Min;
    }

    public void setZona21Min(int zona21Min) {
        this.zona21Min = zona21Min;
    }

    public int getZona21SP() {
        return zona21SP;
    }

    public void setZona21SP(int zona21SP) {
        this.zona21SP = zona21SP;
    }

    public int getZona22Max() {
        return zona22Max;
    }

    public void setZona22Max(int zona22Max) {
        this.zona22Max = zona22Max;
    }

    public int getZona22Min() {
        return zona22Min;
    }

    public void setZona22Min(int zona22Min) {
        this.zona22Min = zona22Min;
    }

    public int getZona22SP() {
        return zona22SP;
    }

    public void setZona22SP(int zona22SP) {
        this.zona22SP = zona22SP;
    }

    public int getZona23Max() {
        return zona23Max;
    }

    public void setZona23Max(int zona23Max) {
        this.zona23Max = zona23Max;
    }

    public int getZona23Min() {
        return zona23Min;
    }

    public void setZona23Min(int zona23Min) {
        this.zona23Min = zona23Min;
    }

    public int getZona23SP() {
        return zona23SP;
    }

    public void setZona23SP(int zona23SP) {
        this.zona23SP = zona23SP;
    }

    public int getZona24Max() {
        return zona24Max;
    }

    public void setZona24Max(int zona24Max) {
        this.zona24Max = zona24Max;
    }

    public int getZona24Min() {
        return zona24Min;
    }

    public void setZona24Min(int zona24Min) {
        this.zona24Min = zona24Min;
    }

    public int getZona24SP() {
        return zona24SP;
    }

    public void setZona24SP(int zona24SP) {
        this.zona24SP = zona24SP;
    }

    public int getZona25Max() {
        return zona25Max;
    }

    public void setZona25Max(int zona25Max) {
        this.zona25Max = zona25Max;
    }

    public int getZona25Min() {
        return zona25Min;
    }

    public void setZona25Min(int zona25Min) {
        this.zona25Min = zona25Min;
    }

    public int getZona25SP() {
        return zona25SP;
    }

    public void setZona25SP(int zona25SP) {
        this.zona25SP = zona25SP;
    }

    public int getZona26Max() {
        return zona26Max;
    }

    public void setZona26Max(int zona26Max) {
        this.zona26Max = zona26Max;
    }

    public int getZona26Min() {
        return zona26Min;
    }

    public void setZona26Min(int zona26Min) {
        this.zona26Min = zona26Min;
    }

    public int getZona26SP() {
        return zona26SP;
    }

    public void setZona26SP(int zona26SP) {
        this.zona26SP = zona26SP;
    }

    public int getZona27Max() {
        return zona27Max;
    }

    public void setZona27Max(int zona27Max) {
        this.zona27Max = zona27Max;
    }

    public int getZona27Min() {
        return zona27Min;
    }

    public void setZona27Min(int zona27Min) {
        this.zona27Min = zona27Min;
    }

    public int getZona27SP() {
        return zona27SP;
    }

    public void setZona27SP(int zona27SP) {
        this.zona27SP = zona27SP;
    }

    public int getZona28Max() {
        return zona28Max;
    }

    public void setZona28Max(int zona28Max) {
        this.zona28Max = zona28Max;
    }

    public int getZona28Min() {
        return zona28Min;
    }

    public void setZona28Min(int zona28Min) {
        this.zona28Min = zona28Min;
    }

    public int getZona28SP() {
        return zona28SP;
    }

    public void setZona28SP(int zona28SP) {
        this.zona28SP = zona28SP;
    }

    public int getZona29Max() {
        return zona29Max;
    }

    public void setZona29Max(int zona29Max) {
        this.zona29Max = zona29Max;
    }

    public int getZona29Min() {
        return zona29Min;
    }

    public void setZona29Min(int zona29Min) {
        this.zona29Min = zona29Min;
    }

    public int getZona29SP() {
        return zona29SP;
    }

    public void setZona29SP(int zona29SP) {
        this.zona29SP = zona29SP;
    }

    public int getZona30Max() {
        return zona30Max;
    }

    public void setZona30Max(int zona30Max) {
        this.zona30Max = zona30Max;
    }

    public int getZona30Min() {
        return zona30Min;
    }

    public void setZona30Min(int zona30Min) {
        this.zona30Min = zona30Min;
    }

    public int getZona30SP() {
        return zona30SP;
    }

    public void setZona30SP(int zona30SP) {
        this.zona30SP = zona30SP;
    }

    public int getZona31Max() {
        return zona31Max;
    }

    public void setZona31Max(int zona31Max) {
        this.zona31Max = zona31Max;
    }

    public int getZona31Min() {
        return zona31Min;
    }

    public void setZona31Min(int zona31Min) {
        this.zona31Min = zona31Min;
    }

    public int getZona31SP() {
        return zona31SP;
    }

    public void setZona31SP(int zona31SP) {
        this.zona31SP = zona31SP;
    }

    public int getZona32Max() {
        return zona32Max;
    }

    public void setZona32Max(int zona32Max) {
        this.zona32Max = zona32Max;
    }

    public int getZona32Min() {
        return zona32Min;
    }

    public void setZona32Min(int zona32Min) {
        this.zona32Min = zona32Min;
    }

    public int getZona32SP() {
        return zona32SP;
    }

    public void setZona32SP(int zona32SP) {
        this.zona32SP = zona32SP;
    }

    public int getZona33Max() {
        return zona33Max;
    }

    public void setZona33Max(int zona33Max) {
        this.zona33Max = zona33Max;
    }

    public int getZona33Min() {
        return zona33Min;
    }

    public void setZona33Min(int zona33Min) {
        this.zona33Min = zona33Min;
    }

    public int getZona33SP() {
        return zona33SP;
    }

    public void setZona33SP(int zona33SP) {
        this.zona33SP = zona33SP;
    }

    public int getZona34Max() {
        return zona34Max;
    }

    public void setZona34Max(int zona34Max) {
        this.zona34Max = zona34Max;
    }

    public int getZona34Min() {
        return zona34Min;
    }

    public void setZona34Min(int zona34Min) {
        this.zona34Min = zona34Min;
    }

    public int getZona34SP() {
        return zona34SP;
    }

    public void setZona34SP(int zona34SP) {
        this.zona34SP = zona34SP;
    }

    public int getZona35Max() {
        return zona35Max;
    }

    public void setZona35Max(int zona35Max) {
        this.zona35Max = zona35Max;
    }

    public int getZona35Min() {
        return zona35Min;
    }

    public void setZona35Min(int zona35Min) {
        this.zona35Min = zona35Min;
    }

    public int getZona35SP() {
        return zona35SP;
    }

    public void setZona35SP(int zona35SP) {
        this.zona35SP = zona35SP;
    }

    public int getZona36Max() {
        return zona36Max;
    }

    public void setZona36Max(int zona36Max) {
        this.zona36Max = zona36Max;
    }

    public int getZona36Min() {
        return zona36Min;
    }

    public void setZona36Min(int zona36Min) {
        this.zona36Min = zona36Min;
    }

    public int getZona36SP() {
        return zona36SP;
    }

    public void setZona36SP(int zona36SP) {
        this.zona36SP = zona36SP;
    }

    public int getZona37Max() {
        return zona37Max;
    }

    public void setZona37Max(int zona37Max) {
        this.zona37Max = zona37Max;
    }

    public int getZona37Min() {
        return zona37Min;
    }

    public void setZona37Min(int zona37Min) {
        this.zona37Min = zona37Min;
    }

    public int getZona37SP() {
        return zona37SP;
    }

    public void setZona37SP(int zona37SP) {
        this.zona37SP = zona37SP;
    }

    public int getZona38Max() {
        return zona38Max;
    }

    public void setZona38Max(int zona38Max) {
        this.zona38Max = zona38Max;
    }

    public int getZona38Min() {
        return zona38Min;
    }

    public void setZona38Min(int zona38Min) {
        this.zona38Min = zona38Min;
    }

    public int getZona38SP() {
        return zona38SP;
    }

    public void setZona38SP(int zona38SP) {
        this.zona38SP = zona38SP;
    }

    public int getZona39Max() {
        return zona39Max;
    }

    public void setZona39Max(int zona39Max) {
        this.zona39Max = zona39Max;
    }

    public int getZona39Min() {
        return zona39Min;
    }

    public void setZona39Min(int zona39Min) {
        this.zona39Min = zona39Min;
    }

    public int getZona39SP() {
        return zona39SP;
    }

    public void setZona39SP(int zona39SP) {
        this.zona39SP = zona39SP;
    }

    public int getZona40Max() {
        return zona40Max;
    }

    public void setZona40Max(int zona40Max) {
        this.zona40Max = zona40Max;
    }

    public int getZona40Min() {
        return zona40Min;
    }

    public void setZona40Min(int zona40Min) {
        this.zona40Min = zona40Min;
    }

    public int getZona40SP() {
        return zona40SP;
    }

    public void setZona40SP(int zona40SP) {
        this.zona40SP = zona40SP;
    }

    public int getZona41Max() {
        return zona41Max;
    }

    public void setZona41Max(int zona41Max) {
        this.zona41Max = zona41Max;
    }

    public int getZona41Min() {
        return zona41Min;
    }

    public void setZona41Min(int zona41Min) {
        this.zona41Min = zona41Min;
    }

    public int getZona41SP() {
        return zona41SP;
    }

    public void setZona41SP(int zona41SP) {
        this.zona41SP = zona41SP;
    }

    public int getZona42Max() {
        return zona42Max;
    }

    public void setZona42Max(int zona42Max) {
        this.zona42Max = zona42Max;
    }

    public int getZona42Min() {
        return zona42Min;
    }

    public void setZona42Min(int zona42Min) {
        this.zona42Min = zona42Min;
    }

    public int getZona42SP() {
        return zona42SP;
    }

    public void setZona42SP(int zona42SP) {
        this.zona42SP = zona42SP;
    }

    public int getZona43Max() {
        return zona43Max;
    }

    public void setZona43Max(int zona43Max) {
        this.zona43Max = zona43Max;
    }

    public int getZona43Min() {
        return zona43Min;
    }

    public void setZona43Min(int zona43Min) {
        this.zona43Min = zona43Min;
    }

    public int getZona43SP() {
        return zona43SP;
    }

    public void setZona43SP(int zona43SP) {
        this.zona43SP = zona43SP;
    }

    public int getZona44Max() {
        return zona44Max;
    }

    public void setZona44Max(int zona44Max) {
        this.zona44Max = zona44Max;
    }

    public int getZona44Min() {
        return zona44Min;
    }

    public void setZona44Min(int zona44Min) {
        this.zona44Min = zona44Min;
    }

    public int getZona44SP() {
        return zona44SP;
    }

    public void setZona44SP(int zona44SP) {
        this.zona44SP = zona44SP;
    }

    public int getZona45Max() {
        return zona45Max;
    }

    public void setZona45Max(int zona45Max) {
        this.zona45Max = zona45Max;
    }

    public int getZona45Min() {
        return zona45Min;
    }

    public void setZona45Min(int zona45Min) {
        this.zona45Min = zona45Min;
    }

    public int getZona45SP() {
        return zona45SP;
    }

    public void setZona45SP(int zona45SP) {
        this.zona45SP = zona45SP;
    }

    public int getZona46Max() {
        return zona46Max;
    }

    public void setZona46Max(int zona46Max) {
        this.zona46Max = zona46Max;
    }

    public int getZona46Min() {
        return zona46Min;
    }

    public void setZona46Min(int zona46Min) {
        this.zona46Min = zona46Min;
    }

    public int getZona46SP() {
        return zona46SP;
    }

    public void setZona46SP(int zona46SP) {
        this.zona46SP = zona46SP;
    }

    public int getZona47Max() {
        return zona47Max;
    }

    public void setZona47Max(int zona47Max) {
        this.zona47Max = zona47Max;
    }

    public int getZona47Min() {
        return zona47Min;
    }

    public void setZona47Min(int zona47Min) {
        this.zona47Min = zona47Min;
    }

    public int getZona47SP() {
        return zona47SP;
    }

    public void setZona47SP(int zona47SP) {
        this.zona47SP = zona47SP;
    }

    public int getZona48Max() {
        return zona48Max;
    }

    public void setZona48Max(int zona48Max) {
        this.zona48Max = zona48Max;
    }

    public int getZona48Min() {
        return zona48Min;
    }

    public void setZona48Min(int zona48Min) {
        this.zona48Min = zona48Min;
    }

    public int getZona48SP() {
        return zona48SP;
    }

    public void setZona48SP(int zona48SP) {
        this.zona48SP = zona48SP;
    }

    public int getZona49Max() {
        return zona49Max;
    }

    public void setZona49Max(int zona49Max) {
        this.zona49Max = zona49Max;
    }

    public int getZona49Min() {
        return zona49Min;
    }

    public void setZona49Min(int zona49Min) {
        this.zona49Min = zona49Min;
    }

    public int getZona49SP() {
        return zona49SP;
    }

    public void setZona49SP(int zona49SP) {
        this.zona49SP = zona49SP;
    }

    public int getZona50Max() {
        return zona50Max;
    }

    public void setZona50Max(int zona50Max) {
        this.zona50Max = zona50Max;
    }

    public int getZona50Min() {
        return zona50Min;
    }

    public void setZona50Min(int zona50Min) {
        this.zona50Min = zona50Min;
    }

    public int getZona50SP() {
        return zona50SP;
    }

    public void setZona50SP(int zona50SP) {
        this.zona50SP = zona50SP;
    }

    public int getZona51Max() {
        return zona51Max;
    }

    public void setZona51Max(int zona51Max) {
        this.zona51Max = zona51Max;
    }

    public int getZona51Min() {
        return zona51Min;
    }

    public void setZona51Min(int zona51Min) {
        this.zona51Min = zona51Min;
    }

    public int getZona51SP() {
        return zona51SP;
    }

    public void setZona51SP(int zona51SP) {
        this.zona51SP = zona51SP;
    }

    public int getZona52Max() {
        return zona52Max;
    }

    public void setZona52Max(int zona52Max) {
        this.zona52Max = zona52Max;
    }

    public int getZona52Min() {
        return zona52Min;
    }

    public void setZona52Min(int zona52Min) {
        this.zona52Min = zona52Min;
    }

    public int getZona52SP() {
        return zona52SP;
    }

    public void setZona52SP(int zona52SP) {
        this.zona52SP = zona52SP;
    }

    public int getZona53Max() {
        return zona53Max;
    }

    public void setZona53Max(int zona53Max) {
        this.zona53Max = zona53Max;
    }

    public int getZona53Min() {
        return zona53Min;
    }

    public void setZona53Min(int zona53Min) {
        this.zona53Min = zona53Min;
    }

    public int getZona53SP() {
        return zona53SP;
    }

    public void setZona53SP(int zona53SP) {
        this.zona53SP = zona53SP;
    }

    public int getZona54Max() {
        return zona54Max;
    }

    public void setZona54Max(int zona54Max) {
        this.zona54Max = zona54Max;
    }

    public int getZona54Min() {
        return zona54Min;
    }

    public void setZona54Min(int zona54Min) {
        this.zona54Min = zona54Min;
    }

    public int getZona54SP() {
        return zona54SP;
    }

    public void setZona54SP(int zona54SP) {
        this.zona54SP = zona54SP;
    }

    public int getZona55Max() {
        return zona55Max;
    }

    public void setZona55Max(int zona55Max) {
        this.zona55Max = zona55Max;
    }

    public int getZona55Min() {
        return zona55Min;
    }

    public void setZona55Min(int zona55Min) {
        this.zona55Min = zona55Min;
    }

    public int getZona55SP() {
        return zona55SP;
    }

    public void setZona55SP(int zona55SP) {
        this.zona55SP = zona55SP;
    }

    public int getZona56Max() {
        return zona56Max;
    }

    public void setZona56Max(int zona56Max) {
        this.zona56Max = zona56Max;
    }

    public int getZona56Min() {
        return zona56Min;
    }

    public void setZona56Min(int zona56Min) {
        this.zona56Min = zona56Min;
    }

    public int getZona56SP() {
        return zona56SP;
    }

    public void setZona56SP(int zona56SP) {
        this.zona56SP = zona56SP;
    }

    public int getZona57Max() {
        return zona57Max;
    }

    public void setZona57Max(int zona57Max) {
        this.zona57Max = zona57Max;
    }

    public int getZona57Min() {
        return zona57Min;
    }

    public void setZona57Min(int zona57Min) {
        this.zona57Min = zona57Min;
    }

    public int getZona57SP() {
        return zona57SP;
    }

    public void setZona57SP(int zona57SP) {
        this.zona57SP = zona57SP;
    }

    public int getZona58Max() {
        return zona58Max;
    }

    public void setZona58Max(int zona58Max) {
        this.zona58Max = zona58Max;
    }

    public int getZona58Min() {
        return zona58Min;
    }

    public void setZona58Min(int zona58Min) {
        this.zona58Min = zona58Min;
    }

    public int getZona58SP() {
        return zona58SP;
    }

    public void setZona58SP(int zona58SP) {
        this.zona58SP = zona58SP;
    }

    public int getZona59Max() {
        return zona59Max;
    }

    public void setZona59Max(int zona59Max) {
        this.zona59Max = zona59Max;
    }

    public int getZona59Min() {
        return zona59Min;
    }

    public void setZona59Min(int zona59Min) {
        this.zona59Min = zona59Min;
    }

    public int getZona59SP() {
        return zona59SP;
    }

    public void setZona59SP(int zona59SP) {
        this.zona59SP = zona59SP;
    }

    public int getZona60Max() {
        return zona60Max;
    }

    public void setZona60Max(int zona60Max) {
        this.zona60Max = zona60Max;
    }

    public int getZona60Min() {
        return zona60Min;
    }

    public void setZona60Min(int zona60Min) {
        this.zona60Min = zona60Min;
    }

    public int getZona60SP() {
        return zona60SP;
    }

    public void setZona60SP(int zona60SP) {
        this.zona60SP = zona60SP;
    }

    public int getZona61Max() {
        return zona61Max;
    }

    public void setZona61Max(int zona61Max) {
        this.zona61Max = zona61Max;
    }

    public int getZona61Min() {
        return zona61Min;
    }

    public void setZona61Min(int zona61Min) {
        this.zona61Min = zona61Min;
    }

    public int getZona61SP() {
        return zona61SP;
    }

    public void setZona61SP(int zona61SP) {
        this.zona61SP = zona61SP;
    }

    public int getZona62Max() {
        return zona62Max;
    }

    public void setZona62Max(int zona62Max) {
        this.zona62Max = zona62Max;
    }

    public int getZona62Min() {
        return zona62Min;
    }

    public void setZona62Min(int zona62Min) {
        this.zona62Min = zona62Min;
    }

    public int getZona62SP() {
        return zona62SP;
    }

    public void setZona62SP(int zona62SP) {
        this.zona62SP = zona62SP;
    }

    public int getZona63Max() {
        return zona63Max;
    }

    public void setZona63Max(int zona63Max) {
        this.zona63Max = zona63Max;
    }

    public int getZona63Min() {
        return zona63Min;
    }

    public void setZona63Min(int zona63Min) {
        this.zona63Min = zona63Min;
    }

    public int getZona63SP() {
        return zona63SP;
    }

    public void setZona63SP(int zona63SP) {
        this.zona63SP = zona63SP;
    }

    public int getZona64Max() {
        return zona64Max;
    }

    public void setZona64Max(int zona64Max) {
        this.zona64Max = zona64Max;
    }

    public int getZona64Min() {
        return zona64Min;
    }

    public void setZona64Min(int zona64Min) {
        this.zona64Min = zona64Min;
    }

    public int getZona64SP() {
        return zona64SP;
    }

    public void setZona64SP(int zona64SP) {
        this.zona64SP = zona64SP;
    }

    public int getZona65Max() {
        return zona65Max;
    }

    public void setZona65Max(int zona65Max) {
        this.zona65Max = zona65Max;
    }

    public int getZona65Min() {
        return zona65Min;
    }

    public void setZona65Min(int zona65Min) {
        this.zona65Min = zona65Min;
    }

    public int getZona65SP() {
        return zona65SP;
    }

    public void setZona65SP(int zona65SP) {
        this.zona65SP = zona65SP;
    }

    public int getZona66Max() {
        return zona66Max;
    }

    public void setZona66Max(int zona66Max) {
        this.zona66Max = zona66Max;
    }

    public int getZona66Min() {
        return zona66Min;
    }

    public void setZona66Min(int zona66Min) {
        this.zona66Min = zona66Min;
    }

    public int getZona66SP() {
        return zona66SP;
    }

    public void setZona66SP(int zona66SP) {
        this.zona66SP = zona66SP;
    }

    public int getZona67Max() {
        return zona67Max;
    }

    public void setZona67Max(int zona67Max) {
        this.zona67Max = zona67Max;
    }

    public int getZona67Min() {
        return zona67Min;
    }

    public void setZona67Min(int zona67Min) {
        this.zona67Min = zona67Min;
    }

    public int getZona67SP() {
        return zona67SP;
    }

    public void setZona67SP(int zona67SP) {
        this.zona67SP = zona67SP;
    }

    public int getZona68Max() {
        return zona68Max;
    }

    public void setZona68Max(int zona68Max) {
        this.zona68Max = zona68Max;
    }

    public int getZona68Min() {
        return zona68Min;
    }

    public void setZona68Min(int zona68Min) {
        this.zona68Min = zona68Min;
    }

    public int getZona68SP() {
        return zona68SP;
    }

    public void setZona68SP(int zona68SP) {
        this.zona68SP = zona68SP;
    }

    public int getZona69Max() {
        return zona69Max;
    }

    public void setZona69Max(int zona69Max) {
        this.zona69Max = zona69Max;
    }

    public int getZona69Min() {
        return zona69Min;
    }

    public void setZona69Min(int zona69Min) {
        this.zona69Min = zona69Min;
    }

    public int getZona69SP() {
        return zona69SP;
    }

    public void setZona69SP(int zona69SP) {
        this.zona69SP = zona69SP;
    }

    public int getZona70Max() {
        return zona70Max;
    }

    public void setZona70Max(int zona70Max) {
        this.zona70Max = zona70Max;
    }

    public int getZona70Min() {
        return zona70Min;
    }

    public void setZona70Min(int zona70Min) {
        this.zona70Min = zona70Min;
    }

    public int getZona70SP() {
        return zona70SP;
    }

    public void setZona70SP(int zona70SP) {
        this.zona70SP = zona70SP;
    }

    public int getZona71Max() {
        return zona71Max;
    }

    public void setZona71Max(int zona71Max) {
        this.zona71Max = zona71Max;
    }

    public int getZona71Min() {
        return zona71Min;
    }

    public void setZona71Min(int zona71Min) {
        this.zona71Min = zona71Min;
    }

    public int getZona71SP() {
        return zona71SP;
    }

    public void setZona71SP(int zona71SP) {
        this.zona71SP = zona71SP;
    }

    public int getZona72Max() {
        return zona72Max;
    }

    public void setZona72Max(int zona72Max) {
        this.zona72Max = zona72Max;
    }

    public int getZona72Min() {
        return zona72Min;
    }

    public void setZona72Min(int zona72Min) {
        this.zona72Min = zona72Min;
    }

    public int getZona72SP() {
        return zona72SP;
    }

    public void setZona72SP(int zona72SP) {
        this.zona72SP = zona72SP;
    }

    public int getZona73Max() {
        return zona73Max;
    }

    public void setZona73Max(int zona73Max) {
        this.zona73Max = zona73Max;
    }

    public int getZona73Min() {
        return zona73Min;
    }

    public void setZona73Min(int zona73Min) {
        this.zona73Min = zona73Min;
    }

    public int getZona73SP() {
        return zona73SP;
    }

    public void setZona73SP(int zona73SP) {
        this.zona73SP = zona73SP;
    }

    public int getZona74Max() {
        return zona74Max;
    }

    public void setZona74Max(int zona74Max) {
        this.zona74Max = zona74Max;
    }

    public int getZona74Min() {
        return zona74Min;
    }

    public void setZona74Min(int zona74Min) {
        this.zona74Min = zona74Min;
    }

    public int getZona74SP() {
        return zona74SP;
    }

    public void setZona74SP(int zona74SP) {
        this.zona74SP = zona74SP;
    }

    public int getZona75Max() {
        return zona75Max;
    }

    public void setZona75Max(int zona75Max) {
        this.zona75Max = zona75Max;
    }

    public int getZona75Min() {
        return zona75Min;
    }

    public void setZona75Min(int zona75Min) {
        this.zona75Min = zona75Min;
    }

    public int getZona75SP() {
        return zona75SP;
    }

    public void setZona75SP(int zona75SP) {
        this.zona75SP = zona75SP;
    }

    public TemposCiclo getTemposCiclo() {
        return temposCiclo;
    }

    public void setTemposCiclo(TemposCiclo temposCiclo) {
        this.temposCiclo = temposCiclo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FtpTpoTermo that = (FtpTpoTermo) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getIdUnidadeProducao() {
        return idUnidadeProducao;
    }

    public void setIdUnidadeProducao(int idUnidadeProducao) {
        this.idUnidadeProducao = idUnidadeProducao;
    }
}

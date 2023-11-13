package br.com.datawake.datawakeapi.model;

import br.com.datawake.datawakeapi.common.model.BaseModel;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "GEMBA")
@Where(clause = "Deletado_Em IS NULL")
public class FtpGemba extends BaseModel {

    @Column(name = "Data")
    private LocalDate data;

    @Column(name = "Nome_Auditor")
    private String NomeAuditor;

    @Column(name = "Nome_Auditado")
    private String NomeAuditado;

    @Column(name = "Planta")
    private String Planta;

    @Column(name = "Celula")
    private String celula;

    @Column(name = "Produto")
    private String Produto;

    @Column(name = "Resposta_1")
    private String resposta1;

    @Column(name = "Caso_Nao_OK_1")
    private String casoNok1;

    @Column(name = "Resposta_2")
    private String resposta2;

    @Column(name = "Caso_Nao_OK_2")
    private String casoNok2;

    @Column(name = "Resposta_3")
    private String resposta3;

    @Column(name = "Caso_Nao_OK_3")
    private String casoNok3;

    @Column(name = "Resposta_4")
    private String resposta4;

    @Column(name = "Caso_Nao_OK_4")
    private String casoNok4;

    @Column(name = "Resposta_5")
    private String resposta5;

    @Column(name = "Caso_Nao_OK_5")
    private String casoNok5;

    @Column(name = "Resposta_6")
    private String resposta6;

    @Column(name = "Caso_Nao_OK_6")
    private String casoNok6;

    @Column(name = "Resposta_7")
    private String resposta7;

    @Column(name = "Caso_Nao_OK_7")
    private String casoNok7;

    @Column(name = "Resposta_8")
    private String resposta8;

    @Column(name = "Caso_Nao_OK_8")
    private String casoNok8;

    @Column(name = "Resposta_9")
    private String resposta9;

    @Column(name = "Caso_Nao_OK_9")
    private String casoNok9;

    @Column(name = "Resposta_10")
    private String resposta10;

    @Column(name = "Caso_Nao_OK_10")
    private String casoNok10;

    @Column(name = "Resposta_11")
    private String resposta11;

    @Column(name = "Caso_Nao_OK_11")
    private String casoNok11;

    @Column(name = "Resposta_12")
    private String resposta12;

    @Column(name = "Caso_Nao_OK_12")
    private String CasoNOK12;

    @Column(name = "Resposta_13")
    private String resposta13;

    @Column(name = "Caso_Nao_OK_13")
    private String CasoNOK13;

    @Column(name = "Resposta_14")
    private String resposta14;

    @Column(name = "Caso_Nao_OK_14")
    private String CasoNOK14;

    @Column(name = "Resposta_15")
    private String resposta15;

    @Column(name = "Caso_Nao_OK_15")
    private String CasoNOK15;

    @Column(name = "Resposta_16")
    private String resposta16;

    @Column(name = "Caso_Nao_OK_16")
    private String CasoNOK16;

    @Column(name = "Resposta_17")
    private String resposta17;

    @Column(name = "Caso_Nao_OK_17")
    private String CasoNOK17;

    @Column(name = "Resposta_18")
    private String resposta18;

    @Column(name = "Caso_Nao_OK_18")
    private String CasoNOK18;

    @Column(name = "Fifo")
    private String fifo;

    @Column(name = "Conformidade_Detectada")
    private String conformidadeDetectada;

    @Column(name = "Feedback_Feed_Foward")
    private String feedbackFeedFoward;

    @Column(name = "Conformidade_Nao_OK")
    private String conformidadeNok;

    @Column(name = "Seguranca5s")
    private String seguranca5s;

    @Column(name = "Conformidade_Na_Seguranca")
    private String conformidadeNaSeguranca;

    @Column(name = "SegurancaE")
    private String SegurancaE;

    @Column(name = "Conformidade_Na_SegurancaE")
    private String ConformidadeNaSegurancaE;

    @Column(name = "Iluminacao")
    private String iluminacao;

    @Column(name = "Conformidade_Na_Iluminacao")
    private String conformidadeNailuminacao;

    @Column(name = "Resp_24")
    private String resp24;

    @Column(name = "Res_24")
    private String res24;

    @Column(name = "Resp_25")
    private String resp25;

    @Column(name = "Res_25")
    private String res25;

    @Column(name = "Resp_26")
    private String resp26;

    @Column(name = "Res_26")
    private String res26;

    @Column(name = "Resp_27")
    private String resp27;

    @Column(name = "Res_27")
    private String res27;

    @Column(name = "Resp_28")
    private String resp28;

    @Column(name = "Res_28")
    private String res28;

    @Column(name = "Resp_29")
    private String resp29;

    @Column(name = "Res_29")
    private String res29;

    @Column(name = "Resp_30")
    private String resp30;

    @Column(name = "Ocorrencia")
    private String ocorrência;

    @Column(name = "Resp_31")
    private String resp31;

    @Column(name = "Res_31")
    private String res31;

    @Column(name = "Resp_32")
    private String resp32;

    @Column(name = "Res_32")
    private String res32;

//    GETTERS AND SETTERS


    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getNomeAuditor() {
        return NomeAuditor;
    }

    public void setNomeAuditor(String nomeAuditor) {
        NomeAuditor = nomeAuditor;
    }

    public String getNomeAuditado() {
        return NomeAuditado;
    }

    public void setNomeAuditado(String nomeAuditado) {
        NomeAuditado = nomeAuditado;
    }

    public String getPlanta() {
        return Planta;
    }

    public void setPlanta(String planta) {
        Planta = planta;
    }

    public String getCelula() {
        return celula;
    }

    public void setCelula(String celula) {
        this.celula = celula;
    }

    public String getProduto() {
        return Produto;
    }

    public void setProduto(String produto) {
        Produto = produto;
    }

    public String getResposta1() {
        return resposta1;
    }

    public void setResposta1(String resposta1) {
        this.resposta1 = resposta1;
    }

    public String getCasoNok1() {
        return casoNok1;
    }

    public void setCasoNok1(String casoNok1) {
        this.casoNok1 = casoNok1;
    }

    public String getResposta2() {
        return resposta2;
    }

    public void setResposta2(String resposta2) {
        this.resposta2 = resposta2;
    }

    public String getCasoNok2() {
        return casoNok2;
    }

    public void setCasoNok2(String casoNok2) {
        this.casoNok2 = casoNok2;
    }

    public String getResposta3() {
        return resposta3;
    }

    public void setResposta3(String resposta3) {
        this.resposta3 = resposta3;
    }

    public String getCasoNok3() {
        return casoNok3;
    }

    public void setCasoNok3(String casoNok3) {
        this.casoNok3 = casoNok3;
    }

    public String getResposta4() {
        return resposta4;
    }

    public void setResposta4(String resposta4) {
        this.resposta4 = resposta4;
    }

    public String getCasoNok4() {
        return casoNok4;
    }

    public void setCasoNok4(String casoNok4) {
        this.casoNok4 = casoNok4;
    }

    public String getResposta5() {
        return resposta5;
    }

    public void setResposta5(String resposta5) {
        this.resposta5 = resposta5;
    }

    public String getCasoNok5() {
        return casoNok5;
    }

    public void setCasoNok5(String casoNok5) {
        this.casoNok5 = casoNok5;
    }

    public String getResposta6() {
        return resposta6;
    }

    public void setResposta6(String resposta6) {
        this.resposta6 = resposta6;
    }

    public String getCasoNok6() {
        return casoNok6;
    }

    public void setCasoNok6(String casoNok6) {
        this.casoNok6 = casoNok6;
    }

    public String getResposta7() {
        return resposta7;
    }

    public void setResposta7(String resposta7) {
        this.resposta7 = resposta7;
    }

    public String getCasoNok7() {
        return casoNok7;
    }

    public void setCasoNok7(String casoNok7) {
        this.casoNok7 = casoNok7;
    }

    public String getResposta8() {
        return resposta8;
    }

    public void setResposta8(String resposta8) {
        this.resposta8 = resposta8;
    }

    public String getCasoNok8() {
        return casoNok8;
    }

    public void setCasoNok8(String casoNok8) {
        this.casoNok8 = casoNok8;
    }

    public String getResposta9() {
        return resposta9;
    }

    public void setResposta9(String resposta9) {
        this.resposta9 = resposta9;
    }

    public String getCasoNok9() {
        return casoNok9;
    }

    public void setCasoNok9(String casoNok9) {
        this.casoNok9 = casoNok9;
    }

    public String getResposta10() {
        return resposta10;
    }

    public void setResposta10(String resposta10) {
        this.resposta10 = resposta10;
    }

    public String getCasoNok10() {
        return casoNok10;
    }

    public void setCasoNok10(String casoNok10) {
        this.casoNok10 = casoNok10;
    }

    public String getResposta11() {
        return resposta11;
    }

    public void setResposta11(String resposta11) {
        this.resposta11 = resposta11;
    }

    public String getCasoNok11() {
        return casoNok11;
    }

    public void setCasoNok11(String casoNok11) {
        this.casoNok11 = casoNok11;
    }

    public String getResposta12() {
        return resposta12;
    }

    public void setResposta12(String resposta12) {
        this.resposta12 = resposta12;
    }

    public String getCasoNOK12() {
        return CasoNOK12;
    }

    public void setCasoNOK12(String casoNOK12) {
        CasoNOK12 = casoNOK12;
    }

    public String getResposta13() {
        return resposta13;
    }

    public void setResposta13(String resposta13) {
        this.resposta13 = resposta13;
    }

    public String getCasoNOK13() {
        return CasoNOK13;
    }

    public void setCasoNOK13(String casoNOK13) {
        CasoNOK13 = casoNOK13;
    }

    public String getResposta14() {
        return resposta14;
    }

    public void setResposta14(String resposta14) {
        this.resposta14 = resposta14;
    }

    public String getCasoNOK14() {
        return CasoNOK14;
    }

    public void setCasoNOK14(String casoNOK14) {
        CasoNOK14 = casoNOK14;
    }

    public String getResposta15() {
        return resposta15;
    }

    public void setResposta15(String resposta15) {
        this.resposta15 = resposta15;
    }

    public String getCasoNOK15() {
        return CasoNOK15;
    }

    public void setCasoNOK15(String casoNOK15) {
        CasoNOK15 = casoNOK15;
    }

    public String getResposta16() {
        return resposta16;
    }

    public void setResposta16(String resposta16) {
        this.resposta16 = resposta16;
    }

    public String getCasoNOK16() {
        return CasoNOK16;
    }

    public void setCasoNOK16(String casoNOK16) {
        CasoNOK16 = casoNOK16;
    }

    public String getResposta17() {
        return resposta17;
    }

    public void setResposta17(String resposta17) {
        this.resposta17 = resposta17;
    }

    public String getCasoNOK17() {
        return CasoNOK17;
    }

    public void setCasoNOK17(String casoNOK17) {
        CasoNOK17 = casoNOK17;
    }

    public String getResposta18() {
        return resposta18;
    }

    public void setResposta18(String resposta18) {
        this.resposta18 = resposta18;
    }

    public String getCasoNOK18() {
        return CasoNOK18;
    }

    public void setCasoNOK18(String casoNOK18) {
        CasoNOK18 = casoNOK18;
    }

    public String getFifo() {
        return fifo;
    }

    public void setFifo(String fifo) {
        this.fifo = fifo;
    }

    public String getConformidadeDetectada() {
        return conformidadeDetectada;
    }

    public void setConformidadeDetectada(String conformidadeDetectada) {
        this.conformidadeDetectada = conformidadeDetectada;
    }

    public String getFeedbackFeedFoward() {
        return feedbackFeedFoward;
    }

    public void setFeedbackFeedFoward(String feedbackFeedFoward) {
        this.feedbackFeedFoward = feedbackFeedFoward;
    }

    public String getConformidadeNok() {
        return conformidadeNok;
    }

    public void setConformidadeNok(String conformidadeNok) {
        this.conformidadeNok = conformidadeNok;
    }

    public String getSeguranca5s() {
        return seguranca5s;
    }

    public void setSeguranca5s(String seguranca5s) {
        this.seguranca5s = seguranca5s;
    }

    public String getConformidadeNaSeguranca() {
        return conformidadeNaSeguranca;
    }

    public void setConformidadeNaSeguranca(String conformidadeNaSeguranca) {
        this.conformidadeNaSeguranca = conformidadeNaSeguranca;
    }

    public String getSegurancaE() {
        return SegurancaE;
    }

    public void setSegurancaE(String segurancaE) {
        SegurancaE = segurancaE;
    }

    public String getConformidadeNaSegurancaE() {
        return ConformidadeNaSegurancaE;
    }

    public void setConformidadeNaSegurancaE(String conformidadeNaSegurancaE) {
        ConformidadeNaSegurancaE = conformidadeNaSegurancaE;
    }

    public String getIluminacao() {
        return iluminacao;
    }

    public void setIluminacao(String iluminacao) {
        this.iluminacao = iluminacao;
    }

    public String getConformidadeNailuminacao() {
        return conformidadeNailuminacao;
    }

    public void setConformidadeNailuminacao(String conformidadeNailuminacao) {
        this.conformidadeNailuminacao = conformidadeNailuminacao;
    }

    public String getResp24() {
        return resp24;
    }

    public void setResp24(String resp24) {
        this.resp24 = resp24;
    }

    public String getRes24() {
        return res24;
    }

    public void setRes24(String res24) {
        this.res24 = res24;
    }

    public String getResp25() {
        return resp25;
    }

    public void setResp25(String resp25) {
        this.resp25 = resp25;
    }

    public String getRes25() {
        return res25;
    }

    public void setRes25(String res25) {
        this.res25 = res25;
    }

    public String getResp26() {
        return resp26;
    }

    public void setResp26(String resp26) {
        this.resp26 = resp26;
    }

    public String getRes26() {
        return res26;
    }

    public void setRes26(String res26) {
        this.res26 = res26;
    }

    public String getResp27() {
        return resp27;
    }

    public void setResp27(String resp27) {
        this.resp27 = resp27;
    }

    public String getRes27() {
        return res27;
    }

    public void setRes27(String res27) {
        this.res27 = res27;
    }

    public String getResp28() {
        return resp28;
    }

    public void setResp28(String resp28) {
        this.resp28 = resp28;
    }

    public String getRes28() {
        return res28;
    }

    public void setRes28(String res28) {
        this.res28 = res28;
    }

    public String getResp29() {
        return resp29;
    }

    public void setResp29(String resp29) {
        this.resp29 = resp29;
    }

    public String getRes29() {
        return res29;
    }

    public void setRes29(String res29) {
        this.res29 = res29;
    }

    public String getResp30() {
        return resp30;
    }

    public void setResp30(String resp30) {
        this.resp30 = resp30;
    }

    public String getOcorrência() {
        return ocorrência;
    }

    public void setOcorrência(String ocorrência) {
        this.ocorrência = ocorrência;
    }

    public String getResp31() {
        return resp31;
    }

    public void setResp31(String resp31) {
        this.resp31 = resp31;
    }

    public String getRes31() {
        return res31;
    }

    public void setRes31(String res31) {
        this.res31 = res31;
    }

    public String getResp32() {
        return resp32;
    }

    public void setResp32(String resp32) {
        this.resp32 = resp32;
    }

    public String getRes32() {
        return res32;
    }

    public void setRes32(String res32) {
        this.res32 = res32;
    }
}
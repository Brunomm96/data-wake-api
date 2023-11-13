package br.com.datawake.datawakeapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Ftp_auditoria_escalonada_digital")
public class FtpAuditoriaEscalonadaDigital{
    @Column (name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_auditoria")
    private LocalDate dataAuditoria;

    @Column(name = "nome_auditor")
    private String nomeAuditor;

    @Column(name = "nome_auditado")
    private String nomeAuditado ;
    @Column(name = "planta")
    private String planta;

    @Column(name = "celula")
    private String celula;

    @Column(name = "resposta1")
    private String resposta1;

    @Column(name = "casoNok1")
    private String casoNok1;

    @Column(name = "resposta2")
    private String resposta2;

    @Column(name = "casoNok2")
    private String casoNok2;

    @Column(name = "resposta3")
    private String resposta3;

    @Column(name = "casoNok3")
    private String casoNok3;

    @Column(name = "resposta4")
    private String resposta4;

    @Column(name = "casoNok4")
    private String casoNok4;

    @Column(name = "resposta5")
    private String resposta5;

    @Column(name = "casoNok5")
    private String casoNok5;

    @Column(name = "resposta6")
    private String resposta6;

    @Column(name = "casoNok6")
    private String casoNok6;

    @Column(name = "resposta7")
    private String resposta7;

    @Column(name = "casoNok7")
    private String casoNok7;

    @Column(name = "resposta8")
    private String resposta8;

    @Column(name = "casoNok8")
    private String casoNok8;

    @Column(name = "resposta9")
    private String resposta9;

    @Column(name = "casoNok9")
    private String casoNok9;

    @Column(name = "resposta10")
    private String resposta10;

    @Column(name = "casoNok10")
    private String casoNok10;

    @Column(name = "resposta11")
    private String resposta11;

    @Column(name = "casoNok11")
    private String casoNok11;

    @Column(name = "resposta12")
    private String resposta12;

    @Column(name = "casoNok12")
    private String casoNok12;

    @Column(name = "resposta13")
    private String resposta13;

    @Column(name = "casoNok13")
    private String casoNok13;

    @Column(name = "resposta14")
    private String resposta14;

    @Column(name = "casoNok14")
    private String casoNok14;

    @Column(name = "resposta15")
    private String resposta15;

    @Column(name = "casoNok15")
    private String casoNok15;

    @Column(name = "resposta16")
    private String resposta16;

    @Column(name = "casoNok16")
    private String casoNok16;

    @Column(name = "resposta17")
    private String resposta17;

    @Column(name = "casoNok17")
    private String casoNok17;

    @Column(name = "resposta18")
    private String resposta18;

    @Column(name = "casoNok18")
    private String casoNok18;

    @Column(name = "resposta19")
    private String resposta19;

    @Column(name = "casoNok19")
    private String casoNok19;

    @Column(name = "resposta20")
    private String resposta20;

    @Column(name = "casoNok20")
    private String casoNok20;

    @Column(name = "resposta21")
    private String resposta21;

    @Column(name = "casoNok21")
    private String casoNok21;

    @Column(name = "resposta22")
    private String resposta22;

    @Column(name = "casoNok22")
    private String casoNok22;

    @Column(name = "resposta23")
    private String resposta23;

    @Column(name = "casoNok23")
    private String casoNok23;

    @Column(name = "resposta24")
    private String resposta24;

    @Column(name = "casoNok24")
    private String casoNok24;

    @Column(name = "resposta25")
    private String resposta25;

    @Column(name = "casoNok25")
    private String casoNok25;



//    GETTERS AND SETTERS

    public Long  getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataAuditoria() {
        return dataAuditoria;
    }

    public void setDataAuditoria(LocalDate dataAuditoria) {
        this.dataAuditoria= dataAuditoria;
    }

    public String getNomeAuditor() {
        return nomeAuditor;
    }

    public void setNomeAuditor(String nomeAuditor) {
        this.nomeAuditor = nomeAuditor;
    }

    public String getNomeAuditado() { return nomeAuditado; }

    public void setNomeAuditado(String nomeAuditado) {this.nomeAuditado = nomeAuditado;}
    public String getPlanta() {
        return planta;
    }

    public void setPlanta(String planta) {
        this.planta = planta;
    }

    public String getCelula() {return celula;}

    public void setCelula(String celula) {this.celula = celula;}

    public String getResposta1() {return resposta1;}

    public void setResposta1(String resposta1) {this.resposta1 = resposta1;}

    public String getCasoNok1() {return casoNok1;}

    public void setCasoNok1(String casoNok1) {this.casoNok1 = casoNok1;}
    public String getResposta2() {return resposta2;}

    public void setResposta2(String resposta2) {this.resposta2 = resposta2;}

    public String getCasoNok2() {return casoNok2;}

    public void setCasoNok2(String casoNok2) {this.casoNok2 = casoNok2;}

    public String getResposta3() {return resposta3;}

    public void setResposta3(String resposta3) {this.resposta3 = resposta3;}

    public String getCasoNok3() {return casoNok3;}

    public void setCasoNok3(String casoNok3) {this.casoNok3 = casoNok3;}

    public String getResposta4() {return resposta4;}

    public void setResposta4(String resposta4) {this.resposta4 = resposta4;}

    public String getCasoNok4() {return casoNok4;}

    public void setCasoNok4(String casoNok4) {this.casoNok4 = casoNok4;}

    public String getResposta5() {return resposta5;}

    public void setResposta5(String resposta5) {this.resposta5 = resposta5;}

    public String getCasoNok5() {return casoNok5;}

    public void setCasoNok5(String casoNok5) {this.casoNok5 = casoNok5;}

    public String getResposta6() {return resposta6;}

    public void setResposta6(String resposta6) {this.resposta6 = resposta6;}

    public String getCasoNok6() {return casoNok6;}

    public void setCasoNok6(String casoNok6) {this.casoNok6 = casoNok6;}

    public String getResposta7() {return resposta7;}

    public void setResposta7(String resposta7) {this.resposta7 = resposta7;}

    public String getCasoNok7() {return casoNok7;}

    public void setCasoNok7(String casoNok7) {this.casoNok7 = casoNok7;}

    public String getResposta8() {return resposta8;}

    public void setResposta8(String resposta8) {this.resposta8 = resposta8;}

    public String getCasoNok8() {return casoNok8;}

    public void setCasoNok8(String casoNok8) {this.casoNok8 = casoNok8;}

    public String getResposta9() {return resposta9;}

    public void setResposta9(String resposta9) {this.resposta9 = resposta9;}

    public String getCasoNok9() {return casoNok9;}

    public void setCasoNok9(String casoNok9) {this.casoNok9 = casoNok9;}

    public String getResposta10() {return resposta10;}

    public void setResposta10(String resposta10) {this.resposta10 = resposta10;}

    public String getCasoNok10() {return casoNok10;}

    public void setCasoNok10(String casoNok10) {this.casoNok10 = casoNok10;}

    public String getResposta11() {return resposta11;}

    public void setResposta11(String resposta11) {this.resposta11 = resposta11;}

    public String getCasoNok11() {return casoNok11;}

    public void setCasoNok11(String casoNok11) {this.casoNok11 = casoNok11;}

    public String getResposta12() {return resposta12;}

    public void setResposta12(String resposta12) {this.resposta12 = resposta12;}

    public String getCasoNok12() {return casoNok12;}

    public void setCasoNok12(String casoNok12) {this.casoNok12 = casoNok12;}

    public String getResposta13() {return resposta13;}

    public void setResposta13(String resposta13) {this.resposta13 = resposta13;}

    public String getCasoNok13() {return casoNok13;}

    public void setCasoNok13(String casoNok13) {this.casoNok13 = casoNok13;}

    public String getResposta14() {return resposta14;}

    public void setResposta14(String resposta14) {this.resposta14 = resposta14;}

    public String getCasoNok14() {return casoNok14;}

    public void setCasoNok14(String casoNok14) {this.casoNok14 = casoNok14;}

    public String getResposta15() {return resposta15;}

    public void setResposta15(String resposta15) {this.resposta15 = resposta15;}

    public String getCasoNok15() {return casoNok15;}

    public void setCasoNok15(String casoNok15) {this.casoNok15 = casoNok15;}

    public String getResposta16() {return resposta16;}

    public void setResposta16(String resposta16) {this.resposta16 = resposta16;}

    public String getCasoNok16() {return casoNok16;}

    public void setCasoNok16(String casoNok16) {this.casoNok16 = casoNok16;}

    public String getResposta17() {return resposta17;}

    public void setResposta17(String resposta17) {this.resposta17 = resposta17;}

    public String getCasoNok17() {return casoNok17;}

    public void setCasoNok17(String casoNok17) {this.casoNok17 = casoNok17;}

    public String getResposta18() {return resposta18;}

    public void setResposta18(String resposta18) {this.resposta18 = resposta18;}

    public String getCasoNok18() {return casoNok18;}

    public void setCasoNok18(String casoNok18) {this.casoNok18 = casoNok18;}

    public String getResposta19() {return resposta19;}

    public void setResposta19(String resposta19) {this.resposta19 = resposta19;}

    public String getCasoNok19() {return casoNok19;}

    public void setCasoNok19(String casoNok19) {this.casoNok19 = casoNok19;}

    public String getResposta20() {return resposta20;}

    public void setResposta20(String resposta20) {this.resposta20 = resposta20;}

    public String getCasoNok20() {return casoNok20;}

    public void setCasoNok20(String casoNok20) {this.casoNok20 = casoNok20;}

    public String getResposta21() {return resposta21;}

    public void setResposta21(String resposta21) {this.resposta21 = resposta21;}

    public String getCasoNok21() {return casoNok21;}

    public void setCasoNok21(String casoNok21) {this.casoNok21 = casoNok21;}

    public String getResposta22() {return resposta22;}

    public void setResposta22(String resposta22) {this.resposta22 = resposta22;}

    public String getCasoNok22() {return casoNok22;}

    public void setCasoNok22(String casoNok22) {this.casoNok22 = casoNok22;}

    public String getResposta23() {return resposta23;}

    public void setResposta23(String resposta23) {this.resposta23 = resposta23;}

    public String getCasoNok23() {return casoNok23;}

    public void setCasoNok23(String casoNok23) {this.casoNok23 = casoNok23;}

    public String getResposta24() {return resposta24;}

    public void setResposta24(String resposta24) {this.resposta24 = resposta24;}

    public String getCasoNok24() {return casoNok24;}

    public void setCasoNok24(String casoNok24) {this.casoNok24 = casoNok24;}

    public String getResposta25() {return resposta25;}

    public void setResposta25(String resposta25) {this.resposta25 = resposta25;}

    public String getCasoNok25() {return casoNok25;}

    public void setCasoNok25(String casoNok25) {this.casoNok25 = casoNok25;}


}

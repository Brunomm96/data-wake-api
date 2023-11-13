package br.com.datawake.datawakeapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.internal.util.StringHelper;

import javax.lang.model.element.Name;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Objects;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Vistoria_Hidrantes_Mangueiras")

public class FtpHidrante {

    @Column(name = "Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Responsavel")
    private String responsavel;

    @Column(name = "Hidrante_N")
    private String hidrante_N;

    @Column(name = "Localizacao")
    private String localizacao;

    @Column(name = "Data_Hidrostatico")
    private String data_Hidrostatico;

    @Column(name = "Validade")
    private String validade;

    @Column(name = "Ano")
    private String ano;

    @Column(name = "Dia_Vistoria")
    private String dia_Vistoria;

    @Column(name = "Questao01")
    private String questao01;

    @Column(name = "Questao02")
    private String questao02;

    @Column(name = "Questao03")
    private String questao03;

    @Column(name = "Questao04")
    private String questao04;

    @Column(name = "Questao05")
    private String questao05;

    @Column(name = "Questao06")
    private String questao06;

    @Column(name = "Questao07")
    private String questao07;

    @Column(name = "Questao08")
    private String questao08;

    @Column(name = "Questao09")
    private String questao09;

    @Column(name = "Questao10")
    private String questao10;

    @Column(name = "Questao11")
    private String questao11;

    @Column(name = "Questao12")
    private String questao12;

    @Column(name = "Questao13")
    private String questao13;

    @Column(name = "Questao14")
    private String questao14;

    @Column(name = "Questao15")
    private String questao15;

    @Column(name = "Questao16")
    private String questao16;

    @Column(name = "Questao17")
    private String questao17;

    @Column(name = "Questao18")
    private String questao18;

    @Column(name = "Questao19")
    private String questao19;

    @Column(name = "Questao20")
    private String questao20;

    @Column(name = "OBS")
    private String obs;

    @Column(name = "Mes_Registro")
    private String mregistro;

    @Column(name = "Prazo")
    private String prazo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FtpHidrante that = (FtpHidrante) o;
        return id.equals(that.id);	}

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getHidrante_N() { return hidrante_N; }
    public void setHidrante_N(String Hidrante_N) {
        this.hidrante_N = Hidrante_N;
    }


    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getData_Hidrostatico() {
        return data_Hidrostatico;
    }

    public void setData_Hidrostatico(String data_Hidrostatico) { this.data_Hidrostatico = data_Hidrostatico;}

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getDia_Vistoria() {
        return dia_Vistoria;
    }

    public void setDia_Vistoria(String dia_Vistoria) {
        this.dia_Vistoria = dia_Vistoria;
    }

    public String getQuestao01() {
        return questao01;
    }

    public void setQuestao01(String questao01) {
        this.questao01 = questao01;
    }

    public String getQuestao02() {
        return questao02;
    }

    public void setQuestao02(String questao02) {
        this.questao02 = questao02;
    }

    public String getQuestao03() {
        return questao03;
    }

    public void setQuestao03(String questao03) {
        this.questao03 = questao03;
    }

    public String getQuestao04() {
        return questao04;
    }

    public void setQuestao04(String questao04) {
        this.questao04 = questao04;
    }

    public String getQuestao05() {
        return questao05;
    }

    public void setQuestao05(String questao05) {
        this.questao05 = questao05;
    }

    public String getQuestao06() {
        return questao06;
    }

    public void setQuestao06(String questao06) {
        this.questao06 = questao06;
    }

    public String getQuestao07() {
        return questao07;
    }

    public void setQuestao07(String questao07) {
        this.questao07 = questao07;
    }

    public String getQuestao08() {
        return questao08;
    }

    public void setQuestao08(String questao08) {
        this.questao08 = questao08;
    }

    public String getQuestao09() {
        return questao09;
    }

    public void setQuestao09(String questao09) {
        this.questao09 = questao09;
    }

    public String getQuestao10() {
        return questao10;
    }

    public void setQuestao10(String questao10) {
        this.questao10 = questao10;
    }

    public String getQuestao11() {
        return questao11;
    }

    public void setQuestao11(String questao11) {
        this.questao11 = questao11;
    }

    public String getQuestao12() {
        return questao12;
    }

    public void setQuestao12(String questao12) {
        this.questao12 = questao12;
    }

    public String getQuestao13() {
        return questao13;
    }

    public void setQuestao13(String questao13) {
        this.questao13 = questao13;
    }

    public String getQuestao14() {
        return questao14;
    }

    public void setQuestao14(String questao14) {
        this.questao14 = questao14;
    }

    public String getQuestao15() {
        return questao15;
    }

    public void setQuestao15(String questao15) {
        this.questao15 = questao15;
    }

    public String getQuestao16() {
        return questao16;
    }

    public void setQuestao16(String questao16) {
        this.questao16 = questao16;
    }

    public String getQuestao17() {
        return questao17;
    }

    public void setQuestao17(String questao17) {
        this.questao17 = questao17;
    }

    public String getQuestao18() {
        return questao18;
    }

    public void setQuestao18(String questao18) {
        this.questao18 = questao18;
    }

    public String getQuestao19() {
        return questao19;
    }

    public void setQuestao19(String questao19) {
        this.questao19 = questao19;
    }

    public String getQuestao20() {
        return questao20;
    }

    public void setQuestao20(String questao20) {
        this.questao20 = questao20;
    }

    public String getOBS() {
        return obs;
    }

    public void setOBS(String OBS) {
        this.obs = OBS;
    }

    public void setId(Long Id) {this.id = Id;}
    public Long getId() {
        return id;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getMregistro() {
        return mregistro;
    }

    public void setMregistro(String mregistro) {
        this.mregistro = mregistro;
    }

    public String getPrazo() {
        return prazo;
    }

    public void setPrazo(String prazo) {
        this.prazo = prazo;
    }
}

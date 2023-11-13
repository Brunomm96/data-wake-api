package br.com.datawake.datawakeapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.hypersistence.utils.hibernate.type.basic.YearMonthDateType;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.YearMonth;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "FTP_Fuxo_Caixa")
@TypeDef(
        typeClass = YearMonthDateType.class,
        defaultForType = YearMonth.class
)
public class FtpFluxoDeCaixa {

    @Column(name = "Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Tipo_Sav")
    private String savType;

    @Column(name = "Responsavel")
    private String responsible;

    @Column(name = "Sav")
    private String sav;

    @Column(name = "Tit_Projeto")
    private String projectTitle;

    @Column(name = "Cliente")
    private String client;

    @Column(name = "Data_Encerramento")
    private LocalDate endDate;

    @Column(name = "Prorrogar_Data_Encerramento")
    private String prolongEndDate;

    @Column(name = "Nova_Data")
    private LocalDate newDate;

    @Column(name = "Mes_Ano")
    private YearMonth monthYear;

    @Column(name = "Projecao_Gastos")
    private Float expenditureProjection;

    @Column(name = "Saldo_para_Pedido")
    private Float orderBalance;

//    GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSavType() {
        return savType;
    }

    public void setSavType(String savType) {
        this.savType = savType;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getSav() {
        return sav;
    }

    public void setSav(String sav) {
        this.sav = sav;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getProlongEndDate() {
        return prolongEndDate;
    }

    public void setProlongEndDate(String prolongEndDate) {
        this.prolongEndDate = prolongEndDate;
    }

    public LocalDate getNewDate() {
        return newDate;
    }

    public void setNewDate(LocalDate newDate) {
        this.newDate = newDate;
    }

    public YearMonth getMonthYear() {
        return monthYear;
    }

    public void setMonthYear(YearMonth monthYear) {
        this.monthYear = monthYear;
    }

    public Float getExpenditureProjection() {
        return expenditureProjection;
    }

    public void setExpenditureProjection(Float expenditureProjection) {
        this.expenditureProjection = expenditureProjection;
    }

    public Float getOrderBalance() {
        return orderBalance;
    }

    public void setOrderBalance(Float orderBalance) {
        this.orderBalance = orderBalance;
    }
}

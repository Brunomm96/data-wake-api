package br.com.datawake.datawakeapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.hypersistence.utils.hibernate.type.basic.YearMonthDateType;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.TypeDef;
import org.hibernate.internal.util.StringHelper;

import javax.lang.model.element.Name;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Consumo_Energia_Agua")
@TypeDef(
        typeClass = YearMonthDateType.class,
        defaultForType = YearMonth.class
)

public class FtpConsumoEnergiaAgua {
    @Column (name = "Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Mes_Ano")
    private YearMonth mesAno;
    @Column(name = "Qtd_Multa")
    private String qtdMulta;

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public YearMonth getMesAno(){
        return mesAno;
    }
    public void setMesAno(YearMonth mesAno) {
        this.mesAno = mesAno;
    }

    public String getQtdMulta(){
        return qtdMulta;
    }

    public void setQtdMulta(String qtdMulta){
        this.qtdMulta = qtdMulta;
    }

}
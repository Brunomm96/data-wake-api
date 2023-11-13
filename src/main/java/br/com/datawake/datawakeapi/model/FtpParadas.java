package br.com.datawake.datawakeapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "PARADA_CADASTRO")
public class FtpParadas implements Cloneable {

    @Id
    @Column(name = "COD_PARADA", unique = true, nullable = false)
    private String cod_parada;

    @Column(name = "DESC_PARADA")
    private String desc_parada;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FtpParadas that = (FtpParadas) o;
        return cod_parada.equals(that.cod_parada);
    }
    public Object clone() throws CloneNotSupportedException {
        return (Object) super.clone();
    }

    @Override
    public int hashCode() {
        return Objects.hash(cod_parada);
    }

    public String getCod_parada() {
        return cod_parada;
    }

    public void setCod_parada(String cod_parada) {
        this.cod_parada = cod_parada;
    }

    public String getDesc_parada() {
        return desc_parada;
    }

    public void setDesc_parada(String desc_parada) {
        this.desc_parada = desc_parada;
    }
}

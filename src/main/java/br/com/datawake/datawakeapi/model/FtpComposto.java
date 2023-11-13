package br.com.datawake.datawakeapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "FTP_COMPOSTO")
public class FtpComposto implements Cloneable {

    @Id
    @Column(name = "Tag_Gaiola", unique = true, nullable = false)
    private String tagGaiola;

    @Column(name = "Tara_Gaiola")
    private Float taraGaiola;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FtpComposto that = (FtpComposto) o;
        return tagGaiola.equals(that.tagGaiola);
    }
    public Object clone() throws CloneNotSupportedException {
        return (Object) super.clone();
    }
    public Float getTaraGaiola() {
        return taraGaiola;
    }

    public void setTaraGaiola(Float taraGaiola) {
        this.taraGaiola = taraGaiola;
    }

    public void setTagGaiola(String tagGaiola) {
        this.tagGaiola = tagGaiola;
    }
    public String getTagGaiola() {
        return tagGaiola;
    }
    @Override
    public int hashCode() {
        return Objects.hash(tagGaiola);
    }
}

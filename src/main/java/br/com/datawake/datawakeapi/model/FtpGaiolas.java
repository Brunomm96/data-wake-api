package br.com.datawake.datawakeapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;


import java.util.Objects;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "MQB_RFID_Caixas")
public class FtpGaiolas {

    @Basic(optional = false)
    @Column(name = "Tag",unique=true, nullable = false)
    @Id
    private String tag;

    @Column(name = "Observacao")
    private String observacao;

    @Column(name = "Tara")
    private Float tara;

    @Column(name = "Descricao")
    private String descricao;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "Tag")
    @JsonProperty("FtpComposto")
    private FtpComposto ftpComposto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FtpGaiolas that = (FtpGaiolas) o;
        return tag.equals(that.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tag);
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Float getTara() {
        return tara;
    }

    public void setTara(Float tara) {
        this.tara = tara;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    public String getTag() {
        return  tag;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public FtpComposto getFtpComposto() {
        return ftpComposto;
    }

    public void setFtpComposto( FtpComposto ftpComposto) {
        this.ftpComposto =  ftpComposto;
    }
}

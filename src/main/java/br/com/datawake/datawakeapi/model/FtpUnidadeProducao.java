package br.com.datawake.datawakeapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "UNIDADE_PRODUCAO")
public class FtpUnidadeProducao implements Cloneable {

    @Id
    @Column(name = "Id_Unidade", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Id_Unidade_Pai")
    private Long idOver;

    @Column(name = "Nome")
    private String name;

    @Column(name = "Abreviacao")
    private String abbreviation;

    @Column(name = "Codigo")
    private String code;

    @Column(name = "Descricao")
    private String description;

    @Column(name = "Id_Tabela_Setup")
    private Long idTableSetup;

    @Column(name = "Nome_Tabela_Setup")
    private String nameTableSetup;

    @Column(name = "Recurso_ERP")
    private String resourceERP;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FtpUnidadeProducao that = (FtpUnidadeProducao) o;
        return id.equals(that.id);
    }
    public Object clone() throws CloneNotSupportedException {
        return (Object) super.clone();
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceERP() {
        return resourceERP;
    }

    public void setResourceERP(String resourceERP) {
        this.resourceERP = resourceERP;
    }

    public String getNameTableSetup() {
        return nameTableSetup;
    }

    public void setNameTableSetup(String nameTableSetup) {
        this.nameTableSetup = nameTableSetup;
    }

    public Long getIdTableSetup() {
        return idTableSetup;
    }

    public void setIdTableSetup(Long idTableSetup) {
        this.idTableSetup = idTableSetup;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public Long getIdOver() {
        return idOver;
    }

    public void setIdOver(Long idOver) {
        this.idOver = idOver;
    }
}

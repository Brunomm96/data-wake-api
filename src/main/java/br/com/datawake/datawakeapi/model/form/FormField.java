package br.com.datawake.datawakeapi.model.form;

import br.com.datawake.datawakeapi.common.model.BaseModel;
import br.com.datawake.datawakeapi.model.enums.TipoCampoFormularioEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Campo_Formulario")
@Where(clause = "Deletado_Em IS NULL")
public class FormField extends BaseModel {
    @Column(name = "Atributo")
    private String attribute;

    @Column(name = "Titulo")
    private String title;

    @Column(name = "Descricao")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "Tipo")
    private TipoCampoFormularioEnum type;

    @Column(name = "Opcoes_Lista")
    private String listOption;

    @ManyToMany(
            mappedBy = "formFields",
            fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE,
            })
    @JsonIgnore
    private Set<Form> forms = new HashSet<>();

    @OneToMany(mappedBy = "formField", fetch = FetchType.LAZY, cascade = {
            CascadeType.MERGE,
    })
    private Set<FormKey> formKeys = new HashSet<>();

    @OneToMany(mappedBy = "formField", fetch = FetchType.LAZY, cascade = {
            CascadeType.MERGE,
    })
    private Set<FormValue> formValues = new HashSet<>();

    public Set<FormValue> getFormValues() {
        return formValues;
    }

    public void setFormValues(Set<FormValue> formValues) {
        this.formValues = formValues;
    }

    public Set<FormKey> getFormKeys() {
        return formKeys;
    }

    public void setFormKeys(Set<FormKey> formKeys) {
        this.formKeys = formKeys;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TipoCampoFormularioEnum getType() {
        return type;
    }

    public void setType(TipoCampoFormularioEnum type) {
        this.type = type;
    }

    public String getListOption() {
        return listOption;
    }

    public void setListOption(String listOption) {
        this.listOption = listOption;
    }

    public Set<Form> getForms() {
        return forms;
    }

    public void setForms(Set<Form> forms) {
        this.forms = forms;
    }
}

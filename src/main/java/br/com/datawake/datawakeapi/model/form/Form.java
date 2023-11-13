package br.com.datawake.datawakeapi.model.form;

import br.com.datawake.datawakeapi.common.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Formulario")
@Where(clause = "Deletado_Em IS NULL")
public class Form extends BaseModel {
    @Column(name = "Codigo")
    private String code;

    @Column(name = "Descricao")
    private String description;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
    })
    @JoinTable(
            name = "Formulario_Campo_Formulario",
            joinColumns = { @JoinColumn(name = "Id_Formulario") },
            inverseJoinColumns = { @JoinColumn(name = "Id_Campo_Formulario") }
    )
    private Set<FormField> formFields = new HashSet<>();

    @OneToMany(mappedBy = "form", cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
    })
    private Set<FormKey> formKeys = new HashSet<>();

    @OneToMany(mappedBy = "form", cascade = {
            CascadeType.PERSIST,
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<FormField> getFormFields() {
        return formFields;
    }

    public void setFormFields(Set<FormField> formFields) {
        this.formFields = formFields;
    }

    public void addFormField(FormField formField) {
        this.formFields.add(formField);
        formField.getForms().add(this);
    }

    public void removeFormField(Long formFieldId){
        FormField formField = this.formFields.stream().filter(t -> t.getId().equals(formFieldId)).findFirst().orElse(null);
        if (formField != null) {
            this.formFields.remove(formField);
            formField.getForms().remove(this);
        }
    }
}

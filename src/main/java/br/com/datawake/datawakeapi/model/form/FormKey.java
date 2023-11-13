package br.com.datawake.datawakeapi.model.form;

import br.com.datawake.datawakeapi.common.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Chave_Formulario")
@Where(clause = "Deletado_Em IS NULL")
public class FormKey extends BaseModel {

    @Column(name = "Rotulo")
    private String label;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Formulario")
    private Form form;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Campo_Formulario")
    private FormField formField;

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public FormField getFormField() {
        return formField;
    }

    public void setFormField(FormField formField) {
        this.formField = formField;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}

package br.com.datawake.datawakeapi.model.form;

import br.com.datawake.datawakeapi.common.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Valor_Formulario")
@Where(clause = "Deletado_Em IS NULL")
public class FormValue extends BaseModel {

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Formulario")
    private Form form;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Campo_Formulario")
    private FormField formField;

    @Column(name = "Valor_Texto")
    private String valueString;

    @Column(name = "Valor_Numero")
    private Float valueNumber;

    @Column(name = "Valor_Data")
    private LocalDate valueDate;

    @Column(name = "Valor_Hora")
    private LocalTime valueTime;

    @Column(name = "Valor_Lista")
    private String valueList;

    @Column(name = "Chave_Registro")
    private String recordAccessKey;

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

    public String getValueString() {
        return valueString;
    }

    public void setValueString(String valueString) {
        this.valueString = valueString;
    }

    public Float getValueNumber() {
        return valueNumber;
    }

    public void setValueNumber(Float valueNumber) {
        this.valueNumber = valueNumber;
    }

    public LocalDate getValueDate() {
        return valueDate;
    }

    public void setValueDate(LocalDate valueDate) {
        this.valueDate = valueDate;
    }

    public LocalTime getValueTime() {
        return valueTime;
    }

    public void setValueTime(LocalTime valueTime) {
        this.valueTime = valueTime;
    }

    public String getValueList() {
        return valueList;
    }

    public void setValueList(String valueList) {
        this.valueList = valueList;
    }

    public String getRecordAccessKey() {
        return recordAccessKey;
    }

    public void setRecordAccessKey(String recordAccessKey) {
        this.recordAccessKey = recordAccessKey;
    }
}

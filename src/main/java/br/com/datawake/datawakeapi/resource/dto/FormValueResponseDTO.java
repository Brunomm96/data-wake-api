package br.com.datawake.datawakeapi.resource.dto;

import br.com.datawake.datawakeapi.common.dto.BaseModelDTO;
import br.com.datawake.datawakeapi.model.form.Form;
import br.com.datawake.datawakeapi.model.form.FormField;
import br.com.datawake.datawakeapi.model.form.FormValue;

import java.time.LocalDate;
import java.time.LocalTime;

public class FormValueResponseDTO extends BaseModelDTO {
    public FormValueResponseDTO(FormValue formValue) {
        super(formValue);

        this.valueString = formValue.getValueString();
        this.valueNumber = formValue.getValueNumber();
        this.valueDate =  formValue.getValueDate();
        this.valueTime =  formValue.getValueTime();
        this.valueList =  formValue.getValueList();
        this.recordAccessKey =  formValue.getRecordAccessKey();
    }

    private String valueString;

    private Float valueNumber;

    private LocalDate valueDate;

    private LocalTime valueTime;

    private String valueList;

    private String recordAccessKey;

    private FormResponseDTO form;

    private FormFieldResponseDTO formField;

    private void fillChildren(Form form, FormField formField){
        fillForm(form);
        fillFormField(formField);
    }

    private void fillChildren(FormValue formValue){
        fillChildren(formValue.getForm(), formValue.getFormField());
    }

    private void fillForm(Form form){
        this.form = FormResponseDTO.createWithoutChildren(form);
    }

    private void fillFormField(FormField formField){
        this.formField = FormFieldResponseDTO.createWithoutChildren(formField);
    }

    public static FormValueResponseDTO createWithoutChildren(FormValue formValue){
        return new FormValueResponseDTO(formValue);
    }

    public static FormValueResponseDTO createWithChildren(FormValue formValue){
        FormValueResponseDTO formValueResponseDto = new FormValueResponseDTO(formValue);

        formValueResponseDto.fillChildren(formValue);

        return formValueResponseDto;
    }

//    GETTERS AND SETTERS

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

    public FormResponseDTO getForm() {
        return form;
    }

    public void setForm(FormResponseDTO form) {
        this.form = form;
    }

    public FormFieldResponseDTO getFormField() {
        return formField;
    }

    public void setFormField(FormFieldResponseDTO formField) {
        this.formField = formField;
    }
}

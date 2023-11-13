package br.com.datawake.datawakeapi.resource.dto;

import br.com.datawake.datawakeapi.common.dto.BaseModelDTO;
import br.com.datawake.datawakeapi.model.form.Form;
import br.com.datawake.datawakeapi.model.form.FormField;
import br.com.datawake.datawakeapi.model.form.FormKey;
import br.com.datawake.datawakeapi.model.form.FormValue;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FormResponseDTO extends BaseModelDTO {
    public FormResponseDTO(Form form) {
        super(form);

        this.code = form.getCode();
        this.description = form.getDescription();
    }

    private String code;

    private String description;

    private Set<FormFieldResponseDTO> formFields = new HashSet<>();

    private Set<FormKeyResponseDTO> formKeys  = new HashSet<>();

    private Set<FormValueResponseDTO> formValues  = new HashSet<>();

    public void fillChildren(Set<FormField> formFields, Set<FormKey> formKeys, Set<FormValue> formValues){
        fillFormFields(formFields);
        fillFormKeys(formKeys);
        fillFormValues(formValues);
    }

    public void fillChildren(Form form){
        fillChildren(form.getFormFields(), form.getFormKeys(), form.getFormValues());
    }

    public void fillFormFields(Set<FormField> formFields) {
        this.formFields = formFields.stream().map(
                FormFieldResponseDTO::createWithoutChildren
        ).collect(Collectors.toSet());
    }

    public void fillFormKeys(Set<FormKey> formKeys) {
        this.formKeys = formKeys.stream().map(
                FormKeyResponseDTO::createWithoutChildren
        ).collect(Collectors.toSet());
    }

    public void fillFormValues(Set<FormValue> formValues) {
        this.formValues = formValues.stream().map(
                FormValueResponseDTO::createWithoutChildren
        ).collect(Collectors.toSet());
    }

    public static FormResponseDTO createWithoutChildren(Form form){
        return new FormResponseDTO(form);
    }

    public static FormResponseDTO createWithChildren(Form form){
        FormResponseDTO formResponseDto = new FormResponseDTO(form);

        formResponseDto.fillChildren(form);

        return formResponseDto;
    }

//    GETTERS AND SETTERS

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

    public Set<FormFieldResponseDTO> getFormFields() {
        return formFields;
    }

    public void setFormFields(Set<FormFieldResponseDTO> formFields) {
        this.formFields = formFields;
    }

    public Set<FormKeyResponseDTO> getFormKeys() {
        return formKeys;
    }

    public void setFormKeys(Set<FormKeyResponseDTO> formKeys) {
        this.formKeys = formKeys;
    }

    public Set<FormValueResponseDTO> getFormValues() {
        return formValues;
    }

    public void setFormValues(Set<FormValueResponseDTO> formValues) {
        this.formValues = formValues;
    }
}

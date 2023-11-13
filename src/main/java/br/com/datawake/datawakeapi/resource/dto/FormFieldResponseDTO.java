package br.com.datawake.datawakeapi.resource.dto;

import br.com.datawake.datawakeapi.common.dto.BaseModelDTO;
import br.com.datawake.datawakeapi.model.enums.TipoCampoFormularioEnum;
import br.com.datawake.datawakeapi.model.form.Form;
import br.com.datawake.datawakeapi.model.form.FormField;
import br.com.datawake.datawakeapi.model.form.FormKey;
import br.com.datawake.datawakeapi.model.form.FormValue;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FormFieldResponseDTO extends BaseModelDTO {
    public FormFieldResponseDTO(FormField formField) {
        super(formField);

        this.attribute = formField.getAttribute();
        this.title = formField.getTitle();
        this.description = formField.getDescription();
        this.type = formField.getType();
        this.listOption = formField.getListOption();
    }
    private String attribute;

    private String title;

    private String description;

    private TipoCampoFormularioEnum type;

    private String listOption;

    private Set<FormResponseDTO> forms = new HashSet<>();

    private Set<FormKeyResponseDTO> formKeys = new HashSet<>();

    private Set<FormValueResponseDTO> formValues = new HashSet<>();

    public void fillChildren(Set<Form> forms, Set<FormKey> formKeys, Set<FormValue> formValues){
        fillForm(forms);
        fillFormKeys(formKeys);
        fillFormValues(formValues);
    }

    public void fillChildren(FormField form){
        fillChildren(form.getForms(), form.getFormKeys(), form.getFormValues());
    }

    public void fillForm(Set<Form> forms) {
        this.forms = forms.stream().map(
                FormResponseDTO::createWithoutChildren
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

    public static FormFieldResponseDTO createWithoutChildren(FormField formField){
        return new FormFieldResponseDTO(formField);
    }

    public static FormFieldResponseDTO createWithChildren(FormField formField){
        FormFieldResponseDTO formFieldDto = new FormFieldResponseDTO(formField);

        formFieldDto.fillChildren(formField);

        return formFieldDto;
    }

//    GETTERS AND SETTERS

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

    public Set<FormResponseDTO> getForms() {
        return forms;
    }

    public void setForms(Set<FormResponseDTO> forms) {
        this.forms = forms;
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
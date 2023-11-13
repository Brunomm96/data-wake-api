package br.com.datawake.datawakeapi.resource.dto;

import br.com.datawake.datawakeapi.model.form.FormField;

public class FormFieldRequestDTO {
    public FormFieldRequestDTO(Iterable<FormField> formFields) {
        this.formFields = formFields;
    }

    public Iterable<FormField> getFormFields() {
        return formFields;
    }

    public void setFormFields(Iterable<FormField> formFields) {
        this.formFields = formFields;
    }

    private Iterable<FormField> formFields;
}

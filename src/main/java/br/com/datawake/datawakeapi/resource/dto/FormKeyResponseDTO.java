package br.com.datawake.datawakeapi.resource.dto;

import br.com.datawake.datawakeapi.common.dto.BaseModelDTO;
import br.com.datawake.datawakeapi.model.form.Form;
import br.com.datawake.datawakeapi.model.form.FormField;
import br.com.datawake.datawakeapi.model.form.FormKey;

public class FormKeyResponseDTO extends BaseModelDTO {
    public FormKeyResponseDTO(FormKey formKey) {
        super(formKey);
    }

    private FormResponseDTO form;

    private FormFieldResponseDTO formField;

    private void fillChildren(Form form, FormField formField){
        fillForm(form);
        fillFormField(formField);
    }

    private void fillChildren(FormKey formKey){
        fillChildren(formKey.getForm(), formKey.getFormField());
    }

    private void fillForm(Form form){
        this.form = FormResponseDTO.createWithoutChildren(form);
    }

    private void fillFormField(FormField formField){
        this.formField = FormFieldResponseDTO.createWithoutChildren(formField);
    }

    public static FormKeyResponseDTO createWithoutChildren(FormKey formKey){
        FormKeyResponseDTO formKeyResponseDto = new FormKeyResponseDTO(formKey);

        formKeyResponseDto.fillChildren(formKey);

        return formKeyResponseDto;
    }

    public static FormKeyResponseDTO createWithChildren(FormKey formKey){
        return createWithoutChildren(formKey);
    }

//    GETTERS AND SETTERS

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

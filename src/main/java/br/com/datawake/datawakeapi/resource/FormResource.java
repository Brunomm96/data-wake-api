package br.com.datawake.datawakeapi.resource;

import br.com.datawake.datawakeapi.common.resource.BaseResource;
import br.com.datawake.datawakeapi.model.form.Form;
import br.com.datawake.datawakeapi.model.form.FormField;
import br.com.datawake.datawakeapi.model.form.FormKey;
import br.com.datawake.datawakeapi.resource.dto.FormFieldRequestDTO;
import br.com.datawake.datawakeapi.resource.dto.FormResponseDTO;
import br.com.datawake.datawakeapi.resource.exception.PageSizeOutOfBoundsException;
import br.com.datawake.datawakeapi.service.FormService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController()
@RequestMapping("/api/v1/forms")
public class FormResource extends BaseResource<Form, FormService> {

    public FormResource(FormService service, ObjectMapper objectMapper) {
        super(service, objectMapper);
    }

    @Override
    @GetMapping()
    public ResponseEntity<Page<?>> GetAll(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        if (size < 1 || size > 50) throw new PageSizeOutOfBoundsException();

        Pageable pageable = PageRequest.of(page, size);
        Page<FormResponseDTO> response = service.getAll(pageable).map(FormResponseDTO::createWithChildren);
        return ResponseEntity.ok().body(response);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> GetById(
            @PathVariable Long id
    ) {
        Form entity = service.get(id);

        return ResponseEntity.ok(FormResponseDTO.createWithChildren(entity));
    }

    @Override
    @PostMapping()
    public ResponseEntity<Form> Post(
            @RequestBody Form body
    ){
        Form form = service.save(body);

        return ResponseEntity.ok(form);
    }

    @PostMapping("/fields")
    public ResponseEntity<FormFieldRequestDTO> PostFields(
            @RequestBody FormFieldRequestDTO body
            ){
        return ResponseEntity.ok().build();
    }

    private void saveFormFields(Iterable<FormField> formFields, Form form){
        formFields.forEach(formField -> saveFormField(formField, form));
    }

    private void saveFormField(FormField formField, Form form){
        Set<Form> forms = formField.getForms();
        forms.add(form);

        formField.setForms(forms);
        service.saveField(formField);
    }

    private void saveFormKeys(Iterable<FormKey> formKeys, Form form){
        formKeys.forEach(formKey -> saveFormKey(formKey, form));
    }

    private void saveFormKey(FormKey formKey, Form form){
        formKey.setForm(form);
        service.saveKey(formKey);
    }
}

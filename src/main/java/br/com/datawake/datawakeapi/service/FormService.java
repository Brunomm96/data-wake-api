package br.com.datawake.datawakeapi.service;

import br.com.datawake.datawakeapi.common.service.BaseService;
import br.com.datawake.datawakeapi.model.form.Form;
import br.com.datawake.datawakeapi.model.form.FormField;
import br.com.datawake.datawakeapi.model.form.FormKey;
import br.com.datawake.datawakeapi.model.form.FormValue;
import br.com.datawake.datawakeapi.repository.form.FormFieldsRepository;
import br.com.datawake.datawakeapi.repository.form.FormKeysRepository;
import br.com.datawake.datawakeapi.repository.form.FormValuesRepository;
import br.com.datawake.datawakeapi.repository.form.FormsRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FormService extends BaseService<Form> {

    private final FormFieldsRepository formFieldsRepository;

    private final FormValuesRepository formValuesRepository;

    private final FormKeysRepository formKeysRepository;

    public FormService(
            FormsRepository formsRepository,
            FormFieldsRepository formFieldsRepository,
            FormValuesRepository formValuesRepository,
            FormKeysRepository formKeysRepository
    ) {
        super(formsRepository);
        this.formFieldsRepository = formFieldsRepository;
        this.formValuesRepository = formValuesRepository;
        this.formKeysRepository = formKeysRepository;
    }


    @Transactional
    public void saveField(FormField field){
        this.customSave(field, formFieldsRepository);
    }

    @Transactional
    public void saveFields(Iterable<FormField> fields){
        this.customSaveAll(fields, formFieldsRepository);
    }

    @Transactional
    public void saveKey(FormKey key){
        this.customSave(key, formKeysRepository);
    }

    @Transactional
    public void saveKeys(Iterable<FormKey> keys){
        this.customSaveAll(keys, formKeysRepository);
    }

    @Transactional
    public void saveValue(FormValue value){
        this.customSave(value, formValuesRepository);
    }

    @Transactional
    public void saveValues(Iterable<FormValue> values){
        this.customSaveAll(values, formValuesRepository);
    }

    @Transactional
    public void deleteField(Long id){
        this.customDelete(id, formFieldsRepository);
    }

    @Transactional
    public void deleteKey(Long id){
        this.customDelete(id, formKeysRepository);
    }

    @Transactional
    public void deleteValue(Long id){
        this.customDelete(id, formValuesRepository);
    }
}

package br.com.datawake.datawakeapi.common.service;

import br.com.datawake.datawakeapi.common.model.BaseModel;
import br.com.datawake.datawakeapi.common.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.util.List;

public abstract class BaseService<T extends BaseModel> {
    protected final BaseRepository<T> repository;

    public BaseService(BaseRepository<T> baseRepository) {
        this.repository = baseRepository;
    }

    @Transactional
    public T save(T model){
        return repository.save(model);
    }

    @Transactional
    public List<T> saveAll(Iterable<T> iterable){
        return repository.saveAll(iterable);
    }

    @Transactional
    protected <U extends BaseModel> U customSave(U model, BaseRepository<U> customRepository){
        return customRepository.save(model);
    }

    @Transactional
    protected <U extends BaseModel> List<U> customSaveAll(Iterable<U> iterable, BaseRepository<U> customRepository){
        return customRepository.saveAll(iterable);
    }

    public T get(Long id){
        return repository.findById(id).orElse(null);
    }

    protected <U extends BaseModel> U customGet(Long id, BaseRepository<U> customRepository){
        return customRepository.getById(id);
    }

    public List<T> getAll(Iterable<Long> ids){
        return repository.findAllById(ids);
    }

    protected <U extends BaseModel> List<U> customGetAll(Iterable<Long> ids, BaseRepository<U> customRepository){
        return customRepository.findAllById(ids);
    }

    public Page<T> getAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    protected <U extends BaseModel> Page<U> customGetAll(Pageable pageable, BaseRepository<U> customRepository){
        return customRepository.findAll(pageable);
    }

    @Transactional
    public void delete(Long id){
        repository.deleteById(id);
    }

    @Transactional
    protected <U extends BaseModel> void customDelete(Long id, BaseRepository<U> customRepository){
        customRepository.deleteById(id);
    }
}

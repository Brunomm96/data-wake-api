package br.com.datawake.datawakeapi.common.resource;

import br.com.datawake.datawakeapi.common.model.BaseModel;
import br.com.datawake.datawakeapi.common.service.BaseService;
import br.com.datawake.datawakeapi.resource.exception.PageSizeOutOfBoundsException;
import br.com.datawake.datawakeapi.resource.exception.PutIdFromParameterIsDifferentFromBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class BaseResource<T extends BaseModel, Service extends BaseService<T>> {
    protected final Service service;

    protected final ObjectMapper objectMapper;

    public BaseResource(
            Service service,
            ObjectMapper objectMapper
    ) {
        this.service = service;
        this.objectMapper = objectMapper;
    }

    @GetMapping()
    public ResponseEntity<Page<?>> GetAll(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        if (size < 1 || size > 50) throw new PageSizeOutOfBoundsException();

        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok().body(service.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> GetById(
            @PathVariable Long id
    ) {
        T entity = service.get(id);

        return ResponseEntity.ok(entity);
    }

    @PostMapping()
    public ResponseEntity<?> Post(
            @RequestBody T body
    ) {
        T object = service.save(body);
        return ResponseEntity.ok(object);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> Put(
            @PathVariable Long id,
            @RequestBody T body
    ) throws PutIdFromParameterIsDifferentFromBody {
        T object = service.get(id);

        if (object == null)
            return ResponseEntity.notFound().build();

        if (!object.getId().equals(body.getId()))
            throw new PutIdFromParameterIsDifferentFromBody();

        object = objectMapper.convertValue(body, (Class<T>) object.getClass());

        T updatedObject = service.save(object);
        return ResponseEntity.ok(updatedObject);
    }

    @PutMapping("")
    public ResponseEntity<?> Put(
            @RequestBody T body
    ) throws PutIdFromParameterIsDifferentFromBody {
        T object = service.get(body.getId());

        if (object == null)
            return ResponseEntity.notFound().build();

        if (!object.getId().equals(body.getId()))
            throw new PutIdFromParameterIsDifferentFromBody();

        object = objectMapper.convertValue(body, (Class<T>) object.getClass());

        T updatedObject = service.save(object);
        return ResponseEntity.ok(updatedObject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> Delete(
            @PathVariable Long id
    ) {
        T object = service.get(id);

        if (object == null)
            return ResponseEntity.notFound().build();

        service.delete(id);

        return ResponseEntity.ok().build();
    }
}

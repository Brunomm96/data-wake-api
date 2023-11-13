package br.com.datawake.datawakeapi.common.repository;

import br.com.datawake.datawakeapi.common.model.BaseModel;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

@NoRepositoryBean
public interface BaseRepository<T extends BaseModel> extends JpaRepository<T, Long> {
    String MULTIPLE_DELETE_IS_NOT_SUPPORTED = "Multiple delete is not supported.";
    @Override
    default void deleteById(Long id) {
        Assert.notNull(id, "The given id must not be null!");

        this.delete(this.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(
                String.format("No %s entity with id %s exists!", "", id), 1)));
    }

    @Override
    default void delete(T entity) {
        Assert.notNull(entity, "The entity must not be null!");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        entity.setDeletedAt(LocalDateTime.now());
        entity.setDeletedBy(authentication.getName());

        save(entity);
    }

    @Override
    default void deleteAll(Iterable<? extends T> entities) {
        throw new UnsupportedOperationException(MULTIPLE_DELETE_IS_NOT_SUPPORTED);
    }

    @Override
    default void deleteAll() {
        throw new UnsupportedOperationException(MULTIPLE_DELETE_IS_NOT_SUPPORTED);
    }
}

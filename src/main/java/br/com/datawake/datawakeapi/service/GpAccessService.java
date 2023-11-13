package br.com.datawake.datawakeapi.service;

import br.com.datawake.datawakeapi.model.GpAccess;
import br.com.datawake.datawakeapi.repository.GpAccessRepository;
import br.com.datawake.datawakeapi.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class GpAccessService {

    @Autowired
    private GpAccessRepository gpAccessRepository;

    @Transactional
    public void save( GpAccess gpAccess ) {

        gpAccessRepository.save(gpAccess);
        return;
    }

    public Optional<GpAccess> getById(Long id) {
        return gpAccessRepository.findById(id);
    }

    public Page<GpAccess> findAll(Pageable pageable) {
        return gpAccessRepository.findAll(pageable);
    }

    public Optional<GpAccess> findById(Long id) {
        return gpAccessRepository.findById(id);
    }

    @Transactional
    public boolean delete(Long id) {
        Optional<GpAccess> gpAccess = gpAccessRepository.findById(id);

        if ( !gpAccess.isPresent() )
            throw new UserNotFoundException();
        gpAccessRepository.deleteById(id);

        return true;

    }
}

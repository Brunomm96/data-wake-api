package br.com.datawake.datawakeapi.service;

import br.com.datawake.datawakeapi.model.logApp;
import br.com.datawake.datawakeapi.repository.logAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class logAppService {

    @Autowired
    private logAppRepository LogAppRepository;

    
    @Transactional
    public void save( logApp LogApp ) {

        LogAppRepository.save(LogApp);

        return;

    }

    public Optional<logApp> getById(Long id) {
        return LogAppRepository.findById(id);
    }

    public Page<logApp> findAll(Pageable pageable) {
        return LogAppRepository.findAll(pageable);
    }

    public Optional<logApp> findById(Long id) {
        return LogAppRepository.findById(id);
    }

    @Transactional
    public void delete(logApp LogApp) {

        LogAppRepository.delete(LogApp);
    }
}

package br.com.datawake.datawakeapi.service;

import br.com.datawake.datawakeapi.model.FtpParadas;
import br.com.datawake.datawakeapi.repository.FtpParadasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class FtpParadaService {

    @Autowired
    private FtpParadasRepository ftpParadasRepository;

    
    @Transactional
    public void save( FtpParadas ftpParadas ) {

        ftpParadasRepository.save(ftpParadas);

        return;

    }

    public Optional<FtpParadas> getById(String idTag) {
        return ftpParadasRepository.findById(idTag);
    }

    public Page<FtpParadas> findAll(Pageable pageable) {
        return ftpParadasRepository.findAll(pageable);
    }

    public Optional<FtpParadas> findById(String idTag) {
        return ftpParadasRepository.findById(idTag);
    }

    @Transactional
    public void delete(FtpParadas ftpParadas) {

        ftpParadasRepository.delete(ftpParadas);
    }
}

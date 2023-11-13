package br.com.datawake.datawakeapi.service;

import br.com.datawake.datawakeapi.model.FtpAPQP;
import br.com.datawake.datawakeapi.repository.FtpAPQPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class FtpAPQPService {

    @Autowired
    private FtpAPQPRepository ftpAPQPRepository;

    @Transactional
    public void save(FtpAPQP ftpAPQP){

        ftpAPQPRepository.save(ftpAPQP);

        return;

    }

    public Optional<FtpAPQP> getById(Long idFtp) {return ftpAPQPRepository.findById(idFtp);}

    public Page<FtpAPQP> findAll(Pageable pageable) {return ftpAPQPRepository.findAll(pageable); }

    public Optional<FtpAPQP> findById(Long idFtp) { return ftpAPQPRepository.findById(idFtp);  }

    @Transactional
    public void delete(FtpAPQP ftpAPQP){
        ftpAPQPRepository.delete(ftpAPQP);
    }
}

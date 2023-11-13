package br.com.datawake.datawakeapi.service;


import br.com.datawake.datawakeapi.model.FtpPPAP;
import br.com.datawake.datawakeapi.repository.FtpPPAPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class FtpPPAPService {

    @Autowired
    private FtpPPAPRepository ftpPPAPRepository;

    @Transactional
    public void save(FtpPPAP ftpPPAP){

        ftpPPAPRepository.save(ftpPPAP);

        return;

    }

    public Optional<FtpPPAP> getById(Long idFtp) {return ftpPPAPRepository.findById(idFtp);}

    public Page<FtpPPAP> findAll(Pageable pageable) {return ftpPPAPRepository.findAll(pageable); }

    public Optional<FtpPPAP> findById(Long idFtp) { return ftpPPAPRepository.findById(idFtp);  }

    @Transactional
    public void delete(FtpPPAP ftpPPAP){
        ftpPPAPRepository.delete(ftpPPAP);
    }
}

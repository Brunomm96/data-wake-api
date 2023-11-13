package br.com.datawake.datawakeapi.service;

import br.com.datawake.datawakeapi.model.FtpAuditoriaEscalonadaDigital;
import br.com.datawake.datawakeapi.repository.FtpAuditoriaEscalonadaDigitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class FtpAuditoriaEscalonadaDigitalService {
    @Autowired
    private FtpAuditoriaEscalonadaDigitalRepository ftpAuditoriaEscalonadaDigitalRepository;

    @Transactional
    public void save ( FtpAuditoriaEscalonadaDigital ftpAuditoriaEscalonadaDigital ) {
        ftpAuditoriaEscalonadaDigitalRepository.save(ftpAuditoriaEscalonadaDigital);
        return;
    }
    public Optional<FtpAuditoriaEscalonadaDigital> getById(Long idFtp) {
        return ftpAuditoriaEscalonadaDigitalRepository.findById(idFtp);
    }
    public Page<FtpAuditoriaEscalonadaDigital> findAll(Pageable pageable) {
        return ftpAuditoriaEscalonadaDigitalRepository.findAll(pageable);
    }
    public Optional<FtpAuditoriaEscalonadaDigital> findById(Long idFtp) {
        return ftpAuditoriaEscalonadaDigitalRepository.findById(idFtp);
    }


    @Transactional
    public void delete(FtpAuditoriaEscalonadaDigital ftpAuditoriaEscalonadaDigital) {
        ftpAuditoriaEscalonadaDigitalRepository.delete(ftpAuditoriaEscalonadaDigital) ;
    }
}

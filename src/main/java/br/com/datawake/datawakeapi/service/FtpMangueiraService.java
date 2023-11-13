package br.com.datawake.datawakeapi.service;

import br.com.datawake.datawakeapi.model.FtpMangueiras;
import br.com.datawake.datawakeapi.repository.FtpMangueiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class FtpMangueiraService {

    @Autowired
    private FtpMangueiraRepository ftpMangueiraRepository;

    @Transactional
    public void save( FtpMangueiras ftpMangueiras ) {

        ftpMangueiraRepository.save(ftpMangueiras);


        return;

    }

    public Optional<FtpMangueiras> getById(Long idFtp) {
        return ftpMangueiraRepository.findById(idFtp);
    }

    public Page<FtpMangueiras> findAll(Pageable pageable) {
        return ftpMangueiraRepository.findAll(pageable);
    }

    public Optional<FtpMangueiras> findById(Long idFtp) {
        return ftpMangueiraRepository.findById(idFtp);
    }

    @Transactional
    public void delete(FtpMangueiras ftpMangueiras) {

        ftpMangueiraRepository.delete(ftpMangueiras);
    }
}

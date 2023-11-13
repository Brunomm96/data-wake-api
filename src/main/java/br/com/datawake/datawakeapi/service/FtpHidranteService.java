package br.com.datawake.datawakeapi.service;

import br.com.datawake.datawakeapi.model.FtpHidrante;
import br.com.datawake.datawakeapi.repository.FtpHidranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class FtpHidranteService {

    @Autowired
    private FtpHidranteRepository ftpHidranteRepository;

    @Transactional
    public void save(FtpHidrante ftpHidrante){

        ftpHidranteRepository.save(ftpHidrante);

        return;
    }

    public Optional<FtpHidrante> getById(Long idFtp) {return ftpHidranteRepository.findById(idFtp);}
    public Page<FtpHidrante> findAll(Pageable pageable) {return ftpHidranteRepository.findAll(pageable);}
    public Optional<FtpHidrante> findById(Long idFtp) {return  ftpHidranteRepository.findById(idFtp);}

    @Transactional
    public void delete(FtpHidrante ftpHidrante) { ftpHidranteRepository.delete(ftpHidrante);}
}

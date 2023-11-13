package br.com.datawake.datawakeapi.service;

import br.com.datawake.datawakeapi.model.FtpLabFisico;
import br.com.datawake.datawakeapi.repository.FtpLabFisicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class FtpLabFisicoService {

    @Autowired
    private FtpLabFisicoRepository ftpLabFisicoRepository;

    @Transactional
    public void save(FtpLabFisico ftpLabFisico){

        ftpLabFisicoRepository.save(ftpLabFisico);

        return;

    }

    public Optional<FtpLabFisico> getById(Long idFtp) {return ftpLabFisicoRepository.findById(idFtp);}

    public Page<FtpLabFisico> findAll(Pageable pageable) {return ftpLabFisicoRepository.findAll(pageable); }

    public Optional<FtpLabFisico> findById(Long idFtp) {return ftpLabFisicoRepository.findById(idFtp);  }

    @Transactional
    public void delete(FtpLabFisico ftpLabFisico){
        ftpLabFisicoRepository.delete(ftpLabFisico);
    }
}

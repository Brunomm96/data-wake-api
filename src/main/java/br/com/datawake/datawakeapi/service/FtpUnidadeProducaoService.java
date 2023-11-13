package br.com.datawake.datawakeapi.service;

import br.com.datawake.datawakeapi.model.FtpUnidadeProducao;
import br.com.datawake.datawakeapi.repository.FtpUnidadeProducaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class FtpUnidadeProducaoService {

    @Autowired
    private FtpUnidadeProducaoRepository ftpUnidadeProducaoRepository;

    @Transactional
    public void save( FtpUnidadeProducao ftpUnidadeProducao ) {

        ftpUnidadeProducaoRepository.save(ftpUnidadeProducao);


        return;

    }

    public Optional<FtpUnidadeProducao> getById(Long id) {
        return ftpUnidadeProducaoRepository.findById(id);
    }

    public Page<FtpUnidadeProducao> findAll(Pageable pageable) {
        return ftpUnidadeProducaoRepository.findAll(pageable);
    }

    public Optional<FtpUnidadeProducao> findById(Long id) {
        return ftpUnidadeProducaoRepository.findById(id);
    }

    @Transactional
    public void delete(FtpUnidadeProducao ftpUnidadeProducao) {

        ftpUnidadeProducaoRepository.delete(ftpUnidadeProducao);
    }
}

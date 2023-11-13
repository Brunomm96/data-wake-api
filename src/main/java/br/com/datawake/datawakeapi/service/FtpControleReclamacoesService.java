package br.com.datawake.datawakeapi.service;

import br.com.datawake.datawakeapi.model.FtpControleReclamacoes;
import br.com.datawake.datawakeapi.repository.FtpControleReclamacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class FtpControleReclamacoesService {

    @Autowired
    private FtpControleReclamacoesRepository ftpControleReclamacoesRepository;

    @Transactional
    public void save(FtpControleReclamacoes ftpControleReclamacoes){

        ftpControleReclamacoesRepository.save(ftpControleReclamacoes);

        return;
    }

    public Optional<FtpControleReclamacoes> getById(String idTag) {return ftpControleReclamacoesRepository.findById(idTag);}

    public Page<FtpControleReclamacoes> findAll(Pageable pageable) {return ftpControleReclamacoesRepository.findAll(pageable); }

    public Optional<FtpControleReclamacoes> findById(String idTag) { return ftpControleReclamacoesRepository.findById(idTag);  }

    @Transactional
    public void delete(FtpControleReclamacoes ftpControleReclamacoes){ftpControleReclamacoesRepository.delete(ftpControleReclamacoes);}
}




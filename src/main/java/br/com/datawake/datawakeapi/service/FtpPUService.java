package br.com.datawake.datawakeapi.service;

import br.com.datawake.datawakeapi.model.FtpPu;
import br.com.datawake.datawakeapi.repository.FtpPURepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class FtpPUService {

    @Autowired
    private FtpPURepository ftpPURepository;

    
    @Transactional
    public void save( FtpPu ftpPu ) {

        ftpPURepository.save(ftpPu);

        return;

    }

    public Optional<FtpPu> getById(String idTag) {
        return ftpPURepository.findById(idTag);
    }

    public Page<FtpPu> findAll(Pageable pageable) {
        return ftpPURepository.findAll(pageable);
    }

    public Optional<FtpPu> findById(String idTag) {
        return ftpPURepository.findById(idTag);
    }

    @Transactional
    public void delete(FtpPu ftpPu) {

        ftpPURepository.delete(ftpPu);
    }
}

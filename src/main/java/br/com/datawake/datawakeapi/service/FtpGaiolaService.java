package br.com.datawake.datawakeapi.service;

import br.com.datawake.datawakeapi.model.FtpGaiolas;
import br.com.datawake.datawakeapi.model.FtpComposto;
import br.com.datawake.datawakeapi.repository.FtpGaiolaRepository;
import br.com.datawake.datawakeapi.repository.FtpCompostoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class FtpGaiolaService {

    @Autowired
    private FtpGaiolaRepository ftpGaiolaRepository;

    @Autowired
    private FtpCompostoRepository ftpCompostoRepository;
    @Transactional
    public void save( FtpGaiolas ftpGaiolas ) {
        FtpComposto ftpComposto = new FtpComposto();

        ftpComposto.setTagGaiola(ftpGaiolas.getTag());
        ftpComposto.setTaraGaiola(ftpGaiolas.getTara());


        ftpGaiolaRepository.save(ftpGaiolas);

        if ( ftpComposto != null && ftpComposto.getTagGaiola() != null ) {
            ftpComposto.setTagGaiola(ftpGaiolas.getTag());
            ftpGaiolas.setFtpComposto(ftpComposto);
            ftpGaiolaRepository.save(ftpGaiolas);
        }
        return;

    }

    public Optional<FtpGaiolas> getById(String idTag) {
        return ftpGaiolaRepository.findById(idTag);
    }

    public Page<FtpGaiolas> findAll(Pageable pageable) {
        return ftpGaiolaRepository.findAll(pageable);
    }

    public Optional<FtpGaiolas> findById(String idTag) {
        return ftpGaiolaRepository.findById(idTag);
    }

    @Transactional
    public void delete(FtpGaiolas ftpGaiolas) {

        if ( ftpGaiolas.getFtpComposto() != null ) {
            ftpCompostoRepository.delete(ftpGaiolas.getFtpComposto());
        }
        ftpGaiolaRepository.delete(ftpGaiolas);
    }
}

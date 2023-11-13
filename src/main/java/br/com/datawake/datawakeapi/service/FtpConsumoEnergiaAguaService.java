package br.com.datawake.datawakeapi.service;

import br.com.datawake.datawakeapi.model.FtpConsumoEnergiaAgua;
import br.com.datawake.datawakeapi.repository.FtpConsumoEnergiaAguaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class FtpConsumoEnergiaAguaService {
    @Autowired
    private FtpConsumoEnergiaAguaRepository ftpConsumoEnergiaAguaRepository;

    @Transactional
    public void save ( FtpConsumoEnergiaAgua ftpConsumoEnergiaAgua ) {
        ftpConsumoEnergiaAguaRepository.save(ftpConsumoEnergiaAgua);
        return;
    }
    public Optional<FtpConsumoEnergiaAgua> getById(Long idFtp) {
        return ftpConsumoEnergiaAguaRepository.findById(idFtp);
    }
    public Page<FtpConsumoEnergiaAgua> findAll(Pageable pageable) {
        return ftpConsumoEnergiaAguaRepository.findAll(pageable);
    }
    public Optional<FtpConsumoEnergiaAgua> findById(Long idFtp) {
        return ftpConsumoEnergiaAguaRepository.findById(idFtp);
    }


    @Transactional
    public void delete(FtpConsumoEnergiaAgua ftpConsumoEnergiaAgua) {
            ftpConsumoEnergiaAguaRepository.delete(ftpConsumoEnergiaAgua) ;
    }
}

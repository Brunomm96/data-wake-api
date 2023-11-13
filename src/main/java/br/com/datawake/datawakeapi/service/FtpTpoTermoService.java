package br.com.datawake.datawakeapi.service;

import br.com.datawake.datawakeapi.model.FtpTpoTermo;
import br.com.datawake.datawakeapi.model.TemposCiclo;
import br.com.datawake.datawakeapi.repository.FtpTpoTermoRepository;
import br.com.datawake.datawakeapi.repository.TemposCicloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class FtpTpoTermoService {

    @Autowired
    private FtpTpoTermoRepository ftpTpoTermoRepository;

    @Autowired
    private TemposCicloRepository temposCicloRepository;

    @Transactional
    public void save( FtpTpoTermo ftpTpoTermo ) {

        TemposCiclo temposCiclo = null;

        if ( ftpTpoTermo.getTemposCiclo() != null && ftpTpoTermo.getTemposCiclo().getId() == null ) {
            try {
                temposCiclo = (TemposCiclo) ftpTpoTermo.getTemposCiclo().clone();
                ftpTpoTermo.setTemposCiclo(null);
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        ftpTpoTermoRepository.save(ftpTpoTermo);

        if ( temposCiclo != null && ftpTpoTermo.getId() != null ) {
            temposCiclo.setId(ftpTpoTermo.getId());
            ftpTpoTermo.setTemposCiclo(temposCiclo);
            ftpTpoTermoRepository.save(ftpTpoTermo);
        }

        return;

    }

    public Optional<FtpTpoTermo> getById(Long idFtp) {
        return ftpTpoTermoRepository.findById(idFtp);
    }

    public Page<FtpTpoTermo> findAll(Pageable pageable) {
        return ftpTpoTermoRepository.findAll(pageable);
    }

    public Optional<FtpTpoTermo> findById(Long idFtp) {
        return ftpTpoTermoRepository.findById(idFtp);
    }

    @Transactional
    public void delete(FtpTpoTermo ftpTpoTermo) {

        if ( ftpTpoTermo.getTemposCiclo() != null )
            temposCicloRepository.delete(ftpTpoTermo.getTemposCiclo());

        ftpTpoTermoRepository.delete(ftpTpoTermo);
    }
}

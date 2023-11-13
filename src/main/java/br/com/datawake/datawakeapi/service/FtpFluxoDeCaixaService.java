package br.com.datawake.datawakeapi.service;

import br.com.datawake.datawakeapi.model.FtpFluxoDeCaixa;
import br.com.datawake.datawakeapi.repository.FtpFluxoDeCaixasRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class FtpFluxoDeCaixaService {

    public FtpFluxoDeCaixaService(FtpFluxoDeCaixasRepository repository) {
        this.repository = repository;
    }

    private final FtpFluxoDeCaixasRepository repository;

    @Transactional
    public void save( FtpFluxoDeCaixa ftpFluxoDeCaixa ) {

        repository.save(ftpFluxoDeCaixa);


        return;

    }

    public Optional<FtpFluxoDeCaixa> getById(Long idFtp) {
        return repository.findById(idFtp);
    }

    public Page<FtpFluxoDeCaixa> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Optional<FtpFluxoDeCaixa> findById(Long idFtp) {
        return repository.findById(idFtp);
    }

    @Transactional
    public void delete(FtpFluxoDeCaixa ftpFluxoDeCaixa) {

        repository.delete(ftpFluxoDeCaixa);
    }

}

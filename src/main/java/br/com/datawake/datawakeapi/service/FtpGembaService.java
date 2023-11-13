package br.com.datawake.datawakeapi.service;

import br.com.datawake.datawakeapi.common.service.BaseService;
import br.com.datawake.datawakeapi.model.FtpGemba;
import br.com.datawake.datawakeapi.repository.FtpGembaRepository;
import org.springframework.stereotype.Service;

@Service
public class FtpGembaService extends BaseService<FtpGemba> {
    public FtpGembaService(FtpGembaRepository ftpGembaRepository) {
        super(ftpGembaRepository);
    }
}

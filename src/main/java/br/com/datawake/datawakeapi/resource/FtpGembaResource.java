package br.com.datawake.datawakeapi.resource;

import br.com.datawake.datawakeapi.common.resource.BaseResource;
import br.com.datawake.datawakeapi.model.FtpGemba;
import br.com.datawake.datawakeapi.service.FtpGembaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/v1/ftpgemba")
public class FtpGembaResource extends BaseResource<FtpGemba, FtpGembaService> {
    public FtpGembaResource(FtpGembaService service, ObjectMapper objectMapper) {
        super(service, objectMapper);
    }
}

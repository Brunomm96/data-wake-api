package br.com.datawake.datawakeapi.resource;

import br.com.datawake.datawakeapi.service.protheus.ProtheusService;
import br.com.datawake.datawakeapi.service.protheus.dto.ProtheusSavDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/protheus")
public class ProtheusResource {
    private final ProtheusService protheusService;

    public ProtheusResource(ProtheusService protheusService) {
        this.protheusService = protheusService;
    }

    @GetMapping("/getSAV/{id}")
    public ResponseEntity<ProtheusSavDTO> getSav(@PathVariable String id){
        ProtheusSavDTO savDTO = protheusService.getSav(id);

        if (savDTO == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(savDTO);
    }
}

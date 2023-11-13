package br.com.datawake.datawakeapi.resource;

import br.com.datawake.datawakeapi.event.ResourceCreatedEvent;
import br.com.datawake.datawakeapi.model.FtpAuditoriaEscalonadaDigital;
import br.com.datawake.datawakeapi.repository.FtpAuditoriaEscalonadaDigitalRepository;
import br.com.datawake.datawakeapi.service.FtpAuditoriaEscalonadaDigitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@RestController
@RequestMapping ("/api/v1")

public class FtpAuditoriaEscalonadaDigitalResource {
    @Autowired
    private FtpAuditoriaEscalonadaDigitalService ftpAuditoriaEscalonadaDigitalService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping ( path = " /ftp_auditoria_escalonada_digital/{idFtp}" )
    public ResponseEntity<FtpAuditoriaEscalonadaDigital> byIdFtp(@PathVariable Long idFtp){

        ResponseEntity<FtpAuditoriaEscalonadaDigital> responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        Optional<FtpAuditoriaEscalonadaDigital> optionalFtpAuditoriaEscalonadaDigital = ftpAuditoriaEscalonadaDigitalService.getById(idFtp);

        if(optionalFtpAuditoriaEscalonadaDigital.isPresent()){
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body((FtpAuditoriaEscalonadaDigital) optionalFtpAuditoriaEscalonadaDigital.get());
        }

        return responseResponseEntity;
    }

    @GetMapping( path = "/ftp_auditoria_escalonada_digital" )
    public ResponseEntity<Page<FtpAuditoriaEscalonadaDigital>> all(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body((Page<FtpAuditoriaEscalonadaDigital>) ftpAuditoriaEscalonadaDigitalService.findAll(pageable));
    }
    @PostMapping(path = "/ftp_auditoria_escalonada_digital")
    public ResponseEntity<FtpAuditoriaEscalonadaDigital> create (@RequestBody FtpAuditoriaEscalonadaDigital ftpAuditoriaEscalonadaDigital, HttpServletResponse response){

        ResponseEntity<FtpAuditoriaEscalonadaDigital> responseResponseEntity;
        ftpAuditoriaEscalonadaDigital.setId(null);
        ftpAuditoriaEscalonadaDigitalService.save(ftpAuditoriaEscalonadaDigital);
        if (ftpAuditoriaEscalonadaDigital != null && ftpAuditoriaEscalonadaDigital.getId() != null) {

            publisher.publishEvent(new ResourceCreatedEvent(this, response, ftpAuditoriaEscalonadaDigital.getId()));
            responseResponseEntity = ResponseEntity.status(HttpStatus.CREATED).body(ftpAuditoriaEscalonadaDigital);

        } else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ftpAuditoriaEscalonadaDigital);

        }
        return responseResponseEntity;
    }
    @PutMapping(path = "/ftp_auditoria_escalonada_digital")
    public ResponseEntity<FtpAuditoriaEscalonadaDigital> update(@RequestBody FtpAuditoriaEscalonadaDigital ftpAuditoriaEscalonadaDigital, HttpServletResponse response){
        ResponseEntity<FtpAuditoriaEscalonadaDigital> responseResponseEntity;

        if (ftpAuditoriaEscalonadaDigital != null && ftpAuditoriaEscalonadaDigital.getId() != null && ftpAuditoriaEscalonadaDigital.getId() > 0) {
            ftpAuditoriaEscalonadaDigitalService.save(ftpAuditoriaEscalonadaDigital);
            publisher.publishEvent(new ResourceCreatedEvent(this, response, ftpAuditoriaEscalonadaDigital.getId()));
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(ftpAuditoriaEscalonadaDigital);

        } else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ftpAuditoriaEscalonadaDigital);
        }
        return responseResponseEntity;
    }

    @DeleteMapping(path = "/ftp_auditoria_escalonada_digital/{id}")
    public ResponseEntity<FtpAuditoriaEscalonadaDigital> delete (@PathVariable Long id) {
        ResponseEntity<FtpAuditoriaEscalonadaDigital> responseResponseEntity;

        Optional<FtpAuditoriaEscalonadaDigital> optionalFtpAuditoriaEscalonadaDigital = ftpAuditoriaEscalonadaDigitalService.findById(id);

        if (optionalFtpAuditoriaEscalonadaDigital.isPresent()) {

            ftpAuditoriaEscalonadaDigitalService.delete(((FtpAuditoriaEscalonadaDigital) optionalFtpAuditoriaEscalonadaDigital.get()));
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(null);

        } else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return responseResponseEntity;
    }
}

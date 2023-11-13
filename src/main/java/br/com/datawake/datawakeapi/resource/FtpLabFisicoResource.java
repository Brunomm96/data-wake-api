package br.com.datawake.datawakeapi.resource;

import br.com.datawake.datawakeapi.event.ResourceCreatedEvent;
import br.com.datawake.datawakeapi.model.FtpLabFisico;
import br.com.datawake.datawakeapi.service.FtpLabFisicoService;
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
@RequestMapping("/api/v1")
public class FtpLabFisicoResource {

    @Autowired
    private FtpLabFisicoService ftpLabFisicoService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping( path = "/ftplabfisico/(idFtp)" )
    public ResponseEntity<FtpLabFisico> byIdFtp(@PathVariable Long idFtp){

        ResponseEntity<FtpLabFisico> responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        Optional<FtpLabFisico> optionalFtpLabFisico = ftpLabFisicoService.getById(idFtp);

        if(optionalFtpLabFisico.isPresent()){
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(optionalFtpLabFisico.get());
        }

        return responseResponseEntity;
    }

    @GetMapping( path = "/ftplabfisico" )
    public ResponseEntity<Page<FtpLabFisico>> all(Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(ftpLabFisicoService.findAll(pageable));

    }
    @PostMapping( path = "/ftplabfisico" )
    public ResponseEntity<FtpLabFisico> create(@RequestBody FtpLabFisico ftpLabFisico, HttpServletResponse response){

        ResponseEntity<FtpLabFisico> responseResponseEntity;

        ftpLabFisico.setId(null);
        ftpLabFisicoService.save(ftpLabFisico);

        if(ftpLabFisico != null && ftpLabFisico.getId() != null){

            publisher.publishEvent(new ResourceCreatedEvent(this, response, ftpLabFisico.getId()));
            responseResponseEntity = ResponseEntity.status(HttpStatus.CREATED).body(ftpLabFisico);

        }else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ftpLabFisico);

        }
        return responseResponseEntity;
    }
    @PutMapping( path = "/ftplabfisico" )
    public ResponseEntity<FtpLabFisico> update(@RequestBody FtpLabFisico ftpLabFisico, HttpServletResponse response){
        ResponseEntity<FtpLabFisico> responseResponseEntity;
        if(ftpLabFisico != null && ftpLabFisico.getId() != null && ftpLabFisico.getId() > 0){
            ftpLabFisicoService.save(ftpLabFisico);
            publisher.publishEvent(new ResourceCreatedEvent(this, response, ftpLabFisico.getId()));
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(ftpLabFisico);

        }
        else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ftpLabFisico);
        }

        return responseResponseEntity;
    }

    @DeleteMapping( path = "/ftplabfisico/{id}" )
    public ResponseEntity<FtpLabFisico> delete(@PathVariable Long id ) {

        ResponseEntity<FtpLabFisico> responseResponseEntity;

        Optional<FtpLabFisico> optionalFtpLabFisico = ftpLabFisicoService.findById(id);

        if ( optionalFtpLabFisico.isPresent() ) {

            ftpLabFisicoService.delete(optionalFtpLabFisico.get());
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(null);

        }
        else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return responseResponseEntity;

    }
}

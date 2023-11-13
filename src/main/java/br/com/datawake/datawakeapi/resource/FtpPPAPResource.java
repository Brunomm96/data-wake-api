package br.com.datawake.datawakeapi.resource;

import br.com.datawake.datawakeapi.event.ResourceCreatedEvent;
import br.com.datawake.datawakeapi.model.FtpPPAP;
import br.com.datawake.datawakeapi.service.FtpPPAPService;
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
public class FtpPPAPResource {

    @Autowired
    private FtpPPAPService ftpPPAPService;

    @Autowired
    private ApplicationEventPublisher publisher;


    @GetMapping( path = "/ftpppap/(idFtp)" )
    public ResponseEntity<FtpPPAP> byIdFtp(@PathVariable Long idFtp){

        ResponseEntity<FtpPPAP> responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        Optional<FtpPPAP> optionalFtpPPAP = ftpPPAPService.getById(idFtp);

        if(optionalFtpPPAP.isPresent()){
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(optionalFtpPPAP.get());
        }

        return responseResponseEntity;
    }

    @GetMapping( path = "/ftpppap" )
    public ResponseEntity<Page<FtpPPAP>> all(Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(ftpPPAPService.findAll(pageable));

    }
    @PostMapping( path = "/ftpppap" )
    public ResponseEntity<FtpPPAP> create(@RequestBody FtpPPAP ftpPPAP, HttpServletResponse response){

        ResponseEntity<FtpPPAP> responseResponseEntity;

        ftpPPAP.setId(null);
        ftpPPAPService.save(ftpPPAP);

        if(ftpPPAP != null && ftpPPAP.getId() != null){

            publisher.publishEvent(new ResourceCreatedEvent(this, response, ftpPPAP.getId()));
            responseResponseEntity = ResponseEntity.status(HttpStatus.CREATED).body(ftpPPAP);

        }else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ftpPPAP);

        }
        return responseResponseEntity;
    }
    @PutMapping( path = "/ftpppap" )
    public ResponseEntity<FtpPPAP> update(@RequestBody FtpPPAP ftpPPAP, HttpServletResponse response){
        ResponseEntity<FtpPPAP> responseResponseEntity;
        if(ftpPPAP != null && ftpPPAP.getId() != null && ftpPPAP.getId() > 0){
            ftpPPAPService.save(ftpPPAP);
            publisher.publishEvent(new ResourceCreatedEvent(this, response, ftpPPAP.getId()));
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(ftpPPAP);

        }
        else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ftpPPAP);
        }

        return responseResponseEntity;
    }

    @DeleteMapping( path = "/ftpppap/{id}" )
    public ResponseEntity<FtpPPAP> delete(@PathVariable Long id ) {

        ResponseEntity<FtpPPAP> responseResponseEntity;

        Optional<FtpPPAP> optionalFtpPPAP = ftpPPAPService.findById(id);

        if ( optionalFtpPPAP.isPresent() ) {

            ftpPPAPService.delete(optionalFtpPPAP.get());
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(null);

        }
        else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return responseResponseEntity;

    }
}

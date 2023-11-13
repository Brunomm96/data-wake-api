package br.com.datawake.datawakeapi.resource;

import br.com.datawake.datawakeapi.event.ResourceCreatedEvent;
import br.com.datawake.datawakeapi.model.FtpAPQP;
import br.com.datawake.datawakeapi.model.FtpMangueiras;
import br.com.datawake.datawakeapi.service.FtpAPQPService;
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
public class FtpAPQPResource {

    @Autowired
    private FtpAPQPService ftpAPQPService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping( path = "/ftpapqp/(idFtp)" )
    public ResponseEntity<FtpAPQP> byIdFtp(@PathVariable Long idFtp){

        ResponseEntity<FtpAPQP> responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        Optional<FtpAPQP> optionalFtpAPQP = ftpAPQPService.getById(idFtp);

        if(optionalFtpAPQP.isPresent()){
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(optionalFtpAPQP.get());
        }

        return responseResponseEntity;
    }

    @GetMapping( path = "/ftpapqp" )
    public ResponseEntity<Page<FtpAPQP>> all(Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(ftpAPQPService.findAll(pageable));

    }
    @PostMapping( path = "/ftpapqp" )
    public ResponseEntity<FtpAPQP> create(@RequestBody FtpAPQP ftpAPQP, HttpServletResponse response){

        ResponseEntity<FtpAPQP> responseResponseEntity;

        ftpAPQP.setId(null);
        ftpAPQPService.save(ftpAPQP);

        if(ftpAPQP != null && ftpAPQP.getId() != null){

            publisher.publishEvent(new ResourceCreatedEvent(this, response, ftpAPQP.getId()));
            responseResponseEntity = ResponseEntity.status(HttpStatus.CREATED).body(ftpAPQP);

        }else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ftpAPQP);

        }
        return responseResponseEntity;
    }
    @PutMapping( path = "/ftpapqp" )
    public ResponseEntity<FtpAPQP> update(@RequestBody FtpAPQP ftpAPQP, HttpServletResponse response){
        ResponseEntity<FtpAPQP> responseResponseEntity;
        if(ftpAPQP != null && ftpAPQP.getId() != null && ftpAPQP.getId() > 0){
            ftpAPQPService.save(ftpAPQP);
            publisher.publishEvent(new ResourceCreatedEvent(this, response, ftpAPQP.getId()));
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(ftpAPQP);

        }
        else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ftpAPQP);
        }

        return responseResponseEntity;
    }

    @DeleteMapping( path = "/ftpapqp/{id}" )
    public ResponseEntity<FtpAPQP> delete(@PathVariable Long id ) {

        ResponseEntity<FtpAPQP> responseResponseEntity;

        Optional<FtpAPQP> optionalFtpAPQP = ftpAPQPService.findById(id);

        if ( optionalFtpAPQP.isPresent() ) {

            ftpAPQPService.delete(optionalFtpAPQP.get());
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(null);

        }
        else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return responseResponseEntity;

    }
}

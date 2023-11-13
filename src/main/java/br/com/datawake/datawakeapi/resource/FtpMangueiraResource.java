package br.com.datawake.datawakeapi.resource;

import br.com.datawake.datawakeapi.event.ResourceCreatedEvent;
import br.com.datawake.datawakeapi.model.FtpMangueiras;
import br.com.datawake.datawakeapi.model.logApp;
import br.com.datawake.datawakeapi.service.FtpMangueiraService;
import br.com.datawake.datawakeapi.service.logAppService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.sql.Time;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class FtpMangueiraResource {

    @Autowired
    private FtpMangueiraService ftpMangueiraService;

    @Autowired
    private ApplicationEventPublisher publisher;

    private final static ObjectMapper objectMapper = new ObjectMapper();
    private final static logApp log = new logApp();

    @Autowired
    private logAppService LogAppService ;

    @GetMapping( path = "/ftpmangueiraspec/{idFtp}" )
    public ResponseEntity<FtpMangueiras> byIdFtp(@PathVariable Long idFtp,@RequestHeader Map<String,String> headers) throws JsonProcessingException {

        ResponseEntity<FtpMangueiras> responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        Optional<FtpMangueiras> optionalFtpMangueiras = ftpMangueiraService.getById(idFtp);

        if ( optionalFtpMangueiras.isPresent() ) {
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(optionalFtpMangueiras.get());
        }
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "GetMapping /ftpmangueiraspec/{idFtp}", new Time(System.currentTimeMillis()),"CONSULTA DE ID "+idFtp.toString(), objectMapper.writeValueAsString(responseResponseEntity.getBody()));
        LogAppService.save(log);
        return responseResponseEntity;

    }

    @GetMapping( path = "/ftpmangueiraspec" )
    public ResponseEntity<Page<FtpMangueiras>> all( Pageable pageable ,@RequestHeader Map<String,String> headers ) throws JsonProcessingException {
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "GetMapping /ftpmangueiraspec", new Time(System.currentTimeMillis()),"CONSULTA GERAL DE Mangueira", objectMapper.writeValueAsString(ftpMangueiraService.findAll(pageable)));
        LogAppService.save(log);
        return ResponseEntity.status(HttpStatus.OK).body(ftpMangueiraService.findAll(pageable));
    }

    @PostMapping( path = "/ftpmangueiraspec" )
    public ResponseEntity<FtpMangueiras> create(@RequestBody FtpMangueiras ftpMangueiras, HttpServletResponse response , @RequestHeader Map<String,String> headers ) throws JsonProcessingException {

        ResponseEntity<FtpMangueiras> responseResponseEntity;

        ftpMangueiras.setId(null);
        ftpMangueiraService.save(ftpMangueiras);

        if ( ftpMangueiras != null && ftpMangueiras.getId() != null ) {

            publisher.publishEvent(new ResourceCreatedEvent(this, response, ftpMangueiras.getId()));
            responseResponseEntity = ResponseEntity.status(HttpStatus.CREATED).body(ftpMangueiras);

        }
        else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ftpMangueiras);
        }
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "PostMapping /ftpmangueiraspec", new Time(System.currentTimeMillis()),objectMapper.writeValueAsString(ftpMangueiras), objectMapper.writeValueAsString(responseResponseEntity.getBody()));
        LogAppService.save(log);
        return responseResponseEntity;

    }

    @PutMapping( path = "/ftpmangueiraspec" )
    public ResponseEntity<FtpMangueiras> update( @RequestBody FtpMangueiras ftpMangueiras, HttpServletResponse response ,@RequestHeader Map<String,String> headers ) throws JsonProcessingException {

        ResponseEntity<FtpMangueiras> responseResponseEntity;
        Optional<FtpMangueiras> optionalftpMangueiras= Optional.of(new FtpMangueiras());

        if ( ftpMangueiras != null && ftpMangueiras.getId() != null && ftpMangueiras.getId() > 0 ) {
            optionalftpMangueiras =  ftpMangueiraService.getById(ftpMangueiras.getId() );
            log.setRequest( objectMapper.writeValueAsString(optionalftpMangueiras.get()));
            ftpMangueiraService.save(ftpMangueiras);
            publisher.publishEvent(new ResourceCreatedEvent(this, response, ftpMangueiras.getId()));
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(ftpMangueiras);

        }
        else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ftpMangueiras);
        }
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "PutMapping /ftpmangueiraspec", new Time(System.currentTimeMillis()),objectMapper.writeValueAsString(optionalftpMangueiras.get()), objectMapper.writeValueAsString(responseResponseEntity.getBody()));
        LogAppService.save(log);
        return responseResponseEntity;

    }

    @DeleteMapping( path = "/ftpmangueiraspec/{id}" )
    public ResponseEntity<FtpMangueiras> delete(@PathVariable Long id ,@RequestHeader Map<String,String> headers ) throws JsonProcessingException {

        ResponseEntity<FtpMangueiras> responseResponseEntity;

        Optional<FtpMangueiras> optionalFtpMangueiras = ftpMangueiraService.findById(id);

        if ( optionalFtpMangueiras.isPresent() ) {

            ftpMangueiraService.delete(optionalFtpMangueiras.get());
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(null);

        }
        else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "DeleteMapping /ftpmangueiraspec/{id}", new Time(System.currentTimeMillis()),"DELETE DE ID : "+id.toString(), objectMapper.writeValueAsString(responseResponseEntity));
        LogAppService.save(log);
        return responseResponseEntity;

    }

}

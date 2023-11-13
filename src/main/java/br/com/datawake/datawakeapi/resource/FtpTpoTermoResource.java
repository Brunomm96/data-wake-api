package br.com.datawake.datawakeapi.resource;

import br.com.datawake.datawakeapi.event.ResourceCreatedEvent;
import br.com.datawake.datawakeapi.model.FtpTpoTermo;
import br.com.datawake.datawakeapi.model.logApp;
import br.com.datawake.datawakeapi.service.FtpTpoTermoService;
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
public class FtpTpoTermoResource {


    private final static ObjectMapper objectMapper = new ObjectMapper();
    private final static logApp log = new logApp();

    @Autowired
    private logAppService LogAppService ;

    @Autowired
    private FtpTpoTermoService ftpTpoTermoService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping( path = "/ftptpotermo/{idFtp}" )
    ////@PreAuthorize("hasAuthority('ROLE_FTP_TPO')")
    public ResponseEntity<FtpTpoTermo> byIdFtp(@PathVariable Long idFtp,@RequestHeader Map<String,String> headers) throws JsonProcessingException {

        ResponseEntity<FtpTpoTermo> responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        Optional<FtpTpoTermo> optionalFtpTpoTermo = ftpTpoTermoService.getById(idFtp);

        if ( optionalFtpTpoTermo.isPresent() ) {
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(optionalFtpTpoTermo.get());
        }

        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "GetMapping /ftptpotermo/{idFtp}", new Time(System.currentTimeMillis()),"CONSULTA DE ID "+idFtp, objectMapper.writeValueAsString(responseResponseEntity.getBody()));
        LogAppService.save(log);

        return responseResponseEntity;

    }

    @GetMapping( path = "/ftptpotermo" )
    ////@PreAuthorize("hasAuthority('ROLE_FTP_TPO')")
    public ResponseEntity<Page<FtpTpoTermo>> all( Pageable pageable ,@RequestHeader Map<String,String> headers) throws JsonProcessingException {
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "GetMapping /ftptpotermo", new Time(System.currentTimeMillis()),"CONSULTA GERAL DE TPO TERMO", objectMapper.writeValueAsString(ftpTpoTermoService.findAll(pageable)));
        LogAppService.save(log);
        return ResponseEntity.status(HttpStatus.OK).body(ftpTpoTermoService.findAll(pageable));
    }

    @PostMapping( path = "/ftptpotermo" )
    //@PreAuthorize("hasAuthority('ROLE_FTP_TPO_INSERT')")
    public ResponseEntity<FtpTpoTermo> create(@RequestBody FtpTpoTermo ftpTpoTermo, HttpServletResponse response , @RequestHeader Map<String,String> headers) throws JsonProcessingException {

        ResponseEntity<FtpTpoTermo> responseResponseEntity;

        ftpTpoTermo.setId(null); // garante que sera uma inclusao
        ftpTpoTermoService.save(ftpTpoTermo);

        if ( ftpTpoTermo != null && ftpTpoTermo.getId() != null ) {

            publisher.publishEvent(new ResourceCreatedEvent(this, response, ftpTpoTermo.getId()));
            responseResponseEntity = ResponseEntity.status(HttpStatus.CREATED).body(ftpTpoTermo);

        }
        else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ftpTpoTermo);
        }
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "PostMapping /ftptpotermo", new Time(System.currentTimeMillis()),objectMapper.writeValueAsString(ftpTpoTermo), objectMapper.writeValueAsString(responseResponseEntity.getBody()));
        LogAppService.save(log);
        return responseResponseEntity;

    }

    @PutMapping( path = "/ftptpotermo" )
    //@PreAuthorize("hasAuthority('ROLE_FTP_TPO_UPDATE')")
    public ResponseEntity<FtpTpoTermo> update( @RequestBody FtpTpoTermo ftpTpoTermo, HttpServletResponse response,@RequestHeader Map<String,String> headers ) throws JsonProcessingException {

        ResponseEntity<FtpTpoTermo> responseResponseEntity;
        Optional<FtpTpoTermo> optionalFtpTpoTermo = Optional.of(new FtpTpoTermo());

        if ( ftpTpoTermo != null && ftpTpoTermo.getId() != null && ftpTpoTermo.getId() > 0 ) {
            optionalFtpTpoTermo =  ftpTpoTermoService.getById(ftpTpoTermo.getId() );
            log.setRequest( objectMapper.writeValueAsString(optionalFtpTpoTermo.get()));
            ftpTpoTermoService.save(ftpTpoTermo);
            publisher.publishEvent(new ResourceCreatedEvent(this, response, ftpTpoTermo.getId()));
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(ftpTpoTermo);

        }
        else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ftpTpoTermo);
        }

        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "PutMapping /ftptpotermo", new Time(System.currentTimeMillis()),objectMapper.writeValueAsString(optionalFtpTpoTermo.get()), objectMapper.writeValueAsString(responseResponseEntity.getBody()));
        LogAppService.save(log);

        return responseResponseEntity;

    }

    @DeleteMapping( path = "/ftptpotermo/{idFtpTpoTermo}" )
    //@PreAuthorize("hasAuthority('ROLE_FTP_TPO_DELETE')")
    public ResponseEntity<FtpTpoTermo> delete( @PathVariable Long idFtpTpoTermo,@RequestHeader Map<String,String> headers ) throws JsonProcessingException {

        ResponseEntity<FtpTpoTermo> responseResponseEntity;

        Optional<FtpTpoTermo> optionalFtpTpoTermo = ftpTpoTermoService.findById(idFtpTpoTermo);

        if ( optionalFtpTpoTermo.isPresent() ) {

            ftpTpoTermoService.delete(optionalFtpTpoTermo.get());
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(null);

        }
        else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "DeleteMapping /ftptpotermo/{idFtpTpoTermo}", new Time(System.currentTimeMillis()),"DELETE DE ID : "+idFtpTpoTermo, objectMapper.writeValueAsString(responseResponseEntity));
        LogAppService.save(log);
        return responseResponseEntity;

    }

}

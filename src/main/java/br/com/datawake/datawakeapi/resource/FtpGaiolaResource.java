package br.com.datawake.datawakeapi.resource;
import br.com.datawake.datawakeapi.service.AppUserDetailsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.datawake.datawakeapi.event.StringResourceCreatedEvent;
import br.com.datawake.datawakeapi.model.FtpGaiolas;
import br.com.datawake.datawakeapi.model.logApp;
import br.com.datawake.datawakeapi.service.FtpGaiolaService;
import br.com.datawake.datawakeapi.service.logAppService;
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
public class FtpGaiolaResource {

    @Autowired
    private FtpGaiolaService ftpGaiolaService;


    private final static ObjectMapper objectMapper = new ObjectMapper();
    private final static  logApp log = new logApp();

    @Autowired
    private logAppService LogAppService ;

    @Autowired
    private AppUserDetailsService usuarioService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping( path = "/ftpgaiolas/{idTag}" )
    public ResponseEntity<FtpGaiolas> byIdFtp(@PathVariable String idTag,@RequestHeader Map<String,String> headers) throws JsonProcessingException {

        ResponseEntity<FtpGaiolas> responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        Optional<FtpGaiolas> optionalFtpGaiolas = ftpGaiolaService.getById(idTag);

        if ( optionalFtpGaiolas.isPresent()){
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(optionalFtpGaiolas.get());
        }


        log.setObject( headers.get("authorization").replace("Bearer ",""),
        new java.sql.Date(System.currentTimeMillis()), "GetMapping /ftpgaiolas/{idTag}", new Time(System.currentTimeMillis()),"CONSULTA DE ID "+idTag, objectMapper.writeValueAsString(responseResponseEntity.getBody()));
        LogAppService.save(log);
        return responseResponseEntity;


    }

    @GetMapping( path = "/ftpgaiolas" )
    public ResponseEntity<Page<FtpGaiolas>> all( Pageable pageable  ,@RequestHeader Map<String,String> headers) throws JsonProcessingException {
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "GetMapping /ftpgaiolas", new Time(System.currentTimeMillis()),"CONSULTA GERAL DE GAIOLAS", objectMapper.writeValueAsString(ftpGaiolaService.findAll(pageable)));
        LogAppService.save(log);
        return ResponseEntity.status(HttpStatus.OK).body(ftpGaiolaService.findAll(pageable));
    }

    @PostMapping( path = "/ftpgaiolas" )
    public ResponseEntity<FtpGaiolas> create(@RequestBody FtpGaiolas ftpGaiolas, HttpServletResponse response , @RequestHeader Map<String,String> headers) throws JsonProcessingException {

        ResponseEntity<FtpGaiolas> responseResponseEntity;

        ftpGaiolaService.save(ftpGaiolas);

        if ( ftpGaiolas != null && ftpGaiolas.getTag() != "" ) {

            publisher.publishEvent(new StringResourceCreatedEvent(this, response, ftpGaiolas.getTag()));
            responseResponseEntity = ResponseEntity.status(HttpStatus.CREATED).body(ftpGaiolas);

        }
        else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ftpGaiolas);
        }
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "PostMapping /ftpgaiolas", new Time(System.currentTimeMillis()),objectMapper.writeValueAsString(ftpGaiolas), objectMapper.writeValueAsString(responseResponseEntity.getBody()));
        LogAppService.save(log);
        return responseResponseEntity;

    }

    @PutMapping( path = "/ftpgaiolas" )
    public ResponseEntity<FtpGaiolas> update( @RequestBody FtpGaiolas ftpGaiolas, HttpServletResponse response ,@RequestHeader Map<String,String> headers) throws JsonProcessingException {

        ResponseEntity<FtpGaiolas> responseResponseEntity;
        Optional<FtpGaiolas> optionalFtpGaiolas = Optional.of(new FtpGaiolas());

        if ( ftpGaiolas != null && ftpGaiolas.getTag() != null && !(ftpGaiolas.getTag().isEmpty()) ) {
            optionalFtpGaiolas =  ftpGaiolaService.getById(ftpGaiolas.getTag() );
            log.setRequest( objectMapper.writeValueAsString(optionalFtpGaiolas.get()));

            ftpGaiolaService.save(ftpGaiolas);
            publisher.publishEvent(new StringResourceCreatedEvent(this, response, ftpGaiolas.getTag()));
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(ftpGaiolas);

        }
        else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ftpGaiolas);
        }
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "PutMapping /ftpgaiolas", new Time(System.currentTimeMillis()),objectMapper.writeValueAsString(optionalFtpGaiolas.get()), objectMapper.writeValueAsString(responseResponseEntity.getBody()));
        LogAppService.save(log);

        return responseResponseEntity;

    }

    @DeleteMapping( path = "/ftpgaiolas/{idTag}" )
    public ResponseEntity<FtpGaiolas> delete(@PathVariable String idTag ,@RequestHeader Map<String,String> headers ) throws JsonProcessingException {

        ResponseEntity<FtpGaiolas> responseResponseEntity;

        Optional<FtpGaiolas> optionalFtpGaiolas = ftpGaiolaService.findById(idTag);

        if ( optionalFtpGaiolas.isPresent() ) {

            ftpGaiolaService.delete(optionalFtpGaiolas.get());
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(null);

        }
        else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "DeleteMapping /ftpgaiolas/{idTag}", new Time(System.currentTimeMillis()),"DELETE DE ID : "+idTag, objectMapper.writeValueAsString(responseResponseEntity));
        LogAppService.save(log);
        return responseResponseEntity;

    }

}

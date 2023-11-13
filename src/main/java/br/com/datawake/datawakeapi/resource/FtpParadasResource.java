package br.com.datawake.datawakeapi.resource;

import br.com.datawake.datawakeapi.event.StringResourceCreatedEvent;
import br.com.datawake.datawakeapi.model.FtpGaiolas;
import br.com.datawake.datawakeapi.model.FtpParadas;
import br.com.datawake.datawakeapi.model.logApp;
import br.com.datawake.datawakeapi.service.FtpParadaService;
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
public class FtpParadasResource {

    @Autowired
    private FtpParadaService ftpParadaService;

    private final static ObjectMapper objectMapper = new ObjectMapper();
    private final static logApp log = new logApp();

    @Autowired
    private logAppService LogAppService ;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping( path = "/ftpparadas/{cod_parada}" )
    public ResponseEntity<FtpParadas> byIdFtp(@PathVariable String cod_parada,@RequestHeader Map<String,String> headers) throws JsonProcessingException {

        ResponseEntity<FtpParadas> responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        Optional<FtpParadas> optionalFtpParadas = ftpParadaService.getById(cod_parada);

        if ( optionalFtpParadas.isPresent()){
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(optionalFtpParadas.get());
        }

        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "GetMapping /ftpparadas/{cod_parada}", new Time(System.currentTimeMillis()),"CONSULTA DE ID "+cod_parada, objectMapper.writeValueAsString(responseResponseEntity.getBody()));
        LogAppService.save(log);
        return responseResponseEntity;

    }

    @GetMapping( path = "/ftpparadas" )
    public ResponseEntity<Page<FtpParadas>> all( Pageable pageable ,@RequestHeader Map<String,String> headers) throws JsonProcessingException {

        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "GetMapping /ftpparadas", new Time(System.currentTimeMillis()),"CONSULTA GERAL DE GAIOLAS", objectMapper.writeValueAsString(ftpParadaService.findAll(pageable)));
        LogAppService.save(log);

        return ResponseEntity.status(HttpStatus.OK).body(ftpParadaService.findAll(pageable));
    }

    @PostMapping( path = "/ftpparadas" )
    public ResponseEntity<FtpParadas> create(@RequestBody FtpParadas ftpparadas, HttpServletResponse response , @RequestHeader Map<String,String> headers) throws JsonProcessingException {

        ResponseEntity<FtpParadas> responseResponseEntity;

        ftpParadaService.save(ftpparadas);

        if ( ftpparadas != null && ftpparadas.getCod_parada() != "" ) {

            publisher.publishEvent(new StringResourceCreatedEvent(this, response, ftpparadas.getCod_parada()));
            responseResponseEntity = ResponseEntity.status(HttpStatus.CREATED).body(ftpparadas);

        }
        else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ftpparadas);
        }

        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "PostMapping /ftpparadas", new Time(System.currentTimeMillis()),objectMapper.writeValueAsString(ftpparadas), objectMapper.writeValueAsString(responseResponseEntity.getBody()));
        LogAppService.save(log);
        return responseResponseEntity;

    }

    @PutMapping( path = "/ftpparadas" )
    public ResponseEntity<FtpParadas> update( @RequestBody FtpParadas ftpparadas, HttpServletResponse response ,@RequestHeader Map<String,String> headers ) throws JsonProcessingException {

        ResponseEntity<FtpParadas> responseResponseEntity;
        Optional<FtpParadas> optionalFtpParadas = Optional.of(new FtpParadas());

        if ( ftpparadas != null && ftpparadas.getCod_parada() != null && !(ftpparadas.getCod_parada().isEmpty()) ) {
            optionalFtpParadas =  ftpParadaService.getById(ftpparadas.getCod_parada() );
            log.setRequest( objectMapper.writeValueAsString(optionalFtpParadas.get()));

            ftpParadaService.save(ftpparadas);
            publisher.publishEvent(new StringResourceCreatedEvent(this, response, ftpparadas.getCod_parada()));
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(ftpparadas);

        }
        else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ftpparadas);
        }

        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "PutMapping /ftpparadas", new Time(System.currentTimeMillis()),objectMapper.writeValueAsString(optionalFtpParadas.get()), objectMapper.writeValueAsString(responseResponseEntity.getBody()));
        LogAppService.save(log);
        return responseResponseEntity;

    }

    @DeleteMapping( path = "/ftpparadas/{cod_parada}" )
    public ResponseEntity<FtpParadas> delete(@PathVariable String cod_parada ,@RequestHeader Map<String,String> headers ) throws JsonProcessingException {

        ResponseEntity<FtpParadas> responseResponseEntity;

        Optional<FtpParadas> optionalFtpParadas = ftpParadaService.findById(cod_parada);

        if ( optionalFtpParadas.isPresent() ) {

            ftpParadaService.delete(optionalFtpParadas.get());
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(null);

        }
        else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "DeleteMapping /ftpparadas/{cod_parada}", new Time(System.currentTimeMillis()),"DELETE DE ID : "+cod_parada, objectMapper.writeValueAsString(responseResponseEntity));
        LogAppService.save(log);
        return responseResponseEntity;

    }

}

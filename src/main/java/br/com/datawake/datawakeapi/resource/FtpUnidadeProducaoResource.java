package br.com.datawake.datawakeapi.resource;

import br.com.datawake.datawakeapi.event.ResourceCreatedEvent;
import br.com.datawake.datawakeapi.model.FtpUnidadeProducao;
import br.com.datawake.datawakeapi.model.logApp;
import br.com.datawake.datawakeapi.service.FtpUnidadeProducaoService;
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
public class FtpUnidadeProducaoResource {
    @Autowired
    private FtpUnidadeProducaoService ftpUnidadeProducaoService;

    private final static ObjectMapper objectMapper = new ObjectMapper();
    private final static logApp log = new logApp();

    @Autowired
    private logAppService LogAppService ;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping( path = "/ftpunidadeproducao/{id}" )
    public ResponseEntity<FtpUnidadeProducao> byId(@PathVariable Long id,@RequestHeader Map<String,String> headers) throws JsonProcessingException {

        ResponseEntity<FtpUnidadeProducao> responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        Optional<FtpUnidadeProducao> optionalFtpUnidadeProducao = ftpUnidadeProducaoService.getById(id);

        if ( optionalFtpUnidadeProducao.isPresent()){
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(optionalFtpUnidadeProducao.get());
        }

        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "GetMapping /ftpunidadeproducao/{id}", new Time(System.currentTimeMillis()),"CONSULTA DE ID "+id, objectMapper.writeValueAsString(responseResponseEntity.getBody()));
        LogAppService.save(log);

        return responseResponseEntity;

    }

    @GetMapping( path = "/ftpunidadeproducao" )
    public ResponseEntity<Page<FtpUnidadeProducao>> all( Pageable pageable  ,@RequestHeader Map<String,String> headers) throws JsonProcessingException {
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "GetMapping /ftpunidadeproducao", new Time(System.currentTimeMillis()),"CONSULTA GERAL DE UNIDADE DE PRODUÇÃO", objectMapper.writeValueAsString(ftpUnidadeProducaoService.findAll(pageable)));
        LogAppService.save(log);
        return ResponseEntity.status(HttpStatus.OK).body(ftpUnidadeProducaoService.findAll(pageable));
    }

    @PostMapping( path = "/ftpunidadeproducao" )
    public ResponseEntity<FtpUnidadeProducao> create(@RequestBody FtpUnidadeProducao ftpUnidadeProducao, HttpServletResponse response , @RequestHeader Map<String,String> headers) throws JsonProcessingException {

        ResponseEntity<FtpUnidadeProducao> responseResponseEntity;

        ftpUnidadeProducaoService.save(ftpUnidadeProducao);

        if ( ftpUnidadeProducao != null && ftpUnidadeProducao.getId() != 0 ) {

            publisher.publishEvent(new ResourceCreatedEvent(this, response, ftpUnidadeProducao.getId()));
            responseResponseEntity = ResponseEntity.status(HttpStatus.CREATED).body(ftpUnidadeProducao);

        }
        else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ftpUnidadeProducao);
        }
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "PostMapping /ftpunidadeproducao", new Time(System.currentTimeMillis()),objectMapper.writeValueAsString(ftpUnidadeProducao), objectMapper.writeValueAsString(responseResponseEntity.getBody()));
        LogAppService.save(log);

        return responseResponseEntity;

    }

    @PutMapping( path = "/ftpunidadeproducao" )
    public ResponseEntity<FtpUnidadeProducao> update( @RequestBody FtpUnidadeProducao ftpUnidadeProducao, HttpServletResponse response,@RequestHeader Map<String,String> headers) throws JsonProcessingException {

        ResponseEntity<FtpUnidadeProducao> responseResponseEntity;
        Optional<FtpUnidadeProducao> optionalftpUnidadeProducao = Optional.of(new FtpUnidadeProducao());

        if ( ftpUnidadeProducao != null && ftpUnidadeProducao.getId() != null  ) {

            optionalftpUnidadeProducao =  ftpUnidadeProducaoService.getById(ftpUnidadeProducao.getId() );
            log.setRequest( objectMapper.writeValueAsString(optionalftpUnidadeProducao.get()));
            ftpUnidadeProducaoService.save(ftpUnidadeProducao);
            publisher.publishEvent(new ResourceCreatedEvent(this, response, ftpUnidadeProducao.getId()));
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(ftpUnidadeProducao);

        }
        else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ftpUnidadeProducao);
        }
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "PutMapping /ftpunidadeproducao", new Time(System.currentTimeMillis()),objectMapper.writeValueAsString(optionalftpUnidadeProducao.get()), objectMapper.writeValueAsString(responseResponseEntity.getBody()));
        LogAppService.save(log);

        return responseResponseEntity;

    }

    @DeleteMapping( path = "/ftpunidadeproducao/{id}" )
    public ResponseEntity<FtpUnidadeProducao> delete(@PathVariable long id ,@RequestHeader Map<String,String> headers ) throws JsonProcessingException {

        ResponseEntity<FtpUnidadeProducao> responseResponseEntity;

        Optional<FtpUnidadeProducao> optionalFtpUnidadeProducao = ftpUnidadeProducaoService.findById(id);

        if ( optionalFtpUnidadeProducao.isPresent() ) {

            ftpUnidadeProducaoService.delete(optionalFtpUnidadeProducao.get());
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(null);

        }
        else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "DeleteMapping /ftpunidadeproducao/{id}", new Time(System.currentTimeMillis()),"DELETE DE ID : "+id, objectMapper.writeValueAsString(responseResponseEntity));
        LogAppService.save(log);
        return responseResponseEntity;

    }

}

package br.com.datawake.datawakeapi.resource;

import br.com.datawake.datawakeapi.event.StringResourceCreatedEvent;
import br.com.datawake.datawakeapi.model.FtpControleReclamacoes;
import br.com.datawake.datawakeapi.model.logApp;
import br.com.datawake.datawakeapi.service.FtpControleReclamacoesService;
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
public class FtpControleReclamacoesResource {

    @Autowired
    private FtpControleReclamacoesService ftpControleReclamacoesService;

    private final static ObjectMapper objectMapper = new ObjectMapper();
    private final static logApp log = new logApp();

    @Autowired
    private logAppService LogAppService ;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping( path = "/ftpcontrolereclamacoes/{item}" )
    public ResponseEntity<FtpControleReclamacoes> byIdFtp(@PathVariable String item,@RequestHeader Map<String,String> headers) throws JsonProcessingException{

        ResponseEntity<FtpControleReclamacoes> responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        Optional<FtpControleReclamacoes> optionalFtpControleReclamacoes = ftpControleReclamacoesService.getById(item);

        if(optionalFtpControleReclamacoes.isPresent()){
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(optionalFtpControleReclamacoes.get());
        }

        log.setObject( headers.get("authorization").replace("Bearer ",""),
            new java.sql.Date(System.currentTimeMillis()), "GetMapping /ftpcontrolereclamacoes/{item}", new Time(System.currentTimeMillis()),"CONSULTA DE ID "+ item, objectMapper.writeValueAsString(responseResponseEntity.getBody()));
        LogAppService.save(log);
        return responseResponseEntity;

    }

    @GetMapping( path = "/ftpcontrolereclamacoes" )
    public ResponseEntity<Page<FtpControleReclamacoes>> all(Pageable pageable ,@RequestHeader Map<String,String> headers ) throws JsonProcessingException {
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "GetMapping /ftpcontrolereclamacoes", new Time(System.currentTimeMillis()),"CONSULTA GERAL DE RECLAMAÇÃO", objectMapper.writeValueAsString(ftpControleReclamacoesService.findAll(pageable)));
        LogAppService.save(log);
        return ResponseEntity.status(HttpStatus.OK).body(ftpControleReclamacoesService.findAll(pageable));
    }

    @PostMapping( path = "/ftpcontrolereclamacoes" )
    public ResponseEntity<FtpControleReclamacoes> create(@RequestBody FtpControleReclamacoes ftpcontrolereclamacoes, HttpServletResponse response , @RequestHeader Map<String,String> headers) throws JsonProcessingException {

        ResponseEntity<FtpControleReclamacoes> responseResponseEntity;

        ftpControleReclamacoesService.save(ftpcontrolereclamacoes);

        if ( ftpcontrolereclamacoes != null && ftpcontrolereclamacoes.getItem() != "" ) {

            publisher.publishEvent(new StringResourceCreatedEvent(this, response, ftpcontrolereclamacoes.getItem()));
            responseResponseEntity = ResponseEntity.status(HttpStatus.CREATED).body(ftpcontrolereclamacoes);

        }
        else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ftpcontrolereclamacoes);
        }
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "PostMapping /ftpcontrolereclamacoes", new Time(System.currentTimeMillis()),objectMapper.writeValueAsString(ftpcontrolereclamacoes), objectMapper.writeValueAsString(responseResponseEntity.getBody()));
        LogAppService.save(log);
        return responseResponseEntity;

    }

    @PutMapping( path = "/ftpcontrolereclamacoes" )
    public ResponseEntity<FtpControleReclamacoes> update(@RequestBody FtpControleReclamacoes ftpControleReclamacoes, HttpServletResponse response,@RequestHeader Map<String,String> headers) throws JsonProcessingException {
        
        ResponseEntity<FtpControleReclamacoes> responseResponseEntity;
        Optional<FtpControleReclamacoes> optionalFtpControleReclamacoes = Optional.of(new FtpControleReclamacoes());
        
        if(ftpControleReclamacoes != null && ftpControleReclamacoes.getItem() != null && !(ftpControleReclamacoes.getItem().isEmpty()) ) {
            optionalFtpControleReclamacoes =  ftpControleReclamacoesService.getById(ftpControleReclamacoes.getItem() );
            log.setRequest( objectMapper.writeValueAsString(optionalFtpControleReclamacoes.get()));

            ftpControleReclamacoesService.save(ftpControleReclamacoes);
            publisher.publishEvent(new StringResourceCreatedEvent(this, response, ftpControleReclamacoes.getItem()));
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(ftpControleReclamacoes);

        }
        else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ftpControleReclamacoes);
        }

        log.setObject( headers.get("authorization").replace("Bearer ",""),
            new java.sql.Date(System.currentTimeMillis()), "PostMapping /ftpcontrolereclamacoes", new Time(System.currentTimeMillis()),objectMapper.writeValueAsString(ftpControleReclamacoes), objectMapper.writeValueAsString(responseResponseEntity.getBody()));
        LogAppService.save(log);
        return responseResponseEntity;

    }

    @DeleteMapping( path = "/ftpcontrolereclamacoes/{item}" )
    public ResponseEntity<FtpControleReclamacoes> delete(@PathVariable String item ,@RequestHeader Map<String,String> headers ) throws JsonProcessingException {

        ResponseEntity<FtpControleReclamacoes> responseResponseEntity;

        Optional<FtpControleReclamacoes> optionalFtpControleReclamacoes = ftpControleReclamacoesService.findById(item);

        if ( optionalFtpControleReclamacoes.isPresent() ) {

            ftpControleReclamacoesService.delete(optionalFtpControleReclamacoes.get());
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(null);

        }
        else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return responseResponseEntity;

    }
}


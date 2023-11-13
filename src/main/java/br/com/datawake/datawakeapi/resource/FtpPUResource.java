package br.com.datawake.datawakeapi.resource;

import br.com.datawake.datawakeapi.event.StringResourceCreatedEvent;
import br.com.datawake.datawakeapi.model.FtpPu;
import br.com.datawake.datawakeapi.model.logApp;
import br.com.datawake.datawakeapi.service.FtpPUService;
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
public class FtpPUResource {

    @Autowired
    private FtpPUService ftpPUService;

    private final static ObjectMapper objectMapper = new ObjectMapper();
    private final static logApp log = new logApp();

    @Autowired
    private logAppService LogAppService ;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping( path = "/ftppu/{produto}" )
    public ResponseEntity<FtpPu> byIdFtp(@PathVariable String produto,@RequestHeader Map<String,String> headers) throws JsonProcessingException {

        ResponseEntity<FtpPu> responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        Optional<FtpPu> optionalFtpPu = ftpPUService.getById(produto);

        if ( optionalFtpPu.isPresent()){
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(optionalFtpPu.get());
        }

        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "GetMapping /ftppu/{produto}", new Time(System.currentTimeMillis()),"CONSULTA DE ID "+produto, objectMapper.writeValueAsString(responseResponseEntity.getBody()));
        LogAppService.save(log);
        return responseResponseEntity;

    }

    @GetMapping( path = "/ftppu" )
    public ResponseEntity<Page<FtpPu>> all( Pageable pageable ,@RequestHeader Map<String,String> headers ) throws JsonProcessingException {
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "GetMapping /ftppu", new Time(System.currentTimeMillis()),"CONSULTA GERAL DE PU", objectMapper.writeValueAsString(ftpPUService.findAll(pageable)));
        LogAppService.save(log);
        return ResponseEntity.status(HttpStatus.OK).body(ftpPUService.findAll(pageable));
    }

    @PostMapping( path = "/ftppu" )
    public ResponseEntity<FtpPu> create(@RequestBody FtpPu ftppu, HttpServletResponse response , @RequestHeader Map<String,String> headers) throws JsonProcessingException {

        ResponseEntity<FtpPu> responseResponseEntity;

        ftpPUService.save(ftppu);

        if ( ftppu != null && ftppu.getProduto() != "" ) {

            publisher.publishEvent(new StringResourceCreatedEvent(this, response, ftppu.getProduto()));
            responseResponseEntity = ResponseEntity.status(HttpStatus.CREATED).body(ftppu);

        }
        else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ftppu);
        }
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "PostMapping /ftppu", new Time(System.currentTimeMillis()),objectMapper.writeValueAsString(ftppu), objectMapper.writeValueAsString(responseResponseEntity.getBody()));
        LogAppService.save(log);
        return responseResponseEntity;

    }

    @PutMapping( path = "/ftppu" )
    public ResponseEntity<FtpPu> update( @RequestBody FtpPu ftppu, HttpServletResponse response  ,@RequestHeader Map<String,String> headers) throws JsonProcessingException {

        ResponseEntity<FtpPu> responseResponseEntity;
        Optional<FtpPu> optionalFtpPu = Optional.of(new FtpPu());

        if ( ftppu != null && ftppu.getProduto() != null && !(ftppu.getProduto().isEmpty()) ) {
            optionalFtpPu =  ftpPUService.getById(ftppu.getProduto() );
            log.setRequest( objectMapper.writeValueAsString(optionalFtpPu.get()));

            ftpPUService.save(ftppu);
            publisher.publishEvent(new StringResourceCreatedEvent(this, response, ftppu.getProduto()));
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(ftppu);

        }
        else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ftppu);
        }

        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "PostMapping /ftppu", new Time(System.currentTimeMillis()),objectMapper.writeValueAsString(ftppu), objectMapper.writeValueAsString(responseResponseEntity.getBody()));
        LogAppService.save(log);
        return responseResponseEntity;

    }

    @DeleteMapping( path = "/ftppu/{produto}" )
    public ResponseEntity<FtpPu> delete(@PathVariable String produto ,@RequestHeader Map<String,String> headers ) throws JsonProcessingException {

        ResponseEntity<FtpPu> responseResponseEntity;

        Optional<FtpPu> optionalFtpPu = ftpPUService.findById(produto);

        if ( optionalFtpPu.isPresent() ) {

            ftpPUService.delete(optionalFtpPu.get());
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(null);

        }
        else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "DeleteMapping /ftppu/{produto}", new Time(System.currentTimeMillis()),"DELETE DE ID : "+produto, objectMapper.writeValueAsString(responseResponseEntity));
        LogAppService.save(log);
        return responseResponseEntity;

    }

}

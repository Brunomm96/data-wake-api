package br.com.datawake.datawakeapi.resource;

import br.com.datawake.datawakeapi.event.ResourceCreatedEvent;
import br.com.datawake.datawakeapi.model.FtpFluxoDeCaixa;
import br.com.datawake.datawakeapi.model.FtpMangueiras;
import br.com.datawake.datawakeapi.model.logApp;
import br.com.datawake.datawakeapi.service.FtpFluxoDeCaixaService;
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
public class FtpFluxoDeCaixaResource {

    public FtpFluxoDeCaixaResource(FtpFluxoDeCaixaService ftpFluxoDeCaixaService, ApplicationEventPublisher publisher, ObjectMapper objectMapper, logAppService logAppService) {
        this.ftpFluxoDeCaixaService = ftpFluxoDeCaixaService;
        this.publisher = publisher;
        this.objectMapper = objectMapper;
        LogAppService = logAppService;
    }

    private final FtpFluxoDeCaixaService ftpFluxoDeCaixaService;

    private final ApplicationEventPublisher publisher;

    private final ObjectMapper objectMapper;
    private final static logApp log = new logApp();

    private final logAppService LogAppService ;

    @GetMapping( path = "/ftpfluxodecaixa/{idFtp)" )
    public ResponseEntity<FtpFluxoDeCaixa> byIdFtp(@PathVariable Long idFtp, @RequestHeader Map<String,String> headers) throws JsonProcessingException {

        ResponseEntity<FtpFluxoDeCaixa> responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        Optional<FtpFluxoDeCaixa> optionalFtpMangueiras = ftpFluxoDeCaixaService.getById(idFtp);

        if ( optionalFtpMangueiras.isPresent() ) {
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(optionalFtpMangueiras.get());
        }
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "GetMapping /ftpmangueiraspec/{idFtp}", new Time(System.currentTimeMillis()),"CONSULTA DE ID "+idFtp.toString(), objectMapper.writeValueAsString(responseResponseEntity.getBody()));
        LogAppService.save(log);
        return responseResponseEntity;

    }

    @GetMapping( path = "/ftpfluxodecaixa" )
    public ResponseEntity<Page<FtpFluxoDeCaixa>> all(Pageable pageable , @RequestHeader Map<String,String> headers ) throws JsonProcessingException {
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "GetMapping /ftpmangueiraspec", new Time(System.currentTimeMillis()),"CONSULTA GERAL DE Mangueira", objectMapper.writeValueAsString(ftpFluxoDeCaixaService.findAll(pageable)));
        LogAppService.save(log);
        return ResponseEntity.status(HttpStatus.OK).body(ftpFluxoDeCaixaService.findAll(pageable));
    }

    @PostMapping( path = "/ftpfluxodecaixa" )
    public ResponseEntity<FtpFluxoDeCaixa> create(@RequestBody FtpFluxoDeCaixa ftpFluxoDeCaixa, HttpServletResponse response , @RequestHeader Map<String,String> headers ) throws JsonProcessingException {

        ResponseEntity<FtpFluxoDeCaixa> responseResponseEntity;

        ftpFluxoDeCaixa.setId(null);
        ftpFluxoDeCaixaService.save(ftpFluxoDeCaixa);

        if ( ftpFluxoDeCaixa != null && ftpFluxoDeCaixa.getId() != null ) {

            publisher.publishEvent(new ResourceCreatedEvent(this, response, ftpFluxoDeCaixa.getId()));
            responseResponseEntity = ResponseEntity.status(HttpStatus.CREATED).body(ftpFluxoDeCaixa);

        }
        else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ftpFluxoDeCaixa);
        }
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "PostMapping /ftpmangueiraspec", new Time(System.currentTimeMillis()),objectMapper.writeValueAsString(ftpFluxoDeCaixa), objectMapper.writeValueAsString(responseResponseEntity.getBody()));
        LogAppService.save(log);
        return responseResponseEntity;

    }

    @PutMapping( path = "/ftpfluxodecaixa" )
    public ResponseEntity<FtpFluxoDeCaixa> update( @RequestBody FtpFluxoDeCaixa ftpFluxoDeCaixa, HttpServletResponse response ,@RequestHeader Map<String,String> headers ) throws JsonProcessingException {

        ResponseEntity<FtpFluxoDeCaixa> responseResponseEntity;
        Optional<FtpFluxoDeCaixa> optionalFtpFluxoDeCaixa= Optional.of(new FtpFluxoDeCaixa());

        if ( ftpFluxoDeCaixa != null && ftpFluxoDeCaixa.getId() != null && ftpFluxoDeCaixa.getId() > 0 ) {
            optionalFtpFluxoDeCaixa =  ftpFluxoDeCaixaService.getById(ftpFluxoDeCaixa.getId() );
            log.setRequest( objectMapper.writeValueAsString(optionalFtpFluxoDeCaixa.get()));
            ftpFluxoDeCaixaService.save(ftpFluxoDeCaixa);
            publisher.publishEvent(new ResourceCreatedEvent(this, response, ftpFluxoDeCaixa.getId()));
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(ftpFluxoDeCaixa);

        }
        else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ftpFluxoDeCaixa);
        }
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "PutMapping /ftpmangueiraspec", new Time(System.currentTimeMillis()),objectMapper.writeValueAsString(optionalFtpFluxoDeCaixa.get()), objectMapper.writeValueAsString(responseResponseEntity.getBody()));
        LogAppService.save(log);
        return responseResponseEntity;

    }

    @DeleteMapping( path = "/ftpfluxodecaixa/{id}" )
    public ResponseEntity<FtpFluxoDeCaixa> delete(@PathVariable Long id ,@RequestHeader Map<String,String> headers ) throws JsonProcessingException {

        ResponseEntity<FtpFluxoDeCaixa> responseResponseEntity;

        Optional<FtpFluxoDeCaixa> ftpFluxoDeCaixaOptional = ftpFluxoDeCaixaService.findById(id);

        if ( ftpFluxoDeCaixaOptional.isPresent() ) {

            ftpFluxoDeCaixaService.delete(ftpFluxoDeCaixaOptional.get());
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

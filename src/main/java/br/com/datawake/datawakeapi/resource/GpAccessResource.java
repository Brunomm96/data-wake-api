package br.com.datawake.datawakeapi.resource;

import br.com.datawake.datawakeapi.event.ResourceCreatedEvent;
import br.com.datawake.datawakeapi.model.FtpGaiolas;
import br.com.datawake.datawakeapi.model.GpAccess;
import br.com.datawake.datawakeapi.model.logApp;
import br.com.datawake.datawakeapi.service.GpAccessService;
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
public class GpAccessResource {
    private final static ObjectMapper objectMapper = new ObjectMapper();
    private final static logApp log = new logApp();

    @Autowired
    private logAppService LogAppService ;

    @Autowired
    private GpAccessService gpAccessService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping( path = "/gpaccess/{id}" )
    public ResponseEntity<GpAccess> byIdFtp(@PathVariable Long id,@RequestHeader Map<String,String> headers) throws JsonProcessingException {

        ResponseEntity<GpAccess> responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        Optional<GpAccess> optionalGpAccess = gpAccessService.getById(id);

        if ( optionalGpAccess.isPresent()){
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(optionalGpAccess.get());
        }
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "GetMapping /gpaccess/{id}", new Time(System.currentTimeMillis()),"CONSULTA DE ID "+id, objectMapper.writeValueAsString(responseResponseEntity.getBody()));
        LogAppService.save(log);

        return responseResponseEntity;

    }

    @GetMapping( path = "/gpaccess" )
    public ResponseEntity<Page<GpAccess>> all( Pageable pageable  ,@RequestHeader Map<String,String> headers) throws JsonProcessingException {
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "GetMapping /gpaccess", new Time(System.currentTimeMillis()),"CONSULTA GERAL DE GAIOLAS", objectMapper.writeValueAsString(gpAccessService.findAll(pageable)));
        LogAppService.save(log);
        return ResponseEntity.status(HttpStatus.OK).body(gpAccessService.findAll(pageable));
    }

    @PostMapping( path = "/gpaccess" )
    public ResponseEntity<GpAccess> create(@RequestBody GpAccess gpAccess, HttpServletResponse response  , @RequestHeader Map<String,String> headers) throws JsonProcessingException {

        ResponseEntity<GpAccess> responseResponseEntity;

        gpAccessService.save(gpAccess);

        if ( gpAccess != null && gpAccess.getId() != 0 ) {

            publisher.publishEvent(new ResourceCreatedEvent(this, response, gpAccess.getId()));
            responseResponseEntity = ResponseEntity.status(HttpStatus.CREATED).body(gpAccess);

        }
        else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(gpAccess);
        }
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "PostMapping /gpaccess", new Time(System.currentTimeMillis()),objectMapper.writeValueAsString(gpAccess), objectMapper.writeValueAsString(responseResponseEntity.getBody()));
        LogAppService.save(log);

        return responseResponseEntity;

    }

    @PutMapping( path = "/gpaccess" )
    public ResponseEntity<GpAccess> update( @RequestBody GpAccess gpAccess, HttpServletResponse response ,@RequestHeader Map<String,String> headers) throws JsonProcessingException {

        ResponseEntity<GpAccess> responseResponseEntity;
        Optional<GpAccess> optionalGpAccess = Optional.of(new GpAccess());

        if ( gpAccess != null && gpAccess.getId() > 0  ) {
            optionalGpAccess =  gpAccessService.getById(gpAccess.getId() );
            log.setRequest( objectMapper.writeValueAsString(optionalGpAccess.get()));
            gpAccessService.save(gpAccess);
            publisher.publishEvent(new ResourceCreatedEvent(this, response, gpAccess.getId()));
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(gpAccess);

        }
        else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(gpAccess);
        }
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "PutMapping /gpaccess", new Time(System.currentTimeMillis()),objectMapper.writeValueAsString(optionalGpAccess.get()), objectMapper.writeValueAsString(responseResponseEntity.getBody()));
        LogAppService.save(log);
        return responseResponseEntity;

    }

    @DeleteMapping( path = "/gpaccess/{id}" )
    public ResponseEntity<String> delete(@PathVariable Long id,@RequestHeader Map<String,String> headers  ) throws JsonProcessingException {

        ResponseEntity<String> responseResponseEntity;


        Optional<GpAccess> optionalGpAccess = gpAccessService.findById(id);

        if ( optionalGpAccess.isPresent() ) {
            try {
                gpAccessService.delete(optionalGpAccess.get().getId());
                responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(null);
            } catch (Exception ex) {
                responseResponseEntity = ResponseEntity.status(HttpStatus.CONFLICT).body("Verifique se o grupo que deseja excluir, não se encontra vinculado a colaboradores. erro: " + ex.getMessage());
            }
        }
        else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "DeleteMapping /gpaccess/{id}", new Time(System.currentTimeMillis()),"DELETE DE ID : "+id, objectMapper.writeValueAsString(responseResponseEntity));
        LogAppService.save(log);
        return responseResponseEntity;

    }

}

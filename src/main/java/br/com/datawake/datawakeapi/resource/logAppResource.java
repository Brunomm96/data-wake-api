package br.com.datawake.datawakeapi.resource;

import br.com.datawake.datawakeapi.event.ResourceCreatedEvent;
import br.com.datawake.datawakeapi.model.logApp;
import br.com.datawake.datawakeapi.service.logAppService;
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
public class logAppResource {

    @Autowired
    private logAppService LogAppService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping( path = "/logapp/{id}" )
    public ResponseEntity<logApp> byIdFtp(@PathVariable Long idFtp) {

        ResponseEntity<logApp> responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        Optional<logApp> optionallogApp = LogAppService.getById(idFtp);

        if ( optionallogApp.isPresent() ) {
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(optionallogApp.get());
        }

        return responseResponseEntity;

    }

    @GetMapping( path = "/logapp" )
    public ResponseEntity<Page<logApp>> all( Pageable pageable ) {
        return ResponseEntity.status(HttpStatus.OK).body(LogAppService.findAll(pageable));
    }

    @PostMapping( path = "/logapp" )
    public ResponseEntity<logApp> create(@RequestBody logApp LogApp, HttpServletResponse response ) {

        ResponseEntity<logApp> responseResponseEntity;

        LogApp.setId(null);
        LogAppService.save(LogApp);

        if ( LogApp != null && LogApp.getId() != null ) {

            publisher.publishEvent(new ResourceCreatedEvent(this, response, LogApp.getId()));
            responseResponseEntity = ResponseEntity.status(HttpStatus.CREATED).body(LogApp);

        }
        else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(LogApp);
        }

        return responseResponseEntity;

    }

    @PutMapping( path = "/logapp" )
    public ResponseEntity<logApp> update( @RequestBody logApp LogApp, HttpServletResponse response ) {

        ResponseEntity<logApp> responseResponseEntity;

        if ( LogApp != null && LogApp.getId() != null && LogApp.getId() > 0 ) {

            LogAppService.save(LogApp);
            publisher.publishEvent(new ResourceCreatedEvent(this, response, LogApp.getId()));
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(LogApp);

        }
        else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(LogApp);
        }

        return responseResponseEntity;

    }

    @DeleteMapping( path = "/logapp/{id}" )
    public ResponseEntity<logApp> delete(@PathVariable Long id ) {

        ResponseEntity<logApp> responseResponseEntity;

        Optional<logApp> optionallogApp = LogAppService.findById(id);

        if ( optionallogApp.isPresent() ) {

            LogAppService.delete(optionallogApp.get());
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(null);

        }
        else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return responseResponseEntity;

    }

}

package br.com.datawake.datawakeapi.resource;

import br.com.datawake.datawakeapi.event.ResourceCreatedEvent;
import br.com.datawake.datawakeapi.model.FtpHidrante;
import br.com.datawake.datawakeapi.service.FtpHidranteService;
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
public class FtpHidranteResource {

    @Autowired
    private FtpHidranteService ftpHidranteService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping( path = "/ftphidrante/{idFtp}" )
    public ResponseEntity<FtpHidrante> byIdFtp(@PathVariable Long idFtp){

        ResponseEntity<FtpHidrante> responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        Optional<FtpHidrante> optionalFtpHidrante = ftpHidranteService.getById(idFtp);

        if(optionalFtpHidrante.isPresent()){
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(optionalFtpHidrante.get());
        }
        return responseResponseEntity;
    }

    @GetMapping( path = "/ftphidrante")
    public ResponseEntity<Page<FtpHidrante>> all(Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(ftpHidranteService.findAll(pageable));
    }



    @PostMapping( path = "/ftphidrante")
    public ResponseEntity<FtpHidrante> create(@RequestBody FtpHidrante ftpHidrante, HttpServletResponse response){

        ResponseEntity<FtpHidrante> responseResponseEntity;

        ftpHidrante.setId(null);
        ftpHidranteService.save(ftpHidrante);

        if(ftpHidrante != null && ftpHidrante.getId() != null){
            publisher.publishEvent(new ResourceCreatedEvent(this, response, ftpHidrante.getId()));
            responseResponseEntity = ResponseEntity.status(HttpStatus.CREATED).body(ftpHidrante);
        }else{
            responseResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ftpHidrante);
        }
        return responseResponseEntity;
    }

    @PutMapping( path = "/ftphidrante")
    public ResponseEntity<FtpHidrante> update(@RequestBody FtpHidrante ftpHidrante, HttpServletResponse response){
        ResponseEntity<FtpHidrante> responseResponseEntity;
        if(ftpHidrante != null && ftpHidrante.getId() != null && ftpHidrante.getId() > 0){
            ftpHidranteService.save(ftpHidrante);
            publisher.publishEvent(new ResourceCreatedEvent(this, response, ftpHidrante.getId()));
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(ftpHidrante);

        }
        else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ftpHidrante);
        }

        return responseResponseEntity;
    }

    @DeleteMapping( path = "/ftphidrante/{id}")
    public ResponseEntity<FtpHidrante> delete(@PathVariable Long id ) {

        ResponseEntity<FtpHidrante> responseResponseEntity;

        Optional<FtpHidrante> optionalFtpHidrante = ftpHidranteService.findById(id);

        if ( optionalFtpHidrante.isPresent() ) {

            ftpHidranteService.delete(optionalFtpHidrante.get());
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(null);

        }
        else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return responseResponseEntity;

    }
}

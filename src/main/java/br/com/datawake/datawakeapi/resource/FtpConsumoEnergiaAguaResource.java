package br.com.datawake.datawakeapi.resource;

import br.com.datawake.datawakeapi.event.ResourceCreatedEvent;
import br.com.datawake.datawakeapi.model.FtpConsumoEnergiaAgua;
import br.com.datawake.datawakeapi.repository.FtpConsumoEnergiaAguaRepository;
import br.com.datawake.datawakeapi.service.FtpConsumoEnergiaAguaService;
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
@RequestMapping ("/api/v1")

public class FtpConsumoEnergiaAguaResource {
    @Autowired
    private FtpConsumoEnergiaAguaService ftpConsumoEnergiaAguaService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping ( path = " /ftpconsumoenergiaagua/{idFtp}" )
    public ResponseEntity<FtpConsumoEnergiaAgua> byIdFtp(@PathVariable Long idFtp){

        ResponseEntity<FtpConsumoEnergiaAgua> responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        Optional<FtpConsumoEnergiaAgua> optionalFtpConsumoEnergiaAgua = ftpConsumoEnergiaAguaService.getById(idFtp);

        if(optionalFtpConsumoEnergiaAgua.isPresent()){
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body((FtpConsumoEnergiaAgua) optionalFtpConsumoEnergiaAgua.get());
        }

        return responseResponseEntity;
    }

    @GetMapping( path = "/ftpconsumoenergiaagua" )
    public ResponseEntity<Page<FtpConsumoEnergiaAgua>> all(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(ftpConsumoEnergiaAguaService.findAll(pageable));
    }
    @PostMapping(path = "/ftpconsumoenergiaagua")
    public ResponseEntity<FtpConsumoEnergiaAgua> create (@RequestBody FtpConsumoEnergiaAgua ftpConsumoEnergiaAgua, HttpServletResponse response){

            ResponseEntity<FtpConsumoEnergiaAgua> responseResponseEntity;
            ftpConsumoEnergiaAgua.setId(null);
            ftpConsumoEnergiaAguaService.save(ftpConsumoEnergiaAgua);
            if (ftpConsumoEnergiaAgua != null && ftpConsumoEnergiaAgua.getId() != null) {

                publisher.publishEvent(new ResourceCreatedEvent(this, response, ftpConsumoEnergiaAgua.getId()));
                responseResponseEntity = ResponseEntity.status(HttpStatus.CREATED).body(ftpConsumoEnergiaAgua);

            } else {
                responseResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ftpConsumoEnergiaAgua);

            }
            return responseResponseEntity;
    }
    @PutMapping(path = "/ftpconsumoenergiaagua")
    public ResponseEntity<FtpConsumoEnergiaAgua> update(@RequestBody FtpConsumoEnergiaAgua ftpConsumoEnergiaAgua, HttpServletResponse response){
            ResponseEntity<FtpConsumoEnergiaAgua> responseResponseEntity;

            if (ftpConsumoEnergiaAgua != null && ftpConsumoEnergiaAgua.getId() != null && ftpConsumoEnergiaAgua.getId() > 0) {
                ftpConsumoEnergiaAguaService.save(ftpConsumoEnergiaAgua);
                publisher.publishEvent(new ResourceCreatedEvent(this, response, ftpConsumoEnergiaAgua.getId()));
                responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(ftpConsumoEnergiaAgua);

            } else {
                responseResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ftpConsumoEnergiaAgua);
            }
            return responseResponseEntity;
    }

    @DeleteMapping(path = "/ftpconsumoenergiaagua/{id}")
    public ResponseEntity<FtpConsumoEnergiaAgua> delete (@PathVariable Long id) {
        ResponseEntity<FtpConsumoEnergiaAgua> responseResponseEntity;

        Optional<FtpConsumoEnergiaAgua> optionalFtpConsumoEnergiaAgua = ftpConsumoEnergiaAguaService.findById(id);

        if (optionalFtpConsumoEnergiaAgua.isPresent()) {

            ftpConsumoEnergiaAguaService.delete((FtpConsumoEnergiaAgua) optionalFtpConsumoEnergiaAgua.get());
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(null);

        } else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return responseResponseEntity;
    }
}

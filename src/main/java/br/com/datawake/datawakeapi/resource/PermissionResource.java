package br.com.datawake.datawakeapi.resource;

import br.com.datawake.datawakeapi.model.Permission;
import br.com.datawake.datawakeapi.model.logApp;
import br.com.datawake.datawakeapi.service.PermissionService;
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
import javax.validation.Valid;
import java.sql.Time;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class PermissionResource {

    private final static ObjectMapper objectMapper = new ObjectMapper();
    private final static logApp log = new logApp();

    @Autowired
    private logAppService LogAppService ;

    @Autowired
    private PermissionService permissionService;
    private ApplicationEventPublisher publisher;

    @GetMapping( path = "/permissions" )
    //@PreAuthorize("hasAuthority('ROLE_VIEW_USER')")
    public ResponseEntity<Page<Permission>> all(Pageable pageable,@RequestHeader Map<String,String> headers ) throws JsonProcessingException {
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "GetMapping /permissions", new Time(System.currentTimeMillis()),"CONSULTA GERAL DE PERMISSÃO", objectMapper.writeValueAsString(permissionService.findAll(pageable)));
        LogAppService.save(log);
        return ResponseEntity.status(HttpStatus.OK).body(permissionService.findAll(pageable));
    }

    @GetMapping( path = "/permissions/byId/{id}" )
   // @PreAuthorize("hasAuthority('ROLE_VIEW_USER')")
    public ResponseEntity<Permission> byId( @PathVariable Long id ,@RequestHeader Map<String,String> headers) throws JsonProcessingException {

        ResponseEntity<Permission> responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        Permission permission = new Permission();
        Optional<Permission> optionalPermission = permissionService.findById(id);

        if ( optionalPermission.isPresent() ) {

            permission = optionalPermission.get();
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(permission);

        }
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "GetMapping /permissions/byId/{id}", new Time(System.currentTimeMillis()),"CONSULTA DE ID "+id, objectMapper.writeValueAsString(responseResponseEntity.getBody()));
        LogAppService.save(log);
        return responseResponseEntity;

    }

    @PostMapping(path = "/permissions")
    // @PreAuthorize("hasAuthority('ROLE_VIEW_USER')")
    public ResponseEntity<Permission> create(@Valid @RequestBody Permission permission, HttpServletResponse response, @RequestHeader Map<String,String> headers ) throws Exception {

        ResponseEntity<Permission> responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        permission.setId(null);
        permissionService.save(permission);

        if (null == permission.getId()) {
            responseResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } else {

            responseResponseEntity = ResponseEntity.status(HttpStatus.CREATED).body(permission);

        }
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "PostMapping /permissions", new Time(System.currentTimeMillis()),objectMapper.writeValueAsString(permission), objectMapper.writeValueAsString(responseResponseEntity.getBody()));
        LogAppService.save(log);
        return responseResponseEntity;

    }

    @PutMapping(path = "/permissions")
    // @PreAuthorize("hasAuthority('ROLE_VIEW_USER')")
    public ResponseEntity<Permission> update(@Valid @RequestBody Permission permission, HttpServletResponse response,@RequestHeader Map<String,String> headers ) throws Exception {

        ResponseEntity<Permission> responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        Optional<Permission> optionalPermission = Optional.of(new Permission());
        optionalPermission =  permissionService.findById(permission.getId() );
        log.setRequest( objectMapper.writeValueAsString(optionalPermission.get()));
        permissionService.save(permission);

        if (null == permission.getId()) {
            responseResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } else {

            responseResponseEntity = ResponseEntity.status(HttpStatus.CREATED).body(permission);

        }

        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "PutMapping /permissions", new Time(System.currentTimeMillis()),objectMapper.writeValueAsString(optionalPermission.get()), objectMapper.writeValueAsString(responseResponseEntity.getBody()));
        LogAppService.save(log);

        return responseResponseEntity;

    }

    @DeleteMapping( path = "/permissions/{id}" )
    public ResponseEntity<String> delete(@PathVariable Long id ,@RequestHeader Map<String,String> headers) throws JsonProcessingException {

        ResponseEntity<String> responseResponseEntity;

        Optional<Permission> optionalPermission = permissionService.findById(id);

        if ( optionalPermission.isPresent() ) {
            try {
                permissionService.delete(optionalPermission.get());
                responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(null);
            } catch (Exception ex) {
                responseResponseEntity = ResponseEntity.status(HttpStatus.CONFLICT).body("Verifique se a permissão que deseja excluir, não se encontra vinculada com um grupo de acesso. erro: " + ex.getMessage());
            }
        }
        else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "DeleteMapping /permissions/{id}", new Time(System.currentTimeMillis()),"DELETE DE ID : "+id, objectMapper.writeValueAsString(responseResponseEntity));
        LogAppService.save(log);
        return responseResponseEntity;

    }
}

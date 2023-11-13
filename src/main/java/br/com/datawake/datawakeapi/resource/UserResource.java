package br.com.datawake.datawakeapi.resource;

import br.com.datawake.datawakeapi.event.ResourceCreatedEvent;
import br.com.datawake.datawakeapi.model.*;
import br.com.datawake.datawakeapi.service.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserResource {

    private final static ObjectMapper objectMapper = new ObjectMapper();
    private final static  logApp log = new logApp();

    @Autowired
    private logAppService LogAppService ;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private UserService userService;

    @Autowired
    private UserService_v2 userService_v2;

    @Autowired
    private PermissionService permissionService;
    //VERSÃO I DOS MÉTODOS DE USUÁRIOS
    @GetMapping( path = "/v1/users" )
   // @PreAuthorize("hasAuthority('ROLE_VIEW_USER')")
    public ResponseEntity<Page<UserAppResponse>> all(Pageable pageable ,@RequestHeader Map<String,String> headers) throws JsonProcessingException {
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "GetMapping /v1/users", new Time(System.currentTimeMillis()),"CONSULTA GERAL DE GAIOLAS", objectMapper.writeValueAsString(userService.findAll(pageable)));
        LogAppService.save(log);
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAllResume(pageable));
    }

    @GetMapping( path = "/v1/users/permissionsById/{id}" )
    //@PreAuthorize("hasAuthority('ROLE_VIEW_USER')")
    public ResponseEntity<List<Permission>> permissionsById(@PathVariable Long id,@RequestHeader Map<String,String> headers ) throws JsonProcessingException {

        ResponseEntity<List<Permission>> responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        List<Permission> permissions = new ArrayList<Permission>();
        UserApp user = new UserApp();
        Optional<UserApp> optionalUserApp = userService.findById(id);

        if ( optionalUserApp.isPresent() ) {

            user = optionalUserApp.get();
            permissions.addAll( user.getPermission() );
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(permissions);

        }
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "GetMapping /v1/users/permissionsById/{id}", new Time(System.currentTimeMillis()),"CONSULTA DE ID "+id, objectMapper.writeValueAsString(responseResponseEntity.getBody()));
        LogAppService.save(log);
        return responseResponseEntity;

    }

    @GetMapping( path = "/v1/users/permissionsByEmail/{email}" )
    public ResponseEntity<List<Permission>> permissionsByEmail(@PathVariable String email ,@RequestHeader Map<String,String> headers ) throws JsonProcessingException {

        ResponseEntity<List<Permission>> responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        List<Permission> permissions = new ArrayList<Permission>();
        UserApp user = new UserApp();
        Optional<UserApp> optionalUserApp = userService.findByEmail(email);

        if ( optionalUserApp.isPresent() ) {

            user = optionalUserApp.get();
            permissions.addAll( user.getPermission() );
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(permissions);

        }
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "GetMapping /v1/users/permissionsByEmail/{email}", new Time(System.currentTimeMillis()),"CONSULTA DE ID "+email, objectMapper.writeValueAsString(responseResponseEntity.getBody()));
        LogAppService.save(log);
        return responseResponseEntity;

    }
    @GetMapping( path = "/v1/users/byId/{id}" )
    //@PreAuthorize("hasAuthority('ROLE_VIEW_USER')")
    public ResponseEntity<UserApp>  byId( @PathVariable Long id,@RequestHeader Map<String,String> headers ) throws JsonProcessingException {

        ResponseEntity<UserApp> responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        UserApp user = new UserApp();
        Optional<UserApp> optionalUserApp = userService.findById(id);

        if ( optionalUserApp.isPresent() ) {

            user = optionalUserApp.get();
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(user);

        }
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "GetMapping /v1/users/byId/{id}", new Time(System.currentTimeMillis()),"CONSULTA DE ID "+id, objectMapper.writeValueAsString(responseResponseEntity.getBody()));
        LogAppService.save(log);
        return responseResponseEntity;

    }

    @GetMapping( path = "/v1/users/byEmail/{email}" )
    //@PreAuthorize("hasAuthority('ROLE_VIEW_USER')")
    public ResponseEntity<UserApp>  byEmail( @PathVariable String email,@RequestHeader Map<String,String> headers ) throws JsonProcessingException {

        ResponseEntity<UserApp> responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        UserApp user = new UserApp();
        Optional<UserApp> optionalUserApp = userService.findByEmail(email);

        if ( optionalUserApp.isPresent() ) {

            user = optionalUserApp.get();
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(user);

        }
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "GetMapping /v1/users/byEmail/{email}", new Time(System.currentTimeMillis()),"CONSULTA DE ID "+email, objectMapper.writeValueAsString(responseResponseEntity.getBody()));
        LogAppService.save(log);
        return responseResponseEntity;

    }

    @PostMapping( path = "/v1/users" )
    //@PreAuthorize("hasAuthority('ROLE_INSERT_USER')")
    public ResponseEntity<UserApp> create(@Valid @RequestBody UserApp user, HttpServletResponse response ,@RequestHeader Map<String,String> headers) throws Exception {

        ResponseEntity<UserApp> responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        UserApp newUserApp = null;

        user.setId(null); // garante que sera uma inclusao

        // TODO temporario ate o desenv do portal
        // Os usuarios que são criados estão recebendo todas as premissoes
        user.setPermission( user.getPermission() );
        user.setFirstAccess(null);
        newUserApp = userService.save(user);

        if ( newUserApp != null && newUserApp.getId() != null ) {

            publisher.publishEvent(new ResourceCreatedEvent(this, response, newUserApp.getId()));
            responseResponseEntity = ResponseEntity.status(HttpStatus.CREATED).body(newUserApp);

        }
        else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(newUserApp);
        }

        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "PostMapping /v1/users", new Time(System.currentTimeMillis()),objectMapper.writeValueAsString(user), objectMapper.writeValueAsString(responseResponseEntity.getBody()));
        LogAppService.save(log);
        return responseResponseEntity;

    }

    @PutMapping( path = "/v1/users" )
    //@PreAuthorize("hasAuthority('ROLE_UPDATE_USER')")
    public ResponseEntity<UserApp> update( @RequestBody UserApp user, HttpServletResponse response ,@RequestHeader Map<String,String> headers) throws Exception {

        ResponseEntity<UserApp> responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);


        if ( user != null && user.getId() != null ) {

            Optional<UserApp> optionalUserApp = userService.findById(user.getId());

            if ( optionalUserApp.isPresent() ) {
                log.setRequest( objectMapper.writeValueAsString(optionalUserApp.get()));
                userService.save(user);
                publisher.publishEvent(new ResourceCreatedEvent(this, response, user.getId()));
                responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(user);

            }
            log.setObject( headers.get("authorization").replace("Bearer ",""),
                    new java.sql.Date(System.currentTimeMillis()), "PutMapping /v1/users", new Time(System.currentTimeMillis()),objectMapper.writeValueAsString(optionalUserApp.get()), objectMapper.writeValueAsString(responseResponseEntity.getBody()));
            LogAppService.save(log);
        }

        return responseResponseEntity;

    }
    @PutMapping( path = "/v1/users/edit" )
    //@PreAuthorize("hasAuthority('ROLE_UPDATE_USER')")
    public ResponseEntity<UserApp> saveUpdate( @RequestBody UserApp user, HttpServletResponse response ,@RequestHeader Map<String,String> headers) throws Exception {

        ResponseEntity<UserApp> responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        if ( user != null && user.getId() != null ) {

            Optional<UserApp> optionalUserApp = userService.findById(user.getId());

            if ( optionalUserApp.isPresent() ) {

                log.setRequest( objectMapper.writeValueAsString(optionalUserApp.get()));
                //crio um novo objeto para setar o nome e email para não perder a senha.
                UserApp userAppCurrent = optionalUserApp.get();

                userAppCurrent.setEmail(user.getEmail());
                userAppCurrent.setName(user.getName());

                userService.saveUpdate(userAppCurrent);
                publisher.publishEvent(new ResourceCreatedEvent(this, response, user.getId()));
                responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(user);

            }
            log.setObject( headers.get("authorization").replace("Bearer ",""),
                    new java.sql.Date(System.currentTimeMillis()), "PutMapping /v1/users/edit", new Time(System.currentTimeMillis()),objectMapper.writeValueAsString(optionalUserApp.get()), objectMapper.writeValueAsString(responseResponseEntity.getBody()));
            LogAppService.save(log);
        }


        return responseResponseEntity;

    }

    @DeleteMapping( path = "/v1/users/{id}" )
    public ResponseEntity<UserApp> delete( @PathVariable Long id,@RequestHeader Map<String,String> headers ) throws JsonProcessingException {

        ResponseEntity<UserApp> responseResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        boolean isDeleted = userService.delete( id );

        if ( isDeleted )
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(null);

            log.setObject( headers.get("authorization").replace("Bearer ",""),
                    new java.sql.Date(System.currentTimeMillis()), "DeleteMapping /v1/users/{id}", new Time(System.currentTimeMillis()),"DELETE DE ID : "+id, objectMapper.writeValueAsString(responseResponseEntity));
            LogAppService.save(log);
        return responseResponseEntity;
    }

@GetMapping( path = "/v2/users" )
// @PreAuthorize("hasAuthority('ROLE_VIEW_USER')")
public ResponseEntity<Page<UserAppResponse>> uppall(Pageable pageable ,@RequestHeader Map<String,String> headers) throws JsonProcessingException {
    log.setObject( headers.get("authorization").replace("Bearer ",""),
            new java.sql.Date(System.currentTimeMillis()), "GetMapping /v2/users", new Time(System.currentTimeMillis()),"CONSULTA GERAL DE USUÁRIOS", objectMapper.writeValueAsString(userService.findAll(pageable)));
    LogAppService.save(log);
    return ResponseEntity.status(HttpStatus.OK).body(userService.findAllResume(pageable));
}
    @GetMapping( path = "/v2/users/groupById/{id}" )
    //@PreAuthorize("hasAuthority('ROLE_VIEW_USER')")
    public ResponseEntity<List<GpAccess>> groupById(@PathVariable Long id ,@RequestHeader Map<String,String> headers) throws JsonProcessingException {

        ResponseEntity<List<GpAccess>> responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        List<GpAccess> groups = new ArrayList<GpAccess>();
        UserApp_v2 user = new UserApp_v2();
        Optional<UserApp_v2> optionalUserApp = userService_v2.findById(id);

        if ( optionalUserApp.isPresent() ) {

            user = optionalUserApp.get();
            groups.addAll( user.getGpAccess() );
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(groups);

        }
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "GetMapping /v2/users/groupById/{id}", new Time(System.currentTimeMillis()),"CONSULTA DE ID "+id, objectMapper.writeValueAsString(responseResponseEntity.getBody()));
        LogAppService.save(log);
        return responseResponseEntity;

    }

    @GetMapping( path = "/v2/users/groupsByEmail/{email}" )
    public ResponseEntity<List<GpAccess>> groupsByEmail(@PathVariable String email ,@RequestHeader Map<String,String> headers) throws JsonProcessingException {

        ResponseEntity<List<GpAccess>> responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        List<GpAccess> gpAccesses = new ArrayList<GpAccess>();
        UserApp_v2 user = new UserApp_v2();
        Optional<UserApp_v2> optionalUserApp = userService_v2.findByEmail(email);

        if ( optionalUserApp.isPresent() ) {

            user = optionalUserApp.get();
            gpAccesses.addAll( user.getGpAccess() );
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(gpAccesses);

        }
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "GetMapping /v2/users/groupsByEmail/{email}", new Time(System.currentTimeMillis()),"CONSULTA DE ID "+email, objectMapper.writeValueAsString(responseResponseEntity.getBody()));
        LogAppService.save(log);
        return responseResponseEntity;

    }

    @GetMapping( path = "/v2/users/byId/{id}" )
    public ResponseEntity<UserApp_v2>  uppbyId( @PathVariable Long id,@RequestHeader Map<String,String> headers ) throws JsonProcessingException {

        ResponseEntity<UserApp_v2> responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        UserApp_v2 user = new UserApp_v2();
        Optional<UserApp_v2> optionalUserApp = userService_v2.findById(id);

        if ( optionalUserApp.isPresent() ) {

            user = optionalUserApp.get();
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(user);

        }
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "GetMapping /v2/users/byId/{id}", new Time(System.currentTimeMillis()),"CONSULTA DE ID "+id, objectMapper.writeValueAsString(responseResponseEntity.getBody()));
        LogAppService.save(log);
        return responseResponseEntity;

    }

    @GetMapping( path = "/v2/users/byEmail/{email}" )
    public ResponseEntity<UserApp_v2>  uppbyEmail( @PathVariable String email ,@RequestHeader Map<String,String> headers) throws JsonProcessingException {

        ResponseEntity<UserApp_v2> responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        UserApp_v2 user = new UserApp_v2();
        Optional<UserApp_v2> optionalUserApp = userService_v2.findByEmail(email);

        if ( optionalUserApp.isPresent() ) {

            user = optionalUserApp.get();
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(user);

        }
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "GetMapping /v2/users/byEmail/{email}", new Time(System.currentTimeMillis()),"CONSULTA DE ID "+email, objectMapper.writeValueAsString(responseResponseEntity.getBody()));
        LogAppService.save(log);
        return responseResponseEntity;

    }

    @PostMapping( path = "/v2/users" )
    public ResponseEntity<UserApp_v2> uppcreate(@Valid @RequestBody UserApp_v2 user, HttpServletResponse response ,@RequestHeader Map<String,String> headers) throws Exception {

        ResponseEntity<UserApp_v2> responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        UserApp_v2 newUserApp = null;

        user.setId(null); // garante que sera uma inclusao

        // Os usuarios que são criados estão recebendo todas as premissoes
        user.setGpAccess( user.getGpAccess() );
        user.setFirstAccess(null);
        newUserApp = userService_v2.save(user);

        if ( newUserApp != null && newUserApp.getId() != null ) {

            publisher.publishEvent(new ResourceCreatedEvent(this, response, newUserApp.getId()));
            responseResponseEntity = ResponseEntity.status(HttpStatus.CREATED).body(newUserApp);

        }
        else {
            responseResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(newUserApp);
        }
        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "PostMapping /v2/users", new Time(System.currentTimeMillis()),objectMapper.writeValueAsString(user), objectMapper.writeValueAsString(responseResponseEntity.getBody()));
        LogAppService.save(log);
        return responseResponseEntity;

    }

    @PutMapping( path = "/v2/users" )
    public ResponseEntity<UserApp_v2> uppupdate( @RequestBody UserApp_v2 user, HttpServletResponse response ,@RequestHeader Map<String,String> headers) throws Exception {

        ResponseEntity<UserApp_v2> responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        if ( user != null && user.getId() != null ) {

            Optional<UserApp_v2> optionalUserApp = userService_v2.findById(user.getId());

            if ( optionalUserApp.isPresent() ) {
                optionalUserApp =  userService_v2.findById(user.getId() );
                log.setRequest( objectMapper.writeValueAsString(optionalUserApp.get()));
                userService_v2.save(user);
                publisher.publishEvent(new ResourceCreatedEvent(this, response, user.getId()));
                responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(user);

            }
            log.setObject( headers.get("authorization").replace("Bearer ",""),
                    new java.sql.Date(System.currentTimeMillis()), "PutMapping /v2/users", new Time(System.currentTimeMillis()),objectMapper.writeValueAsString(optionalUserApp.get()), objectMapper.writeValueAsString(responseResponseEntity.getBody()));
            LogAppService.save(log);
        }

        return responseResponseEntity;

    }

    @PutMapping( path = "/v2/users/edit" )
    public ResponseEntity<UserApp_v2> uppsaveUpdate( @RequestBody UserApp_v2 user, HttpServletResponse response ,@RequestHeader Map<String,String> headers) throws Exception {

        ResponseEntity<UserApp_v2> responseResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        if ( user != null && user.getId() != null ) {

            Optional<UserApp_v2> optionalUserApp = userService_v2.findById(user.getId());

            if ( optionalUserApp.isPresent() ) {
                optionalUserApp =  userService_v2.findById(user.getId() );
                log.setRequest( objectMapper.writeValueAsString(optionalUserApp.get()));
                //crio um novo objeto para setar o nome e email para não perder a senha.
                UserApp_v2 userAppCurrent = optionalUserApp.get();

                userAppCurrent.setEmail(user.getEmail());
                userAppCurrent.setName(user.getName());

                userService_v2.saveUpdate(userAppCurrent);
                publisher.publishEvent(new ResourceCreatedEvent(this, response, user.getId()));
                responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(user);
                log.setObject( headers.get("authorization").replace("Bearer ",""),
                        new java.sql.Date(System.currentTimeMillis()), "PutMapping /v2/users/edit", new Time(System.currentTimeMillis()),objectMapper.writeValueAsString(optionalUserApp.get()), objectMapper.writeValueAsString(responseResponseEntity.getBody()));
                LogAppService.save(log);
            }

        }

        return responseResponseEntity;

    }

    @DeleteMapping( path = "/v2/users/{id}" )
    public ResponseEntity<UserApp_v2> uppdelete( @PathVariable Long id,@RequestHeader Map<String,String> headers ) throws JsonProcessingException {

        ResponseEntity<UserApp_v2> responseResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        boolean isDeleted = userService_v2.delete( id );

        if ( isDeleted )
            responseResponseEntity = ResponseEntity.status(HttpStatus.OK).body(null);

        log.setObject( headers.get("authorization").replace("Bearer ",""),
                new java.sql.Date(System.currentTimeMillis()), "DeleteMapping /v2/users/{id}", new Time(System.currentTimeMillis()),"DELETE DE ID : "+id, objectMapper.writeValueAsString(responseResponseEntity));
        LogAppService.save(log);
        return responseResponseEntity;
    }

}
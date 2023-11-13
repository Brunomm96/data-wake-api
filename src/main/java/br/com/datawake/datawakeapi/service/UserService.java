package br.com.datawake.datawakeapi.service;

import br.com.datawake.datawakeapi.model.UserApp;
import br.com.datawake.datawakeapi.model.UserAppResponse;
import br.com.datawake.datawakeapi.repository.Users;
import br.com.datawake.datawakeapi.repository.Users_v2;
import br.com.datawake.datawakeapi.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private Users users;

    @Transactional
    public UserApp save(UserApp user) throws Exception {

        /**
         * Trata encriptacao de senha
         */
        if ( user.getId() == null || user.getId() == 0 ) {
            user.encryptPassWord();
        }
        else {

            UserApp userFull = users.findById( user.getId() ).get();

            if ( !userFull.getPassword().equals(user.getPassword()) )
                user.encryptPassWord();

        }

        return users.save(user);
    }

    public UserApp saveUpdate(UserApp user) throws Exception {
        return users.save(user);
    }

    public Optional<UserApp> findByEmail(String email) {
        return users.findByEmail(email);
    }

    public Page<UserApp> findAll(Pageable pageable) {
        return users.findAll(pageable);
    }

    public Optional<UserApp> findById(Long id) {
        return users.findById(id);
    }

    public Page<UserAppResponse> findAllResume(Pageable pageable) {
        return users.findAllResume(pageable);
    }

    @Transactional
    public boolean delete(Long id) {

        Optional<UserApp> userApp = users.findById(id);

        if ( !userApp.isPresent() )
            throw new UserNotFoundException();

        users.deleteById( id );

        return true;

    }
}
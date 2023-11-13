package br.com.datawake.datawakeapi.service;


import br.com.datawake.datawakeapi.model.UserAppResponse;
import br.com.datawake.datawakeapi.model.UserApp_v2;
import br.com.datawake.datawakeapi.repository.Users_v2;
import br.com.datawake.datawakeapi.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService_v2 {

    @Autowired
    private Users_v2 users;

    @Transactional
    public UserApp_v2 save(UserApp_v2 user) throws Exception {

        if ( user.getId() == null || user.getId() == 0 ) {
            user.encryptPassWord();
        }
        else {

            UserApp_v2 userFull = users.findById( user.getId() ).get();

            if ( !userFull.getPassword().equals(user.getPassword()) )
                user.encryptPassWord();

        }

        return users.save(user);
    }

    public UserApp_v2 saveUpdate(UserApp_v2 user) throws Exception {
        return users.save(user);
    }

    public Optional<UserApp_v2> findByEmail(String email) {
        return users.findByEmail(email);
    }

    public Page<UserApp_v2> findAll(Pageable pageable) {
        return users.findAll(pageable);
    }

    public Optional<UserApp_v2> findById(Long id) {
        return users.findById(id);
    }

    public Page<UserAppResponse> findAllResume(Pageable pageable) {
        return users.findAllResume(pageable);
    }

    @Transactional
    public boolean delete(Long id) {

        Optional<UserApp_v2> userApp = users.findById(id);

        if ( !userApp.isPresent() )
            throw new UserNotFoundException();

        users.deleteById( id );

        return true;

    }
}
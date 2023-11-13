package br.com.datawake.datawakeapi.config.security;

import br.com.datawake.datawakeapi.model.UserApp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class UserSystem extends User {

    private static final long serialVersionUID = 1L;

    private UserApp user;

    public UserSystem(UserApp user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getEmail(), user.getPassword(), authorities);
        this.user = user;
    }

    public UserApp getUser() {
        return user;
    }

}
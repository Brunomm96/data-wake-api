package br.com.datawake.datawakeapi.service;

import br.com.datawake.datawakeapi.config.security.UserSystem;
import br.com.datawake.datawakeapi.model.UserApp;
import br.com.datawake.datawakeapi.repository.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private Users users;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserApp> usuarioOptional = users.findByEmail(email);
        UserApp usuario = usuarioOptional.orElseThrow(() -> new UsernameNotFoundException("Usuario e/ou senha incorretos"));
        return new UserSystem(usuario, getPermissoes(usuario));
    }

    private Collection<? extends GrantedAuthority> getPermissoes(UserApp usuario) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        usuario.getPermission().forEach(p -> authorities.add(new SimpleGrantedAuthority(p.getDescription().toUpperCase())));
        return authorities;
    }

}
//package br.com.datawake.datawakeapi.model;
//
//import br.com.datawake.datawakeapi.service.AppUserDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Optional;
//
//public class UserAppDetails implements UserDetails {
//
//    @Autowired
//    private final Optional<UserApp> usuario;
//
//    @Autowired
//    private AppUserDetailsService appUserDetailsService
//
//    public UserAppDetails(Optional<UserApp> usuario) {
//        this.usuario = usuario;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return appUserDetailsService.;
//    }
//
//    @Override
//    public String getPassword() {
//        return usuario.orElse(new UserApp()).getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return usuario.orElse(new UserApp()).getEmail();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
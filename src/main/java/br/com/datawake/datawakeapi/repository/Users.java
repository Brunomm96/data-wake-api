package br.com.datawake.datawakeapi.repository;

import br.com.datawake.datawakeapi.model.UserApp;
import br.com.datawake.datawakeapi.model.UserAppResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface Users extends JpaRepository<UserApp, Long> {

    public Optional<UserApp> findByEmail(String email);

    public List<UserApp> findByPermissionDescription(String permissionDescription);

    @Query(value =	"select NEW br.com.datawake.datawakeapi.model.UserAppResponse( usr.id , usr.name , usr.email ,usr.firstAccess) " +
            "from UserApp usr order by usr.id")
    Page<UserAppResponse> findAllResume(Pageable pageable);
}
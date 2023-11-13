package br.com.datawake.datawakeapi.repository;

import br.com.datawake.datawakeapi.model.UserApp_v2;
import br.com.datawake.datawakeapi.model.UserAppResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface Users_v2 extends JpaRepository<UserApp_v2, Long> {

    public Optional<UserApp_v2> findByEmail(String email);

        @Query(value =	"select NEW br.com.datawake.datawakeapi.model.UserAppResponse( usr.id , usr.name , usr.email ,usr.firstAccess) " +
            "from UserApp usr order by usr.id")
    Page<UserAppResponse> findAllResume(Pageable pageable);
}
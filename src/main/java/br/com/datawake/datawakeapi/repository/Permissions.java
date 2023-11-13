package br.com.datawake.datawakeapi.repository;

import br.com.datawake.datawakeapi.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Permissions extends JpaRepository<Permission, Long> {


}

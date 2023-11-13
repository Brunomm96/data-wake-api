package br.com.datawake.datawakeapi.repository;

import br.com.datawake.datawakeapi.model.logApp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface logAppRepository extends JpaRepository<logApp, Long> {
}
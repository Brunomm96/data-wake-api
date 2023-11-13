package br.com.datawake.datawakeapi.repository;

import br.com.datawake.datawakeapi.model.FtpAuditoriaEscalonadaDigital;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface FtpAuditoriaEscalonadaDigitalRepository extends JpaRepository<FtpAuditoriaEscalonadaDigital, Long> {
}

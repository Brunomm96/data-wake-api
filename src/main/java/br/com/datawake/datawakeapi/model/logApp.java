package br.com.datawake.datawakeapi.model;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "log_app")
public class logApp {
    public static final String TOKEN_SENHA = "463408a1-54c9-4307-bb1c-6cced559f5a7";
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "data")
    private java.sql.Date data;

    @Column(name = "horario")
    private Time horario;

    @Column(name = "evento")
    private String evento;

    @Column(name = "pay_response")
    private String response;

    @Column(name = "pay_request")
    private String request;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        logApp that = (logApp) o;
        return id.equals(that.id);
    }
    public Object clone() throws CloneNotSupportedException {
        return (Object) super.clone();
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public java.sql.Date getData() {
        return data;
    }

    public void setData(java.sql.Date data) {
        this.data = data;
    }

    public Time getHorario() {
        return horario;
    }

    public void setHorario(Time horario) {
        this.horario = horario;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public void setObject(String usuario,java.sql.Date data,String evento,Time horario,String request,String response){
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC512(TOKEN_SENHA))
                .build()
                .verify(usuario);
        this.id = null;
        this.usuario = decodedJWT.getSubject();
        this.data = data;
        this.evento = evento;
        this.horario = horario;
        if(this.request != "") {
            this.request = request;
        }
        if(this.response != "") {
            this.response = response;
        }
    }
}

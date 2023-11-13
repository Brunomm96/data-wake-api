package br.com.datawake.datawakeapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Acompanhamento_APQP")
public class FtpAPQP {
	@Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name = "DATA_SOP")
	private LocalDate data_SOP;

	@Column(name = "Qtde_Reprograma")
	private Integer qtd_Reprograma;

	@Column(name = "Responsavel")
	private String responsavel;

	@Column(name = "Cliente")
	private String cliente;

	@Column(name = "Codigo_Cliente")
	private String codigo_Cliente;

	@Column(name = "Codigo_Paranoa")
	private String codigo_Paranoa;

	@Column(name = "Nome_Projeto")
	private String nome_Projeto;

	@Column(name = "Unidade_Negocio")
	private String unidade_Negocio;

	@Column(name = "Tipo_Projeto")
	private String tipo_Projeto;

	@Column(name = "Tipo_Desvio")
	private String tipo_Desvio;

	@Column(name = "Data_Liberacao")
	private LocalDate data_Liberacao;

	@Column(name = "Tipo_Evento")
	private String tipo_Evento;

	@Column(name = "Data_Full")
	private LocalDate data_Full;

	@Column(name = "Data_Reprograma")
	private LocalDate data_Reprograma;

	@Column(name = "Status_Projeto")
	private String status_Projeto;

	@Column(name = "Data_Ficha")
	private LocalDate data_Ficha;

	@Column(name = "Status_Ficha")
	private String status_Ficha;

	@Column(name = "OBS")
	private  String obs;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FtpAPQP that = (FtpAPQP) o;
		return id.equals(that.id);	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public String getCliente() {return cliente;}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getOBS(){ return obs; }
	public void setOBS(String obs) { this.obs = obs; }

	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) { this.responsavel = responsavel; }

	public String getCodigo_Cliente() {
		return codigo_Cliente;
	}
	public void setCodigo_Cliente(String codigo_Cliente) {
		this.codigo_Cliente = codigo_Cliente;
	}

	public String getCodigo_Paranoa() {
		return codigo_Paranoa;
	}
	public void setCodigo_Paranoa(String codigo_Paranoa) {
		this.codigo_Paranoa = codigo_Paranoa;
	}

	public String getNome_Projeto() {
		return nome_Projeto;
	}
	public void setNome_Projeto(String nome_Projeto) { this.nome_Projeto = nome_Projeto; }

	public LocalDate getData_Liberacao() {
		return data_Liberacao;
	}

	public void setData_Liberacao(LocalDate data_Liberacao) {
		this.data_Liberacao = data_Liberacao;
	}

	public LocalDate getData_Full() {
		return data_Full;
	}

	public void setData_Full(LocalDate data_Full) {
		this.data_Full = data_Full;
	}

	public LocalDate getData_Reprograma() {
		return data_Reprograma;
	}

	public void setData_Reprograma(LocalDate data_Reprograma) {
		this.data_Reprograma = data_Reprograma;
	}

	public LocalDate getData_Ficha() {
		return data_Ficha;
	}

	public void setData_Ficha(LocalDate data_Ficha) {
		this.data_Ficha = data_Ficha;
	}

	public String getStatus_Ficha() {
		return status_Ficha;
	}
	public void setStatus_Ficha(String status_Ficha) {
		this.status_Ficha = status_Ficha;
	}

	public String getStatus_Projeto() {
		return status_Projeto;
	}
	public void setStatus_Projeto(String status_Projeto) {
		this.status_Projeto = status_Projeto;
	}

	public String getTipo_Evento() {
		return tipo_Evento;
	}
	public void setTipo_Evento(String tipo_Evento) {
		this.tipo_Evento = tipo_Evento;
	}

	public String getTipo_Projeto() {
		return tipo_Projeto;
	}
	public void setTipo_Projeto(String tipo_Projeto) {
		this.tipo_Projeto = tipo_Projeto;
	}

	public String getTipo_Desvio() {
		return tipo_Desvio;
	}
	public void setTipo_Desvio(String tipo_Desvio) {
		this.tipo_Desvio = tipo_Desvio;
	}

	public String getUnidade_Negocio() {
		return unidade_Negocio;
	}
	public void setUnidade_Negocio(String unidade_Negocio) {
		this.unidade_Negocio = unidade_Negocio;
	}

	public LocalDate getData_SOP() {
		return data_SOP;
	}

	public void setData_SOP(LocalDate data_SOP) {
		this.data_SOP = data_SOP;
	}

	public Integer getQtd_Reprograma() {
		return qtd_Reprograma;
	}

	public void setQtd_Reprograma(Integer qtd_Reprograma) {
		this.qtd_Reprograma = qtd_Reprograma;
	}

	public void setId(Long id) {this.id = id;}
	public Long getId() {
		return id;
	}
}


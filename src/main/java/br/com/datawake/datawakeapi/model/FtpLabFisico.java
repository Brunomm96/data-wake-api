package br.com.datawake.datawakeapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.internal.util.StringHelper;
import javax.lang.model.element.Name;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Objects;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Laboratorio_Fisico")
public class FtpLabFisico {

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NomeNorma")
	private String nomeNorma;

	@Column(name = "RevisaoNorma")
	private String revisaoNorma;

	@Column(name = "NomeCliente")
	private String nomeCliente;

	@Column(name = "TemperaturaLiquido")
	private String temperaturaLiquido;

	@Column(name = "TemperaturaCamara")
	private String temperaturaCamara;

	@Column(name = "TempoRampaTemperatura")
	private String tempoRampaTemperatura;

	@Column(name = "PressaoTrabalho")
	private String pressaoTrabalho;

	@Column(name = "TempoRampaPressao")
	private String tempoRampaPressao;

	@Column(name = "FrequenciaPressurizacao")
	private String frequenciaPressurizacao;

	@Column(name = "QuantidadeCiclos")
	private String quantidadeCiclos;

	public String getQuantidadeCiclos() { return quantidadeCiclos; }
	public void setQuantidadeCiclos(String quantidadeCiclos) { 
		this.quantidadeCiclos = quantidadeCiclos; 
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FtpLabFisico that = (FtpLabFisico) o;
		return id.equals(that.id);	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public String getNomeNorma() {return nomeNorma;}
	public void setNomeNorma(String nomeNorma) {
		this.nomeNorma = nomeNorma;
	}

	public String getRevisaoNorma(){ return revisaoNorma; }
	public void setRevisaoNorma(String revisaoNorma) { 
        this.revisaoNorma = revisaoNorma; 
    }

	public String getNomeCliente() { return nomeCliente; }
	public void setNomeCliente(String nomeCliente) { 
        this.nomeCliente = nomeCliente; 
    }

	public String getTemperaturaLiquido() { return temperaturaLiquido; }
	public void setTemperaturaLiquido(String temperaturaLiquido) {
		this.temperaturaLiquido = temperaturaLiquido;
	}

	public String getTemperaturaCamara() { return temperaturaCamara; }
	public void setTemperaturaCamara(String temperaturaCamara) {
		this.temperaturaCamara = temperaturaCamara;
	}

	public String getTempoRampaTemperatura() { return tempoRampaTemperatura; }
	public void setTempoRampaTemperatura(String tempoRampaTemperatura) {
		this.tempoRampaTemperatura = tempoRampaTemperatura;
	}

	public String getPressaoTrabalho() { return pressaoTrabalho; }
	public void setPressaoTrabalho(String pressaoTrabalho) {
		this.pressaoTrabalho = pressaoTrabalho;
	}

	public String getTempoRampaPressao() { return tempoRampaPressao; }
	public void setTempoRampaPressao(String tempoRampaPressao) {
		this.tempoRampaPressao = tempoRampaPressao;
	}

	public String getFrequenciaPressurizacao() { return frequenciaPressurizacao; }
	public void setFrequenciaPressurizacao(String frequenciaPressurizacao) {
		this.frequenciaPressurizacao = frequenciaPressurizacao;
	}

	public void setId(Long id) {this.id = id;}
	public Long getId() {
		return id;
	}
}


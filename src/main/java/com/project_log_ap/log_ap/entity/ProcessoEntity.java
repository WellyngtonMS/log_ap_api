package com.project_log_ap.log_ap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PROCESSO")
public class ProcessoEntity {
    @Id
    @Column(name = "ID_PROCESSO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PROCESSO")
	@SequenceGenerator(name = "SEQ_PROCESSO", sequenceName = "SEQ_PROCESSO", allocationSize = 1)
	private Long id;
    
    @NotBlank
    @Size(max = 50)
    @Column(name = "DS_STRING")
    private String string;

    @NotNull
	@Column(name = "DS_VOGAL")
	private Character vogal;

	@NotNull
	@Column(name = "NUM_TEMPO_TOTAL")
	private String tempoTotal;

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public Character getVogal() {
		return vogal;
	}

	public void setVogal(Character vogal) {
		this.vogal = vogal;
	}

	public String getTempoTotal() {
		return tempoTotal;
	}

	public void setTempoTotal(String tempoFinal) {
		this.tempoTotal = tempoFinal;
	}
}

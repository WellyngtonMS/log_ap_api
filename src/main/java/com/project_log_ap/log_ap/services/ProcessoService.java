package com.project_log_ap.log_ap.services;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.project_log_ap.log_ap.entity.ProcessoEntity;
import com.project_log_ap.log_ap.exceptions.BadRequestException;
import com.project_log_ap.log_ap.repository.ProcessoRepository;

@Component
public class ProcessoService {
    @Autowired(required = false)
    public ProcessoRepository repository;

	@Transactional
	public ProcessoEntity processar(ProcessoEntity entity) {
		this.processarConteudo(entity);
		this.save(entity);
		return entity;
	}

	private void save(ProcessoEntity entity) {
    }

    private void validarProcessamento(ProcessoEntity entity) {
		if (entity == null) {
			throw new BadRequestException("O campo String é de preenchimento obrigatório");
		}
		if (entity.getString().length() < 3) {
			throw new BadRequestException("A string deve conter ao menos 3 letras");
		}
	}

	private void processarConteudo(ProcessoEntity entity) {

		Long tempoInicial = new Date().getTime();
		this.validarProcessamento(entity);
		boolean encontrou = false;

		String conteudo = entity.getString();

		int length = conteudo.length();
		for (int i = 2; i < length; i++) {
			if (this.obterQtdLetraRepetida(conteudo, conteudo.charAt(i)).equals(1) && this.isVogal(conteudo.charAt(i))
					&& !this.isVogal(conteudo.charAt(i - 1)) && this.isVogal(conteudo.charAt(i - 2))) {
				encontrou = true;
				entity.setVogal(conteudo.charAt(i));
				break;
			}
		}
		if (!encontrou) {
			throw new BadRequestException("Não foi encontrada nenhuma vogal valida");
		}
		String tempoFinal = new Date().getTime() - tempoInicial + "ms";
		entity.setTempoTotal(tempoFinal);
	}

	private boolean isVogal(char e) {
		e = Character.toLowerCase(e);
		return e == 'a' || e == 'e' || e == 'i' || e == 'o' || e == 'u';
	}

	private Integer obterQtdLetraRepetida(String conteudo, Character letra) {
		Long qtd = conteudo.chars().mapToObj(item -> (char) item)
				.filter(item -> Character.toLowerCase(item) == Character.toLowerCase(letra)).count();
		return qtd.intValue();
	}
}

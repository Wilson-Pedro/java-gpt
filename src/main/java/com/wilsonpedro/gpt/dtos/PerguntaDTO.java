package com.wilsonpedro.gpt.dtos;

import java.io.Serializable;

public class PerguntaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String pergunta;

	public PerguntaDTO() {
	}

	public PerguntaDTO(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
}

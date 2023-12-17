package com.wilsonpedro.gpt.dtos;

import java.io.Serializable;

public class RespostaDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private String resposta;

	public RespostaDTO() {
	}

	public RespostaDTO(String resposta) {
		this.resposta = resposta;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
}

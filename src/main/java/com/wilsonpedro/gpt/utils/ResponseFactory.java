package com.wilsonpedro.gpt.utils;

import org.springframework.stereotype.Component;

import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;


@Component
public class ResponseFactory {
	
	private static final String API_KEY = "";

	OpenAiService openAiService = new OpenAiService(API_KEY);
	
	public String gerarResposta(String pergunta) {

		CompletionRequest request = CompletionRequest.builder()
				.model("text-davinci-003")
				.prompt(pergunta)
				.maxTokens(2000)
				.temperature(0.7)
				.build();
		
		String resposta = openAiService.createCompletion(request).getChoices().toString();
		
		return formartarString(resposta);
	}
	
	public String gerarTraducao(String pergunta) {

		CompletionRequest request = CompletionRequest.builder()
				.model("text-davinci-003")
				.prompt("Traduza para português essa frase: " + pergunta)
				.maxTokens(2000)
				.temperature(0.7)
				.build();
		
		String resposta = openAiService.createCompletion(request).getChoices().toString();
		
		return formartarString(resposta);
	}
	

	private String formartarString(String resposta) {
		String removerInicio = "[CompletionChoice(text=\n\n";
		String removerFInal = ", index=0, logprobs=null, finish_reason=stop)]";
		
		resposta = resposta.replace(removerInicio, "");
		resposta = resposta.replace(removerFInal, "");
		
		return resposta;
	}
}


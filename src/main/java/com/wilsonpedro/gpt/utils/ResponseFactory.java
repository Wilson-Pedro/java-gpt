package com.wilsonpedro.gpt.utils;

import org.springframework.stereotype.Component;

import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;


@Component
public class ResponseFactory {
	
	private static final String API_KEY = "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";

	OpenAiService openAiService = new OpenAiService(API_KEY);
	
	public Object gerarResposta(String pergunta) {

		CompletionRequest request = CompletionRequest.builder()
				.model("text-davinci-003")
				.prompt(pergunta)
				.maxTokens(2000)
				.temperature(0.7)
				.build();
		
		Object obj = openAiService.createCompletion(request).getChoices();
		
		return obj;
	}
	
	public void imprimir(CompletionRequest request) {
		System.out.println(openAiService.createCompletion(request).getChoices());
	}

}


package com.wilsonpedro.gpt.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;
import com.wilsonpedro.gpt.dtos.PerguntaDTO;

@RestController
@RequestMapping("/gpt")
public class GptController {
	
	private static final String API_KEY = "";
	
	OpenAiService openAiService = new OpenAiService(API_KEY);
	
	@PostMapping
	public ResponseEntity perguntarAoGpt(@RequestBody PerguntaDTO pergunta) {
		
		CompletionRequest request = CompletionRequest.builder()
				.model("text-davinci-003")
				.prompt(pergunta.getPergunta())
				.maxTokens(100)
				.temperature(0.7)
				.build();
		
		Object obj = openAiService.createCompletion(request).getChoices();
		
		return ResponseEntity.ok(obj);
	}
}

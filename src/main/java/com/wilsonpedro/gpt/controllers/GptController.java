package com.wilsonpedro.gpt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilsonpedro.gpt.dtos.PerguntaDTO;
import com.wilsonpedro.gpt.utils.ResponseFactory;

@RestController
@RequestMapping("/gpt")
public class GptController {
	
	@Autowired
	ResponseFactory responseFactory;
	
	@PostMapping
	public ResponseEntity perguntarAoGpt(@RequestBody PerguntaDTO pergunta) {
		
		Object obj = responseFactory.gerarResposta(pergunta.getPergunta());
		
		return ResponseEntity.ok(obj);
	}
}

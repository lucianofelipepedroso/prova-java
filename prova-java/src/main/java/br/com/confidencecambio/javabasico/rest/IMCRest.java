package br.com.confidencecambio.javabasico.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.confidencecambio.javabasico.form.IMCForm;

@RestController
@RequestMapping("imc")
public class IMCRest {

	// http://localhost:8080/imc/1.98/87
	@GetMapping("{altura}/{peso}")
	public ResponseEntity<String> calculoIMCGet(@PathVariable String altura,@PathVariable String peso) {
		return new ResponseEntity<String>(calculoIMC(peso, altura),HttpStatus.OK);

	}
 
//http://localhost:8080/imc	
//	{
//	       "altura":"1.78",
//	       "peso":"78.5"
//	}

	@PostMapping
	public ResponseEntity<String> calculoIMCPost(@RequestBody @Validated IMCForm form) {
		 return new ResponseEntity<String>(calculoIMC(form.getPeso(),form.getAltura()),HttpStatus.OK);

	}

	private String calculoIMC(String peso, String altura) {
		Double imc = Double.valueOf(peso) / (Math.pow(Double.valueOf(altura), 2));
		return String.format("%.2f kg/m2", imc);

	}

}

package br.com.confidencecambio.javabasico.validacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ErroHandler {
	
	@Autowired
	private MessageSource messageSource;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroFormularioDto> handle(MethodArgumentNotValidException exception) {
		
		List<ErroFormularioDto>	dtos = new ArrayList<ErroFormularioDto>();
        List<FieldError> errors = exception.getBindingResult().getFieldErrors();
        
        errors.forEach( e -> {
        	
        	String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
        	ErroFormularioDto dto = new ErroFormularioDto(e.getField(), mensagem);
        	dtos.add(dto);
        });
		
		return  dtos;
		
	}

}

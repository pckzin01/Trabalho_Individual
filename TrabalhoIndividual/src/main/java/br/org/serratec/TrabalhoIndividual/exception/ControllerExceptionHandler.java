package br.org.serratec.TrabalhoIndividual.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			org.springframework.http.HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		List<String> erros = new ArrayList<>();
		for (FieldError e: ex.getBindingResult().getFieldErrors()) {
			erros.add(e.getField() + ": " + e.getDefaultMessage());
		}
		
		ErroResposta erroResposta = new ErroResposta(status.value(), "Existem campos inválidos",
				LocalDateTime.now(), erros);
		
		return super.handleExceptionInternal(ex, erroResposta, headers, status, request);
	}
	
	
}

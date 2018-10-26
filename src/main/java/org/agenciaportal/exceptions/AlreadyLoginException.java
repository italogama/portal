package org.agenciaportal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.TEMPORARY_REDIRECT,
				reason=" User already logged in",
				code=HttpStatus.TEMPORARY_REDIRECT)
public class AlreadyLoginException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public AlreadyLoginException() {
	super("Usuário ja logado tentou acessar a página de registro / login");
	}
}

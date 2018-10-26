package org.agenciaportal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND,
				reason=" No order found for user",
				code=HttpStatus.NOT_FOUND)
public class NoOrderFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public NoOrderFoundException() {
		super("Nenhum pedido encontrado para o usu�rio logado");
	}
}

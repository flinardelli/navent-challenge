package com.navent.challenge.exceptions;

public class PedidoException extends RuntimeException{
		
		private static final long serialVersionUID = 1L;

		public PedidoException(String message){
	        super("Ocurrió un error:" + message);
	    }
}

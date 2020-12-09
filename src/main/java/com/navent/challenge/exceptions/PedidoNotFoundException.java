package com.navent.challenge.exceptions;

public class PedidoNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public PedidoNotFoundException(){
        super("El pedido no existe");
    }

}

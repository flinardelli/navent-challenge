package com.navent.challenge.service;

import com.navent.challenge.model.dto.PedidoRequest;
import com.navent.challenge.model.dto.PedidoResponse;

public interface PedidoService {
	/**
	 * Obtiene un pedido por el id del mismo
	 * 
	 * @param idPedido id del pedido
	 * @author flinardelli
	 * */
	PedidoResponse getPedidoById(Integer idPedido);
	
	/**
	 * Crea un pedido
	 * 
	 * @param pedido Objeto a eliminar
	 * @author flinardelli
	 * */
	PedidoResponse createPedido (PedidoRequest pedido);
	
	/**
	 * Crea un pedido
	 * 
	 * @param pedido Objeto a eliminar
	 * @author flinardelli
	 * */
	PedidoResponse updatePedido(Integer idPedido, PedidoRequest pedido);
	
	/**
	 * Elimina un pedido
	 * 
	 * @param pedido Objeto pedido a eliminar
	 * @author flinardelli
	 * */
	PedidoResponse deletePedido(Integer idPedido);

	
	
}

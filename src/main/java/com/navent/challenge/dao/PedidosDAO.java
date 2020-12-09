package com.navent.challenge.dao;

import org.springframework.stereotype.Repository;

import com.navent.challenge.model.entity.Pedido;

@Repository
public class PedidosDAO {
	/**
     * inserta un nuevo pedido en la base de datos o modifica un pedido existente
     * (en cado de crear uno nuevo, el pedido pasado como parametro se completa con el nuevo id)
     * @param pedido
     */
    public void insertOrUpdate(Pedido pedido){}

    /**
     * elimina el pedido que corresponde al id recibido.
     * @param pedido
     */
    public void delete (Pedido pedido){}

    /**
     * busca un pedido por id.
     * @param idPedido
     * @return
     */
    public Pedido select(Integer idPedido){return null;}
}

package com.navent.challenge.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navent.challenge.dao.BumexMemcached;
import com.navent.challenge.dao.PedidosDAO;
import com.navent.challenge.exceptions.PedidoException;
import com.navent.challenge.exceptions.PedidoNotFoundException;
import com.navent.challenge.model.dto.PedidoRequest;
import com.navent.challenge.model.dto.PedidoResponse;
import com.navent.challenge.model.entity.Pedido;
import com.navent.challenge.service.PedidoService;
import com.navent.challenge.utils.KeySimulate;
import com.navent.challenge.utils.ModelMapperUtils;


@Service
public class PedidoServiceImpl implements PedidoService{
	
	@Autowired
	private PedidosDAO pedidosDAO;
	
	@Override
	public PedidoResponse getPedidoById(Integer idPedido) {
		Pedido pedido = (Pedido) BumexMemcached.getInstance().get(String.valueOf(idPedido));		
		if (pedido == null) {
			pedido = Optional.ofNullable(pedidosDAO.select(idPedido)).orElseThrow(PedidoNotFoundException::new);
		}		
		return ModelMapperUtils.getInstance().modeler(pedido, PedidoResponse.class);
	}
	
	@Override
	public PedidoResponse createPedido (PedidoRequest pedido) {
		Pedido pedidoEntity = (Pedido) ModelMapperUtils.getInstance().modeler(pedido, Pedido.class);
		try {
			pedidosDAO.insertOrUpdate(pedidoEntity);
			Integer idSumulate = KeySimulate.getSimulateId();
			pedidoEntity.setIdPedido(idSumulate);
			BumexMemcached.getInstance().set(String.valueOf(idSumulate), pedidoEntity);
		} catch (Exception ex) {
			throw new PedidoException(ex.getMessage());
		}
		
		return ModelMapperUtils.getInstance().modeler(pedidoEntity, PedidoResponse.class);
	}
	
	
	@Override
	public PedidoResponse deletePedido(Integer idPedido) {
		PedidoResponse pedido = this.getPedidoById(idPedido);
		Pedido pedidoEntity = ModelMapperUtils.getInstance().modeler(pedido, Pedido.class);
		try {
			pedidosDAO.delete(pedidoEntity);
			BumexMemcached.getInstance().delete(String.valueOf(pedidoEntity.getIdPedido()));
		} catch (Exception ex) {
			throw new PedidoException(ex.getMessage());
		}
		
		return ModelMapperUtils.getInstance().modeler(pedidoEntity, PedidoResponse.class);
	}

	@Override
	public PedidoResponse updatePedido(Integer idPedido, PedidoRequest pedidoRequest) {
		PedidoResponse pedido = this.getPedidoById(idPedido);
		Pedido pedidoEntity = ModelMapperUtils.getInstance().modeler(pedido, Pedido.class);
		
		Optional.ofNullable(pedidoRequest.getNombre()).ifPresent(p -> pedidoEntity.setNombre(pedidoRequest.getNombre()));
		Optional.ofNullable(pedidoRequest.getMonto()).ifPresent(p -> pedidoEntity.setMonto(pedidoRequest.getMonto()));
		Optional.ofNullable(pedidoRequest.getDescuento()).ifPresent(p -> pedidoEntity.setDescuento(pedidoRequest.getDescuento()));
		
		try {
			pedidosDAO.insertOrUpdate(pedidoEntity);
			BumexMemcached.getInstance().delete(String.valueOf(pedidoEntity.getIdPedido()));
			BumexMemcached.getInstance().set(String.valueOf(pedidoEntity.getIdPedido()), pedidoEntity);
		} catch (Exception ex) {
			throw new PedidoException(ex.getMessage());
		}
		
		return ModelMapperUtils.getInstance().modeler(pedidoEntity, PedidoResponse.class);
	}
}

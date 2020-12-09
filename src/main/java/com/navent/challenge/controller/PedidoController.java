package com.navent.challenge.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.navent.challenge.model.dto.PedidoRequest;
import com.navent.challenge.model.dto.PedidoResponse;
import com.navent.challenge.service.PedidoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/pedidos")
@Api(value = "Controlador de pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping("/{id}")
	@ResponseBody
	@ApiOperation(value = "Obtiene un usuario específico", notes = "Obtiene el usuario por medio del id")
	public ResponseEntity<PedidoResponse> getPedidoById(@PathVariable(name = "id") Integer idPedido) {
		PedidoResponse pedidoResponse= pedidoService.getPedidoById(idPedido);
		return ResponseEntity.ok(pedidoResponse);
	}
	
	@PostMapping
	@ResponseBody
	@ApiOperation(value = "Crea un pedido", notes = "Crea un pedido y valida que los campos ingresados no esten nulos", code = 201)
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<PedidoResponse> createPedido(@Valid @RequestBody PedidoRequest pedido) {
		PedidoResponse pedidoResponse= pedidoService.createPedido(pedido);
		return ResponseEntity.status(HttpStatus.CREATED).body(pedidoResponse);
	}
	
	@PutMapping("/{id}")
	@ResponseBody
	@ApiOperation(value = "Actualiza un pedido")
	public ResponseEntity<PedidoResponse> updatePedido(@PathVariable(name = "id") Integer idPedido, @RequestBody PedidoRequest pedido) {
		PedidoResponse pedidoResponse= pedidoService.updatePedido(idPedido, pedido);
		return ResponseEntity.ok(pedidoResponse);
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	@ApiOperation(value = "Elimina un pedido")
	public ResponseEntity<PedidoResponse> deletePedido(@PathVariable(name = "id") Integer idPedido) {
		PedidoResponse pedidoResponse= pedidoService.deletePedido(idPedido);
		return ResponseEntity.ok(pedidoResponse);
	}
}

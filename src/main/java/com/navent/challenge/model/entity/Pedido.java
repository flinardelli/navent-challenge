package com.navent.challenge.model.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
	private Integer idPedido; 
	private String nombre; 
	private Float monto;
	private Float descuento;
}

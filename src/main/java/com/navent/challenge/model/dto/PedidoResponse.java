package com.navent.challenge.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("Respuestas de Pedidos")
public class PedidoResponse {
	private Integer idPedido; 
	private String nombre; 
	private Float monto;
	private Float descuento;
}

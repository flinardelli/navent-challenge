package com.navent.challenge.model.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("Peticiones de Pedidos")
public class PedidoRequest {
	@NotEmpty(message = "El nombre no puede estar vacío")
	private String nombre; 
	
	@NotNull(message = "El monto no puede estar vacío")
	@Min(value = 1, message = "Debe ingresar un monto mayor a 1")
	private Float monto;
	
	@NotNull(message = "El descuento no puede estar vacío")
	private Float descuento;
}

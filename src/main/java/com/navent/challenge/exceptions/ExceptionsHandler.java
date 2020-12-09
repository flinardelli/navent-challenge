package com.navent.challenge.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.navent.challenge.model.dto.ErrorResponse;

@ControllerAdvice
public class ExceptionsHandler {

    @ResponseBody
    @ExceptionHandler(PedidoNotFoundException.class)
    public ResponseEntity<?> pedidoNotFoundException(PedidoNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse.builder().message(ex.getMessage()).build());
    }
    
    @ResponseBody
    @ExceptionHandler(PedidoException.class)
    public ResponseEntity<?> pedidoException(PedidoNotFoundException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ErrorResponse.builder().message(ex.getMessage()).build());
    }
    
    
    @ExceptionHandler({MethodArgumentNotValidException.class})
	public ResponseEntity<?> invalidParamsExceptionHandler(MethodArgumentNotValidException e){
		List<ErrorResponse> errorDTOList = new ArrayList<>();
		e.getBindingResult().getFieldErrors().forEach(m -> {
			ErrorResponse errorDTO = ErrorResponse.builder()
					.message(m.getDefaultMessage())
					.build();
			errorDTOList.add(errorDTO);
		});

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTOList);
	}
    
}

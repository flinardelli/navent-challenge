package com.navent.challenge.utils;

import org.modelmapper.ModelMapper;

public class ModelMapperUtils {
	
	private ModelMapper modelMapper = new ModelMapper();
	private static ModelMapperUtils modelMapperUtils;
	
	private ModelMapperUtils() {}
	
	
	public static ModelMapperUtils getInstance() {
		return (modelMapperUtils == null) ? modelMapperUtils = new ModelMapperUtils() : modelMapperUtils;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T modeler(Object source, Class<?> destinationType) {
		return (T) modelMapper.map(source, destinationType);
	}

}

package com.navent.challenge.dao;

import java.util.HashMap;
import java.util.Map;

public class BumexMemcached {
	
	private static BumexMemcached bumexMemcached = null;
	private Map<String, Object> listObj = new HashMap<>();
	
	private BumexMemcached() {}
	
	public static BumexMemcached getInstance() {
		return (bumexMemcached == null) ? bumexMemcached = new BumexMemcached() : bumexMemcached;
	}
	
	public void set(String key, Object value) {
		listObj.put(key, value);
	}
	
	public Object get(String key) {
		return listObj.get(key);
	}
	
	public void delete(String key) {
		listObj.remove(key);
	}
	
}

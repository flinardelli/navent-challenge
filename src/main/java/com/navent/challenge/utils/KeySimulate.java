package com.navent.challenge.utils;

import java.util.Random;

public class KeySimulate {
	
	public static Integer getSimulateId() {
		Random r = new Random();
        return r.nextInt((1000 - 1) + 1) + 1;
	}

}

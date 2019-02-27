package com.company;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe amb capacitats d'execuci� ass�ncrona (thread).
 * El m�tode "run()" compta fins a una fita m�xima mentre
 * s'atura un temps determinat a cada iteraci�.
 */
public class CountWorker implements Runnable {
	// Identificador
	private String id;
	// Temps d'aturada
	private long sleepTime;
	// Fita m�xima
	private long topValue;
	private PrintWriter file;
	private int value;
	private String date;
	private final Object lock = new Object();
	private final List<String> demo;




	public CountWorker(String id, long sleepTime, long topValue, PrintWriter file, List<String> list) {
		this.id = id;
		this.sleepTime = sleepTime;
		this.topValue = topValue;
		this.file = file;
		this.value = 0;
		this.demo = list;
	}

	public List<String> getDemo() {
		return demo;
	}

	@Override
	public void run() {
		prueba();
		value++;

	}

	private void prueba() {

		synchronized (demo) {
			demo.add(id);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			demo.add("hola" + id);
		}
	}

	private String getContent(){
		String content = LocalTime.now().toString();
		return content;
	}
	
}

package com.company;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe amb el procediment principal.
 * Crea 3 fils d'execuci� ambn diferents par�metres
 * i els inicia.
 */
public class ExempleWorker {



	public static void main(String[] args) {

	 	List<String> demo = new ArrayList<>();

		try {
			PrintWriter writer = new PrintWriter("solucio.txt");
			System.out.println(LocalTime.now());
			// Creem 3 processos
			CountWorker c1 = new CountWorker("A", 100, 10, writer, demo);
			CountWorker c2 = new CountWorker("B", 1000, 10, writer, demo);
			//CountWorker c3 = new CountWorker("C", 500, 10, writer);
			// Els engegem
			Thread t1 = new Thread(c1);
			Thread t2 = new Thread(c2);
			t1.start();
			t2.start();

			t1.join();
			t2.join();
			System.out.println(demo);
			writer.close();
			//new Thread(c3).start();

		}catch (Exception o){

		}




	}
}


public class Main {

	public static void main(String[] args) {

		/*
		 * Runnable interface
		 * Thread ise classt�r
		 * Kulland�g�m�z classda extend edilmi� bir class varsa interface burada i�imizi ��z�yor.
		 * */
		System.out.println("Program ba�lat�ld� thread ad�: " +Thread.currentThread().getName());
		
		Worker worker = new Worker();
		worker.setName("worker");
		worker.start();
		
		WorkerRunnable workerRunnable = new WorkerRunnable();
		Thread worker2 = new Thread(workerRunnable);
		worker2.setName("worker2");
		worker2.start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					System.out.println("Runnable Inner class started to work!! Thread name : " +Thread.currentThread().getName());
					Thread.sleep(10000);
					System.out.println("Runnable Inner class stoped to work !! ");
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		}).start(); 
		
		new Thread() {
			public void run() {
				try {
					System.out.println("Thread Inner class started to work!! Thread name : " +Thread.currentThread().getName());
					Thread.sleep(10000);
					System.out.println("Thread Inner class stoped to work !! ");
				} catch (Exception e) {
					// TODO: handle exception
				}
			};
		}.start();
		
		
		System.out.println("Done");
	}
	/*output
		Program ba�lat�ld� thread ad�: main
		Worker class started to work!! Thread name : worker
		Runnable class started to work!! Thread name : worker2
		Runnable Inner class started to work!! Thread name : Thread-2
		Done
		Thread Inner class started to work!! Thread name : Thread-3
		Worker class stoped to work !! 
		Runnable class stoped to work !! 
		Runnable Inner class stoped to work !! 
		Thread Inner class stoped to work !! 

	 **/
}

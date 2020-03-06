
public class Worker extends Thread {

	@Override
	public void run() {
		try {
			System.out.println("Worker class started to work!! Thread name : " +Thread.currentThread().getName());
			Thread.sleep(10000);
			System.out.println("Worker class stoped to work !! ");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

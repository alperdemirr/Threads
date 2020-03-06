
public class WorkerRunnable implements Runnable{

	@Override
	public void run() {
		try {
			System.out.println("Runnable class started to work!! Thread name : " +Thread.currentThread().getName());
			Thread.sleep(10000);
			System.out.println("Runnable class stoped to work !! ");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}

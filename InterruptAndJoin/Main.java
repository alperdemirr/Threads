package InterruptAndJoin;

public class Main {

	public static void main(String[] args) {
		Worker w1 = new Worker();
		w1.start();
		
		new Thread() {
			public void run() {
				try {
					for(int i = 0; i < 100; i++) {
						if (i == 10) {
							w1.join(); // Join yapýlan thread geçerli kýlýnýr ve diðer thread bu iþlem bitene kadar bekler.
						}
						System.out.println("Inner Thread" + i);
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					return;
				}
			};
		}.start();
		
	}

	public static class Worker extends Thread{
		@Override
		public void run() {
			try {
				for (int i = 0; i < 100; i++) {
					if (i == 20) {
						interrupt(); // Geçerli threadin iliþkisini keseriz ve return ile sonlandýrýrýz
					}
					System.out.println("worker" + i);
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				return;
			}
			
		}
	}
}


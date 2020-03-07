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
							w1.join(); // Join yap�lan thread ge�erli k�l�n�r ve di�er thread bu i�lem bitene kadar bekler.
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
						interrupt(); // Ge�erli threadin ili�kisini keseriz ve return ile sonland�r�r�z
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


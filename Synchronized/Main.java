package Synchronized;

public class Main {

	/* Output without synchronized
	    0 numaralý dosya, thread adý: Thread-0
		0 numaralý dosya, thread adý: Thread-1
		1 numaralý dosya, thread adý: Thread-0
		1 numaralý dosya, thread adý: Thread-1
		2 numaralý dosya, thread adý: Thread-0
		2 numaralý dosya, thread adý: Thread-1
		3 numaralý dosya, thread adý: Thread-1
		3 numaralý dosya, thread adý: Thread-0
		4 numaralý dosya, thread adý: Thread-1
		4 numaralý dosya, thread adý: Thread-0
		5 numaralý dosya, thread adý: Thread-1
		5 numaralý dosya, thread adý: Thread-0
		6 numaralý dosya, thread adý: Thread-1
		6 numaralý dosya, thread adý: Thread-0
		7 numaralý dosya, thread adý: Thread-1
		7 numaralý dosya, thread adý: Thread-0
		8 numaralý dosya, thread adý: Thread-1
		8 numaralý dosya, thread adý: Thread-0
		9 numaralý dosya, thread adý: Thread-1
		9 numaralý dosya, thread adý: Thread-0
	 * */
	/* Output ith snycronized
	0 numaralý dosya, thread adý: Thread-0
	1 numaralý dosya, thread adý: Thread-0
	2 numaralý dosya, thread adý: Thread-0
	3 numaralý dosya, thread adý: Thread-0
	4 numaralý dosya, thread adý: Thread-0
	5 numaralý dosya, thread adý: Thread-0
	6 numaralý dosya, thread adý: Thread-0
	7 numaralý dosya, thread adý: Thread-0
	8 numaralý dosya, thread adý: Thread-0
	9 numaralý dosya, thread adý: Thread-0
	0 numaralý dosya, thread adý: Thread-1
	1 numaralý dosya, thread adý: Thread-1
	2 numaralý dosya, thread adý: Thread-1
	3 numaralý dosya, thread adý: Thread-1
	4 numaralý dosya, thread adý: Thread-1
	5 numaralý dosya, thread adý: Thread-1
	6 numaralý dosya, thread adý: Thread-1
	7 numaralý dosya, thread adý: Thread-1
	8 numaralý dosya, thread adý: Thread-1
	9 numaralý dosya, thread adý: Thread-1
	 * */
	public static void main(String[] args) {
		Printer p = new Printer(10);
		A a = new A(p);
		B b = new B(p);
		a.start();
		b.start();

	}
	public static class Printer {
		int count;
		public Printer(int a) {
			count = a;
		}
	
		public synchronized void print() {
			for (int i = 0; i < count; i++) {
				System.out.println(i+" numaralý dosya, thread adý: "+Thread.currentThread().getName());
			}
		}
		


	}
	public static class A extends Thread{
		private Printer printer;
		public A(Printer printer) {
			this.printer = printer;
		}
		@Override
		public void run() {
			printer.print();
		}
	}
	public static class B extends Thread{
		private Printer printer;
		public B(Printer printer) {
			this.printer = printer;
		}
		@Override
		public void run() {
			printer.print();
		}
	}
}

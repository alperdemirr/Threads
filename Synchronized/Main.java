package Synchronized;

public class Main {

	/* Output without synchronized
	    0 numaral� dosya, thread ad�: Thread-0
		0 numaral� dosya, thread ad�: Thread-1
		1 numaral� dosya, thread ad�: Thread-0
		1 numaral� dosya, thread ad�: Thread-1
		2 numaral� dosya, thread ad�: Thread-0
		2 numaral� dosya, thread ad�: Thread-1
		3 numaral� dosya, thread ad�: Thread-1
		3 numaral� dosya, thread ad�: Thread-0
		4 numaral� dosya, thread ad�: Thread-1
		4 numaral� dosya, thread ad�: Thread-0
		5 numaral� dosya, thread ad�: Thread-1
		5 numaral� dosya, thread ad�: Thread-0
		6 numaral� dosya, thread ad�: Thread-1
		6 numaral� dosya, thread ad�: Thread-0
		7 numaral� dosya, thread ad�: Thread-1
		7 numaral� dosya, thread ad�: Thread-0
		8 numaral� dosya, thread ad�: Thread-1
		8 numaral� dosya, thread ad�: Thread-0
		9 numaral� dosya, thread ad�: Thread-1
		9 numaral� dosya, thread ad�: Thread-0
	 * */
	/* Output ith snycronized
	0 numaral� dosya, thread ad�: Thread-0
	1 numaral� dosya, thread ad�: Thread-0
	2 numaral� dosya, thread ad�: Thread-0
	3 numaral� dosya, thread ad�: Thread-0
	4 numaral� dosya, thread ad�: Thread-0
	5 numaral� dosya, thread ad�: Thread-0
	6 numaral� dosya, thread ad�: Thread-0
	7 numaral� dosya, thread ad�: Thread-0
	8 numaral� dosya, thread ad�: Thread-0
	9 numaral� dosya, thread ad�: Thread-0
	0 numaral� dosya, thread ad�: Thread-1
	1 numaral� dosya, thread ad�: Thread-1
	2 numaral� dosya, thread ad�: Thread-1
	3 numaral� dosya, thread ad�: Thread-1
	4 numaral� dosya, thread ad�: Thread-1
	5 numaral� dosya, thread ad�: Thread-1
	6 numaral� dosya, thread ad�: Thread-1
	7 numaral� dosya, thread ad�: Thread-1
	8 numaral� dosya, thread ad�: Thread-1
	9 numaral� dosya, thread ad�: Thread-1
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
				System.out.println(i+" numaral� dosya, thread ad�: "+Thread.currentThread().getName());
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

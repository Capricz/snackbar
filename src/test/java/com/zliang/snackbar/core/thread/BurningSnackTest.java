package com.zliang.snackbar.core.thread;

import java.util.Random;

public class BurningSnackTest implements Runnable{
	
	private int percentage;
	private String name;
	
	public BurningSnackTest(int percentage,String name){
		this.percentage = percentage;
		this.name = name;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 100;
		String name="hello";
		BurningSnackTest r = new BurningSnackTest(i,name);
		BurningSnackTest r2 = new BurningSnackTest(i,name);
//		BurningSnackTest r1 = new BurningSnackTest();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r2);
//		Thread t3 = new Thread(r1);
//		Thread t4 = new Thread(r1);
		
		t1.start();
		t2.start();
//		t3.start();
//		t4.start();
	}

	public void run() {
//		synchronized (this) {
			while(notFinished()){
				/*try {
//					Thread.sleep(new Random().nextInt(5));
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}*/
//				synchronized (this) {
				    if("Thread-0".equals(Thread.currentThread().getName()))
				    {
				    	try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				    }
				    if("Thread-1".equals(Thread.currentThread().getName())) {
				    	try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				    	name = "Carbin";
				    }
					System.out.println("thread name = "+Thread.currentThread().getName()+", percentage="+percentage+",name="+name);
//					if(percentage!=0)percentage--;
					percentage--;
			}
//		}
	}
	
	public boolean notFinished(){
		return percentage>0;
	}

}

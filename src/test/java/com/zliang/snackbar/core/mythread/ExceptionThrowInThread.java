package com.zliang.snackbar.core.mythread;

public class ExceptionThrowInThread {

	public static void main(String[] args) {
		Thread t = new Thread(new Runnable(){
			@Override
			public void run() {
				System.out.println("in thread run method...");
//				try {
//					Thread.sleep(10000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
				throw new NullPointerException();
			}
			
		});
		t.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("in main method...");
	}

}

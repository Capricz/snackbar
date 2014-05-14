package com.zliang.snackbar.core.mythread;

import java.util.Random;

public class PrintLogThreadTest {

	public static void main(String[] args) {
		Thread t = new Thread(new MyThreadGroupMain("myThreadGroupMain"),new A());
//		Thread t = new Thread(new B());
		t.start();

	}

}

class A implements Runnable{
	int countA = 3;

	@Override
	public void run() {
		while(!Thread.interrupted()){
			System.out.println("(class A)print msg...");
			try {
				if(countA>0){
					System.out.println("new Thread for runnable C");
					new Thread(new MyThreadGroup("myThreadGroup"),new C()).start();
					countA--;
				}
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class B implements Runnable{
	int count = 10;

	@Override
	public void run() {
		while(count>0){
			System.out.println("(class B)print msg... Thread:"+Thread.currentThread().getName()+", count:"+count);
			count--;
			try {
				Thread.sleep(new Random().nextInt(10000000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class C implements Runnable{

	private int count = 3;

	@Override
	public void run() {
		while(count >0 && !Thread.interrupted()){
			if(count<2){
				throw new NullPointerException();
			}
			System.out.println("(class C)print msg... Thread:"+Thread.currentThread().getName()+", count:"+count);
			count--;
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}

class MyThreadGroupMain extends ThreadGroup{

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("in MyThreadGroupMain...");
		String threadName = t.getName();
		System.out.println("will stop parent thread name : "+threadName);
//		try {
//			t.join();
//		} catch (InterruptedException e1) {
//			e1.printStackTrace();
//		}
		t.getThreadGroup().getParent().interrupt();
		
		/*ThreadGroup threadGroup = t.getThreadGroup();
		if(threadGroup!=null){
			ThreadGroup tg = threadGroup;
			StringBuffer sb = new StringBuffer();
			sb.append("maxPriority:"+tg.getMaxPriority());
			sb.append(",name:"+tg.getName());
			sb.append(",parent:"+tg.getParent());
//			System.out.println(sb.toString());
//			threadGroup.uncaughtException(t, e);
			System.out.println("print thread group list");
			t.getThreadGroup().list();
			t.getThreadGroup().interrupt();
			ThreadGroup parentTG = threadGroup.getParent();
			System.out.println("will stop parent thread name : "+parentTG.getName());
			parentTG.uncaughtException(t, e);
//			System.exit(1);
		}*/
	}

	public MyThreadGroupMain(String name) {
		super(name);
	}
}

class MyThreadGroup extends ThreadGroup{

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		ThreadGroup threadGroup = t.getThreadGroup();
		String threadName = t.getName();
		System.out.println("will stop thread name : "+threadName);
		t.interrupt();
		/*if(threadGroup!=null){
			ThreadGroup parentTG = threadGroup.getParent();
			if(parentTG!=null){
				parentTG.uncaughtException(t, e);
			}
		}*/
//		super.uncaughtException(t, e);
	}

	public MyThreadGroup(String name) {
		super(name);
	}
}
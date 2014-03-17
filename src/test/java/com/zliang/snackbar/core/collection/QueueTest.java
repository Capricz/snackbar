package com.zliang.snackbar.core.collection;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.DelayQueue;

public class QueueTest {

	public static void main(String[] args) {
		ArrayDeque<String> q = new ArrayDeque<String>();
		q.push("a");
		q.push("b");
		q.push("c");;
		System.out.println(q);
		q.offer("e");
		System.out.println(q);
		String peek = q.peek();
		System.out.println("peek = "+peek);
		System.out.println(q);
		String pop = q.pop();
		System.out.println("pop = "+pop);
		System.out.println(q);
		String poll = q.poll();
		System.out.println("poll = "+poll);
		System.out.println(q);
	}

}

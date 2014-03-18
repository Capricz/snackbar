package com.zliang.snackbar.core.reference;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class ReferenceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String snack = "snack";
		WeakReference<String> rsnack = new WeakReference<String>(snack);
		snack = null;
		//get the object of weak reference
		System.out.println(rsnack.get());
		System.gc();
		//Runs the finalization methods of any objects pending finalization. 
		System.runFinalization();
		System.out.println(rsnack.get());

	}

}

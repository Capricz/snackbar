package com.zliang.snackbar.core.loop;

public class OuterLoopTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		outer1:
			for(int i = 0; i < 5 ;i++) {
				for (int j = 0; j < 3; j++) {
					if(j==1){
						System.out.println("i="+i+", j="+j);
						break outer1;
//						break;
					}
				}
			}
	}

}

package com.zliang.snackbar.core.homework;

public class DrawCircle {

	/**
	 * Draw a circle base on the given radius r
	 * @param args
	 */
	public static void main(String[] args) {
		int r = 5;
		int scale = 1;
		int length = scale*r;
		String[][] unitRightUp = new String[length][length];
//		String[][] leftUp = new String[length][length];
//		
//		String[][] leftDown = new String[length][length];
//		String[][] rightDown = new String[length][length];
		
//		double aa = 1.2;
//		System.out.println(Math.toRadians(120));
		
		/*String[][] aa = new String[3][3];
		for (int i = 0; i < aa.length; i++) {
			for (int j = 0; j < aa[i].length; j++) {
				aa[i][j] = "#";
			}
		}
		aa[1][0] = "*";
		aa[0][1] = "*";
		
		printArr(aa);*/
		
		initalArr(unitRightUp);
		int a = 0;
		int b = 0;
		for(double i = 0.0; i < 90.0 ; i += 0.0001){
			double x = Math.abs(Math.cos(Math.toRadians(i))*r);
			double y = Math.abs(Math.sin(Math.toRadians(i))*r);
			setValue(unitRightUp,a,b,x,y,length);
//			leftUp[x==length?(int)length-1:(int)x][y==length?(int)length-1:(int)y] = "*";
//			System.out.print("[x,y]=["+x+","+y+"]");
		}
		
		/*for(int i=0;i<unitRightUp.length;i++){
			for(int j = 0;j<rightUp[i].length;j++){
//				System.out.print("[x,y]=["+i+","+j+"]");
				unitRightUp[i][j] = unitRightUp[i][length-j-1];
			}
		}
		
		for(int i=0;i<unitRightUp.length;i++){
			for(int j = 0;j<unitRightUp[i].length;j++){
//				System.out.print("[x,y]=["+i+","+j+"]");
				leftDown[i][j] = rightUp[length-i-1][length-j-1];
			}
		}
		
		for(int i=0;i<rightUp.length;i++){
			for(int j = 0;j<rightUp[i].length;j++){
//				System.out.print("[x,y]=["+i+","+j+"]");
				rightDown[i][j] = rightUp[length-i-1][j];
			}
		}*/
		
		String[][] result = new String[2*length][2*length];
		for (int i = result.length-1; i >= 0; i--) {
			if(i < length){
				for(int j=0;j<result[i].length;j++){
					if(j<length){
						result[i][j] = unitRightUp[length-j-1][length-i-1];
					}else{
						result[i][j] = unitRightUp[j-length][length - i -1];
					}
					
				}
			} else{
				for (int j = 0; j < result[i].length; j++) {
					if(j<length){
						result[i][j] = unitRightUp[i-length][length - j -1];
					}else{
						result[i][j] = unitRightUp[i-length][j-length];
					}
				}
			}
			/*for (int j = 0; j < result[i].length; j++) {
				if(i >= length && j < length){
					result[i][j] = rightUp[i-length][j];
				}
				
				if(i >= length && j >= length){
					result[i][j] = rightUp[i-length][j-length];
				}
				
				if(i < length && j >= length){
					result[i][j] = rightUp[i][j-length];
				}
				
				if(i < length && j < length){
					result[i][j] = rightUp[i][j];
				}*/
		}
		
//		System.out.println("####################### right up ####################");
//		printArr(rightUp);
		/*System.out.println("####################### left up ####################");
		printArr(leftUp);
		System.out.println("####################### right down ####################");
		printArr(rightDown);
		System.out.println("####################### left down  ####################");
		printArr(leftDown);*/
		
		printArr(result);
		
//		System.out.println(Math.sin(Math.toRadians(30)));
		
		/*leftUp = drawLeftUp(leftUp,length);
		
		for(int i=leftUp.length-1;i>=0;i--){
			for (int j = 0; j < leftUp[i].length; j++) {
				System.out.print(leftUp[i][j]);
			}
			System.out.println();
		}*/
		
		/*for (int i = 0; i < leftUp.length; i++) {
			for (int j = 0; j < leftUp[i].length; j++) {
				System.out.print(leftUp[i][j]);
			}
			System.out.println();
		}*/
		
		
	}

	private static void setValue(String[][] leftUp, int a, int b,double x,double y,int length) {
		a = (int)x;
		b = (int)y;
		if(a==length){
			leftUp[a-1][b] = " * ";
		}
		else if(b==length){
			leftUp[a][b-1] = " * ";
		} else{
			leftUp[a][b] = " * ";
		}
	}

	private static void initalArr(String[][] leftUp) {
		for (int i = 0; i < leftUp.length; i++) {
			for (int j = 0; j < leftUp[i].length; j++) {
				leftUp[i][j] = "  ";
			}
		}
	}

	private static void printArr(String[][] aa) {
		for(int i = aa.length-1;i>=0;i--){
			for(int j = 0 ;j<aa[i].length;j++){
				System.out.print(aa[i][j]);
			}
			System.out.println();
		}
		
	}

	/*private static String[][] drawLeftUp(String[][] leftUp,int r) {
//		double degree0 = Math.toDegrees(0);
//		double degree30 = Math.toDegrees(30);
//		double degree45 = Math.toDegrees(45);
//		double degree60 = Math.toDegrees(60);
//		double degree90 = Math.toDegrees(90);
		
//		double degree0 = Math.toRadians(0);
//		double degree30 = Math.toRadians(30);
//		double degree45 = Math.toRadians(45);
//		double degree60 = Math.toRadians(60);
//		double degree90 = Math.toRadians(90);
//		
//		
//		int starPosArr[][] = new int[r][r];
//		double x,y = 0.0;
//		//0 degree
//		starPosArr[0][0] = 1;
//		
//		//30 degree
//		x = r - Math.cos(degree30)*r;
//		y = Math.sin(degree30)*r;
//		starPosArr[(int)x][(int)y] = 1;
//		
//		//45 degree
//		x = r - Math.cos(degree45)*r;
//		y = Math.sin(degree45)*r;
//		starPosArr[(int)x][(int)y] = 1;
//		
//		//60 degree
//		x = r - Math.cos(degree60)*r;
//		y = Math.sin(degree60)*r;
//		starPosArr[(int)x][(int)y] = 1;
//		
//		//90 degree
//		starPosArr[r-1][r-1] = 1;
//		
//		for (int i = 0; i < starPosArr.length; i++) {
//			for (int j = 0; j < starPosArr[i].length; j++) {
//				if(starPosArr[i][j] == 1){
//					leftUp[i][j] = "*";
//				}
//			}
//		}
		
		for(double i = 0.0; i < 90.0 ; i++){
			double x = (1.0 - Math.cos(Math.toRadians(i)))*r;
			double y = Math.sin(Math.toRadians(i))*r;
			leftUp[(int)x][(int)y] = "*";
		}
		
		return leftUp;
	}*/

}

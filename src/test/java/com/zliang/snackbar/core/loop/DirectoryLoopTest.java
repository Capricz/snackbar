package com.zliang.snackbar.core.loop;

import java.io.File;

public class DirectoryLoopTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String root = "C:\\workspace jee";
		searchSubDirectory(root);
	}

	private static void searchSubDirectory(String path) {
		if(!path.endsWith("/")){
			path = path+"/";
		}
		File f = new File(path);
		if(f.isDirectory()){
			System.out.println(f.getAbsolutePath());
			String[] list = f.list();//only retrieve the sub directory name
			if(list!=null && list.length>=0){
				for (int i = 0; i < list.length; i++) {
					String filePath = path + list[i];
					searchSubDirectory(filePath);
				}
			}
		} else{
			return;
		}
	}

}

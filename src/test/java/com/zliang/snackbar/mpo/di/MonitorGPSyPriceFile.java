package com.zliang.snackbar.mpo.di;

import java.util.ArrayList;
import java.util.List;

public class MonitorGPSyPriceFile {

	public static void main(String[] args) {
		
		//load config file
		
		//load database connection
		
		//Step#1 – find all the gpsy_filename created between past 1 hour to 48 hours
		List<String> priceFileNameList = fetchPriceFileNameList();
		
		//Step#2 – compare the list of gpsy_filename generated from step#1 to the file in the below server/folder
		List<String> existFileNameList = fetchExistFileNameList();
		List<String> needUpdateFileNameList = new ArrayList();
		if(priceFileNameList!=null && !priceFileNameList.isEmpty()){
			if(existFileNameList != null && !existFileNameList.isEmpty()){
				for (String fileName : priceFileNameList) {
					if(!priceFileNameList.contains(fileName)){
						needUpdateFileNameList.add(fileName);
					}
				}
			} else{
				needUpdateFileNameList.addAll(priceFileNameList);
				System.out.println("there is no file exist under folder, update all price record...");
			}
		} else{
			System.out.println("can not fetch record from database");
		}
		
		//Step#3 For each extra filename in the list of step#1, update the pub_status_fg from 2 to 1 to force the file re-sent.
		if(needUpdateFileNameList!=null && !needUpdateFileNameList.isEmpty()){
			updateProductPricesLogs(needUpdateFileNameList);
			
			sendNotificationEmail();
		} else{
			System.out.println("there is no need to update price table...");
		}
		
	}

	private static void sendNotificationEmail() {
		
	}

	private static void updateProductPricesLogs(List<String> needUpdateFileNameList) {
		// TODO Auto-generated method stub
		
	}

	private static List<String> fetchExistFileNameList() {
		// TODO Auto-generated method stub
		return null;
	}

	private static List<String> fetchPriceFileNameList() {
		// TODO Auto-generated method stub
		return null;
	}

}

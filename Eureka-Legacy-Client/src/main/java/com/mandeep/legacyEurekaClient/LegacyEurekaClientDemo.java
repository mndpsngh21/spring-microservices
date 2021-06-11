package com.mandeep.legacyEurekaClient;

import com.netflix.appinfo.InstanceInfo;

/**
 * 
 * @author Mandeep
 * 
 * This is sample application for connect EurekaServer to get url for MicroService Instance. 
 * This can be useful incase there is any code which is present in legacy java code or code implementation is without Spring boot.
 *
 */
public class LegacyEurekaClientDemo {
	public static void main(String[] args) {
		EurekaLegacyClient eurekaLegacyClient = EurekaLegacyClient.getEurekaLegacyClient();
		/**
		 * You can replace below value with your microservice name
		 */
		String MICROSERVICE_NAME = "STOCK-SERVICE";
		InstanceInfo instanceInfo= eurekaLegacyClient.getEurekaInfo(MICROSERVICE_NAME);
		/**
		 * Let us print IPAddresss and port to connect
		 */
		System.out.println("You can connect to microService @ "+instanceInfo.getIPAddr()+":"+instanceInfo.getPort());
	}
}

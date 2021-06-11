package com.mandeep.legacyEurekaClient;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.appinfo.MyDataCenterInstanceConfig;
import com.netflix.discovery.DefaultEurekaClientConfig;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.DiscoveryManager;
import com.netflix.discovery.EurekaClient;

public class EurekaLegacyClient {

	private static EurekaLegacyClient eurekaLegacyClient;
	private EurekaClient discoveryClient;

	private EurekaLegacyClient() {

	}

	public synchronized static EurekaLegacyClient getEurekaLegacyClient() {
		if (eurekaLegacyClient == null) {
			eurekaLegacyClient = new EurekaLegacyClient();
		}
		return eurekaLegacyClient;
	}

	@SuppressWarnings("deprecation")
	public EurekaClient getDiscoveryClient(String microServiceName) {
		if (discoveryClient != null) {
			return discoveryClient;
		}
		DiscoveryManager.getInstance().initComponent(new MyDataCenterInstanceConfig(), new DefaultEurekaClientConfig());
		discoveryClient = DiscoveryManager.getInstance().getEurekaClient();
		return discoveryClient;
	}

	@SuppressWarnings("deprecation")
	public InstanceInfo getEurekaInfo(String microServiceName) throws RuntimeException {
		InstanceInfo nextServerInfo = null;
		EurekaClient eurekaClient = getDiscoveryClient(microServiceName);

		try {
			nextServerInfo = eurekaClient.getNextServerFromEureka(microServiceName, false);
			return nextServerInfo;
		} catch (Exception e) {
			System.err.println("Cannot get an instance of example service to talk to from eureka");
			throw new RuntimeException("No instance Found");
		}
	}

}

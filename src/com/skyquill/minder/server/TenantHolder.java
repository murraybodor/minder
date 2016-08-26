package com.skyquill.minder.server;

public class TenantHolder {

	private static class TenantThreadLocal extends ThreadLocal<Object> {

		String tenant;

		public void setTenant(String tenant) {
			this.tenant = tenant;
		}

		public String getTenant() {
			return tenant;
		}

	}

	private static TenantThreadLocal ttl = new TenantThreadLocal();

	public static String getTenant() {
		return ttl.getTenant();
	}

	public static void setTenant(String tenant) {
		ttl.setTenant(tenant);
	}
}

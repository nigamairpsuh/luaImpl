package tarantool.com.sp;

import static tarantool.com.sp.SPConstants.getAdvertiserDetailsByCreative;

import java.util.List;

import org.tarantool.TarantoolClient;

import tarantool.com.client.TaranToolClientUtil;

public class IncDecCampSpend {
	public static void main(String[] args) {

		TarantoolClient client = TaranToolClientUtil.getClient();
		// ADVERTISER_ID, CAMPAIGN_ID, BALANCE_DATE	
		List<?> result = client.syncOps().call(getAdvertiserDetailsByCreative, 228849,2118232,20171122);
		System.out.println("getAdvertiserDetailsByCreative Result- " + result.toString());

	}
}

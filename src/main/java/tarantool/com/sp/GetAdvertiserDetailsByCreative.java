package tarantool.com.sp;

import static tarantool.com.sp.SPConstants.incDecCampSpend;

import java.util.List;

import org.tarantool.TarantoolClient;

import tarantool.com.client.TaranToolClientUtil;

public class GetAdvertiserDetailsByCreative {
	public static void main(String[] args) {

		TarantoolClient client = TaranToolClientUtil.getClient();
		// ADVERTISER_ID,PUBLISHER_ID, CAMPAIGN_ID, CREATIVE_ID, BALANCE_DATE, NFR_RUNNING_DAILY_SPEND, CLICK_COUNT	
		List<?> result = client.syncOps().call(incDecCampSpend, 228849,0,2118232,11111,20171122, 11.02,100);
		System.out.println("incDecCampSpend Result- " + result.toString());

	}
}

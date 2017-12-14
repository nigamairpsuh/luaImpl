package tarantool.com.sp;

import static tarantool.com.sp.SPConstants.incDecCampPushCountAndPushSpend;

import java.util.List;

import org.tarantool.TarantoolClient;

import tarantool.com.client.TaranToolClientUtil;

public class IncDecCampPushCountAndPushSpend {
	public static void main(String[] args) {

		TarantoolClient client = TaranToolClientUtil.getClient();
		// ADVERTISER_ID,PUBLISHER_ID, CAMPAIGN_ID, CREATIVE_ID, BALANCE_DATE, NFR_RUNNING_DAILY_PUSH_SPEND, NFR_PUSH_COUNT
		List<?> result = client.syncOps().call(incDecCampPushCountAndPushSpend, 228849,0,2118232,11111,20171122, 22.01,11);
		System.out.println("incDecCampPushCountAndPushSpend Result- " + result.toString());

	}
}

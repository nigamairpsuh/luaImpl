package tarantool.com.sp;

import static tarantool.com.sp.SPConstants.*;

import java.util.List;

import org.tarantool.TarantoolClient;

import tarantool.com.client.TaranToolClientUtil;

public class UpdateAdvertiserCampMaxDailyBudget {
	public static void main(String[] args) {

		TarantoolClient client = TaranToolClientUtil.getClient();
		/*
		 * ADVERTISER_ID, CAMPAIGN_ID, BALANCE_DATE, CAMPAIGN_MAX_DAILY_BUGET
		 */
		List<?> result = client.syncOps().call(updateAdvertiserCampMaxDailyBudget, 304003,2120585, 20171208, 50);
		System.out.println("\n\nupdateAdvertiserCampMaxDailyBudget Result- " + result.toString());
	}
}

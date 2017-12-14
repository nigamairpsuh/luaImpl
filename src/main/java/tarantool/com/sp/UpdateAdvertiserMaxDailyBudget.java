package tarantool.com.sp;

import static tarantool.com.sp.SPConstants.updateAdvertiserMaxDailyBudget;

import java.util.List;

import org.tarantool.TarantoolClient;

import tarantool.com.client.TaranToolClientUtil;

public class UpdateAdvertiserMaxDailyBudget {
	public static void main(String[] args) {

		TarantoolClient client = TaranToolClientUtil.getClient();
		// ADVERTISER_ID, BALANCE_DATE, ADVERTISER_MAX_DAILY_BUDGET
		List<?> result = client.syncOps().call(updateAdvertiserMaxDailyBudget, 228849, 20171122, 1000);
		System.out.println("updateAdvertiserMaxDailyBudget Result- " + result.toString());

	}
}

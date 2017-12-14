package tarantool.com.sp;

import static tarantool.com.sp.SPConstants.addCampPushSpend;
import static tarantool.com.sp.SPConstants.getDetailedCampaignBalance;

import java.util.List;

import org.tarantool.TarantoolClient;

import tarantool.com.client.TaranToolClientUtil;

public class AddCampPushSpend {
	public static void main(String[] args) {

		TarantoolClient client = TaranToolClientUtil.getClient();
		// ADVERTISER_ID,PUBLISHER_ID, CAMPAIGN_ID, CREATIVE_ID, BALANCE_DATE, RUNNING_DAILY_PUSH_SPEND,PUSH_COUN
		List<?> result = client.syncOps().call(addCampPushSpend, 304003, 0, 2120018, 4236128, 20171209, 10, 10);
		System.out.println("addCampPushSpend Result- " + result.toString());

		result = client.syncOps().call(getDetailedCampaignBalance, 304003, 2120018, 20171209);
		System.out.println("\n\ngetDetailedCampaignBalance Result- " + result.toString());
	}
}

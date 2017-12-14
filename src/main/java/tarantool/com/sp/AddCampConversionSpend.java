package tarantool.com.sp;

import static tarantool.com.sp.SPConstants.*;

import java.util.List;

import org.tarantool.TarantoolClient;

import tarantool.com.client.TaranToolClientUtil;

public class AddCampConversionSpend {
	public static void main(String[] args) {

		TarantoolClient client = TaranToolClientUtil.getClient();
//		ADVERTISER_ID,PUBLISHER_ID, CAMPAIGN_ID, CREATIVE_ID, BALANCE_DATE, RUNNING_DAILY_SPEND, CLICK_COUNT
		List<?> result = client.syncOps().call(addCampConversionSpend, 304003, 0, 2120018, 4236128, 20171209, 10, 1);
		System.out.println("addCampConversionSpend Result- " + result.toString());

		result = client.syncOps().call(getDetailedCampaignBalance, 304003, 2120018, 20171209);
		System.out.println("\n\ngetDetailedCampaignBalance Result- " + result.toString());
	}
}

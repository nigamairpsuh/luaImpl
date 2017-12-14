package tarantool.com.sp;

import static tarantool.com.sp.SPConstants.*;

import java.util.List;

import org.tarantool.TarantoolClient;

import tarantool.com.client.TaranToolClientUtil;

public class InsertCampaigns {
	public static void main(String[] args) {

		TarantoolClient client = TaranToolClientUtil.getClient();
		// CAMPAIGN_ID,ADVERTISER_ID,CAMPAIGN_NAME,CAMPAIGN_STATUS,CAMPAIGN_DAILYBUDGET,CAMPAIGN_PPMBID,CAMPAIGN_PRIORITY,CAMPAIGN_CATEGORY_ID,CAMPAIGN_CATEGORY_GROUPID
		List<?> result = client.syncOps().call(insertCampaigns, 2120018, 304003, "testCampaign", 1, 100, 100, 1, 1, 1);
		System.out.println("\n\ninsertCampaigns Result- " + result.toString());
	}
}

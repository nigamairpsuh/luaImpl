package tarantool.com.sp;

import static tarantool.com.sp.SPConstants.getAdvertiserCampaignConversions;

import java.util.List;

import org.tarantool.TarantoolClient;

import tarantool.com.client.TaranToolClientUtil;

public class GetAdvertiserCampaignConversions {
	public static void main(String[] args) {

		TarantoolClient client = TaranToolClientUtil.getClient();
		// ADVERTISER_ID,TX_DATE
		List<?> result = client.syncOps().call(getAdvertiserCampaignConversions, 228849,20171122);
		System.out.println("getAdvertiserCampaignConversions Result- " + result.toString());
	}
}

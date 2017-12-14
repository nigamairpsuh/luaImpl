package tarantool.com.sp;

import static tarantool.com.sp.SPConstants.*;

import java.util.List;

import org.tarantool.TarantoolClient;

import tarantool.com.client.TaranToolClientUtil;

public class GetAdvertiserCampaigns {
	public static void main(String[] args) {

		TarantoolClient client = TaranToolClientUtil.getClient();
		// ADVERTISER_ID
		List<?> result = client.syncOps().call(getAdvertiserCampaigns, 304003);
		System.out.println("\n\ngetCampSpend Result- " + result.toString());
	}
}

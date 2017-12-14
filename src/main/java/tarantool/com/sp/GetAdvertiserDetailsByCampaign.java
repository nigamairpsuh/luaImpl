package tarantool.com.sp;

import static tarantool.com.sp.SPConstants.*;

import java.util.List;

import org.tarantool.TarantoolClient;

import tarantool.com.client.TaranToolClientUtil;

public class GetAdvertiserDetailsByCampaign {
	public static void main(String[] args) {

		TarantoolClient client = TaranToolClientUtil.getClient();
		// ADVERTISER_ID, BALANCE_DATE
		List<?> result = client.syncOps().call(getAdvertiserDetailsByCampaign, 228849, 20171122);
		System.out.println("\n\ngetAdvertiserDetailsByCampaign Result- " + result.toString());
	}
}

package tarantool.com.sp;

import static tarantool.com.sp.SPConstants.addConversions;

import java.util.List;

import org.tarantool.TarantoolClient;

import tarantool.com.client.TaranToolClientUtil;

public class AddConversions {
	public static void main(String[] args) {

		TarantoolClient client = TaranToolClientUtil.getClient();
		// CONVERSION_DATE,ADVERTISER_ID,CAMPAIGN_ID,CREATIVE_ID,CONVERSION_SPEND,CONVERSION_COUNT
		List<?> result = client.syncOps().call(addConversions, 20171122,228849,2118232,11111,0.03,1);
		System.out.println("addConversions Result- " + result.toString());
	}
}

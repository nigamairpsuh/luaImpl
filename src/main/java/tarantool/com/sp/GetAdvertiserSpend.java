package tarantool.com.sp;

import static tarantool.com.sp.SPConstants.getAdvertiserSpend;

import java.util.List;

import org.tarantool.TarantoolClient;

import tarantool.com.client.TaranToolClientUtil;

public class GetAdvertiserSpend {
	public static void main(String[] args) {

		TarantoolClient client = TaranToolClientUtil.getClient();
		//  ADVERTISER_ID, BALANCE_DATE
		List<?> result = client.syncOps().call(getAdvertiserSpend, 228849,20171122);
		System.out.println("getAdvertiserSpend Result- " + result.toString());

	}
}

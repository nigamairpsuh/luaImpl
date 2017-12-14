package tarantool.com.sp;

import static tarantool.com.sp.SPConstants.getAdvertiserLedgerData;

import java.util.List;

import org.tarantool.TarantoolClient;

import tarantool.com.client.TaranToolClientUtil;

public class GetAdvertiserLedgerData {
	public static void main(String[] args) {

		TarantoolClient client = TaranToolClientUtil.getClient();
		// ADVERTISER_ID
		List<?> result = client.syncOps().call(getAdvertiserLedgerData, 304003);
		System.out.println("getAdvertiserLedgerData Result- " + result.toString());

	}
}

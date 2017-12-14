package tarantool.com.sp;

import static tarantool.com.sp.SPConstants.*;

import java.util.List;

import org.tarantool.TarantoolClient;

import tarantool.com.client.TaranToolClientUtil;

public class GetCampSpend {
	public static void main(String[] args) {

		TarantoolClient client = TaranToolClientUtil.getClient();
		// ADVERTISER_ID, CAMPAIGN_ID, BALANCE_DATE,
		List<?> result = client.syncOps().call(getCampSpend, 304003, 2120018, 20171209);
		System.out.println("\n\ngetCampSpend Result- " + result.toString());
	}
}

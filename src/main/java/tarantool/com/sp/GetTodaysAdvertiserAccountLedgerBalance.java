package tarantool.com.sp;

import static tarantool.com.sp.SPConstants.getTodaysAdvertiserAccountLedgerBalance;

import java.util.List;

import org.tarantool.TarantoolClient;

import tarantool.com.client.TaranToolClientUtil;

public class GetTodaysAdvertiserAccountLedgerBalance {
	public static void main(String[] args) {

		TarantoolClient client = TaranToolClientUtil.getClient();
		//  ADVERTISER_ID, BALANCE_DATE
		List<?> result = client.syncOps().call(getTodaysAdvertiserAccountLedgerBalance, 654321,20150101);
		System.out.println("getTodaysAdvertiserAccountLedgerBalance Result- " + result.toString());

	}
}

package tarantool.com.sp;

import static tarantool.com.sp.SPConstants.insertAdvertiserLedgerTX;

import java.util.List;

import org.tarantool.TarantoolClient;

import tarantool.com.client.TaranToolClientUtil;

public class InsertAdvertiserLedgerTX {
	public static void main(String[] args) {

		TarantoolClient client = TaranToolClientUtil.getClient();
		//  carrier_id, country_id, carrier_name, country_name
		List<?> result = client.syncOps().call(insertAdvertiserLedgerTX, 304003, 1, 20171216, 100, 100);
		System.out.println("insertAdvertiserLedgerTX Result- " + result.toString());

	}
}

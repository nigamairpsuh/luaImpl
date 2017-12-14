package tarantool.com.sp;

import static tarantool.com.sp.SPConstants.insertCarrier;

import java.util.List;

import org.tarantool.TarantoolClient;

import tarantool.com.client.TaranToolClientUtil;

public class InsertCarrier {
	public static void main(String[] args) {

		TarantoolClient client = TaranToolClientUtil.getClient();
		//  carrier_id, country_id, carrier_name, country_name
		List<?> result = client.syncOps().call(insertCarrier, 1,1, "Airtel", "India");
		System.out.println("insertCarrier Result- " + result.toString());

	}
}

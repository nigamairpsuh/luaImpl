package tarantool.com.sp;

import static tarantool.com.sp.SPConstants.insertCountry;

import java.util.List;

import org.tarantool.TarantoolClient;

import tarantool.com.client.TaranToolClientUtil;

public class InsertCountry {
	public static void main(String[] args) {

		TarantoolClient client = TaranToolClientUtil.getClient();
		//  COUNTRY_ID, COUNTRY_NAME
		List<?> result = client.syncOps().call(insertCountry, 1, "India");
		System.out.println("insertCountry Result- " + result.toString());

	}
}

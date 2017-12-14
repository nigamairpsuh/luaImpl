package tarantool.com.sp;

import static tarantool.com.sp.SPConstants.insertPhoneModel;

import java.util.List;

import org.tarantool.TarantoolClient;

import tarantool.com.client.TaranToolClientUtil;

public class InsertPhoneModel {
	public static void main(String[] args) {

		TarantoolClient client = TaranToolClientUtil.getClient();
		// STATE_ID, COUNTRY_ID, STATE_NAME, STATE_COUNTRY_NAME
		List<?> result = client.syncOps().call(insertPhoneModel, 1, 1, "Samsung", "2");
		System.out.println("insertPhoneModel Result- " + result.toString());

	}
}

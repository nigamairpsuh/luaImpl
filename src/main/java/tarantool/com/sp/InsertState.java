package tarantool.com.sp;

import static tarantool.com.sp.SPConstants.insertState;

import java.util.List;

import org.tarantool.TarantoolClient;

import tarantool.com.client.TaranToolClientUtil;

public class InsertState {
	public static void main(String[] args) {

		TarantoolClient client = TaranToolClientUtil.getClient();
		// STATE_ID, COUNTRY_ID, STATE_NAME, STATE_COUNTRY_NAME
		List<?> result = client.syncOps().call(insertState, 1, 1, "Karnataka", "India");
		System.out.println("insertState Result- " + result.toString());

	}
}

package tarantool.com.sp;

import static tarantool.com.sp.SPConstants.*;

import java.util.List;

import org.tarantool.TarantoolClient;

import tarantool.com.client.TaranToolClientUtil;

public class InsertApplication {
	public static void main(String[] args) {

		TarantoolClient client = TaranToolClientUtil.getClient();
		// APPLICATION_ID,PUBLISHER_ID,APPLICATION_NAME,APPLICATION_STATUS,APPLICATION_CATEGORY,APPLICATION_FREQUENCY,APPLICATION_URL,ALL_USERS,IS_BRAND_SAFE
		List<?> result = client.syncOps().call(insertApplication, 1, 1, "testApp", 1, 1, 1, "testapp.com", 10, 1);
		System.out.println("\n\ninsertApplication Result- " + result.toString());
	}
}

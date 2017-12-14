package tarantool.com.sp;

import static tarantool.com.sp.SPConstants.*;

import java.util.List;

import org.tarantool.TarantoolClient;

import tarantool.com.client.TaranToolClientUtil;

public class InsertManufacturer {
	public static void main(String[] args) {

		TarantoolClient client = TaranToolClientUtil.getClient();
		// MANUFACTURER_ID, MANUFACTURER_NAME
		List<?> result = client.syncOps().call(insertManufacturer, 1, "ABC");
		System.out.println("\n\ninsertManufacturer Result- " + result.toString());
	}
}

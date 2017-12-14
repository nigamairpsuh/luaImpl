package tarantool.com.sp;

import static tarantool.com.sp.SPConstants.*;

import java.util.List;

import org.tarantool.TarantoolClient;

import tarantool.com.client.TaranToolClientUtil;

public class GetDeveloperEarnings {
	public static void main(String[] args) {

		TarantoolClient client = TaranToolClientUtil.getClient();
		// PUBLISHER_ID,TX_DATE
		List<?> result = client.syncOps().call(getDeveloperEarnings, 1, 3);
		System.out.println("\n\ngetDeveloperEarnings Result- " + result.toString());
	}
}

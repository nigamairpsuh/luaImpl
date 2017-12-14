package tarantool.com.sp;

import static tarantool.com.sp.SPConstants.*;

import java.util.List;

import org.tarantool.TarantoolClient;

import tarantool.com.client.TaranToolClientUtil;

public class InsertNetworkConnection {
	public static void main(String[] args) {

		TarantoolClient client = TaranToolClientUtil.getClient();
//		NETWORK_ID, NETWORK_TYPE
		List<?> result = client.syncOps().call(insertNetworkConnection, 1, 10);
		System.out.println("\n\ninsertNetworkConnection Result- " + result.toString());

	}
}

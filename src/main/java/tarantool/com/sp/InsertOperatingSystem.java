package tarantool.com.sp;

import static tarantool.com.sp.SPConstants.insertOperatingSystem;

import java.util.List;

import org.tarantool.TarantoolClient;

import tarantool.com.client.TaranToolClientUtil;

public class InsertOperatingSystem {
	public static void main(String[] args) {

		TarantoolClient client = TaranToolClientUtil.getClient();
		//  OS_ID, OS_VERSION, OS_NAME, OS_TYPE
		List<?> result = client.syncOps().call(insertOperatingSystem, 1, "India");
		System.out.println("insertOperatingSystem Result- " + result.toString());

	}
}

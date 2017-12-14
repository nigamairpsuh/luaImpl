package tarantool.com.sp;

import static tarantool.com.sp.SPConstants.insertUsers;

import java.util.List;

import org.tarantool.TarantoolClient;

import tarantool.com.client.TaranToolClientUtil;

public class InsertUsers {
	public static void main(String[] args) {

		TarantoolClient client = TaranToolClientUtil.getClient();
		//  USER_ID, FIRST_NAME, LAST_NAME, EMAIL, USER_STATUS, USER_TYPE, CUT_OFF
		List<?> result = client.syncOps().call(insertUsers, 1, "akshay", "nigam", "akshay.deep@airpush.com", 1, 1, 100);
		System.out.println("insertUsers Result- " + result.toString());

	}
}

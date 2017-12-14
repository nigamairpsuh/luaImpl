package tarantool.com.sp;

import static tarantool.com.sp.SPConstants.insertCategoryType;

import java.util.List;

import org.tarantool.TarantoolClient;

import tarantool.com.client.TaranToolClientUtil;

public class InsertCategoryType {
	public static void main(String[] args) {

		TarantoolClient client = TaranToolClientUtil.getClient();
		//  COUNTRY_ID, COUNTRY_NAME
		List<?> result = client.syncOps().call(insertCategoryType, 1, "category1", 1);
		System.out.println("insertCategoryType Result- " + result.toString());

	}
}

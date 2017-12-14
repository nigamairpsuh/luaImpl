package tarantool.com.sp;

import static tarantool.com.sp.SPConstants.insertDeliveryIABCategory;

import java.util.List;

import org.tarantool.TarantoolClient;

import tarantool.com.client.TaranToolClientUtil;

public class InsertDeliveryIABCategory {
	public static void main(String[] args) {

		TarantoolClient client = TaranToolClientUtil.getClient();
		// IAB_CATEGORY_ID, IAB_ID, IAB_CATEGORY_NAME, IAB_STATUS, IAB_PARENT_CATEGORY_ID
		List<?> result = client.syncOps().call(insertDeliveryIABCategory, 1, 1, "bb", 1, 1);
		System.out.println("insertDeliveryIABCategory Result- " + result.toString());

	}
}

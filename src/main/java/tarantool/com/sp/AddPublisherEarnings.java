package tarantool.com.sp;

import static tarantool.com.sp.SPConstants.*;

import java.util.List;

import org.tarantool.TarantoolClient;

import tarantool.com.client.TaranToolClientUtil;

public class AddPublisherEarnings {
	public static void main(String[] args) {

		TarantoolClient client = TaranToolClientUtil.getClient();
//		PUBLISHER_ID,APPLICATION_ID,TX_DATE,TX_HOUR,CLICK_COUNT,RUNNING_EARNINGS
		List<?> result = client.syncOps().call(addPublisherEarnings, 1, 1, 20171214, 20, 1, 1);
		System.out.println("addPublisherEarnings Result- " + result.toString());

	}
}

package tarantool.com.sp;

import static tarantool.com.sp.SPConstants.*;

import java.util.List;

import org.tarantool.TarantoolClient;

import tarantool.com.client.TaranToolClientUtil;

public class IncDecPublisherPushCountAndEarning {
	public static void main(String[] args) {

		TarantoolClient client = TaranToolClientUtil.getClient();
		// PUBLISHER_ID,APPLICATION_ID,TX_DATE,TX_HOUR,NFR_PUSH_COUNT,NFR_RUNNING_EARNINGS
		List<?> result = client.syncOps().call(incDecPublisherPushCountAndEarning, 1,2,3,4,10,20);
		System.out.println("\n\nincDecPublisherPushCountAndEarning Result- " + result.toString());
	}
}

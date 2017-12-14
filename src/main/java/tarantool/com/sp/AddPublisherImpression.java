package tarantool.com.sp;

import static tarantool.com.sp.SPConstants.*;

import java.util.List;

import org.tarantool.TarantoolClient;

import tarantool.com.client.TaranToolClientUtil;

public class AddPublisherImpression {
	public static void main(String[] args) {

		TarantoolClient client = TaranToolClientUtil.getClient();
		// PUBLISHER_ID,APPLICATION_ID,TX_DATE,TX_HOUR,PUSH_COUNT
		List<?> result = client.syncOps().call(addPublisherImpression, 1,2,3,4,5);
		System.out.println("\n\naddPublisherImpression Result- " + result.toString());
	}
}

package tarantool.com.sp;

import static tarantool.com.sp.SPConstants.*;

import java.util.List;

import org.tarantool.TarantoolClient;

import tarantool.com.client.TaranToolClientUtil;

public class InsertCampaignGroups {
	public static void main(String[] args) {

		TarantoolClient client = TaranToolClientUtil.getClient();
		// GROUP_ID,GROUP_NAME,GROUP_STATUS,ADMIN_ID
		List<?> result = client.syncOps().call(insertCampaignGroups, 1, "g1", 1, 1);
		System.out.println("\n\ninsertCampaignGroups Result- " + result.toString());
	}
}

package tarantool.com.sp;

import static tarantool.com.sp.SPConstants.*;

import java.util.List;

import org.tarantool.TarantoolClient;

import tarantool.com.client.TaranToolClientUtil;

public class InsertLandingPage {
	public static void main(String[] args) {

		TarantoolClient client = TaranToolClientUtil.getClient();
		// LANDING_PAGE_ID,CREATIVE_ID,CAMPAIGN_ID,LANDING_PAGE_URL,LANDING_PAGE_STATUS
		List<?> result = client.syncOps().call(insertLandingPage, 1, 1, 1, 1 ,1);
		System.out.println("\n\ninsertLandingPage Result- " + result.toString());
	}
}

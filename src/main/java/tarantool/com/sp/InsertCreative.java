package tarantool.com.sp;

import static tarantool.com.sp.SPConstants.insertCreative;

import java.util.List;

import org.tarantool.TarantoolClient;

import tarantool.com.client.TaranToolClientUtil;

public class InsertCreative {
	public static void main(String[] args) {

		TarantoolClient client = TaranToolClientUtil.getClient();
		// CREATIVE_ID, CAMPAIGN_ID, CREATIVE_NAME, CREATIVE_STATUS,
		// CREATIVE_TYPE, CREATIVE_URL, CREATIVE_TEXTAD_TITLE,
		// CREATIVE_TEXTAD_DESC, CREATIVE_AD_IMAGE, CREATIVE_TEXT_COLOR,
		// CREATIVE_TEXT_BGCOLOR, CREATIVE_BANNER_PATH, CREATIVE_SIZE_CATEGOR
		List<?> result = client.syncOps().call(insertCreative, 4236128, 2120018, "testcreative", 1, 1, 1,
				"creative.com", "CREATIVE", "desc", 1, 1, 1, 1, 1);
		System.out.println("insertCreative Result- " + result.toString());

	}
}

package tarantool.com.sp;

import static tarantool.com.sp.SPConstants.*;

import java.util.List;

import org.tarantool.TarantoolClient;

import tarantool.com.client.TaranToolClientUtil;

public class InsertTransaction {
	public static void main(String[] args) {

		TarantoolClient client = TaranToolClientUtil.getClient();
		/*
		 * TX_DATE, TX_HOUR, AD_FORMAT_ID, ADTYPE_ID, APPID, CITY_ID, STATE_ID,
		 * COUNTRY_ID, CARRIER_ID, PHONEMODEL_ID, MANUFACTURER_ID, OS_ID,
		 * CAMPAIGN_ID, CREATIVE_ID, LANDING_PAGE_ID, PUBLISHER_ID,
		 * ADVERTISER_ID, AFFILIATE_ID, FEED_ID, SDKVERSION, WIFI, ALGORITHM_ID,
		 * DEVICE_TYPE, DVC_NETWORK_GENERATION, USER_AGENT_ID, DVC_ORIENTATION,
		 * BROWSER_ID, PLACEMENT_ID, OFFERID, TID, TAGID, TAGUID,
		 * CREATIVE_CATEGORY_ID, CREATIVE_ENT_ID, CREATIVE_SUBCATEGORY_ID,
		 * PLATFORM_ID, PACKAGEID, ZIPCODE, APPCATEGORY, ADOPT, PUSHES,
		 * IMPRESSIONS, CLICKS, CPC_CLICKS, CREATIVE_QUALITY_SCORE_COUNT,
		 * CREATIVE_QUALITY_SCORE_TOTAL, CONVERSIONS, ADV_MIN_BID, EARNINGS,
		 * DEV_EARNINGS, NET_EARNINGS, BID_AMOUNT, WIN_AMOUNT, DISCOUNT_AMOUNT
		 */
		List<?> result = client.syncOps().call(insertTransaction, 20171216, 18, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2120018,
				4236128, 1, 0, 304003, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 10);
		System.out.println("\n\ninsertTransaction Result- " + result.toString());
	}
}

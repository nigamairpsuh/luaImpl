package tarantool.com.sp;

import static tarantool.com.sp.SPConstants.addCampaign;

import java.util.List;

import org.tarantool.TarantoolClient;

import tarantool.com.client.TaranToolClientUtil;

public class AddCampaign {
	public static void main(String[] args) {

		TarantoolClient client = TaranToolClientUtil.getClient();
		// CAMPAIGNID,CAMPAIGNCATEGORYID,UID,CAMPAIGNNAME,DAILYBUDGET,STARTDATE,ENDDATE,PPM,PPMBID,BUDGETSPENT,CAMPAIGNSTATUS,CAMPAIGNTYPE,TARGET,CARRIER,CAMPAIGNEXPIRY,TARGET_CITY,PRIORITY,SDKVERSION,TARGETTRAFFIC,TARGETOSVERSION,ISFEED,AIRPUSH_CATEGORY,CATEGORY_GROUPID,IS_DIRECTRESPONSE,IS_ADULTCONTENT,CREATEDATE,CREATIVES_COUNT_ACTIVE,ISDAYPARTING,SUPERAD,DEVICE_TARGETING,MANU_LIST,DEVICE_CATEGORY,IS_CPI,CPI_BID,IAB_CATEGORY_ID
		// airpushdb.ProcedureList().AddCampaigns
		List<?> result = client.syncOps().call(addCampaign, 2118232,1,228849, "test",100,20171101,20171102,1,2,3,4,"aaaa","bbbb","cccc",20171201,"dddd",5,6,7,8,9,10,11,12,13,20171001,14,15,16,17,18,19,1,100.011,"mobile");
		System.out.println("addCampaign Result- " + result.toString());

	}
}

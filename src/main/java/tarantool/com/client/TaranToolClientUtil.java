package tarantool.com.client;

import static tarantool.com.config.Config.address;
import static tarantool.com.server.NettyServer.queryIndex;
import static tarantool.com.client.DataSet.dataset;
import static tarantool.com.config.Config.password;
import static tarantool.com.config.Config.tarantoolPort;
import static tarantool.com.config.Config.username;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.util.List;
import java.util.concurrent.Future;

import org.tarantool.SocketChannelProvider;
import org.tarantool.TarantoolClient;
import org.tarantool.TarantoolClientConfig;
import org.tarantool.TarantoolClientImpl;

import tarantool.com.config.Config;

public class TaranToolClientUtil {

	private static TarantoolClient client;

	static long totalResponseTime = 0; // keep adding execution time of each
										// request
	static int countofRequests = 0; // number of requests executed at any given
									// moment
	// averageResponseTime = totalResponseTime/countofRequests

	// Stored Procedure GetDetailedCampaignBalance
	// static String sp =
	// "airpushdb.ProcedureList().GetDetailedCampaignBalance(" +
	// Config.advertiserId + ","
	// + Config.campaignId + "," + Config.balanceDate + ")";

	static String sp = "airpushdb.ProcedureList().GetDetailedCampaignBalance(" + Config.advertiserId + ","
			+ Config.campaignId + "," + Config.balanceDate + ")";

	static FileWriter fw = null;
	static BufferedWriter bw = null;
	static {
		try {
			fw = new FileWriter("loadResponse_" + Config.logName + ".log", true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bw = new BufferedWriter(fw);
	}

	// function to call lua implementation of GetDetailedCampaignBalance stored
	// procedure
	public static void getDetailedCampaign(int counter) {
		try {
			client = getClient();		
//			double i = Math.random();
//			int qureyIndex = (int) (i * 3);
//			if (qureyIndex == 1)
//				sp = "airpushdb.ProcedureList().GetDetailedCampaignBalance(" + 304107 + "," + 2120907 + "," + 20171213
//						+ ")";
//			else if (qureyIndex == 2)
//				sp = "airpushdb.ProcedureList().GetDetailedCampaignBalance(" + 304003 + "," + 2120018 + "," + 20171208
//						+ ")";

//			selecting different parameters for SP
			int sleep = 1;
//			if (qureyIndex == 0){
//				Config.advertiserId = 228849;
//				Config.campaignId = 2118232;
//				Config.balanceDate = 20171121;
//				sleep = 0;
//			}
//			else if (qureyIndex == 1){
//				Config.advertiserId = 304003;
//				Config.campaignId = 2120018;
//				Config.balanceDate = 20171208;
//				sleep = 1;
//			}
//			else if (qureyIndex == 2){
//				Config.advertiserId = 304107;
//				Config.campaignId = 2120907;
//				Config.balanceDate = 20171213;				
//				sleep = 5;
//			}
			
			bw.write(counter + "- Executing Lua SP implementation\n");
			System.out.println(counter + "- Executing Lua SP implementation...");
			long startTime = System.currentTimeMillis();
			
			
			Future<List<?>> SPResult = client.asyncOps().call("test", dataset[queryIndex][0], dataset[queryIndex][1],
					dataset[queryIndex][2], sleep);
			
			queryIndex++;
			if(queryIndex==20)
				queryIndex=0;
			// sync operation
			// List<?> res1 = client.syncOps().eval(sp, 1);

			// ToDO- check why empty response is obtained in java client
			// Note- java client is able to execute procedures but response
			// obtained at client side is empty
			// async operations
			// Future<List<?>> SPResult = client.asyncOps().eval(sp, 1);
			
			
//			Note-
//			client.asyncOps()/call function when invoked like- 
//			call("airpushdb.ProcedureList().GetDetailedCampaignBalance", arguments)
//			throws procedure not defined error because it looks for a procedure named - "airpushdb.ProcedureList().GetDetailedCampaignBalance"
//			so created a reference to procedure in db-
//			test = airpushdb.ProcedureList().GetDetailedCampaignBalance
//			Future<List<?>> SPResult = client.asyncOps().call("test", Config.advertiserId, Config.campaignId,
//					Config.balanceDate, sleep);
			List<?> SPResultList = SPResult.get();
			long endTime = System.currentTimeMillis();

			bw.write(counter + "- time took in executing Lua SP implementation " + (endTime - startTime) + "\n");
			bw.write(counter + "- Result: " + SPResultList.toString() + "\n");
			// System.out.println("time took in executing Lua SP implementation
			// " + (endTime-startTime));

			// countofRequests++;
			// totalResponseTime = totalResponseTime + (endTime-startTime);
			// bw.write("Average Response Time till " + countofRequests + "
			// requests is " + (totalResponseTime/countofRequests) );
			bw.write("\n**********************************\n\n\n");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// not closing the stream in order to use it to log other
				// requests
				if (bw != null)
					bw.flush();

				if (fw != null)
					fw.flush();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}

	}

	public static void main(String[] args) {
		// try {
		// client = getClient();
		// System.out.println(client.isAlive());
		// String sp = "airpushdb.ProcedureList().GetDetailedCampaignBalance(" +
		// Config.advertiserId + ","
		// + Config.campaignId + "," + Config.balanceDate + ")";
		// System.out.println(client.syncOps().eval(sp, 1));
		//
		// //
		// System.out.println(client.syncOps().eval("airpushdb.ViewList().model().vw_with_nfr_aggr_campaign_daily_transactions(1,
		// // 2, 5555)", 1));
		//
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

	public static TarantoolClient getClient() {
		if (client != null)
			return client;

		TarantoolClientConfig config = new TarantoolClientConfig();
		config.username = username;
		config.password = password;
		config.initTimeoutMillis = 60000;

		SocketChannelProvider socketChannelProvider = new SocketChannelProvider() {
			public SocketChannel get(int retryNumber, Throwable lastError) {
				if (lastError != null) {
					lastError.printStackTrace(System.out);
				}
				try {
					return SocketChannel.open(new InetSocketAddress(address, tarantoolPort));
				} catch (IOException e) {
					throw new IllegalStateException(e);
				}
			}
		};
		return new TarantoolClientImpl(socketChannelProvider, config);
	}

}

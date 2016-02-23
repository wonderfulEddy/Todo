import java.io.FileOutputStream;
import javax.net.ssl.HttpsURLConnection;
import java.net.URL;
import java.io.*;
import javax.net.ssl.*;

public class Test{
	public static void main(String[] args){
		MainMessage.Request messageRequest = MainMessage.Request.newBuilder()
												.setFuncNo(5)
												.setDeviceId("wvOfnnTIrtvojrvmDRSyuBF3gh0KjscW4NT6")
												.setContent(
													AppVersion.AppVersionRequest.newBuilder()
													.setAppId(11)
													.setAppType(1)
													.build().toByteString())
												.build();

		TrustManager[] trustAllCerts = new TrustManager[]{
			new X509TrustManager() {
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}
				public void checkClientTrusted(
					java.security.cert.X509Certificate[] certs, String authType) {
				}
				public void checkServerTrusted(
					java.security.cert.X509Certificate[] certs, String authType) {
				}
			}
		};
		HttpsURLConnection connection = null;
		URL url;
		InputStream httpInputStream = null;
		OutputStream output = null, httpOutputStream = null;
		//PrintWriter writer = new PrintWriter();
		
		byte[] paraData = messageRequest.toByteArray();

		try{
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
			
			//´ú¸Õ¥Î
			HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
				@Override
				public boolean verify(String s, SSLSession sslSession) {
					return true;
				}
			});
			url = new URL("https://mobile.cotabank.com.tw/service/AppCenter.ashx");
			connection = (HttpsURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.connect();
			
			httpOutputStream = connection.getOutputStream();
			httpOutputStream.write(paraData);
			System.out.println(connection.getResponseMessage());
			httpInputStream = connection.getInputStream();
			MainMessage.Response messageResponse = MainMessage.Response.parseFrom(httpInputStream);
			AppVersion.AppVersionResponse appVer = AppVersion.AppVersionResponse.parseFrom(messageResponse.getContent().toByteArray());
			System.out.println(messageResponse);
		}catch(Exception e){
			System.out.println(e.getMessage());
			
		}finally{
			try {
				if (output != null)
					output.close();
				if (httpInputStream != null)
					httpInputStream.close();
				if (httpOutputStream != null)
					httpOutputStream.close();
			} catch (IOException ignored) {
			}

			if (connection != null)
				connection.disconnect();
		}
		
	}
}
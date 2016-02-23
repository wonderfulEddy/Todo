package com.cotabank;

import java.security.NoSuchAlgorithmException;
import com.cotabank.util.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.net.URL;
import java.io.*;
import javax.net.ssl.*;
import android.util.Log;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;

public class AppVersionChecker extends CordovaPlugin {

	@Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
    }
	
	@Override
	public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		if (action.equals("checkUpdate")) {
			final int app_id = Integer.parseInt(args.getString(0));
			cordova.getThreadPool().execute(new Runnable() {
				public void run() {
					try {
						boolean hasNewVersion = checkNewVersion(app_id);
						callbackContext.success(String.valueOf(hasNewVersion));
					} catch (NameNotFoundException e) {
						Log.i("ex", "ex", e);
						callbackContext.error(e.getMessage());
					} catch (Exception e){
						Log.i("ex", "ex", e);
						callbackContext.error(e.getMessage());
					}
				}
			});
			return true;
		}else
			return false;

	}
	private boolean checkNewVersion(int app_id) throws Exception{
		PackageManager packageManager = this.cordova.getActivity().getPackageManager();
		String device_app_version = packageManager.getPackageInfo(this.cordova.getActivity().getPackageName(), 0).versionName;
		String server_app_version = getServerAppVersion(app_id);
		
		Log.i("AppVersionChecker", device_app_version + ";" + server_app_version);
		Log.i("AppVersionChecker", "device_app_version.compareTo(server_app_version) = " + device_app_version.compareTo(server_app_version));
		
		if(device_app_version.compareTo(server_app_version) >= 0)
			return false;
		else
			return true;
	}
	private String getServerAppVersion(int app_id) throws Exception{
		CDataEnc enc = new CDataEnc();
		MainMessage.Request messageRequest = MainMessage.Request.newBuilder()
												.setFuncNo(5)
												.setDeviceId(enc.DataEncrypt(android.os.Build.SERIAL))
												.setContent(
													AppVersion.AppVersionRequest.newBuilder()
													.setAppId(app_id)
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
		OutputStream httpOutputStream = null;
		//PrintWriter writer = new PrintWriter();
		
		byte[] paraData = messageRequest.toByteArray();

		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, new java.security.SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		//測試機用
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
		try {
			if (httpInputStream != null)
				httpInputStream.close();
			if (httpOutputStream != null)
				httpOutputStream.close();
		} catch (IOException ignored) {
		}
		if (connection != null)
			connection.disconnect();
		return appVer.getVersion();

	}
}

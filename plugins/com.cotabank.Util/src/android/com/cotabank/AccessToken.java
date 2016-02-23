package com.cotabank;

import com.cotabank.util.*;

import android.widget.Toast;
import android.util.Log;
import android.content.Context;
import java.net.URL;
import java.net.URLEncoder;

import java.security.NoSuchAlgorithmException;

import java.util.Iterator;
import java.util.Date;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import java.text.SimpleDateFormat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.Boolean;
import java.lang.Override;
import java.lang.Runnable;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * This class echoes a string called from JavaScript.
 */
public class AccessToken extends CordovaPlugin {

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
    }

    @Override
    public boolean execute(final String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		CDataEnc enc = new CDataEnc();

        if("getAccessToken".equals(action)){
			String encString = null;
			try{
				SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date current = new Date();
				encString = enc.DataEncrypt(android.os.Build.SERIAL+";"+sdFormat.format(current));
				callbackContext.success(encString);
				return true;
			}catch(NoSuchAlgorithmException ex){
				return false;
			}
		}
		return true;

    }
	
}
//
//  CDVGetAppVersion.m
//
//
//  Created by wonderful on 2015/11/23.
//
//

#import <Cordova/CDV.h>
#import "CDVGetAppVersion.h"
#import "GetAppVersion.h"
#import "DataEnc.h"


@implementation CDVGetAppVersion

- (void)checkUpdate:(CDVInvokedUrlCommand*)command
{
    NSString *app_id = [command.arguments objectAtIndex:0];
    //NSString *app_id = [[NSString alloc]init];
    NSString *deviceIdStr = [[NSString alloc] init];
    
    __block CDVPluginResult *pluginResult = nil;
    __block NSString *hasNewVersion;
    __block NSString *versionFromServer = @"fail to check";
    
    // Encrypt data
    DataEnc *dataEnc = [[DataEnc alloc] init];
    NSString *enc_data = [[NSString alloc] init];
    NSString *in_str = [[NSString alloc] initWithString:[[[UIDevice currentDevice] identifierForVendor] UUIDString]];
    [dataEnc encryptWithString:in_str outData: &enc_data];
    deviceIdStr = (NSString *)enc_data;     // Device ID
    
    if (deviceIdStr != nil && [deviceIdStr length]>0) {

        int32_t app_id_int = [app_id intValue];
        
        GetAppVersion *getAppInfo = [[GetAppVersion alloc] init];
        
        /* 
         * Method: getAppInfo
         * appVersion: 0 for iOS, 1 for Android
         * withAppId: Cotabank App ID
         * withFuncNo: Protocol Buffer 的功能代碼
         * withDevieId: Device ID
         */
        [getAppInfo appVersion:0 withAppId:11 withFuncNo:5 withDeviceId:deviceIdStr completion:^(NSString *result) {
            if (![result isEqual:@""] && result != nil) {
                
                // Client 端 App 的版本
                NSString *versioNow = [[NSBundle mainBundle] objectForInfoDictionaryKey:@"CFBundleShortVersionString"];
                
                // Server 端 App 的版本
                versionFromServer = result;
                BOOL isEqual =[ versioNow isEqualToString: versionFromServer];
                
                // 有沒有新版本
                hasNewVersion = [NSString stringWithFormat:isEqual ? @"false" : @"true"];
                pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:hasNewVersion];
            }
            
            else
            {
                pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
            }
            
            [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
            
        }];
    }else
    {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
        [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
    }
    
    
    
    
}


@end

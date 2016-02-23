//
//  CDVGetDeviceId.m
//
//
//  Created by wonderful on 2015/11/17.
//
//


//#include <sys/types.h>
//#include <sys/sysctl.h>

#import "CDVGetDeviceId.h"
#import <Cordova/CDV.h>
#import "DataEnc.h"

@implementation CDVGetDeviceId

- (void)getAccessToken:(CDVInvokedUrlCommand*)command
{
    CDVPluginResult *pluginResult = nil;
    NSString *deviceIdStr = [[[UIDevice currentDevice] identifierForVendor] UUIDString];
    DataEnc *dataEnc = [[DataEnc alloc]init];
    NSDateFormatter *dateFormatter = [[NSDateFormatter alloc] init];
    [dateFormatter setDateFormat:@"yyyy-MM-dd HH:mm:ss"];
    NSDate *current = [NSDate date];
    NSString *strDate = [dateFormatter stringFromDate:current];
    
    NSString *in_str = [NSString stringWithFormat:@"%@;%@",deviceIdStr, strDate];
    NSString *out_str = [[NSString alloc] init];
    [dataEnc encryptWithString:in_str outData:&out_str];
    NSString *accessToken = [[NSString alloc] init];
    accessToken = (NSString *)out_str;
    
    if (accessToken != nil && [accessToken length] > 0) {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:accessToken];
    } else {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
    }
    
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end


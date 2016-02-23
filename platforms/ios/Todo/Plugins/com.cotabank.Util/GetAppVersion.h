//
//  GetAppVersion.h
//  GetAppVersion
//
//  Created by wonderful on 2015/11/24.
//  Copyright © 2015年 wonderful. All rights reserved.
//

#ifndef GetAppVersion_h
#define GetAppVersion_h


@interface GetAppVersion : NSObject
{
    NSString *app_Version;
    NSData *requestData;
}
@property NSString *app_Version;
@property NSData *requestData;

-(void)appVersion:(int32_t)type
        withAppId:(int32_t)appId
       withFuncNo:(int32_t)funcNo
     withDeviceId:(NSString *)deviceId
       completion:(void (^)(NSString *result))completionBlock;

-(void)appVersion2:(int32_t)type
        withAppId:(int32_t)appId
        withFuncNo:(int32_t)funcNo;

@end
#endif /* GetAppVersion_h */


//
//  CDVGetAppVersion.h
//  
//
//  Created by wonderful on 2015/11/23.
//
//


#import <UIKit/UIKit.h>
#import <Cordova/CDVPlugin.h>

@interface CDVGetAppVersion: CDVPlugin
{

}

- (void)checkUpdate:(CDVInvokedUrlCommand*)command;


@end
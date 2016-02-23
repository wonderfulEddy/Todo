//
//  CDVGetDeviceId.h
//  HelloWorld
//
//  Created by wonderful on 2015/11/17.
//
//
#import <UIKit/UIKit.h>
#import <Cordova/CDVPlugin.h>

@interface CDVGetDeviceId: CDVPlugin
{
    
}

- (void)getAccessToken:(CDVInvokedUrlCommand*)command;

@end



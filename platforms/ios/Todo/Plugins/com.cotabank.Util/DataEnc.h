//
//  CIDataEnc.h
//  CotaInfo
//
//  Created by 忠德 林 on 2/7/12.
//  Copyright (c) 2012 __MyCompanyName__. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>

#define KEY_LENGTH 128

@interface DataEnc : NSObject
{
    int encType;
}

@property(nonatomic) int encType;

- (id)init;
- (int)encryptWithData:(NSData *)in_data outData:(NSString **)out_str;
- (int)encryptWithString:(NSString *)in_str outData:(NSString **)out_str;
- (int)decryptWithData:(NSString *)in_str outData:(NSData **)out_data;
- (int)decryptWithData:(NSString *)in_str asUtf8String:(NSString **)out_str;
- (int)decryptWithData:(NSString *)in_str asBig5String:(NSString **)out_str;

@end

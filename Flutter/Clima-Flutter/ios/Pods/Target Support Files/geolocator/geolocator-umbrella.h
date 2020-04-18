#ifdef __OBJC__
#import <UIKit/UIKit.h>
#else
#ifndef FOUNDATION_EXPORT
#if defined(__cplusplus)
#define FOUNDATION_EXPORT extern "C"
#else
#define FOUNDATION_EXPORT extern
#endif
#endif
#endif

#import "LocationOptions.h"
#import "CLLocation_Extensions.h"
#import "CLPlacemark_Extensions.h"
#import "GeolocatorPlugin.h"
#import "CalculateDistanceTask.h"
#import "GeocodeTask.h"
#import "LastKnownLocationTask.h"
#import "LocationTask.h"
#import "Task.h"
#import "TaskContext.h"
#import "TaskProtocol.h"

FOUNDATION_EXPORT double geolocatorVersionNumber;
FOUNDATION_EXPORT const unsigned char geolocatorVersionString[];


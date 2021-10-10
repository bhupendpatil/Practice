///////////////////////////////////////////////////////////////////////////////////////////
//
// ALA library example: SimpleRgbLed
//
// Example to demonstrate how to create a color-fading animation for one RGB LED.
//
// Web page: http://yaab-arduino.blogspot.com/p/ala-example-simplergbled.html
//
///////////////////////////////////////////////////////////////////////////////////////////

#include <AlaLedRgb.h>

#define REDPIN 5
#define GREENPIN 6
#define BLUEPIN 3

AlaLedRgb rgbLed;

void setup()
{
  rgbLed.initPWM(REDPIN, GREENPIN, BLUEPIN);                 // initialize output pins
  rgbLed.setBrightness(0x66FF44);                            // calibrate white
  rgbLed.setAnimation(ALA_PIXELSMOOTHBOUNCE, 5000, alaPalRgb);  // set the animation
}

void loop()
{
  rgbLed.runAnimation();  // run the animation indefinitely
}

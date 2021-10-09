// Morse Code

int led_pin = 8;

void setup() {
  pinMode(led_pin,OUTPUT);
}

void loop() {
  s();o();o(); // SOS
  word_end();
  
  b();h();u();p();e();n();d(); // BHUPEND
  word_end();
  
  s();o();o(); // SOS
  word_end();
  
  sentence_end();
}

void flash(int duration) {
  digitalWrite(led_pin,HIGH);
  delay(duration);
  digitalWrite(led_pin,LOW);
  delay(duration);
}

void short_flash(int times) {
  for(int i=1; i<=times; i++) {
    flash(200);
  }
  delay(300);
}

void long_flash(int times) {
  for(int i=1; i<=times; i++) {
    flash(500);
  }
  delay(300);
}

void word_end() {
  delay(2000);
}

void sentence_end() {
  delay(5000);
}

// Alphabets

void a() {
  short_flash(1);
  long_flash(1);
}

void b() {
  long_flash(1);
  short_flash(3);
}

void c() {
  for(int i=1; i<=2; i++) {
    long_flash(1);
    short_flash(1);
  } 
}

void d() {
  long_flash(1);
  short_flash(2);
}

void e() {
  short_flash(1);
}

void f() {
  short_flash(2);
  long_flash(1);
  short_flash(1);
}

void g() {
  long_flash(2);
  short_flash(1);
}

void h() {
  short_flash(4);
}

void i() {
  short_flash(2);
}

void j() {
  short_flash(1); 
  long_flash(3);
}

void k() {
  long_flash(1);
  short_flash(1);
  long_flash(1);
}

void l() {
  short_flash(1);
  long_flash(1);
  short_flash(2);
}

void m() {
  long_flash(2);
}

void n() {
  long_flash(1);
  short_flash(1);
}

void o() {
  long_flash(3);  
}

void p() {
  short_flash(1);
  long_flash(2);
  short_flash(1);
}

void q() {
  long_flash(2);
  short_flash(1);
  long_flash(1);
}

void r() {
  short_flash(1);
  long_flash(1);
  short_flash(1);
}

void s() {
  short_flash(3);
}

void t() {
  short_flash(1);
}

void u() {
  short_flash(2);
  long_flash(1);
}

void v() {
  short_flash(3);
  long_flash(1);
}

void w() {
  short_flash(1);
  long_flash(2);
}

void x() {
  long_flash(1);
  short_flash(2);
  long_flash(1);
}

void y() {
  long_flash(1);
  short_flash(1);
  long_flash(2);
}

void z() {
  long_flash(2);
  short_flash(2);
}

// Numbers

void zero() {
  long_flash(5);  
}

void one() {
  short_flash(1);
  long_flash(4); 
}

void two() {
  short_flash(2);
  long_flash(3); 
}

void three() {
  short_flash(3);
  long_flash(2); 
}

void four() {
  short_flash(4);
  long_flash(1); 
}

void five() {
  short_flash(5); 
}

void six() {
  long_flash(1);
  short_flash(4);
}

void seven() {
  long_flash(2);
  short_flash(3);
}

void eight() {
  long_flash(3);
  short_flash(2);
}

void nine() {
  long_flash(4);
  short_flash(1);
}

import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        backgroundColor: Colors.teal,
        body: SafeArea(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              CircleAvatar(
                radius: 55.0,
                backgroundImage: AssetImage('images/bhupend.png'),
              ),
              Text(
                'Bhupend Patil',
                style: TextStyle(
                  fontSize: 40.0,
                  fontFamily: 'Bangers',
                  fontWeight: FontWeight.bold,
                  color: Colors.white,
                  letterSpacing: 1.5,
                ),
              ),
              Text(
                'Techie',
                style: TextStyle(
                  fontSize: 20.0,
                  fontFamily: 'PermanentMarker',
                  fontWeight: FontWeight.bold,
                  letterSpacing: 2.5,
                  color: Colors.teal.shade100,
                ),
              ),
              SizedBox(
                height: 20.0,
                width: 150.0,
                child: Divider(
                  color: Colors.teal.shade100,
                ),
              ),
              Card(
                color: Colors.white,
                margin: EdgeInsets.symmetric(horizontal: 20.0, vertical: 10.0),
                child: ListTile(
                  leading: Icon(
                    Icons.phone,
                    color: Colors.teal.shade900,
                  ),
                  title: Text(
                    '+91 98193 23536',
                    style: TextStyle(
                      fontSize: 19.0,
                      fontFamily: 'PermanentMarker',
                      color: Colors.teal.shade900,
                    ),
                  ),
                ),
              ),
              Card(
                margin: EdgeInsets.symmetric(horizontal: 20.0, vertical: 10.0),
                color: Colors.white,
                child: ListTile(
                  leading: Icon(
                    Icons.mail,
                    color: Colors.teal.shade900,
                  ),
                  title: (Text(
                    'bhupendpatil@gmail.com',
                    style: TextStyle(
                      fontSize: 19.0,
                      fontFamily: 'PermanentMarker',
                      color: Colors.teal.shade900,
                    ),
                  )),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}

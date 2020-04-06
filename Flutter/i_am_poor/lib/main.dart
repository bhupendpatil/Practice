import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    home: Scaffold(
      backgroundColor: Colors.deepPurple[200],
      appBar: AppBar(
        title: Text('I am Poor'),
        backgroundColor: Colors.deepPurple[400],
      ),
      body: Center(
        child: Image(
          image: AssetImage('images/poor1.png'),
        ),
      ),
    ),
  ));
}

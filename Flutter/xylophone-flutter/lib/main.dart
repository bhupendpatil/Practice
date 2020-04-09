import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:audioplayers/audio_cache.dart';

void main() => runApp(XylophoneApp());

class XylophoneApp extends StatelessWidget {
  Expanded tonesPlayed({Color color, int noteNumber}) {
    return Expanded(
      child: FlatButton(
        color: color,
        onPressed: () {
          final player = AudioCache();
          player.play('note$noteNumber.wav');
        },
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        backgroundColor: Colors.black,
        body: SafeArea(
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.stretch,
            children: <Widget>[
              tonesPlayed(color: Colors.red, noteNumber: 1),
              tonesPlayed(color: Colors.orange, noteNumber: 2),
              tonesPlayed(color: Colors.yellow, noteNumber: 3),
              tonesPlayed(color: Colors.green, noteNumber: 4),
              tonesPlayed(color: Colors.teal, noteNumber: 5),
              tonesPlayed(color: Colors.blue, noteNumber: 6),
              tonesPlayed(color: Colors.purple, noteNumber: 7),
            ],
          ),
        ),
      ),
    );
  }
}

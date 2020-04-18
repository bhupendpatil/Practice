import 'package:geolocator/geolocator.dart';

class Location {
  double lati;
  double longi;

  Future<void> getCurrentLocation() async {
    try {
      Position position = await Geolocator()
          .getCurrentPosition(desiredAccuracy: LocationAccuracy.low);

      lati = position.latitude;
      longi = position.longitude;
    } catch (e) {
      print(e);
    }
  }
}

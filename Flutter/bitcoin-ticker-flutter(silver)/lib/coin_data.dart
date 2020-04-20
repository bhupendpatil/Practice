import 'package:http/http.dart' as http;
import 'dart:convert';

const List<String> currenciesList = [
  'AUD',
  'BRL',
  'CAD',
  'CNY',
  'EUR',
  'GBP',
  'HKD',
  'IDR',
  'ILS',
  'INR',
  'JPY',
  'MXN',
  'NOK',
  'NZD',
  'PLN',
  'RON',
  'RUB',
  'SEK',
  'SGD',
  'USD',
  'ZAR'
];

const List<String> cryptoList = [
  'BTC',
  'ETH',
  'LTC',
];

const apiKey = 'F62225CA-B042-49E2-8617-D1EC286BE714';
const coinAPIURL = 'https://rest.coinapi.io/v1/exchangerate/BTC';

class CoinData {
  CoinData(this.url);

  final String url;
  Future getCoinData() async {
    http.Response response = await http.get(url);
    if (response.statusCode == 200) {
      var data = jsonDecode(response.body);
      var rate = data['rate'];
      return rate;
    } else {
      print(response.statusCode);
    }
  }
}

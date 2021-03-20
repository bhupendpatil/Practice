import React from "react";
import {
  SafeAreaView,
  StyleSheet,
  Platform,
  StatusBar,
  View,
} from "react-native";
import { useDeviceOrientation } from "@react-native-community/hooks";

export default function App() {
  return (
    <SafeAreaView style={styles.container}>
      <View
        style={{
          backgroundColor: "#fff",
          flex: 1,
          flexDirection: "row",
          justifyContent: "center",
          alignItems: "center",
          alignContent: "center",
          flexWrap: "wrap",
        }}
      >
        <View
          style={{
            backgroundColor: "dodgerblue",
            width: 100,
            height: 300,
          }}
        ></View>
        <View
          style={{
            backgroundColor: "gold",
            width: 100,
            height: 100,
          }}
        ></View>
        <View
          style={{
            backgroundColor: "tomato",
            width: 100,
            height: 100,
          }}
        ></View>
        <View
          style={{
            backgroundColor: "grey",
            width: 100,
            height: 100,
          }}
        ></View>
        <View
          style={{
            backgroundColor: "greenyellow",
            width: 100,
            height: 100,
          }}
        ></View>
      </View>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#fff",
    paddingTop: Platform.OS === "android" ? StatusBar.currentHeight : 0,
  },
});

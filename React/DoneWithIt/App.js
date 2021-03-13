import { StatusBar } from "expo-status-bar";
import React from "react";
import { SafeAreaView, StyleSheet, Text, Image } from "react-native";

export default function App() {
  return (
    <SafeAreaView style={styles.container}>
      <Text>Hello Bhupend!</Text>
      <Image
        blurRadius={1}
        source={{
          width: 200,
          height: 300,
          uri: "https://picsum.photos/200/300",
        }}
      />
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#fff",
    justifyContent: "center",
    alignItems: "center",
  },
});

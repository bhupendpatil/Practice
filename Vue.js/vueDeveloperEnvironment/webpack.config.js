module.exports = {
  entry: "./index.js",
  output: {
    filename: "bundle.js",
    path: __dirname + "/dist",
  },
  mode: "development",
  module: {
    rules: [
      {
        test: /\.js%/,
        exclude: /(node_modules)/,
        use: "babel-loader",
      },
      {
        test: /\.scss$/,
        use: ["css-loader", "sass-loader"],
      },
    ],
  },
};

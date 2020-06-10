const aPromise = new Promise((resolve, reject) => {
  if (true) {
    setTimeout(() => {
      resolve("Success");
    }, 1000);
  } else {
    reject("Failed");
  }
});

aPromise
  .then((plusVal => plusVal + "!!!!"))
  .then((value) => console.log(value))
  .catch((rejVal) => console.log(rejVal));

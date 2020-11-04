console.clear();

const createPolicy = (name, amount) => {
  return {
    type: "CREATE_POLICY",
    payload: {
      name: name,
      amount: amount,
    },
  };
};

const deletePolicy = (name) => {
  return {
    type: "DELETE_POLICY",
    payload: {
      name: name,
    },
  };
};

const createClaim = (none, amountOfMoneyToCollect) => {
  return {
    type: "CREATE_CLAIM",
    payload: {
      name: name,
      amountOfMoneyToCollect: amountOfMoneyToCollect,
    },
  };
};

const claimsHistory = (oldListOfClaims = [], action) => {
  if (action.type == "CREATE_CLAIM") {
    return [...oldListOfClaims, action.payload];
  }
  return oldListOfClaims;
};

const accounting = (bagOfMoney = 100, action) => {
  if (action.type == "CREATE_CLAIM") {
    return bagOfMoney - action.payload.amountOfMoneyToCollect;
  } else if (action.type == "CREATE_POLICY") {
    return bagOfMoney + action.payload.amount;
  }
  return bagOfMoney;
};

const policies = (listOfPolicies = [], action) => {
  if (action.type == "CREATE_POLICY") {
    return [...listOfPolicies, action.payload.name];
  } else if (action.tyle == "DELETE_POLICY") {
    return listOfPolicies.filter((name) => name !== action.payload.name);
  }
  return listOfPolicies;
};

const { createStore, combineReducers } = Redux;

const ourDepartments = combineReducers({
  accounting: accounting,
  claimsHistory: claimsHistory,
  policies: policies,
});

const store = createStore(ourDepartments);

store.dispatch(createPolicy("Bhupend", 20));
store.dispatch(createPolicy("Harshad", 30));
store.dispatch(createPolicy("Hitesh", 40));

store.dispatch(createClaim("Bhupend", 120));
store.dispatch(createClaim("Harshad", 50));

store.dispatch(deletePolicy("Hitesh"));

console.log(store.getState());

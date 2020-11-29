import { combineReducers } from "redux";
import { reducer as fromReducer } from "redux-form";
import authReducer from "./authReducer";
import streamReducer from "./streamReducer";

export default combineReducers({
  auth: authReducer,
  form: fromReducer,
  streams: streamReducer,
});

import axios from "axios";

export default axios.create({
  baseURL: "https://api.unsplash.com",
  headers: {
    Authorization: "Client-ID 2yeQQqby3O9e-QeisUjWdClQZjIPHbCk_ahNO30CmCU",
  },
});

import axios from "axios";

const KEY = "AIzaSyBtuRkFmw6F2PBy6PGEVwyoEBWqKhVaqQE";

export default axios.create({
  baseURL: "https://www.googleapis.com/youtube/v3",
  params: {
    part: "snippet",
    maxResults: 5,
    key: KEY,
  },
});

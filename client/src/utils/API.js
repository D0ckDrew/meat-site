import axios from "axios";

const instance = axios.create({
    baseURL: 'http://localhost:3001'
});

const token = window.localStorage.getItem("token");
if (window.localStorage.getItem(token)){
    instance.defaults.headers.common['Authorization'] = token;
}


/*export default axios.create({
    baseURL: "http://localhost:3001",
    headers: {"Authorization": window.localStorage.getItem("token") ? }
    defaults.headers.common['Authorization'] = AUTH_TOKEN;*/

/*axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
    responseType: "json"
});*/

export default instance;
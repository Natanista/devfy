import axios from 'axios'

const api = axios.create(
    {
        baseUrlr: "https://618324d791d76c00172d17c8.mockapi.io/music"
    }
);


export default api;
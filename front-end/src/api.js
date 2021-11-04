import axios from 'axios'

const api = axios.create(
    {
        baseUrl: "https://61845f70ac0b850017489e1d.mockapi.io/devfy/dashboard"
    }
);

export default api;
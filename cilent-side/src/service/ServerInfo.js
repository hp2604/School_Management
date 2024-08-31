import axios from "axios"
import { getToken } from "./JwtToken";


const token=getToken();
export const url='http://localhost:8080';

export const myaxios=axios.create({
    baseURL:url,
    headers:{
        Authorization:`Bearer ${token}`,
    } ,
    
})
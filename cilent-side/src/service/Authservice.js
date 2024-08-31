import axios from "axios";
import { setToken,getToken, removeToken } from "./JwtToken";
import { useState } from "react";

 var status='';
 var responseBody='';
 var error=false;


const  login=async(data)=>{
    try {
        
        const response=await axios.post('http://localhost:8080/auth/login',data);
        status=response.status;
        if(status===202)
        {
            const token=response.data;
            setToken(token);
        }
        else if(status===401){
            responseBody=response.data;
        }

    } catch (error) {
        responseBody="Something went Wronng";
        error=true;
        
    }
};
const logout=()=>{
    removeToken();
    console.log("remove ");
    
};
 const getHeader=()=>{
    const token=getToken();
    return{
        Authorization:`Bearer ${token}`,
    };
 };
 export{login,logout,getHeader,responseBody,status,error};

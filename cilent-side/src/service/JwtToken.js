const tokenKey="jwt";

//Getting token
export const getToken=()=>{
    return localStorage.getItem(tokenKey);
}


//Setting token
export const setToken=(token)=>{

     localStorage.setItem(tokenKey,token);
}

//Remove Token
export const removeToken=()=>{
    localStorage.removeItem(tokenKey);
}


'use strict';

var username = null;

window.onload=function testSecureEndpoint(){

    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    var access_token = sessionStorage.getItem("access_token");
    var user_to_search = urlParams.get("username")
    console.log(access_token);
    if(access_token === null) {
        document.location.href="/login.html";
    }
    getUserDetails(user_to_search);
}

function logout(){
    alert("You have been logged out");
    sessionStorage.clear();
}

async function getUserDetails(user_to_search){

    
    let res= await fetch("/userdetail/getUserDetails",{
        method: 'POST',
        headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
        body:
            JSON.stringify({
                username: user_to_search,
                email: "email",
                description: "description"
            })
    });

    if (res.status == 200){
        const data= await res.json();
        console.log(data);
        for(var [key,value] of Object.entries(data)){
            console.log(value);
            document.getElementById("username").innerHTML=value.username
            document.getElementById("user_email").innerHTML=value.email
            document.getElementById("user_description").innerHTML=value.description
        }
    }
}

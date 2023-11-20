
'use strict';



function openregister(event){
    event.preventDefault();
    document.location.href="/register.html";
}

function openlogin(event){
    event.preventDefault();
    document.location.href="/login.html";
}

/*var username = null;

window.onload=function testSecureEndpoint(){

    var access_token = sessionStorage.getItem("access_token");

    console.log(access_token);
    if(access_token === null) {
        document.location.href="/login.html";
    }
}

function logout(){
    sessionStorage.clear();
}*/

'use strict';

var username = null;

window.onload=function testSecureEndpoint(){

    var access_token = sessionStorage.getItem("access_token");

    console.log(access_token);
    if(access_token === null) {
        document.location.href="/login.html";
    }
}

function menuroommates(event){
    event.preventDefault();
    document.location.href="/roommate.html";
}
function menulists(event){
    event.preventDefault();
    document.location.href="/user_lists.html";
}
function menuaccounts(event){
    event.preventDefault();
    document.location.href="/account.html";
}

var username = null;

window.onload=function testSecureEndpoint(){

    var access_token = sessionStorage.getItem("access_token");

    console.log(access_token);
    if(access_token === null) {
        document.location.href="/login.html";
    }
}

function logout(){
    alert("You have been logged out");
    sessionStorage.clear();
}

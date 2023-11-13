'use strict';

function menuroommates(event){        //for roomates 
    event.preventDefault();
    document.location.href="/roommate.html";
}
function menulists(event){        //for menu 
    event.preventDefault();
    document.location.href="/user_lists.html";
}
function menuaccounts(event){
    event.preventDefault();
    document.location.href="/account.html";
}



function logout(){
    sessionStorage.clear();
}

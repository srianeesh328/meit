async function newmeit(event){
    event.preventDefault();
    console.log("Realizando meit");
    var meitname = document.getElementById("meitname").value.trim();
    var meitdescription = document.getElementById("meitdescription").value.trim();
    let res= await fetch("/meit/newMeit",{
        method: 'POST',
        headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
        body:
            JSON.stringify({
             meitid :"0",
             username: sessionStorage.getItem("username"),
             expense: meitname,
             concept: meitdescription
            })
    });
    document.getElementById("meitname").innerHTML="";
    document.getElementById("meitdescription").innerHTML="";
    getMeits();
}
async function getMeits(){
    let res= await fetch("/meit/getMeit",{
        method: 'POST',
        headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
        body:
            JSON.stringify({
             meitid :"0",
             username: sessionStorage.getItem("username"),
             expense: "",
             concept: ""
            })
    });

    if (res.status ==200){
        const data= await res.json();
        console.log(data);
        var results= document.getElementById("results")
        results.innerHTML='';
        for(var [key,value] of Object.entries(data)){
            results.innerHTML += '<div>                <br>              <button style="border-radius: 25px; width:100%;" >  <div class="card-body p-md-5 card text-black" style="border-radius: 25px;">                    <div class="row justify-content-center">                        <div class="form-group">                        <h2>'+value.expense+': '+value.meitid+'</h2> '+value.concept+'                                              </div>                    </div>                </div>        </button>    </div>;'
            console.log(value.expense);
        }
    }
}

async function joinMeit(event){
    event.preventDefault();
    console.log("Realizando meit");

    var meitid =  document.getElementById("meitid").value.trim();
    let res= await fetch("/meit/joinMeit",{
        method: 'POST',
        headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
        body:
            JSON.stringify({
             meitid :meitid,
             username: sessionStorage.getItem("username"),
             expense: "Join",
             concept: "Join"
            })
    });
    document.getElementById("meitname").innerHTML="";
    document.getElementById("meitdescription").innerHTML="";
    getMeits();
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
    sessionStorage.clear();
}

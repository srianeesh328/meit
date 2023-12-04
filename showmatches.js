window.onload=function testSecureEndpoint(){

    
    getMatches();
}

async function getMatches(){
    let res= await fetch("/match/getBestMatches",{
        method: 'POST',
        headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
        body:
            JSON.stringify({
             username: sessionStorage.getItem("username"),
             pets: "",
             mixed: "",
             gender: "",
             info: ""
            })
    });
    if (res.status ==200){
        const data= await res.json();
        console.log(data);
        
        for(var [key,value] of Object.entries(data)){
            if(value.username=="null"){
                console.log("Please take the survey")
                results.innerHTML += '<div> <br><div class="card-body p-md-5 card text-black" style="border-radius: 25px;"><div class="row justify-content-center"> <div class="form-group"><div class="row"> <div class="col-9"><h2>Please complete the survey</h2></div><div class="col-3"><button class="btn btn-primary" onclick="openSurvey()">Take the survey!</button></div></div></div></div></div></div>';

            }
            else{
                var username_temp = '+value.username+'
                results.innerHTML += '<div> <br><div class="card-body p-md-5 card text-black" style="border-radius: 25px;"><div class="row justify-content-center"> <div class="form-group"><div class="row"> <div class="col-9"><h2>'+value.username+'</h2><p>Gender: '+value.gender+'</p><p>Allows mixed? '+value.mixed+'</p><p>Allow pets? '+value.pets+'</p><p>Other relevant informations: '+value.info+'</p></div><div class="col-3"><button class="btn btn-primary" onclick="goToProfile(\'' + value.username + '\')" >Go to profile details</button></div></div></div></div></div></div>';
            }
        }
    }
}

async function goToProfile(value){
    console.log(value);
    document.location.href="/search_profile.html?username="+value;
}

async function openSurvey(){
    document.location.href="./survey.html";
}

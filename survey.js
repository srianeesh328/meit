async function sendSurvey(){
    alert(`Answers changed`);
    var gender = document.getElementById("gender").value;

    var mixed=document.getElementById("mixed").checked;
    var smoke=document.getElementById("smoke").checked;
    var pets=document.getElementById("pets").checked;
    var food=document.getElementById("food").checked;
    var furnished=document.getElementById("furnished").checked;
    var party=document.getElementById("party").checked;

    var distance = document.getElementById("distance").value;
    var baths = document.getElementById("baths").value;
    var roommates = document.getElementById("roommates").value;
    var transport = document.getElementById("transport").value;

    var text = "Smokes: "+smoke+" Able to share food: "+ food+" Want the house furnished: "+ furnished + " Allow parties: "+party+" Distance to University: "+ distance+ " Number of bathrooms: "+ baths + " Max roommates: "+ roommates +" Public transport: "+ transport;
    var text = text.replace(/false/g,"no");
    var text = text.replace(/true/g,"yes");


    let res= await fetch("/match/saveUserSurvey",{
        method: 'POST',
        headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
        body:
            JSON.stringify({
             username: sessionStorage.getItem("username"),
             pets: pets,
             mixed: mixed,
             gender:gender,
             info: text 
            })
    });

    if (res.status ==200){
        document.location.href="./survey2.html";
    }

}

function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
  }

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
  }   

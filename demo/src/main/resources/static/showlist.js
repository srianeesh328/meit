window.onload=function testSecureEndpoint(){

    getListDescription();
    getItems();
}

async function getItems(){
    let res= await fetch("/list/getItems",{
        method: 'POST',
        headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
        body:
            JSON.stringify({
            listid: sessionStorage.getItem("listId"),
            username: sessionStorage.getItem("username"),
            concept: "0",
            status: "0"
            })
    });
    if (res.status ==200){
        const data= await res.json();
        console.log(data);
        var results= document.getElementById("results")
        results.innerHTML='';
        for(var [key,value] of Object.entries(data)){
            if(value.status==0){
                results.innerHTML += '<div> <br><div class="card-body p-md-5 card text-black" style="border-radius: 25px;"><div class="row justify-content-center"> <div class="form-group"><div class="row"> <div class="col-8"><h2>'+value.concept+'</h2></div><div class="col-2"><button class="btn btn-primary" onclick="markDone('+value.id+')" >Mark as  done</button></div><div class="col-2"><button class="btn btn-primary" data-container="body" data-toggle="popover" data-placement="top" data-content="Top popover" onclick="deleteItem('+value.id+')">Delete</button></div></div></div></div></div></div>';
            }
           else{
            results.innerHTML += '<div> <br><div class="card-body p-md-5 card text-black" style="border-radius: 25px; background-color: rgb(155,155,155)"><div class="row justify-content-center"> <div class="form-group"><div class="row"> <div class="col-8"><h2>'+value.concept+'</h2></div><div class="col-2"><button class="btn btn-primary" onclick="markNotDone('+value.id+')" >Mark as not done</button></div><div class="col-2"><button class="btn btn-primary" data-container="body" data-toggle="popover" data-placement="top" data-content="Top popover" onclick="deleteItem('+value.id+')">Delete</button></div></div></div></div></div></div>';

           }
    }
    }
}

async function addNewItem(){
    var item = document.getElementById("item").value.trim()
    let res= await fetch("/list/saveNewItem",{
        method: 'POST',
        headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
        body:
            JSON.stringify({
             listid :sessionStorage.getItem("listId"),
             username: sessionStorage.getItem("username"),
             concept: item,
             status: "0"
            })
    });

    getItems();

}


async function markNotDone(value){

    let res= await fetch("/list/updateStatus",{
        method: 'POST',
        headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
        body:
            JSON.stringify({
             id:value,
             listid:sessionStorage.getItem("listId"),
             username: sessionStorage.getItem("username"),
             concept: "Set as not done",
             status: "0"
            })
    });

    getItems();

}


async function markDone(value){

    let res= await fetch("/list/updateStatus",{
        method: 'POST',
        headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
            body:
            JSON.stringify({
             id:value,
             listid:sessionStorage.getItem("listId"),
             username: sessionStorage.getItem("username"),
             concept: "Set as not done",
             status: "1"
            })
    });

    getItems();

}

async function getListDescription(){
    let res= await fetch("/list/getListDescription",{
        method: 'POST',
        headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
        body:
            JSON.stringify({
             listid : sessionStorage.getItem("listId"),
             username: sessionStorage.getItem("username"),
             concept: "",
             status: ""
            })
    });

    if (res.status ==200){
        const data= await res.json();
        console.log(data);
        var name= document.getElementById("meitname")
        
        results.innerHTML='';
        for(var [key,value] of Object.entries(data)){
            
                name.innerHTML=value.status+": "+ value.concept;
            
        }
    }
}

async function deleteItem(value){

    let res= await fetch("/list/deleteItemById",{
        method: 'POST',
        headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
        body:
        JSON.stringify({
            id : value,
            listid : sessionStorage.getItem("listId"),
            username: sessionStorage.getItem("username"),
            concept: "",
            status: ""
           })
    });

    getItems();

}

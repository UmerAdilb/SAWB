


if(getToken() == null){


    window.open(login  , "_self")
}


document.getElementById("toggleVisibilityButton").addEventListener("click", function(button) { 
    if (document.getElementById("displaytable").style.display === "none")            
     document.getElementById("displaytable").style.display = "";
    else document.getElementById("displaytable").style.display = "none";
 });



getCandidateDetail();

function getCandidateDetail(){
  
    getData("/tally").then(allCandidateData=>{
       
        showResult(allCandidateData);
    })
}

function updateOpenPolling(){
    debugger
    data={
        pollingEnabled:true
    }
    updateData("/polling" , data).then(openAndClose=>{
        console.log(openAndClose)
        alert("Polling is Opened!")
    })
}

function updateClosePolling(){
    debugger
    data={
        pollingEnabled:false
    }
    updateData("/polling" , data).then(openAndClose=>{
        console.log(openAndClose)
        alert("Polling is Closed!")
    })
}

function showResult(allCandidateData){
    let tbody = document.getElementById('candidateRows')
    let table = ""
    for (let index = 0; index < allCandidateData.length; index++) {
         table += `
        <tr>
        <th scope="row">${index+1}</th>
        <td>${allCandidateData[index].candidate.scientificName}</td>
            <td>${allCandidateData[index].candidate.commonName}</td>
            <td>${allCandidateData[index].candidate.description}</td>
            <td>${allCandidateData[index].tally}</td>
        </tr>
            `
            tbody.innerHTML = table } };












document.getElementById("toggleVisibilityButton").addEventListener("click", function(button) { 
    if (document.getElementById("displaytable").style.display === "none")            
     document.getElementById("displaytable").style.display = "";
    else document.getElementById("displaytable").style.display = "none";
 });

var candidate;

 getCandidate();

 function getCandidate(){
  
    getData("/candidate").then(allCandidateData=>{
        candidate=allCandidateData
        showResult(allCandidateData);
        showBirdsNameInDropDown(allCandidateData)
    })
}

function showResult(allCandidateData){
    let tbody = document.getElementById('candidateRows')
    let table = ""
    for (let index = 0; index < allCandidateData.length; index++) {
         table += `
        <tr>
        <th scope="row">${index+1}</th>
        <td>${allCandidateData[index].scientificName}</td>
            <td>${allCandidateData[index].commonName}</td>
            <td>${allCandidateData[index].description}</td>
    
        </tr>
            `
            tbody.innerHTML = table } };


function showBirdsNameInDropDown(candidate){
    let renderData = ""
  console.log(candidate);

  if (candidate.length !== 0) {
    for (let i = 0; i < candidate.length; i++) {
        renderData += `
    <option value="${candidate[i].id}">${candidate[i].commonName}</option>
`
    }
}
else {
    renderData += `
    <option value="" disabled selected>Sorry No Bird Available</option>
`
}
document.getElementById("sel1").innerHTML = renderData;
}

function saveVote(){
    debugger
    let name = document.getElementById("inputName").value;
    let age = document.getElementById("inputAge").value;
    let membershipNumber = document.getElementById("inputMemberNo").value;
    let region = document.getElementById("inputRegion").value;
    var selectCandidate = document.getElementById("sel1");
    candidateId = selectCandidate.options[selectCandidate.selectedIndex].value;

    console.log(candidateId);

    var selectedCand = (getByValue(candidate,candidateId));

    var voter={
        name : name,
        age : parseInt(age),
        membershipNumber : parseInt(membershipNumber),
        region : region
    }
    console.log(voter);
    var ballot = {
        user : voter,
        candidate :  selectedCand
        
    }
    sendData("/ballot" , ballot).then(data=>{
        console.log(data);
        if(data.body != null){
            alert(data.body);
        }else{
            alert("Voted Successfully")
        }
        
    })
   
}

function getByValue(candidate, candidateId) {

    for (var i=0, iLen=candidate.length; i<iLen; i++) {
  
      if (candidate[i].id == candidateId) return candidate[i];
    }
  }



  function deleteVoteById(){
    let membershipNumber = document.getElementById("inputMemberNo").value;

    deleteData(`/ballot/${membershipNumber}`).then(data=>{
        console.log(data)
        alert("Deleted Successfully")
    })
  }

  function showTable(){
    let membershipNumber = document.getElementById("inputMemberNo").value;

    getData(`/ballot/${membershipNumber}`).then(CandidateData=>{
        debugger
        if(CandidateData.id != null){
            console.log(CandidateData);
        document.getElementById("showVote").innerHTML=`You have voted for ${CandidateData.commonName} with the slogan ${CandidateData.description} `;

            
        }else{
            document.getElementById("showVote").innerHTML=`You haven't voted to any candidate!`;
        }
       
    })

  
  }
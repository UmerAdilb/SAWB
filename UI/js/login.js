

function loginData(){
    debugger
    var email=document.getElementById('email').value
    var password=document.getElementById('password').value

    if(email != "" && password != ""){
        debugger
        let loginCredentials = {
            username: email,
            password: password
        }

        fetch(`${baseUrl}/user/token`, {
            method: "POST",
            headers: {
                "Content-type": "application/json"
            },
            body: JSON.stringify(loginCredentials)
        })
        .then((response) => {
            debugger;
                wrongEmailAndPass = '';

                    if(!response.ok){
                        wrongEmailAndPass +=
                        `
                        <div  style=" 
                        margin: auto;
                        text-align: center;
                        width: 100%;
                        height: 6vh; text-align: center; 
                        justify-content: center;
                        font-size: large" 
                        class="alert alert-danger" role="alert">
                        Wrong Credentials
                        </div>`

                        document.getElementById("notAllowed").innerHTML = wrongEmailAndPass
                        
                        setTimeout(()=>{
                            document.getElementById("notAllowed").innerHTML = ""
                        },2000)
                    }
                    // paginationDiv.style.display='none'
                response.json()
            
            .then((data) => {
                if (data.jwt != null) {
                    localStorage.setItem("jwtToken", data.jwt)
                    // location.href = `${baseUrl}/admin.html`
                    window.open(admin  , "_self")
                    // getUserData();
                    document.getElementById('password').value = ""
                }
            })
            .catch((error) => {
                console.log(error);
            });
        })
    }



    console.log(email);
    console.log(password);
}


function getToken() {
    let token = localStorage.getItem("jwtToken")
    if (token != null) {
        return "Bearer " + token
    }
    return null;
}




function getData(url) {
 
    return fetch(`${baseUrl}/api${url}`, {
        method: "GET",
        headers: {
            "Content-type": "application/json",
            "Authorization": getToken()
        }
    })
     .then((response) => {
            return response.json()
                .then((data) => {
                    
                    return data;
                })
                .catch((err) => {
                    console.log(err)
                })
        })
        .catch((error) => {
            // window.open(exception503, "_self")
        })
  

}

function updateData(url, data) {
   debugger
    return fetch(`${baseUrl}/api${url}`, {
        method: "PUT",
        headers: {
            "Content-type": "application/json",
            "Authorization": getToken()
        },
        body: JSON.stringify(data)
    })
        .then((response) => {
            switch (response.status) {
                case 404:
                    window.open(exception404, "_self")
                    break;
                case 500:
                    window.open(exception500, "_self")
                    break;
                case 401:
                    localStorage.clear()
                    window.open(loginPage, "_self")
                    break;
            }

            return response.json()
                .then((data) => {
                    return data;
                }).catch((err) => {
                    console.log(err);
                })
        })
        .catch((error) => {
            // window.open(exception503, "_self")
            console.log(error)
        });
}

function sendData(url, data) {

    return fetch(`${baseUrl}/api${url}`, {
        method: "POST",
        headers: {
            "Content-type": "application/json",
        },
        body: JSON.stringify(data)
    })
        .then((response) => {
            return response.json()
                .then((data) => {
                    return data;
                })
                .catch((err) => {
                    console.log("Caught it " + err);
                })
        })
        .catch((error) => {
            // window.open(exception503, "_self")
            console.log(error)
        });
}

function deleteData(url) {
   
    return fetch(`${baseUrl}/api${url}`, {
        method: 'DELETE',
        headers: {
            "Authorization": getToken()
        }
    })
        .catch((error) => {
            console.log(error);
        });
}

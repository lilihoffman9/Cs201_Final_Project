function validatePassword() {
    // Making sure password confirmation is valid
    var password = document.getElementById("password").value;
    var confirm_password = document.getElementById("confirm-password").value;
    
    if(password == confirm_password)
    {
		document.getElementById("error").innerHTML = "";
		return true;
	}
    else
    {
		document.getElementById("error").innerHTML = "Passwords do not match!";
		return false;
	}
    
}

function addUser() {
	console.log("adding users....");
    if(!validatePassword())
    {
		return false;
	}
	
	//get inputs from frontend
	var _email = document.getElementById("email").value;
	var _firstName = document.getElementById("first-name").value;
	var _lastName = document.getElementById("last-name").value;
	var _username = document.getElementById("username").value;
    var _password = document.getElementById("password").value;
    var _confirmpassword = document.getElementById("confirm-password").value;
    
    var result = JSON.stringify({
		email: _email,
		firstName: _firstName,
		lastName: _lastName,
		username: _username,
		password: _password,
		confirmpassword: _confirmpassword
	});
	
	fetch('signup_pageServlet', {
	    method: 'POST',
	    headers: {'Content-Type': 'application/json'}, 
	    body: result
	})
	.then(response => response.json())
	.then(data => {
	    console.log(data);
	    if (!response.ok) {  
	        alert("Error: " + data);
	    } 
	    else if (response.redirected) {
            window.location.href = response.url;
		}  
	})
	.catch(error => {
	    console.error("Error adding user: ", error);
	    alert("An error occurred while adding user. " + error);
	});


    return false;
}

document.addEventListener('DOMContentLoaded', function() {
    localStorage.clear(); 
    console.log("Local storage cleared.");
});

function login(){
	var _username = document.getElementById("username").value;
	var _password = document.getElementById("password").value;
	
	
	let jsonData = JSON.stringify({
	    username: _username,
	    password: _password
	});
	
	
	console.log("Sending JSON: ", jsonData);
	fetch('LogInServlet', {
	    method: 'POST',
	    headers: {'Content-Type': 'application/json'},
	    body: jsonData
	})
	.then(res => res.json())
	.then((data) => {
	  if(data == "Invalid login credentials")
	  {
		alert("Invalid login credentials");
	  	console.log("Error log!");
	  }
	  else if (data == "User info missing") {
		  alert("User info missing");
	  }
	  else
	  {
	  	localStorage.setItem("firstName", data.firstName);
	  	localStorage.setItem("lastName", data.lastName);
	  	localStorage.setItem("email", data.email);
	  	localStorage.setItem("registeredEvents", "");
	  	localStorage.setItem("userName", data.username);
	  	location.href = 'profilePage.html';
	  	alert(localStorage.getItem('userName'));
	  	
	  }
	})
	.catch(error => {
		alert("An error occurred while adding user. " + error);
	});
	
	return false;
}

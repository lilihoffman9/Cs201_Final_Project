function login(){
	console.log("Here");
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
	  	window.localStorage.setItem("user_info", data);
	  	window.location.href = 'profilePage.html';
	  	console.log("Received upon login: " + data);
	  	
	  }
	})
	.catch(error => {
		alert("An error occurred while adding user. " + error);
	});
	
	return false;
}

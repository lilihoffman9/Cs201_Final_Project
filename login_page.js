window.onload = function () {

	var _username = document.getElementById("username").value;
	var _password = document.getElementById("password").value;
	
	fetch('Messages', {
		method: 'POST',
		headers: {'Content-Type': 'application/json'},
		body: JSON.stringify({
			username: _username,
			password: _password
		})
	})
	.then(res => res.json())
	.then((data) => {
	  if(data == false)
	  {
	  	console.log("Error log!");
	  }
	  else
	  {
	  	window.localStorage.setItem("user_info", data);
	  	window.location.href = 'profilePage.html';
	  }
	})
	.catch(error => {
		alert("An error occurred while adding user. " + error);
	});
	
	return false;
}

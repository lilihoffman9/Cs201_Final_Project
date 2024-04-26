window.onload = function () {

	var curr_user = localStorage.getItem("user_info");
	console.log(JSON.stringify(curr_user));
	document.getElementById("userName").innerHTML += localStorage.getItem("userName");
	document.getElementById("username").innerHTML += localStorage.getItem("userName");
	document.getElementById("fullname").innerHTML += localStorage.getItem("firstName");
	document.getElementById("fullname").innerHTML += localStorage.getItem("lastName");
	document.getElementById("email").innerHTML += localStorage.getItem("email");
	
	return false;
}

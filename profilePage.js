window.onload = function () {

	var curr_user = JSON.parse(window.localStorage.getItem("curr_user"));
	document.getElementById("my_name").innerHTML += curr_user.username;
	document.getElementById("username").innerHTML += curr_user.username;
	document.getElementById("fullname").innerHTML += curr_user.firstName;
	document.getElementById("fullname").innerHTML += curr_user.lastName;
	document.getElementById("email").innerHTML += curr_user.email;
	
	return false;
}

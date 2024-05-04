<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset= UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Chat Room</title>
<style media="screen" type="text/css">
	* {
		margin: 0; 
		padding: 0;
	}
	
	#navbar {
	    background-color: rgba(255, 255, 255, 0.2);
	    position:fixed;
	    top: 0px;
		left: 0px;
		right: 0px;
		z-index: 1;
	    padding-left:30px;
	    padding-right:30px;
	}
	
	#nav ul {
	    list-style: none;
	    margin: 0px;
	    padding: 0px;
	    display: flex;
	    justify-content: flex-end;
	}
	
	#nav li {
	    line-height: 30px;
	    text-align: center;
	}
	
	#nav a {
	    color: white;
	    font-size:17px;
	    text-decoration:none;
	}
	
	#nav a:hover:after {
	    transform: scaleX(1);
	}
	
	#nav a::after {
	    display:block;
	    content: '';
	    border-bottom: solid 3px #d3cbf5;  
	    transform: scaleX(0);  
	    transition: 350ms ease-in-out;
	    transform-origin: 0% 50%;
	}
	
	.right-items ul {
	    display:flex;
	    padding:0;
	    margin:0;
	    list-style: none;
	}
	
	.right-items li {
	    padding-left: 8px;
	}
	
	#vertical-navbar {
	    background-color: rgba(255, 255, 255, 0.2);
	    position: fixed;
	    top: 34px; 
	    left: 0;
	    width: 200px;
	    height: calc(100% - 34px); 
	    padding: 30px 10px;
	    box-sizing: border-box;
	    z-index: 1;
	    text-align: center;
	    
	}
	
	#vertical-navbar ul {
	    list-style: none;
	    padding: 0;
	    margin: 0;
	}
	
	#vertical-navbar a {
	    color: white;
	    font-size: 23px;
	    text-decoration: none;
	    display: block; 
	    transition: color 0.3s;
	}
	
	#vertical-navbar a:hover::after {
	    transform: scaleX(1);
	}
	
	#vertical-navbar a::after {
	    content: '';
	    display: block;
	    border-bottom: solid 3px #d3cbf5;
	    transform: scaleX(0);
	    transition: transform 350ms ease-in-out;
	    transform-origin: 50% 50%;
	}
	
	#vertical-navbar li {
	    margin-bottom: 40px;
	    border-bottom: 1px solid #ccc;
	    padding-bottom: 35px; 
	}
	
	
	body {
	    font-family: Arial, sans-serif;
	    background-color: #F88A3E;
	    margin: 0;
	    padding: 0;
	    display: flex;
	    justify-content: center;
	    align-items: center;
	    height: 100vh;
	}
	
	#inner-box {
	    width: calc(100% - 100px);
	    height: calc(100% - 135px);
	    background-color: #D9D9D9;
	    border-radius: 5px;
	    z-index: 0;
	    margin-top: 80px;
	    margin-left: 250px;
	    margin-right: 50px;
	    bottom: 30px;
	    display: flex;
	    flex-direction: column;
	    position: relative;
	    text-align: left;
	}
	
	div#user { 
		background-color: #737373;
		width: 100%;
		height: 45px;
		text-align: center;
		color: white;
		font-size: 16px;
		align-items: center;
		border-top-left-radius: 5px;
		border-top-right-radius: 5px;
	}
	
	p#username {
		padding: 10px;
		font-size: 20px;
	}
	
	div#message {
		position: absolute;
	    bottom: 0;
	    background-color: #afafaf;
	    width: 98.3%; 
	    color: white;
	    padding: 10px;
	    display: flex;
	    height: 60px;
	}
	
	div#message-write {
		width: 90%;
		height: 90%;
	}
	
	textarea#message-box{
		width: 1000px; 
		height: 90%;
		padding: 10px;
		resize: none;
		margin-top: 5px;
	}
	
	div#send-button {
		align-items: center;
		position: relative;
		height: 90%;
	}
	
	button#send {
		width: 70px;
		padding: 10px;
	    font-size: large;
	    background-color: #F88A3E;
	    border: none;
	    cursor: pointer;
	    margin-left: 10px;
	    margin-top: 10px;
	    display: inline-block;
	}
	
	.flex-container{
		display: flex;
	}
	
	.children {
		display: inline-block;
	}
	
	#search-area {
	    width: 100%;
	    display: flex;
	    flex-direction: column;
	    align-items: center;
	
	    position: absolute; 
	    bottom: 30px; 
	    width: 100%; 
	}
	
	#sent-messages {
	    margin-top: 20px;
	    width: 1100px;
	    height: 350px;
	    padding: 10px;
	    border-radius: 5px;
	    background-color: whitesmoke;
	    border: none;
	    margin-right: 10px;
	    font-size:large;
	}
	
	
	#search-box-container {
	    display: flex;
	    align-items: center;
	    margin-bottom: 20px;
	    text-align: center;
	}
	
	#search-box {
	    margin-top: 20px;
	    width: 700px;
	    padding: 10px;
	    border-radius: 5px;
	    background-color: whitesmoke;
	    border: none;
	    margin-right: 10px;
	    font-size:large;
	}
	
	#action-button {
	    padding: 10px 20px;
	    margin: 0 10px;
	    border: none;
	    border-radius: 5px;
	    cursor: pointer;
	    width: 150px;
	    font-size:large;
	}
	
	#action-button {
	    width: auto;
	    margin-top: 20px;
	    font-size: 20px;
	}
	
	#search-by {
	    display: flex;
	    align-items: center;
	    font-family: Arial;
	    font-size:large;
	}
	
	#search-by-text {
	    color:#4D4646;
	}
</style>
<script type = "text/javascript">
	/* var ws;

	function connect() {
		ws = new WebSocket('ws://' + window.location.host + "/Final_Project/chat");

		ws.onmessage = function(event) {
			var mySpan = document.getElementById("sent-messages");
			mySpan.innerHTML+=event.data+"<br/>";
		};

		ws.onclose = function(event) {
		        console.log('Connection closed by the server.');
		};
		
		ws.onerror = function(event) {
			console.log("Error", event);
		}
		
		function sendMsg() {
			var msg = document.getElementById("search-box").value;
			ws.send(msg);
			msg = "";
		}
	}

	window.onload = connect; */
	
	var wordBank = [
        "Hello",
        "So excited",
        "It sounds very interesting",
        "We should totally meet up at the event",
        "See you soon",
        "Bye"
    ];

var currentIndex = 0;

    function sendMsg() {
        var inputBox = document.getElementById("search-box");
        var messages = document.getElementById("sent-messages");
        var userMessage = inputBox.value;
        if (userMessage.trim() !== "") {
            // Display user message
            messages.innerHTML += "<div>User 1: " + userMessage + "</div>";

            // Clear input after sending
            inputBox.value = "";
            
            var randomDelay = Math.floor(Math.random() * (5000 - 1000 + 1) + 1000);

            // Simulate receiving a response from the word bank
            setTimeout(function() {
                var response = wordBank[currentIndex];
                messages.innerHTML += "<div>User 2: " + response + "</div>";
                
                // Increment the index to the next message
                currentIndex++;
                // If we've reached the end of the word bank, loop back to the beginning
                if (currentIndex >= wordBank.length) {
                    currentIndex = 0;
                }
            }, randomDelay);
        }
    }

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
</script>
</head>
<body>
	<div id="navbar">
        <div id="nav">
            <ul>
                <li id="right-items">
                    <ul>
                        <li><a href="profilePage.html">Welcome [Username]</a></li>
                    </ul>
                </li>
            </ul>
        </div> <!-- #nav -->
    </div> <!-- #navbar -->

    <div id="vertical-navbar">
        <ul>
            <li><a href="profilePage.html">Home</a></li>
            <li><a href="search_page.html">Search</a></li>
            <li><a href="profilePage_events.html">My Events</a></li>
            <li><a href="chatRoom.html">Messages</a></li>
        </ul>
    </div> <!-- #vertical-navbar -->

    <div id="inner-box">
    	<div id="user">
    		<p id="username">
    			[Username]
    		</p>
    	</div>
    	
    	<div id="sent-messages" class="sent-messages"></div>

        <div id="search-area">
            <div id="search-box-container">
                <input type="text" id="search-box" placeholder="Enter a message">
                <button id="action-button" onclick="sendMsg()">Send</button>
            </div>
        </div>

    	
    </div>
</body>
</html>

/**
 * 
 */
function connectServer() {
  var isEmpty = checkValue(inputUsername.value);

  if (isEmpty) {
    setStatus('Please enter username');
    return;
  }

  try {
    ws = new WebSocket(createURI(URI));
    ws.addEventListener('open', onOpen);
    ws.addEventListener('message', onMessage);
    ws.addEventListener('error', onError);
    ws.addEventListener('close', onClose);
  } catch (e) {
    setStatus(e.message);
  }
}

function createURI(URI) {
  var newURI = "ws://";
  var location = window.location;
  if (location.protocol === 'https:') {
    newURI = "wss://"
  }
  return newURI + location.host + location.pathname + URI;
}

function onOpen(e) {
  initCustomEvent();
  sendMessage('setUserName', inputUsername.value);
  setConnect();
  setStatus('Connected succesfully.');
  textareaMessage.focus();
}

function initCustomEvent() {
  ws.addEventListener('join', onJoin);
  ws.addEventListener('left', onLeft);
  ws.addEventListener('newMessage', onNewMessage);
}

function onMessage(e) {
  var message = JSON.parse(e.data);

  ws.dispatchEvent(new CustomEvent(message.action, {
    detail: message
  }));
}

function onError(e) {
  setDisconnect();
  setStatus('Something went wrong: ' + e);
}

function onClose(e) {
  setDisconnect();
  setStatus(e.reason);
}

function setStatus(message) {
  spanStatus.textContent = message;
  setTimeout(function () {
    spanStatus.textContent = null;
  }, 1500);
}

function sendMessage(action, value) {
  ws.send(JSON.stringify({
    action: action,
    value: value
  }));
}

function addMessage(content) {
  var messageElement = document.createElement('li');
  messageElement.textContent = content;
  messageElement.className = 'text-center';
  messageList.insertAdjacentElement('beforeend', messageElement);
}

function setOnlineCount(count) {
  onlineStatus.textContent = count + ' user online';
}

function onJoin(e) {
  addMessage(e.detail.username + ' joined.');
  setOnlineCount(e.detail.value);
  chatBody.scrollTop = chatBody.scrollHeight;
}

function onLeft(e) {
  addMessage(e.detail.username + ' left.');
  setOnlineCount(e.detail.value);
  chatBody.scrollTop = chatBody.scrollHeight;
}

function onNewMessage(e) {
  var messageDate = new Date(e.detail.date);
  var messageElement = document.createElement('li');
  messageElement.textContent = e.detail.value;
  var messageInfo = document.createElement('strong');
  messageInfo.textContent = '(' + messageDate.toLocaleTimeString() + ') ' + e.detail.username + ': ';
  messageElement.insertAdjacentElement('afterbegin', messageInfo);
  messageList.insertAdjacentElement('beforeend', messageElement);
  chatBody.scrollTop = chatBody.scrollHeight;
}

function setConnect() {
  onlineStatus.classList.remove('d-none');
  chatForm.classList.add('d-none');
  chatBody.classList.remove('d-none');
  chatFooter.classList.remove('d-none');
}

function setDisconnect() {
  onlineStatus.classList.add('d-none');
  chatForm.classList.remove('d-none');
  chatBody.classList.add('d-none');
  chatFooter.classList.add('d-none');
}

function checkValue(value) {
  return value == null || value.trim() == '';
}

function sendNewMessage() {
  var isEmpty = checkValue(textareaMessage.value);

  if (isEmpty) {
    setStatus('Please enter message');
    return;
  }

  sendMessage('sendMessage', textareaMessage.value);
  textareaMessage.value = '';
  textareaMessage.focus();
}

document.addEventListener('DOMContentLoaded', init);

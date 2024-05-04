

import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.OnOpen;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;



/**
 * Servlet implementation class ChatServlet
 */
@ServerEndpoint("/ChatServlet")
public class ChatServlet extends HttpServlet {
	private static Set<Session> userSessions = Collections.newSetFromMap(new ConcurrentHashMap<Session, Boolean>());
	
	@OnOpen
	public void OnOpen(Session curSession) {
		userSessions.add(curSession);
	}
	
	@OnClose
	public void OnClose(Session curSession) {
		userSessions.remove(curSession);
	}
	
	@OnMessage
	public void onMessage(String message, Session userSession) {
		for(Session ses: userSessions) {
			ses.getAsyncRemote().sendText(message);
		}
	}
}

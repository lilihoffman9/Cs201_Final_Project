import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.Session;
import javax.websocket.OnOpen;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;

@ServerEndpoint("/ChatServlet")
public class ChatServlet {
    private static Set<Session> userSessions = Collections.newSetFromMap(new ConcurrentHashMap<Session, Boolean>());

    @OnOpen
    public void onOpen(Session curSession) {
        userSessions.add(curSession);
    }

    @OnClose
    public void onClose(Session curSession) {
        userSessions.remove(curSession);
    }

    @OnMessage
    public void onMessage(String message, Session userSession) {
        for(Session ses: userSessions) {
            ses.getAsyncRemote().sendText(message);
        }
    }
}

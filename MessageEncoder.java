

/*import javax.json.bind.JsonbBuilder;
import jakarta.websocket.EncodeException;
import jakarta.websocket.Encoder;
import jakarta.websocket.EndpointConfig;*/
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class MessageEncoder implements Encoder.Text<Message> {

    public String encode(Message message) throws EncodeException {
        return JsonbBuilder.create().toJson(message);
    }

    public void init(EndpointConfig ec) {
    }

    public void destroy() {
    }

}
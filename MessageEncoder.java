

/*import javax.json.bind.JsonbBuilder;
import jakarta.websocket.EncodeException;
import jakarta.websocket.Encoder;
import jakarta.websocket.EndpointConfig;*/
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;

public class MessageEncoder implements Encoder.Text<Message> {

    public String encode(Message message) throws EncodeException {
    	String message1 = new Gson().toJson(message);
    	return message1;
       // return JsonbBuilder.create().toJson(message);
    }

    public void init(EndpointConfig ec) {
    }

    public void destroy() {
    }

}

/*
import javax.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbException;
import jakarta.websocket.DecodeException;
import jakarta.websocket.Decoder;
import jakarta.websocket.EndpointConfig;*/

//import javax.json.bind.JsonbBuilder;
//import javax.json.bind.JsonbException;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;
public class MessageDecoder implements Decoder.Text<Message> {
	Gson gson = new Gson();

    public Message decode(String text) throws DecodeException {
       // try {
        	Message message = new Gson().fromJson(text, Message.class);
        	return message;
            //return JsonbBuilder.create().fromJson(text, Message.class);
            
         /*catch (JsonbException e) {
            throw new DecodeException(text, e.getMessage(), e);
        }*/
    }

    public boolean willDecode(String text) {
        return true;
    }

  //  @Override
    public void init(EndpointConfig ec) {
    }

    public void destroy() {
    }

}

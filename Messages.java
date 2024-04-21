import java.io.BufferedReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Messages {
    private int messageId;
    private int senderId;
    private int recieverId;
    private String message;
    private long timeStamp;

    //return whole collection of messages
    public void doPost(HttpServletRequest request,HttpServletResponse response){ 
        try{
        	
        	//add message to sql table
            PrintWriter pw = response.getWriter();
            response.setContentType("application/json");
    
            BufferedReader br = request.getReader();
            StringBuilder jsonString = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                jsonString.append(line);
            }
    
            Gson gson = new Gson();
            JsonElement jsonElement = gson.fromJson(jsonString.toString(),JsonElement.class);
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            int senderId = jsonObject.get("senderID").getAsInt();
            int receiverId = jsonObject.get("receiverID").getAsInt();
            String message = jsonObject.get("messageContent").getAsString();
            String timestamp = jsonObject.get("timestamp").getAsString();
    
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/MessageTable", "username", "password");
    
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO MessageTable (senderID, receiverID, messageContent, timestamp) VALUES (?, ?, ?, ?)");
            preparedStatement.setInt(1, senderId);
            preparedStatement.setInt(2, receiverId);
            preparedStatement.setString(3, message);
            preparedStatement.setString(4, timestamp);
            preparedStatement.executeUpdate();
            
            // Retrieve all messages from the table
            PreparedStatement selectStatement = connection.prepareStatement("SELECT * FROM MessageTable");
            ResultSet resultSet = selectStatement.executeQuery();

            JSONArray messagesArray = new JSONArray();	//to put messages in

            while (resultSet.next()) {
                JSONObject messageObject = new JSONObject();
                messageObject.put("senderID", resultSet.getInt("senderID"));
                messageObject.put("receiverID", resultSet.getInt("receiverID"));
                messageObject.put("messageContent", resultSet.getString("messageContent"));
                messageObject.put("timestamp", resultSet.getString("timestamp"));

                messagesArray.put(messageObject);
            }
    
            //send response with all the messages
            JSONObject responseJson = new JSONObject();
            responseJson.put("status", "success");
            pw.print(responseJson.toString());
            
            
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public int getSenderID(){
        return senderId;
    }

    public int getRecieverID(){
        return recieverId;
    }

    public int getMessageID(){
        return messageId;
    }

    public String getMessage(){
        return message;
    }

    public long getTimeStamp(){
        return timeStamp;
    }
}

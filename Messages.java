public class Messages {
    private int messageId;
    private int senderId;
    private int recieverId;
    private String message;
    private long timeStamp;

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

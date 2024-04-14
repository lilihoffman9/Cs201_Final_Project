package clientHandler;
public class Event {
    private String name;
    private String location;
    private String date; 
    private String details;
    
    Event(String name, String location, String date, String details){
    	this.name = name;
    	this.location = location;
    	this.date = date;
    	this.details = details;
    }

    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }

    public String getLocation(){
        return location;
    }
    
    public void setLocation(String location){
        this.location = location;
    }

    public String getDate(){
        return date;
    }
    
    public void setDate(String date){
        this.date = date;
    }

    public String getDetails(){
        return details;
    }
    
    public void setDetails(String details){
        this.details = details;
    }
}

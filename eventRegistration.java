import java.time.LocalDateTime; 
import java.util.UUID; // For generating unique registration IDs and QR codes

public class EventRegistration {
    private String userID;
    private String eventName;
    private LocalDateTime regTime;
    private String regID;
    private String QRCode;

    public EventRegistration(String userID, String eventName) {
        this.userID = userID;
        this.eventName = eventName;
        this.regTime = LocalDateTime.now(); 
        this.regID = UUID.randomUUID().toString(); 
        this.QRCode = generateQR(); 
    }

    private String generateQR() {
        // Just to simulate QR code with unique UUID for now
        return UUID.randomUUID().toString(); 
    }

    public String getUserID() {
        return userID;
    }

    public String getEventName() {
        return eventName;
    }

    public LocalDateTime getRegTime() {
        return regTime;
    }

    public String getRegID() {
        return regID;
    }

    public String getQRCode() {
        return QRCode;
    }

    public void addRegistration(String eventName) {
        // Each user can register an event via this method
    }
}

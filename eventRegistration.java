/*
 * This class is to: 
 * 1. Create Event Registration
 * 2. Allow users to retrieve their registration information
 * 3. As long as the user registers for the event, insert reg info to Registrations table
 * 4. Allow users to register for an event
*/


package ningyues_CSCI201_Final_Project;

import java.time.LocalDateTime;
import java.util.List;
//import java.io.ByteArrayOutputStream;
import java.io.IOException;
//import java.nio.file.FileSystems;
//import java.nio.file.Path;

public class eventRegistration {
    private int userID;
    private int eventID;
    private LocalDateTime regTime;
//    private String QRCodePath;
    private int regID;
    private List<String> registrationList;
    

    public eventRegistration(int userID,int eventID) throws IOException {
        this.userID = userID;
        this.eventID= eventID; 
        //this.QRCodePath = generateQR(this.regID);
        EventRegistrationJDBCConnector auth = new EventRegistrationJDBCConnector();
        this.regID = auth.getRegistrationID(userID, eventID);
        this.registrationList = auth.getUserRegistrations(userID);
        this.regTime = auth.getRegistrationTime(userID, eventID);
        auth.insertRegistration(userID, eventID);
    }
//
//    private String generateQR(String data) throws WriterException, IOException {
//        QRCodeWriter qrCodeWriter = new QRCodeWriter();
//        BitMatrix bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, 350, 350);
//
//        String filePath = "QRCode_" + this.regID + ".png";
//        Path path = FileSystems.getDefault().getPath(filePath);
//        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
//
//        return filePath; 
//    }

//    public String getQRCodePath() {
//        return QRCodePath;
//    }
//    
    public int getUserID() {
        return userID;
    }

    public int getEventID() {
        return eventID;
    }
    
    public LocalDateTime getRegTime() {
        return regTime;
    }

    public int getRegID() {
        return regID;
    }
    
    public List<String> getUserRegistrations() {
    	return registrationList;
    }
    
//    public static void main(String[] args) {
//        try {
//            EventRegistration registration = new EventRegistration("User123", "SampleEvent");
//            System.out.println("QR Code generated at: " + registration.getQRCodePath());
//        } catch (WriterException | IOException e) {
//            e.printStackTrace();
//        }
//    }
}

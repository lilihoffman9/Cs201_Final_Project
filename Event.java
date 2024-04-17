package ningyues_CSCI201_Final_Project;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class Event {
	private int id;
    private String name;
    private String location;
    private String date; 
    private String details;
    private String QRCodePath;
    
    Event(String name, String location, String date, String details) throws WriterException, IOException{
    	this.name = name;
    	this.location = location;
    	this.date = date;
    	this.details = details;
    	this.QRCodePath = generateQR(String.valueOf(id));
    }
    
    private String generateQR(String eventID) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(eventID, BarcodeFormat.QR_CODE, 350, 350);

        String filePath = "QRCode_" + eventID + ".png";
        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

        return filePath; 
    }

    public String getQRPath() {
    	return QRCodePath;
    }
    
    public int getID() {
    	return id;
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

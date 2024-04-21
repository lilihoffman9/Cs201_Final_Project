package ningyues_CSCI201_Final_Project;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/* This class is used to hard-code the QR code for each event.
 * Download core.jar and javas.jar, manually type in the HTML for each event,
 * run this class as java application, and refresh the project folder, a qr-code.png will appear at the bottom.
 * We could display the qr-code.png after the user register for a event
 */
public class QRCodeGenerator {

    public String generateQRCode(String url, String filePath) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(url, BarcodeFormat.QR_CODE, 350, 350);

        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

        return path.toString();
    }
    
    public static void main(String[] args) {
        QRCodeGenerator qrGenerator = new QRCodeGenerator();
        try {
            String url = "http://localhost:8080/ningyues_CSCI201_Final_Project/event_info.html"; 
            String qrCodePath = qrGenerator.generateQRCode(url, "qr_code.png");
            System.out.println("QR Code generated at: " + qrCodePath);
        } catch (WriterException | IOException e) {
            System.err.println("Error generating QR code: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

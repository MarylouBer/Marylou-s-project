import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.net.URLEncoder;
import org.json.JSONObject;
import org.apache.commons.io.IOUtils;
import java.net.URL;
import java.nio.charset.Charset;

public class ParkingFinder {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your address: ");

            String address = scanner.nextLine();
            String encodedAddress = URLEncoder.encode(address, StandardCharsets.UTF_8.toString());

            String geoCodingApiUrl = "https://maps.googleapis.com/maps/api/geocode/json?address=" + encodedAddress + "&key=AIzaSyBGV5iCBkicloU4YXUpxeGNPQU-uSEhksQ";
            JSONObject json = new JSONObject(IOUtils.toString(new URL(geoCodingApiUrl), Charset.forName("UTF-8")));
            System.out.println(json);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}

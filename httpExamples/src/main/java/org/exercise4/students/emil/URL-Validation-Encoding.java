import java.net.URL;
import java.net.URLEncoder;
import java.net.URLDecoder;

public class URLValidationEncoding {

    public static void main(String[] args) throws Exception {
        String url = "https://www.example.com/search?query=hello world & java encoding";

        if (isValidURL(url)) {
            String encodedURL = URLEncoder.encode(url, "UTF-8");
            System.out.println("Encoded URL: " + encodedURL);

            String decodedURL = URLDecoder.decode(encodedURL, "UTF-8");
            System.out.println("Decoded URL: " + decodedURL);
        } else {
            System.out.println("Invalid URL");
        }
    }

    public static boolean isValidURL(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

import java.net.MalformedURLException;
import org.apache.commons.validator.routines.UrlValidator;

public class security {
    public static void main(String[] args) throws MalformedURLException {
        security s = new security();
        System.out.print(s.isValidURL("https://www.example.com"));
    }

    boolean isValidURL(String url) throws MalformedURLException {
        String[] schemes = {"http","https"};
        UrlValidator validator = new UrlValidator(schemes);
        return validator.isValid(url);
    }

}

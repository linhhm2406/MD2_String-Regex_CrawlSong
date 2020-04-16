import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlSongExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.nhaccuatui.com/bai-hat/nhac-tre-moi.html");

            InputStreamReader isd = new InputStreamReader(url.openStream());
            Scanner scanner = new Scanner(isd);
//                                    System.out.println(scanner);
            scanner.useDelimiter("\\Z");
//                                    System.out.println(scanner.useDelimiter("\\Z"));
            String content = scanner.next();
//                                    System.out.println(content);
            scanner.close();

            content = content.replaceAll("\\n+","");
//                                    System.out.println(content);

            Pattern p = Pattern.compile("name_song\"(.*?)Bai Hat Moi(.*?)>(.*?)<\\/a>");
            Matcher m = p.matcher(content);
            while (m.find()) {
                System.out.println(m.group(3));
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

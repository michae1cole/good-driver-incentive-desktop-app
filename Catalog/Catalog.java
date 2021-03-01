import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.lang.System;


public class Catalog{
    public static void main(String[] args){
    
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder.uri(URI.create()).build("https://www.etsy.com/c/art-and-collectibles/prints/screenprints?ref=catcard-126-245561393&explicit=1");
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(Httpresponse::body).thenAccept(System.out::println).join();
    }
}

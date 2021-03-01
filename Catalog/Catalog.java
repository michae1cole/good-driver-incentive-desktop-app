import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpsURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.lang.System;


public class Catalog{
    public static void main(String[] args){
    
        HttpsClient client = HttpsClient.newHttpClient();
        HttpsRequest request = HttpsRequest.newBuilder.uri(URI.create()).build("https://www.etsy.com/c/art-and-collectibles/prints/screenprints?ref=catcard-126-245561393&explicit=1");
        client.sendAsync(request, HttpsResponse.BodyHandlers.ofString()).thenApply(Httpsresponse::body).thenAccept(System.out::println).join();
    }
}

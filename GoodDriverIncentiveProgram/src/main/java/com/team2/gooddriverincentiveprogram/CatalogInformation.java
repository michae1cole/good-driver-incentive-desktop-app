/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team2.gooddriverincentiveprogram;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author lizst
 */

public class CatalogInformation {
    
    private static int ITEM_REQUEST_LIMIT = 25;
    
    public static void main(String[] args) throws IOException, InterruptedException{
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://openapi.etsy.com/v2/listings/active?api_key=pzm9kr33wye2gmv9fy2h4g64&keywords=cards&limit="+ITEM_REQUEST_LIMIT))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject jsonResponse = new JSONObject(response.body());
        parse(jsonResponse);
    }
    
    public static void parse(JSONObject responseB) throws IOException, InterruptedException{
        //for(int i = 0; i < responseB.getJSONArray("results").length(); i++) {
        for(int i = 0; i < 1; i++) {
            int listingID = responseB.getJSONArray("results").getJSONObject(i).getInt("listing_id");
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://openapi.etsy.com/v2/listings/" + listingID + "/images?api_key=pzm9kr33wye2gmv9fy2h4g64"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject jsonResponse = new JSONObject(response.body());
            System.out.println(jsonResponse.getJSONArray("results").getJSONObject(i).getString("url_75x75"));
            //String title = responseB.getJSONArray("results").getJSONObject(i).getString("title");
            //title = title.replaceAll("&#39;", "\'");
            //String description = responseB.getJSONArray("results").getJSONObject(i).getString("description");
            //String price = responseB.getJSONArray("results").getJSONObject(i).getString("price");
            //System.out.println(title + "\n" + description + ":" + "\n" + price);
            //System.out.println(title + "\n" + price);
        }
    }
    
    public static void databaseItemInsert(double price, String title, String imageURL, int quantity) {
        try {
            PreparedStatement catalogItemPS = MyConnection.getConnection().prepareStatement("INSERT INTO CatalogItems (Price, ItemDescription, ItemImage, Quantity) VALUES (?, ?, ?, ?)");
            catalogItemPS.setDouble(1, price);
            catalogItemPS.setString(2, title);
            catalogItemPS.setString(3, imageURL);
            catalogItemPS.setInt(4, quantity);
            catalogItemPS.executeUpdate();
        } catch(SQLException e) {
            Logger.getLogger(CatalogInformation.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}

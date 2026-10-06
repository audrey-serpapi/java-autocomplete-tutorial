package org.example;

import serpapi.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;

public class ScrapeAutocomplete {

    public static void main(String[] args) throws Exception {
        findTools();
    }

    // Asks Google for autocomplete suggestions and prints them out
    public static void findTools() throws Exception {

        // Set up the SerpApi client with your key and engine choice
        String apiKey = System.getenv("SERPAPI_KEY");
        Map<String, String> settings = new HashMap<>();
        settings.put("api_key", apiKey);
        settings.put("engine", "google_autocomplete");

        SerpApi client = new SerpApi(settings);

        // Define what we want to search for
        Map<String, String> searchTerms = new HashMap<>();
        searchTerms.put("q", "software engineers are using ");
        searchTerms.put("json_restrictor", "suggestions");

        try {
            // Gather the results
            JsonObject response = client.search(searchTerms);
            //JsonArray suggestions = response.getAsJsonArray("suggestions");

            // Print each suggestion's text
            System.out.println("Autocomplete suggestions for \"software engineers are using...\":");
            
            System.out.println("Autocomplete suggestions for \"software engineers are using...\":");
            for (JsonElement element : response) {
                JsonObject obj = element.getAsJsonObject();
                if (obj.has("value")) {
                    System.out.println("* " + obj.get("value").getAsString());
                }
            }
        } catch (SerpApiException ex) {
            System.out.println("Exception:");
            System.out.println(ex.toString());
        }
        
    }
}
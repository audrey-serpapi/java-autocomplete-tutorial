package org.example;

import serpapi.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScrapeAutocomplete {

    public static void main(String[] args) throws Exception {
        List<String> suggestions = findTools();

        System.out.println("Autocomplete suggestions:");
        for (String suggestion : suggestions) {
            System.out.println("* " + suggestion);
        }
    }

    // Asks Google for autocomplete suggestions and returns them as a list
    public static List<String> findTools() throws Exception {

        // Set up the SerpApi client with your key
        String apiKey = System.getenv("SERPAPI_KEY");

        Map<String, String> settings = new HashMap<>();
        settings.put("api_key", apiKey);
        settings.put("engine", "google_autocomplete");

        SerpApi client = new SerpApi(settings);

        // Define what we want to search for
        Map<String, String> searchTerms = new HashMap<>();
        searchTerms.put("q", "software engineers are using ");

        JsonObject response = client.search(searchTerms);

        // Pull the suggestions out of the response
        JsonArray suggestionsFromApi = response.getAsJsonArray("suggestions");

        // Copy each suggestion's text into a simple list of Strings
        List<String> results = new ArrayList<>();
        for (int i = 0; i < suggestionsFromApi.size(); i++) {
            JsonObject item = suggestionsFromApi.get(i).getAsJsonObject();
            String text = item.get("value").getAsString();
            results.add(text);
        }

        return results;
    }
}
package org.example;

import java.util.List;
import java.util.ArrayList;
import java.awt.EventQueue;

public class Main {

    private static WindowManager frame;

    public static void main(String[] args) {

        // Search for sour chewy snack min15 with no allergens

        Search search = new Search(Search.Flavor.sour, Search.Texture.chewy, Search.Type.snack, Search.Time.min15, Search.Allergen.any);
        List<SearchResult> results = search.runSearch();
        for (SearchResult result : results) {
            int id = result.getId();
            String name = result.getName();
            System.out.println("Search for sour chewy snack min15 with no allergens\nrecipe " + id + ": " + name);
        }

        // Search for sour chewy snack min15 with milk allergen

        search = new Search(Search.Flavor.sour, Search.Texture.chewy, Search.Type.snack, Search.Time.min15, Search.Allergen.milk);
        results = search.runSearch();
        for (SearchResult result : results) {
            int id = result.getId();
            String name = result.getName();
            System.out.println("\nSearch for sour chewy snack min15 with milk allergen\nrecipe " + id + ": " + name);
        }

        try {
            frame = new WindowManager();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
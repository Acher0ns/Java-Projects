package assignment7_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import graphs.WAdjacencyGraph;
import graphs.WGraph;

public class TravelingSalesman {
    public static final String DATA_PATH = "C:/Users/Kamron Cole/Documents/GitHub/SoftDevII/Unit07/data/";

    public static WGraph<City> makeGraph(List<City> cities) {
        WGraph<City> graph = new WAdjacencyGraph<>();
        for (City from_city : cities) {
            if (!graph.contains(from_city)) {
                graph.add(from_city);
            }
            for (City to_city : cities) {
                if (!from_city.equals(to_city) && !graph.contains(to_city)) {
                    graph.add(to_city);
                }

                graph.connect(from_city, to_city, from_city.distanceFrom(to_city));
            }
        }
        return graph;
    }

    public static List<City> makeCities(String filename) {
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader reader = new BufferedReader(fr);
            List<City> cities = new LinkedList<>();
            
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length == 4) {
                    cities.add(new City(tokens[0], tokens[1], Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3])));
                }
            }
            reader.close();
            fr.close();
            return cities;
        } catch (IOException ioe) {
            System.out.println("Error creating city list: " + ioe);
            return null;
        }
    }

    public static City findCity(String targetStr, List<City> cities) {
        for (City city : cities) {
            String cityStr = city.toString();
            if (cityStr.equals(targetStr)) {
                return city;
            }
        }
        System.out.println(targetStr + " is not found. Try again.");
        System.out.println();
        return null;
    }

    public static void main(String[] args) {
        List<City> cities = makeCities(DATA_PATH + "52cities.csv");
        WGraph<City> graph = makeGraph(cities);

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter origin city: ");
            String origCityStr = sc.nextLine();

            System.out.print("Enter destination city: ");
            String destCityStr = sc.nextLine();

            if (origCityStr == "" || destCityStr == "") {
                break;
            }

            City origCity = findCity(origCityStr, cities);
            if (origCity == null) {
                continue;
            }

            City destCity = findCity(destCityStr, cities);
            if (destCity == null) {
                continue;
            }

            System.out.println(graph.nearestNeighbors(origCity, destCity));
            System.out.println();
        }
        System.out.println();
        System.out.println("Goodbye!");
        sc.close();
    }
}

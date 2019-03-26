import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        City city0 = new City("Seattle", 608660, "Mike McGinn");
        City city1 = new City("Houston", 2099451, "Annise Parker");
        City[] cities = {city0, city1};

        ArrayList<Edge> list = new ArrayList<>();
        list.add(new Edge(0, 1));
        list.add(new Edge(0, 3));
        list.add(new Edge(0, 5));

        List<ArrayList<Edge>> neighbours = new ArrayList<>();
        neighbours.add(new ArrayList<Edge>());
        neighbours.get(0).add(new Edge(0, 1));
        neighbours.get(0).add(new Edge(0, 3));
        neighbours.get(0).add(new Edge(0, 5));
        neighbours.add(new ArrayList<Edge>());
        neighbours.get(1).add(new Edge(11, 8));
        neighbours.get(1).add(new Edge(11, 9));
        neighbours.get(1).add(new Edge(11, 10));
    }
}

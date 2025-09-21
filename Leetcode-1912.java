import java.util.*;

class MovieRentingSystem {
    private class Movie {
        int shop;
        int price;

        Movie(int shop, int price) {
            this.shop = shop;
            this.price = price;
        }
    }

    private class Rent {
        int shop;
        int movie;
        int price;

        Rent(int shop, int movie, int price) {
            this.shop = shop;
            this.movie = movie;
            this.price = price;
        }
    }

    private Map<Integer, TreeSet<Movie>> movies = new HashMap<>();
    private TreeSet<Rent> rentedMovies = new TreeSet<>((a, b) -> {
        if (a.price != b.price) return Integer.compare(a.price, b.price);
        if (a.shop != b.shop) return Integer.compare(a.shop, b.shop);
        return Integer.compare(a.movie, b.movie);
    });
    private Map<String, Integer> priceMap = new HashMap<>();

    public MovieRentingSystem(int n, int[][] entries) {
        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];

            String key = getKey(shop, movie);
            priceMap.put(key, price);

            movies.computeIfAbsent(movie, k -> new TreeSet<>((a, b) -> {
                if (a.price != b.price) return Integer.compare(a.price, b.price);
                return Integer.compare(a.shop, b.shop);
            })).add(new Movie(shop, price));
        }
    }

    // 1, 23 - 123
    // 12, 3 - 123
    private String getKey(int shop, int movie) {
        return shop + "_" + movie;
    }
    
    public List<Integer> search(int movie) {
        TreeSet<Movie> availableMovies = movies.getOrDefault(movie, new TreeSet<>());

        List<Integer> result = new ArrayList<>();
        int count = 0;

        for (Movie m : availableMovies) {
            if (count >= 5) {
                break;
            }

            result.add(m.shop);

            count += 1;
        }

        return result;
    }
    
    public void rent(int shop, int movie) {
        String key = getKey(shop, movie);
        Integer price = priceMap.get(key);

        TreeSet<Movie> availableMovies = movies.getOrDefault(movie, new TreeSet<>());
        availableMovies.remove(new Movie(shop, price));

        rentedMovies.add(new Rent(shop, movie, price));
    }
    
    public void drop(int shop, int movie) {
        String key = getKey(shop, movie);
        Integer price = priceMap.get(key);

        TreeSet<Movie> availableMovies = movies.getOrDefault(movie, new TreeSet<>());
        availableMovies.add(new Movie(shop, price));

        rentedMovies.remove(new Rent(shop, movie, price));
    }
    
    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();
        int count = 0;

        for (Rent m : rentedMovies) {
            if (count >= 5) {
                break;
            }

            result.add(Arrays.asList(m.shop, m.movie));

            count += 1;
        }

        return result;
    }
}

package ru.croc.task13;

import java.io.*;
import java.util.*;

public class MovieRecommendSystem {

    private static final String MOVIESPATH = "src/ru/croc/task13/movies.txt";

    private static final String VIEWINGHISTORYPATH = "src/ru/croc/task13/viewingHistory.txt";

    private static final Map<Integer, String> MOVIES;

    private static List<Viewer> viewers = new ArrayList<>();

    static {
        File file = new File(MOVIESPATH);
        try (Scanner scanner = new Scanner(file)){
            scanner.useDelimiter(",| *\\r\\n");
            MOVIES = new HashMap<>();
            while (scanner.hasNextLine()) {
                MOVIES.put(scanner.nextInt(), scanner.next());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Viewer mainUser = new Viewer();
        Scanner input = new Scanner(System.in);
        mainUser.editViewingHistory(input.nextLine());

        try {
            viewers = getViewingHistoryFromFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        removeViewers(mainUser);
        removeWatchedMovies(mainUser);
        System.out.println(MOVIES.get(recommendCounter()));
    }

    private static void removeViewers(Viewer mainUser) {
        Iterator<Viewer> iterator = viewers.iterator();
        Viewer viewer;
        while (iterator.hasNext()) {
            viewer = iterator.next();
            if (!viewer.isRightViewer(mainUser)) {
                iterator.remove();
            }
        }
    }

    private static ArrayList<Viewer> getViewingHistoryFromFile() throws IOException {
        File file = new File(VIEWINGHISTORYPATH);
        Scanner scanner = new Scanner(file);
        ArrayList<Viewer> viewers = new ArrayList<>();
        Viewer viewer;
        while (scanner.hasNextLine()) {
            viewer = new Viewer();
            viewer.editViewingHistory(scanner.nextLine());
            viewers.add(viewer);
        }
        return viewers;
    }

    private static void removeWatchedMovies(Viewer mainUser) {
        for (Viewer viewer: viewers) {
            viewer.removeMovies(mainUser);
        }
    }

    private static int recommendCounter() {
        Map<Integer, Integer> recommendations = new HashMap<>();

        for (Viewer viewer: viewers) {
            for (Integer key: viewer.getViewingHistory().keySet()) {
                if (recommendations.containsKey(key)) {
                    recommendations.put(key, recommendations.get(key) + viewer.getViewingHistory().get(key));
                } else {
                    recommendations.put(key, viewer.getViewingHistory().get(key));
                }
            }
        }

        int max = 0;
        int id = 0;
        for(Integer key: recommendations.keySet()) {
            if (recommendations.get(key) > max) {
                max = recommendations.get(key);
                id = key;
            }
        }

        return id;
    }

}

package ru.croc.task13;

import java.util.HashMap;
import java.util.Map;

public class Viewer {

    private Map<Integer, Integer> viewingHistory = new HashMap<>();  // key: id фильма, value: кол-во просмотров

    public Map<Integer, Integer> getViewingHistory() {
        return viewingHistory;
    }

    public void editViewingHistory(String history) {
        // конвертирует из строки history вида "2,1,3" поле Map<Integer, Integer> viewingHistory
        int newId;
        for (String numString : history.split(",")) {
            newId = Integer.parseInt(numString);
            if (!viewingHistory.containsKey(newId)) {
                viewingHistory.put(newId, 1);
            } else {
                viewingHistory.put(newId, viewingHistory.get(newId) + 1);
            }
        }
    }

    public boolean isRightViewer(Viewer mainUser) {
        double matchCounter = 0;  // эта переменная double, так как в return matchCounter сравнивается с double
        for (Integer key : mainUser.getViewingHistory().keySet()) {
            if (viewingHistory.containsKey(key)) {
                ++matchCounter;
            }
        }
        return (matchCounter >= mainUser.viewingHistory.size() / 2.0);
    }

    public void removeMovies(Viewer mainUser) {
        for (Integer key : mainUser.getViewingHistory().keySet()) {
            viewingHistory.remove(key);
        }

    }

}

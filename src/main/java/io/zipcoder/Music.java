package io.zipcoder;

import java.util.ArrayList;
import java.util.List;

public class Music {
    String[] playlist;

    public Music(String[] playlist) {
        this.playlist = playlist;
    }

    public Integer selection(int startingIndex, String selection) {
        int index = -1;
        int up = 0, down = 0;

        // Find all indices of the target song q
        List<Integer> song = new ArrayList<Integer>();
        for (int i = 0; i < playlist.length; i++) {
            if (playlist[i].equals(selection)) {
                song.add(i);
            }
        }

        // Calculate the number of button presses needed to reach q
        int minPresses = Integer.MAX_VALUE;
        for (int indexTemp : song) {
            if (indexTemp == startingIndex) {
                return 0;
            }
            if (indexTemp < startingIndex) {
                up = startingIndex - indexTemp;
                down = playlist.length - up;
            } else {
                down = indexTemp - startingIndex;
                up = playlist.length - down;
            }
            minPresses = Math.min(minPresses, Math.min(up, down));
        }

        // Return the minimum number of button presses
        return minPresses;
    }
}
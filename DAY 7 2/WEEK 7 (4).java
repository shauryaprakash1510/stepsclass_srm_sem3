package week_7.set_2;

import java.util.Arrays;

class Playlist {
    private final String[] songs;
    private int count;

    public Playlist(int maxSize) {
        this.songs = new String[maxSize];
        this.count = 0;
    }

    public void addSong(String song) {
        if (count < songs.length) {
            songs[count++] = song;
        }
    }

    public String[] getSongs() {
        // Defensive copy: creates a brand-new array copy
        return Arrays.copyOf(songs, count);
    }

    public int getSongCount() {
        return count;
    }
}

public class P2_Playlist {
    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked";

        System.out.println("p.getSongs()[0] is still: " + p.getSongs()[0]);
        System.out.println("p.getSongCount() -> " + p.getSongCount());
    }
}
package web;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;

public class VoteForm {

    private static String[] singerChoice;
    private static String[] genereChoice;
    private static String[] aboutMe;

    public VoteForm() {
        this.singerChoice = singerChoice;
        this.genereChoice = genereChoice;
        this.aboutMe = aboutMe;
    }

    public void setSingerChoice(String[] singerChoice) {
        this.singerChoice = singerChoice;
    }

    public void setGenereChoice(String[] genereChoice) {
        this.genereChoice = genereChoice;
    }

    public void setAboutMe(String[] aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String[] getSingerChoice() {
        return singerChoice;
    }

    public String[] getGenereChoice() {
        return genereChoice;
    }

    public String[] getAboutMe() {
        return aboutMe;
    }


    private static Map<String, Integer> collectionMapGenere = new HashMap<>();

    private static Map<String, Integer> collectionMapSinger = new HashMap<>();

    private static Map<Timestamp, String> collectionMapAbout = new HashMap<>();


    public static List aboutCounter() {
        Instant instant = Instant.now();
        for (String item : aboutMe) {
            collectionMapAbout.put(Timestamp.from(instant), item);
        }
        List about = new ArrayList(collectionMapAbout.entrySet());
        about.sort(new MapTimeComparator());
        return about;
    }
    public static List genereVotesCounter() {
        for (String item : genereChoice) {
            if (collectionMapGenere.keySet().contains(item)) {
                collectionMapGenere.put(item, collectionMapGenere.get(item) + 1);
            } else {
                collectionMapGenere.put(item, 1);
            }
        }
        List genvotes = new ArrayList(collectionMapGenere.entrySet());
        genvotes.sort(new MapValueComparator());
        return genvotes;
    }

    public static List singerVotesCounter() {
        for (String item: singerChoice) {
            if(collectionMapSinger.keySet().contains(item)){
                collectionMapSinger.put(item, collectionMapSinger.get(item) + 1);
            } else {
                collectionMapSinger.put(item, 1);
            }
        }
        List singervotes = new ArrayList(collectionMapSinger.entrySet());
        singervotes.sort(new MapValueComparator());
        return singervotes;
    }

}


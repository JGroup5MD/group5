package web;

import java.util.Arrays;

public class Checker {
    String[] name;
    String[] genere;
    String[] about;

    public Checker(String[] name, String[] genere, String[] about) {
        this.name = name;
        this.genere = genere;
        this.about = about;
    }

    Singer singer = new Singer();
    Genere gener = new Genere();
    VoteForm form = new VoteForm();



    public boolean nameChecker(){
        for (String s : name) {
            if(Arrays.asList(singer.getSinger()).contains(s)) {
                form.setSingerChoice(name);
            } else return false;
        }
        return true;
    }

    public boolean genereChecker(){
        for (String s : genere) {
            if(Arrays.asList(gener.getGenere()).contains(s)) {
                form.setGenereChoice(genere);
            } else return false;
        }
        return true;
    }

}

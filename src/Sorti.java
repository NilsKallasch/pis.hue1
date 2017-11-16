
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Ivan on 14.11.2017.
 */
public class Sorti {
/*
    public static void main(String[] args) {

        Sorti s = new Sorti("gutentaaag");

        s.sorti();

        for(int i = 0; i< s.los.length(); i++) {
            System.out.println(s.copy.get(i));
        }

    }

    private String los;
    private ArrayList<Speicher> copy;
    private ArrayList<Speicher> speicher;

    Sorti(String los) {
        this.los = los;
        copy = new ArrayList<>();
        speicher = new ArrayList<>();

        int j = 1;
        for(int i = 0; i<los.length(); i++, j++) {
            copy.add(new Speicher(los.substring(i,j).toLowerCase(), i));
            speicher.add(new Speicher(los.substring(i,j).toLowerCase(), i));
        }

    }

    class Speicher {
        String a;
        int b;

        Speicher(String a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return this.a + " " + String.valueOf(this.b);
        }
    }

    private void sorti() {
        int kuerz;
        for(int i = 0; i<copy.size(); i++) {
            kuerz = i;
            for(int k = i+1; k<copy.size(); k++) {

                if(copy.get(k).a.compareTo(copy.get(kuerz).a) < 0) {
                    kuerz = k;
                }
            }
            if(kuerz != i) {
                Speicher tmp = new Speicher(copy.get(i).a, copy.get(i).b);
                //copy.get(i).b = copy.get(kuerz).b;
                copy.get(i).a = copy.get(kuerz).a;
                //copy.get(kuerz).b = tmp.b;
                copy.get(kuerz).a = tmp.a;
            }
        }
        for(int i = 0; i<speicher.size(); i++) {
            for(int k = 0; k<speicher.size(); k++) {
                if(speicher.get(i).a.equals(copy.get(k).a)) {
                    speicher.get(i).b = copy.get(k).b;
                    copy.get(k).a = "";
                    break;
                }
            }
            System.out.println(speicher.get(i));
        }
        /*
        for(int i = 0; i<s.length; i++) {
            kuerz = i;
            for(int k = i + 1; k<s.length; k++) {
                if(s[k].compareTo(s[kuerz]) < 0) {
                    kuerz = k;
                }
            }
            if(kuerz != i) {
                String tmp = s[i];
                s[i] = s[kuerz];
                s[kuerz] = tmp;
            }
        }
        */
    }

import java.util.ArrayList;

/**
 * Created by Ivan on 10.11.2017.
 */
public class Wuerfel implements Codec {

    public static void main(String[] args) {
        Wuerfel a = new Wuerfel("senor");

        System.out.println(a.kodiere("hallofreundewiegehts"));

        //Codec codec = new Wuerfel("Domo");
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

    //
    private String losungswort;
    private ArrayList<Speicher> copy;
    private ArrayList<Speicher> speicher;
    private int[] perm;

    Wuerfel(String losungswort) {
        this.losungswort = losungswort;
        setzeOrdnung();
        copy = new ArrayList<>();
        speicher = new ArrayList<>();
        perm = new int[losungswort.length()];

        int j = 1;
        for(int i = 0; i<losungswort.length(); i++, j++) {
            copy.add(new Speicher(losungswort.substring(i,j).toLowerCase(), i));
            speicher.add(new Speicher(losungswort.substring(i,j).toLowerCase(), i));
        }
        this.sortieren();
    }

    private void setzeOrdnung() {
        copy = new ArrayList<>();
        speicher = new ArrayList<>();
        perm = new int[losungswort.length()];

        int j = 1;
        for(int i = 0; i<losungswort.length(); i++, j++) {
            copy.add(new Speicher(losungswort.substring(i,j).toLowerCase(), i));
            speicher.add(new Speicher(losungswort.substring(i,j).toLowerCase(), i));
        }
        this.sortieren();
    }

    private void sortieren() {
        int kuerz;
        for (int i = 0; i < copy.size(); i++) {
            kuerz = i;
            for (int k = i + 1; k < copy.size(); k++) {

                if (copy.get(k).a.compareTo(copy.get(kuerz).a) < 0) {
                    kuerz = k;
                }
            }
            if (kuerz != i) {
                Speicher tmp = new Speicher(copy.get(i).a, copy.get(i).b);
                copy.get(i).a = copy.get(kuerz).a;
                copy.get(kuerz).a = tmp.a;
            }
        }
        for (int i = 0; i < speicher.size(); i++) {
            for (int k = 0; k < speicher.size(); k++) {
                if (speicher.get(i).a.equals(copy.get(k).a)) {
                    speicher.get(i).b = copy.get(k).b;
                    copy.get(k).a = "";
                    break;
                }
            }
        }
        for(int i = 0; i < losungswort.length(); i++) {
            perm[i] = speicher.get(i).b;
        }
    }

    @Override
    public String kodiere(String klartext) {

        StringBuilder geheim = new StringBuilder();

        for(int i = 0; i < klartext.length(); i++) {
            for(int j = 0; j<losungswort.length(); j++) {
                if(i == perm[j]) {
                    for(int k = 0; k<klartext.length(); k+=losungswort.length()) {
                        if(k+j >= klartext.length()) {
                            break;
                        } else {
                            geheim.append(klartext.charAt(k+j));
                        }
                    }
                }
            }
        }

        return String.valueOf(geheim);
    }

    @Override
    public String dekodiere(String geheimtext) {



        return null;
    }

    @Override
    public String gibLosung() {

        return this.losungswort;
    }

    @Override
    public void setzeLosung(String schluessel) throws IllegalArgumentException {
        if(schluessel.equals("")) {
            throw new IllegalArgumentException("Muss Text enthalten!");
        }
        this.losungswort = schluessel;
        this.setzeOrdnung();
    }
}

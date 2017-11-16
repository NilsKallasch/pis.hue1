/**
 * Created by Ivan on 10.11.2017.
 */
public interface Codec {

    String kodiere(String klartext);
    String dekodiere(String geheimtext);
    String gibLosung();
    void setzeLosung(String schluessel)throws IllegalArgumentException;

}

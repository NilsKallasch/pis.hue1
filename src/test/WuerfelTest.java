package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

/*
Instruktionen:

1.	Der folgende Testfall muss von ihrem Programm bestanden werden. Sie dürfen den Testfall nicht abändern/anpassen.
	Sie muessen das JUnit Framework ggf. in ihr Projekt einbinden.
2.	Achtung! Dieser Test ist nicht vollstaendig und dient lediglich als Anhaltspunkt einer korrekten Abgabe. 
	In erster Linie stellt der Test eine korrekte Abgabestruktur sicher.
3.	Alle Plagiate werden abgelehnt und die Autoren können somit nicht an der PIS Klausur im WS 17/18 Teilnehmen. 

Viel Spaß und Erfolg beim Programmieren ;)
*/

public class WuerfelTest {

    Codec codec_1 = new Wuerfel("THM");
    Codec codec_2 = new Wuerfel("Mittelhessen");
    //Codec codec_3 = new Caesar();

    @Test
    public void testKodiereWuerfel() {
        Assert.assertEquals("rza  me rhoeTiu r yn1471?a gikptvwrsna edcBe,2580Fnjtmoltealt xqruhar 369!",
                codec_1.kodiere("Franz jagt im komplett verwahrlosten Taxi quer durch Bayern, 12345678910!?"));
        Assert.assertEquals(" ridtr ntelao7r5a3eypBohziaaF !m kcmurT?n0t9e1s8l6r1v,trh4w2e au  nx  gejq",
                codec_2.kodiere("rza  me rhoeTiu r yn1471?a gikptvwrsna edcBe,2580Fnjtmoltealt xqruhar 369!"));

        codec_1.setzeLosung("Schwarzwald");
        codec_2.setzeLosung("Schwenningen");

        Assert.assertEquals("rneregnfirsrtdeulnsptnveoedtmeeregteaefntnfuei",
                codec_1.kodiere("eintreffendersendungverspaetetneuerterminfolgt"));
        Assert.assertEquals("ndeeelmtsvtrngieedffprugnennsefiteereertoarutn",
                codec_2.kodiere("rneregnfirsrtdeulnsptnveoedtmeeregteaefntnfuei"));
    }

    @Test
    public void testDekodiereWuerfel() {
        codec_1.setzeLosung("Schwarzwald");
        codec_2.setzeLosung("Schwenningen");

        Assert.assertEquals("eintreffendersendungverspaetetneuerterminfolgt",
                codec_1.dekodiere("rneregnfirsrtdeulnsptnveoedtmeeregteaefntnfuei"));
        Assert.assertEquals("rneregnfirsrtdeulnsptnveoedtmeeregteaefntnfuei",
                codec_2.dekodiere("ndeeelmtsvtrngieedffprugnennsefiteereertoarutn"));

        codec_1.setzeLosung("THM");
        codec_2.setzeLosung("Mittelhessen");

        Assert.assertEquals("Franz jagt im komplett verwahrlosten Taxi quer durch Bayern, 12345678910!?",
                codec_1.dekodiere("rza  me rhoeTiu r yn1471?a gikptvwrsna edcBe,2580Fnjtmoltealt xqruhar 369!"));
        Assert.assertEquals("rza  me rhoeTiu r yn1471?a gikptvwrsna edcBe,2580Fnjtmoltealt xqruhar 369!",
                codec_2.dekodiere(" ridtr ntelao7r5a3eypBohziaaF !m kcmurT?n0t9e1s8l6r1v,trh4w2e au  nx  gejq"));
    }

    @Test
    public void testGibLosungWuerfel() {
        Assert.assertEquals("THM", codec_1.gibLosung());
        Assert.assertEquals("Mittelhessen", codec_2.gibLosung());
        codec_1.setzeLosung("Schwarzwald");
        codec_2.setzeLosung("Schwenningen");
        Assert.assertEquals("Schwarzwald", codec_1.gibLosung());
        Assert.assertEquals("Schwenningen", codec_2.gibLosung());
    }
/*
    @Test
    public void testKodiereCaesar() {
        codec_3.setzeLosung("Schwarzwald");
        assertEquals("ptyecpqqpyopcdpyofyrgpcdalpepeypfpcepcxtyqzwre",
                codec_3.kodiere("eintreffendersendungverspaetetneuerterminfolgt"));
    }

    @Test
    public void testDekodiereCaesar() {
        codec_3.setzeLosung("Mittelhessen");
        assertEquals("Franz jagt im komplett verwahrlosten Taxi quer durch Bayern, 12345678910!?",
                codec_3.dekodiere("Rdmzl vmsf uy waybxqff hqdimtdxaefqz Fmju cgqd pgdot Nmkqdz, 12345678910!?"));
    }

    @Test
    public void testGibLosungCaesar() {
        codec_3.setzeLosung("Mittelhessen");
        assertEquals("Mittelhessen", codec_3.gibLosung());
        codec_3.setzeLosung("Schwarzwald");
        assertEquals("Schwarzwald", codec_3.gibLosung());

    }*/
}
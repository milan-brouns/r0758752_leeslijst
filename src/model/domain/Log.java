package model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Log {
    private final String datum,tijdstip;
    private String  activiteit;
    public Log(String activiteit){

        LocalDateTime logtime = LocalDateTime.now();
        this.datum= logtime.format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
        this.tijdstip=logtime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        setActiviteit(activiteit);
    }

    private void setActiviteit(String activiteit) {
        if (activiteit== null||activiteit.trim().isEmpty())
            throw new IllegalArgumentException("Dit is geen geldige activiteit.");
        this.activiteit = activiteit;
    }


    public String getActiviteit() {
        return activiteit;
    }
    public String getDatum() {
        return datum;
    }
    public String getTijdstip() {
        return tijdstip;
    }
}

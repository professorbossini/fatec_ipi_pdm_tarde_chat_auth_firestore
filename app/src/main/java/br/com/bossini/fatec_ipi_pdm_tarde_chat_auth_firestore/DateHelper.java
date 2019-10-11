package br.com.bossini.fatec_ipi_pdm_tarde_chat_auth_firestore;

import java.text.SimpleDateFormat;
import java.util.Date;

class DateHelper {

    private static SimpleDateFormat sdf =
            new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public static String format (Date date) {
        return sdf.format(date);
    }
}

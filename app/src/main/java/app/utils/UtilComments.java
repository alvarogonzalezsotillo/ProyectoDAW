package app.utils;

import app.beans.MelomBean;

public class UtilComments {

    private static Long idMelomToComment;

    private static MelomBean melom;

    public static Long getIdMelom() {

        return idMelomToComment;
    }

    public static void setIdMelom(Long idMelom) {

        idMelomToComment = idMelom;

    }

    public static MelomBean getMelom() {
        return melom;
    }

    public static void setMelom(MelomBean melomBean) {
        melom = melomBean;
    }
}

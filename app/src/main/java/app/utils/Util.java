package app.utils;

import org.mockito.internal.creation.instance.InstantationException;
import org.primefaces.model.UploadedFile;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Util {

    private static final String salt = "S%J(G</DAW";

    private Util() throws InstantiationError {

        throw new InstantationException("Clase estática no instanciable", null);

    }

    public static String getSalt() {

        return salt;

    }

    public static String hashPasswordSHA(String passwordToHash) {

        String generatedPassword = null;

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            byte[] bytes = md.digest(passwordToHash.getBytes());

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < bytes.length; i++) {

                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            generatedPassword = sb.toString();
        }

        catch (NoSuchAlgorithmException e) {

            throw new RuntimeException("Problema en hashPassword" + e);
        }

        return generatedPassword;
    }

    public static byte[] transformFile(UploadedFile file){

        return file.getContents();

    }

}

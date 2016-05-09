package app.utils;

import org.primefaces.model.UploadedFile;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UtilPasswords {
    private static final String SALT = "S%J(G</DAW";

    public static String getSalt() {

        return SALT;

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

}

package app.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.mockito.internal.creation.instance.InstantationException;

public final class Util {

    private Util() throws InstantiationError {

        throw new InstantationException("Clase estática no instanciable", null);

    }

    public static String saltGenerator() {

        char[] arrayLetras = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLOMNOPQRSTUVWXYZ$%&()".toCharArray();

        StringBuilder temporalString = new StringBuilder();

        Random random = new Random();

        for (int i = 0; i < 20; i++) {

            char c = arrayLetras[random.nextInt(arrayLetras.length)];

            temporalString.append(c);

        }

        String salt = temporalString.toString();

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

}

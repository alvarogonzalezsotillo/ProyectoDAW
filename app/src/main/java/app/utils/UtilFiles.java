package app.utils;

import org.primefaces.model.UploadedFile;
import org.primefaces.util.Base64;

import java.io.*;
import java.util.Random;

public class UtilFiles {

//    private final static String PATH = "/Users/guillermo/apache-tomcat-8.0.33/webapps/ROOT/resources/files";
    private final static String PATH = "C:\\xampp\\tomcat\\webapps\\ROOT";
    private final static String FILE_ROUTE = "/resources/files/";
    public static final String PERFIL_DEFAULT_PNG = "perfilDefault.png";

    public static byte[] transformFile(UploadedFile file) {

        return file.getContents();

    }

    public static String transformFileToBase64(byte[] file) {

        return Base64.encodeToString(file, false);

    }

    public static String getPath() {

        return PATH;

    }

    public static String getFileRoute(File file) {

        return FILE_ROUTE + file.getName();
    }

    public static String getRandomName() {

        char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        StringBuilder randomName = new StringBuilder();

        Random random = new Random();

        for (int i = 0; i < 32; i++) {

            char c = chars[random.nextInt(chars.length)];

            randomName.append(c);
        }

        return randomName.toString();
    }

    public static String getTypeFile(UploadedFile uploadedFile) {

        String typeFile = "";

        if (uploadedFile != null) {

            String originalName = uploadedFile.getFileName();

            int index = originalName.indexOf(".");

            typeFile = originalName.substring(index);

        }

        return typeFile;

    }

    public static String upload(UploadedFile uploadedFile) throws IOException {

        String randomNameFile = UtilFiles.getRandomName();

        String typeFile = UtilFiles.getTypeFile(uploadedFile);

        String newName = randomNameFile + typeFile;

        byte[] contents = uploadedFile.getContents();

        InputStream dataFile = uploadedFile.getInputstream();

        File file = new File(UtilFiles.getPath(), newName);

        return saveFile(file, dataFile, contents);

    }

    public static String getDefaultAlbumRoute() {

        Random rand = new Random();

        int randomNum = rand.nextInt((2 - 1) + 1) + 1;

        return FILE_ROUTE + "albumDefault" + randomNum + ".png";
    }

    public static String getDefaultUserRoute() {

        return FILE_ROUTE + PERFIL_DEFAULT_PNG;

    }

    private static String saveFile(File file, InputStream dataFile, byte[] contents) throws IOException {

        OutputStream streamOut = new FileOutputStream(file);

        int read = 0;
        byte[] bytes = new byte[contents.length];
        while ((read = dataFile.read(bytes)) != -1) {
            streamOut.write(bytes, 0, read);
        }
        streamOut.flush();

        return UtilFiles.getFileRoute(file);
    }
}

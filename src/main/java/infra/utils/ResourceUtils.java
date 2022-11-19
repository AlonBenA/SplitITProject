package infra.utils;


import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ResourceUtils {

    private ResourceUtils() {
        // static class
    }

    public static String getResourceAsString(String resourceName) throws IOException {
        final ClassLoader cl = new ResourceUtils().getClass().getClassLoader();
        final InputStream is = cl.getResourceAsStream(resourceName);
        if (null == is) {
            throw new IOException("Failed to find resource with name " + resourceName);
        }
        try (Scanner s = new Scanner(is, "utf-8")) {
            s.useDelimiter("\\A");
            return s.hasNext() ? s.next() : "";
        }

    }
}

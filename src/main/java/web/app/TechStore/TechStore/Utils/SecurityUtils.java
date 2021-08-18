package web.app.TechStore.TechStore.Utils;

import lombok.SneakyThrows;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.Random;

public class SecurityUtils {

    public static final int SALT_SIZE = 16;

    @SneakyThrows
    public static String getHashedValue(String target, byte[] salt){
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update(salt);
        byte[] bytes = digest.digest(target.getBytes());
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static String generateRandomString(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(SALT_SIZE)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}

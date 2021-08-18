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
}

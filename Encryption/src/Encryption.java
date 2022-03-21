import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Base64;

public class Encryption {
    private static String SECRET_KEY = "123key";
    private static String SALT = "456";

    //return en encrypted string
    public static String encrypt(String inputString){

        try{
            //this object is going to generate a new secret key, the string in the end is the algorithm that should be used
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            //then define the specs of the key, string we want to encrypt, salt, iterations of algorithm and key length in bytes
            KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(),SALT.getBytes(),65536,256);
            SecretKey tmp = factory.generateSecret(spec);
            //build the new key with the specified algorithm
            SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

            //now we encrypt this key
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE,secretKey);

            //here we take the input string, use cipher.doFinal on it to encrypt it with our generated key and then
            //turn it from a buffered byte string into a nrmal string with the help of Mase64
            return Base64.getEncoder().encodeToString(cipher.doFinal(inputString.getBytes(StandardCharsets.UTF_8)));

        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static String decryptText(String cipheredString){
        try{
            //set up the same secret Key as in the encryption
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(),SALT.getBytes(),65536,256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

            //now we need to call the decrypt mode of the cipher object
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE,secretKey);
            //now we call doFinal and decode it with help of Base64
            return new String(cipher.doFinal(Base64.getDecoder().decode(cipheredString)));

        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

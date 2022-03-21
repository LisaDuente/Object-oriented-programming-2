public class Main {

    public static void main(String[] args) {
        System.out.println("original string: 123key");
        String encryptedString = Encryption.encrypt("123key");
        System.out.println("encrypted: "+encryptedString);
        String decrypted = Encryption.decryptText(encryptedString);
        System.out.println(decrypted);
    }
}

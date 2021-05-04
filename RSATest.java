package sec;
import java.security.*;

import javax.crypto.Cipher;
import javax.crypto.BadPaddingException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
public class RSATest {
    public static void main ( String[] args ) throws Exception{
        //Creating KeyPair generator object
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(2048);

        //GEN PAIR KEY
        KeyPair pair = keyPairGen.generateKeyPair();
        // PUBLIC KEY
        PublicKey publicKey = pair.getPublic();

        //Creating a Cipher object
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        File file = new File("D:\\Lab 3\\src\\abc.txt");
        try {
            byte[] fileContent = Files.readAllBytes(file.toPath());
            cipher.update(fileContent);
            System.out.println (new String(cipher.doFinal()) );
            byte[] cipherText = cipher.doFinal();
//            System.out.println( new String(cipherText, "UTF8"));
//
            Files.write(Paths.get("D:\\Lab 3\\src\\abc.encode.txt"),cipherText , StandardOpenOption.CREATE, StandardOpenOption.APPEND);
//
//            cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());
//            byte[] decipheredText = cipher.doFinal(cipherText);
//            Files.write(Paths.get("D:\\Lab 3\\src\\tempDecode.jpg"),decipheredText , StandardOpenOption.CREATE, StandardOpenOption.APPEND);
//            System.out.println(new String(decipheredText));
        }catch (IOException e){

        }

    }
}

package com.yantra;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;

public class TextDecryptor {

    public static void main(String[] args) throws IOException {

        TextDecryptor cls = new TextDecryptor();
        System.out.println("Value : " + cls.decryptor("DLyQkrHPRIq6V8NHklTkNAchlf32gHsWbYZv1r7i924="));
    }

    public String decryptor(String iban) throws IOException {
        Properties prop = new Properties();
        InputStream input = null;
        input = TextDecryptor.class.getClassLoader().getResourceAsStream("application.properties");
        prop.load(input);

        final PooledPBEStringEncryptor stringEncryptor = new PooledPBEStringEncryptor();
        stringEncryptor.setAlgorithm("PBEWithMD5AndDES");
        stringEncryptor.setPoolSize(4);
        stringEncryptor.setPassword(prop.getProperty("jaspyt.encryptor.password"));
        stringEncryptor.initialize();
        String ibanDecrypted = stringEncryptor.decrypt(iban);
        return ibanDecrypted;
    }
}

package ru.solicom.zavod.util;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;

@Service
public class PasswordHelper implements PasswordEncoder {
    private MessageDigest md;

    @Override
    public String encode(CharSequence charSequence) {
        if (md == null) {
            return charSequence.toString();
        }
        md.update(charSequence.toString().getBytes());
        byte byteData[] = md.digest();
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            String hex = Integer.toHexString(0xff & byteData[i]);
            if(hex.length()==1){
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return charSequence.equals(s);
    }
}

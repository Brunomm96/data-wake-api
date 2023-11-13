package br.com.datawake.datawakeapi.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeradorSenha {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("123")); // $2a$10$UGa5JnFXlpgFbfNGtb7xpuIy7g6QIjY5bPD8jD/HtdMRsYdlEgpAC
        System.out.println(encoder.encode("@ngul@r0")); // $2a$10$wuEM0DmTXiRSOjwQUSQxweb3wp/lU/ABflMbWXNLkHZ.Zm7pPmR9.

//		MessageDigest md = null;
//		try {
//			md = MessageDigest.getInstance("MD5");
//		} catch (NoSuchAlgorithmException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		md.update("kjansdfiadni3n32nriwnrjasnflna23pn23inrwonfoasdn".getBytes());
//		byte[] hashMd5 = md.digest();
//		System.out.println( stringHexa( hashMd5 ) );
    }

//	private static String stringHexa(byte[] bytes) {
//	   StringBuilder s = new StringBuilder();
//	   for (int i = 0; i < bytes.length; i++) {
//	       int parteAlta = ((bytes[i] >> 4) & 0xf) << 4;
//	       int parteBaixa = bytes[i] & 0xf;
//	       if (parteAlta == 0) s.append('0');
//	       s.append(Integer.toHexString(parteAlta | parteBaixa));
//	   }
//	   return s.toString();
//	}

}

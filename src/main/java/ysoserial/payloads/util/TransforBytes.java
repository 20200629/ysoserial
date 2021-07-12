package ysoserial.payloads.util;

import java.io.*;

/**
 * created by 0x22cb7139 on 2021/7/9
 */
public class TransforBytes {


    public static String readStringFromInputStream(InputStream inputStream) throws Exception{
        StringBuilder stringBuilder = new StringBuilder("");
        byte[] bytes = new byte[1024];
        int n = 0;
        while ((n=inputStream.read(bytes)) != -1){
            stringBuilder.append(new String(bytes,0,n));
        }
        return stringBuilder.toString();
    }

    public static String readFile(String path) {
        try {
            File file = new File(path);
            if (file.exists()) {
                FileReader reader = new FileReader(file);
                BufferedReader br = new BufferedReader(reader);
                StringBuffer sb = new StringBuffer("");
                String line = "";
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                    sb.append("\r\n");
                }
                return sb.toString();
            } else {
                System.err.println(String.format("[-] %s is not exists!", path));
                System.exit(0);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void CreateFileFromBytes(byte[] expbyte,String targetname) throws IOException {
        FileOutputStream fos=new FileOutputStream(targetname);
        fos.write(expbyte);
        fos.close();
    }
    public static byte[] BytesFromFile(String path) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream(1024);
        FileInputStream fis = new FileInputStream(path);
        byte[] b= new byte[1024];
        int n;
        while ((n = fis.read(b)) != -1) {
            bos.write(b, 0, n);
        }
        fis.close();
        byte[] data = bos.toByteArray();
        bos.close();
        return data;
    }
}

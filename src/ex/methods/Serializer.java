package ex.methods;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

import com.thoughtworks.xstream.XStream;
import ex.obj.subscriptions.VkSource;

public class Serializer {

    private XStream xstream;

    public Serializer() {
        this.xstream = new XStream();
    }

    public VkSource deserialize(String fromXml) {
        try {
            return (VkSource) xstream.fromXML(fromXml);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String serialize(VkSource vkSource) {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            Writer writer = new OutputStreamWriter(outputStream, Charset.forName("UTF-8"));
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            xstream.toXML(vkSource, writer);
            return outputStream.toString("UTF-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

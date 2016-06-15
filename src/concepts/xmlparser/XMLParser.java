package concepts.xmlparser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Arrays;


/**
 * Created by parya on 6/14/2016.
 */
public class XMLParser {

    private static XMLParser xmlParser = null;

    public static XMLParser getInstance() {
        if (xmlParser == null) {
            xmlParser = new XMLParser();
        }
        return xmlParser;
    }

    private XMLParser() {

    }

    public Object unmarshal(Class<?> className, InputStream inputStream) throws JAXBException {
        JAXBContext jaxbContext;
        jaxbContext = JAXBContext.newInstance(className);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return jaxbUnmarshaller.unmarshal(inputStream);
    }

    public StringWriter marshal(Class<?> className, Object object) throws JAXBException {
        StringWriter stringWriter = new StringWriter();
        JAXBContext jaxbContext = JAXBContext.newInstance(className);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.marshal(object, stringWriter);
        return stringWriter;
    }

    public static void main(String[] args) {
        XMLParser xmlParser = XMLParser.getInstance();

        ResponseDto responseDto = new ResponseDto();
        responseDto.setErrorMessage(Arrays.asList("Oops                    something went wrong"));
        responseDto.setValidResponse(false);
        Data data = new Data();
        data.setType("type");
        data.getDatum().add("this is datum                    string");
        responseDto.setResponseList(data);

        try {
            StringWriter stringWriter = xmlParser.marshal(ResponseDto.class, responseDto);
            System.out.println(stringWriter);
            InputStream inputStream = new ByteArrayInputStream(stringWriter.getBuffer().toString().getBytes());
            ResponseDto response = (ResponseDto) xmlParser.unmarshal(ResponseDto.class, inputStream);
            System.out.println("After unmarshalling");
            System.out.println(response);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}

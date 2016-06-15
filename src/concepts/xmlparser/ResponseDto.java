package concepts.xmlparser;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "ResponseDto")

public class ResponseDto {

    @XmlElement(name = "IsValidResponse")
    boolean isValidResponse;

    @XmlElement(name = "ErrorMessage")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    List<String> errorMessage;

    @XmlElement(name = "ResponseList")
    Data responseList;

    public boolean isValidResponse() {
        return isValidResponse;
    }

    public void setValidResponse(boolean isValidResponse) {
        this.isValidResponse = isValidResponse;
    }

    public List<String> getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(List<String> errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Data getResponseList() {
        return responseList;
    }

    public void setResponseList(Data responseList) {
        this.responseList = responseList;
    }

    @Override
    public String toString() {
        return errorMessage + "-" + responseList.getDatum();
    }
}
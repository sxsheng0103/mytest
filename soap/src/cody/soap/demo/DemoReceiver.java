package cody.soap.demo;  
  
import java.util.Iterator;  
  
import javax.servlet.ServletConfig;  
import javax.servlet.ServletException;  
import javax.xml.messaging.JAXMServlet;   
import javax.xml.messaging.ReqRespListener;  
import javax.xml.soap.MessageFactory;  
import javax.xml.soap.SOAPBody;  
import javax.xml.soap.SOAPElement;  
import javax.xml.soap.SOAPEnvelope;  
import javax.xml.soap.SOAPException;  
import javax.xml.soap.SOAPMessage;  
import javax.xml.soap.SOAPPart;  
  
public class DemoReceiver extends JAXMServlet implements ReqRespListener{  
  
    /** 
     * Generated automatically 
     */  
    private static final long serialVersionUID = 1L;  
    private static MessageFactory messageFactory = null;  
    @Override  
    public void init(ServletConfig servletConfig) throws ServletException {  
        super.init(servletConfig);  
        try {  
            messageFactory = MessageFactory.newInstance();  
        } catch (SOAPException e) {  
            e.printStackTrace();  
        }  
    }  
  /**
    out.msg
    Xml代码  收藏代码
    ------=_Part_0_1985246804.1403343570084  
    Content-Type: text/xml; charset=utf-8  
      
    <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">  
    <SOAP-ENV:Header/>  
    <SOAP-ENV:Body>  
    <laptops:numberAvailable xmlns:laptops="http://ecodl.taobao.com/">216</laptops:numberAvailable>  
    </SOAP-ENV:Body>  
    </SOAP-ENV:Envelope>  
    ------=_Part_0_1985246804.1403343570084  
    Content-Type: text/html  
      
    <?xml version="1.0" encoding="UTF-8" ?>  
    <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">  
    <HTML>  
        <HEAD>  
            <TITLE>SOAP and Java</TITLE>  
        </HEAD>  
      
        <BODY>  
            <H1>SOAP and Java</H1>  
               Click <A HREF="DemoSend">here</a> to send the SOAP message.  
        </BODY>  
    </HTML>  
    ------=_Part_0_1985246804.1403343570084--  
    in.msg
    Xml代码  收藏代码
    <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">  
    <SOAP-ENV:Header/>  
    <SOAP-ENV:Body>  
    <Response>Got the SOAP message indicating there are 216 laptops available.  
    </Response>  
    </SOAP-ENV:Body>  
    </SOAP-ENV:Envelope>  
    **/
    @Override  
    public SOAPMessage onMessage(SOAPMessage msg) {  
        SOAPPart soappart = msg.getSOAPPart();  
        try {  
            SOAPEnvelope incomingEnvelope;        
            incomingEnvelope = soappart.getEnvelope();        
            SOAPBody body = incomingEnvelope.getBody();  
      
            Iterator<?> iterator = body.getChildElements(incomingEnvelope.createName("numberAvailable", "laptops", "http://ecodl.taobao.com/"));  
      
            SOAPElement element;  
            element = (SOAPElement) iterator.next();  
      
            SOAPMessage message = messageFactory.createMessage();  
            SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();  
      
            SOAPBody responsebody = envelope.getBody();  
            String responseText = "Got the SOAP message indicating there are " + element.getValue() + " laptops available.";  
            responsebody.addChildElement(envelope.createName("Response")).addTextNode(responseText);  
      
            return message;  
        } catch (SOAPException e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  
  
}  
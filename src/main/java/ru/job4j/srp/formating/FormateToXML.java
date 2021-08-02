package ru.job4j.srp.formating;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.StringWriter;

public class FormateToXML implements Formatting{
    String text;

    public FormateToXML(String text) {
        this.text = text;
    }


    @Override
    public String translation() {
        StringWriter sw = new StringWriter();
        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(FormateToXML.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(text, sw);
        } catch (PropertyException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    return  sw.toString();
    }
}

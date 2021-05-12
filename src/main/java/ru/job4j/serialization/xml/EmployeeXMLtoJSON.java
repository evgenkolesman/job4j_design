package ru.job4j.serialization.xml;

import ru.job4j.serialization.json.ContactJSON;
import ru.job4j.serialization.json.EmployeeJSON;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringReader;
import java.io.StringWriter;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeXMLtoJSON {
    public static void main(String[] args) throws Exception {
        EmployeeJSON employee = new EmployeeJSON(false, 25,
                new ContactJSON("8-8442-73-73-73"), new String[]{"Builder", "Slinger", "Free"});

        // Получаем контекст для доступа к АПИ
        JAXBContext context = JAXBContext.newInstance(EmployeeJSON.class);
        // Создаем сериализатор
        Marshaller marshaller = context.createMarshaller();
        // Указываем, что нам нужно форматирование
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml;
        try (StringWriter writer = new StringWriter()) {
            // Сериализуем
            marshaller.marshal(employee, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        // Для десериализации нам нужно создать десериализатор
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            // десериализуем
            EmployeeJSON result = (EmployeeJSON) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}

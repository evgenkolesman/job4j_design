package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

/* JAXB. Преобразование XML в POJO.
 *  Класс EmployeeXML
 * это пример работы с классом для производства сериализации/десериализации и перевода в тип
 * данных из ХМL в pojo c выводом результата в консоль
 * @author Kolesnikov Evgeniy (evgeniysanich@mail.ru)
 * @version 1.0
 */

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeXML {

    @XmlAttribute
    private boolean sex;

    @XmlAttribute
    private int age;
    private ContactXML contact;

    private String[] statuses;

    public EmployeeXML() {
    }

    public EmployeeXML(boolean sex, int age, ContactXML contact, String[] statuses) {
        this.sex = sex;
        this.age = age;
        this.contact = contact;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return String.format("Employee{sex=%s, age=%d, contact=%s, statuses=%s}", sex, age, contact, Arrays.toString(statuses));
    }

    public static void main(String[] args) throws JAXBException {
        final ru.job4j.serialization.xml.EmployeeXML employee = new EmployeeXML(false, 25,
                new ContactXML("8-8442-73-73-73"), new String[]{"Builder", "Slinger", "Free"});

        // Получаем контекст для доступа к АПИ
        JAXBContext context = JAXBContext.newInstance(EmployeeXML.class);
        // Создаем сериализатор
        Marshaller marshaller = context.createMarshaller();
        // Указываем, что нам нужно форматирование
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        String xml = "";

        try (StringWriter writer = new StringWriter()) {
            // Сериализуем
            marshaller.marshal(employee, writer);
            String result = writer.getBuffer().toString();
            xml = result;
            System.out.println(xml);
        } catch (Exception e) {
        }

        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            // десериализуем
            EmployeeXML result1 = (EmployeeXML) unmarshaller.unmarshal(reader);
            System.out.println(result1);
        }
    }
}

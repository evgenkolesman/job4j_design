package ru.job4j.solid.dip.examples.second;

/*
 * Модуль обработки заказов
 *
 */
public class Second {
        public void process(Order order) {

            MySQLOrderRepository repository = new MySQLOrderRepository();
            ConfirmationEmailSender mailSender = new ConfirmationEmailSender();

            if (order.isValid() && repository.save(order)) {
                mailSender.sendConfirmationEmail(order);
            }
        }
    }

    ///////////
// Следует реализовывать так
//  мы избавляемся от зависимостей и привязок к конкретным значениям
/*
interface MailSender {
    void sendConfirmationEmail(Order order);
}

interface OrderRepository {
    boolean save(Order order);
}

public class ConfirmationEmailSender implements MailSender {
    @Override
    public void sendConfirmationEmail(Order order) {
        String name = order.getCustomerName();
        String email = order.getCustomerEmail();
        // Шлем письмо клиенту
    }
}

public class MySQLOrderRepository implements OrderRepository {
    @Override
    public boolean save(Order order) {
        MySqlConnection connection = new MySqlConnection("database.url");
        // сохраняем заказ в базу данных
        return true;
    }
}

public class OrderProcessor {

    private MailSender mailSender;
    private OrderRepository repository;

    public OrderProcessor(MailSender mailSender, OrderRepository repository) {
        this.mailSender = mailSender;
        this.repository = repository;
    }

    public void process(Order order){
        if (order.isValid() && repository.save(order)) {
            mailSender.sendConfirmationEmail(order);
        }
    }
}
 */
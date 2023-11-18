package itmo.project;

import lombok.Data;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


@Data
public class SessionJDBC {

    private final SessionFactory SESSION_FACTORY = new Configuration()
            .configure("hibernate.cfg.xml")
            .buildSessionFactory();


}

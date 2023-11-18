package itmo.project;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import lombok.Data;
import org.hibernate.classic.Session;

import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
@Data
public class Result {
    private SessionJDBC sessionJDBC = new SessionJDBC();
    private List<Row> list = new ArrayList<>();

    public Result() {
        Session session = sessionJDBC.getSESSION_FACTORY().getCurrentSession();
        try {
            for (var i = 1; i < 100; i++) {
                Row row = new Row();
                session.beginTransaction();
                row = (Row) session.get(Row.class, i);
                if (row == null) break;
                list.add(row);
            }
            session.getTransaction().commit();
        } finally {
            sessionJDBC.getSESSION_FACTORY().close();
        }
    }


}

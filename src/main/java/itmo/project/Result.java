package itmo.project;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import jakarta.faces.context.FacesContext;
import lombok.Data;
import org.hibernate.classic.Session;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@ManagedBean
@SessionScoped
@Data
public class Result {
    private SessionJDBC sessionJDBC = new SessionJDBC();
    private List<Row> list = new ArrayList<>();
    private String x;
    private String y;
    private String r;
    private boolean fromBD;

    {
    }

    public Result() {
        Session session = sessionJDBC.getSESSION_FACTORY().getCurrentSession();

        for (var i = 1; i < 100; i++) {
            Row row;
            session.beginTransaction();
            row = (Row) session.get(Row.class, i);
            if (row == null) break;
            list.add(row);
        }
        session.getTransaction().commit();

    }

    public void test() {
        Session session = sessionJDBC.getSESSION_FACTORY().getCurrentSession();

        Map<String, String> parameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String param1 = parameters.get("param1");
        String param2 = parameters.get("param2");
        String param3 = parameters.get("param3");
        String request_time = parameters.get("request_time");

        if (param1 == null || param2 == null || param3 == null || request_time == null) {
            System.out.println("some of parameters are null");
            return;
        }
        Row row = Row.rowCreate(param1, param2, param3);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH.mm.ss.SSS");
        row.setResponseTime(formatter.format(date));
        row.setRequestTime(request_time);
        list.add(row);

        session.beginTransaction();

        session.save(row);

        session.getTransaction().commit();

    }
}





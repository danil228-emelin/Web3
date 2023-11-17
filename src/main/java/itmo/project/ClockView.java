package itmo.project;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import jakarta.faces.view.ViewScoped;

import java.io.Serializable;
import java.time.LocalDateTime;


@ManagedBean
@SessionScoped
public class ClockView implements Serializable {

    private LocalDateTime dateTime;

    public void init() {
        dateTime = LocalDateTime.now();
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}

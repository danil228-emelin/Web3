package itmo.project;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@jakarta.persistence.Table(name = "list")
@Data
@ManagedBean
@SessionScoped
@NoArgsConstructor
@AllArgsConstructor
public class Row {
    @Id
    @Column(name = "id")
    private int id=0;
    @Column(name = "x")

    private String x;
    @Column(name = "y")

    private String y;
    @Column(name = "r")

    private String r;
    @Column(name = "response_time")

    private String responseTime;
    @Column(name = "request_time")

    private String requestTime;



}

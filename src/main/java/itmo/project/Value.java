package itmo.project;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import lombok.Data;

import java.io.Serializable;

@ManagedBean
@SessionScoped
@Data
public class Value implements Serializable {
    private int x=1;
    private int y=2;
    private int r=3;


}


package itmo.project;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;

import java.io.Serializable;

@ManagedBean
@SessionScoped
public class HelloBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name="BORIS";

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

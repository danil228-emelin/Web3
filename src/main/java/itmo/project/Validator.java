package itmo.project;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.UIInput;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.ValidatorException;
@ManagedBean
@SessionScoped
@FacesValidator("Y_validator")
public class Validator implements jakarta.faces.validator.Validator<String> {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, String s) throws ValidatorException {
        try {

            System.out.println(s);
            Double d = Double.parseDouble(s);
            if (d < -3 || d > 5) throw new NumberFormatException();
        } catch (NumberFormatException exception) {
            ((UIInput) uiComponent).setValid(false);
            facesContext.addMessage(uiComponent.getClientId(facesContext),  new FacesMessage("String isn't a double in [-3,5]"));
        }
    }
}

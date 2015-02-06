package view.backing;

import javax.annotation.Generated;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlOutputText;

@ManagedBean(name = "backing_error")
@RequestScoped
@Generated(value = "1error.jsf", comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class Error {
    private HtmlOutputText outputText1;

    public void setOutputText1(HtmlOutputText outputText1) {
        this.outputText1 = outputText1;
    }

    public HtmlOutputText getOutputText1() {
        return outputText1;
    }
}

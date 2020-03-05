package beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.bean.SessionScoped;

@Named(value = "eventPopupController")
@ManagedBean
@SessionScoped
public class EventPopupController implements Serializable{

    private boolean showPopup;
    
    public EventPopupController() {
    }
    
    public void show() {
        showPopup = true;
    }
    
    public void hide() {
        showPopup = false;
    }
    
    public boolean isShowPopup() {
        return showPopup;
    }
    
    public void setShowPopup(boolean showPopup) {
        this.showPopup = showPopup;
    }
}

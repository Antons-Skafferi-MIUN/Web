package beans;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

/**
 *
 * @author mahl1400
 */
@Named(value = "uploadedFileBean")
@ManagedBean
@SessionScoped
public class UploadedFileBean {

    private Part file; 
    
    public UploadedFileBean() {
    }

    public void save() {
        try (InputStream input = file.getInputStream()) {
//            Files.copy(input, new File(uploads, filename).toPath());
        } catch (IOException e) {
            // Show faces message?
        }
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }
    
    

}


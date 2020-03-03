package beans;

import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author shawk
 */
@Named(value = "uploadedFileBean")
@ManagedBean
@SessionScoped
public class UploadedFileBean {

    public UploadedFileBean() {
    }

    private Part file; // +getter+setter

    public void save() {
        try (InputStream input = file.getInputStream()) {
            Files.copy(input, new File(uploads, filename).toPath());
        } catch (IOException e) {
            // Show faces message?
        }
    }

}

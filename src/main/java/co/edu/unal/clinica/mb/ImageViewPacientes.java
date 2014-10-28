package co.edu.unal.clinica.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="imageViewPacientes")
@SessionScoped
public class ImageViewPacientes {
	
	private List<String> images;
    
    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 1; i <= 12; i++) {
            images.add("unal" + i + ".jpg");
        }
    }
 
    public List<String> getImages() {
        return images;
    }

}

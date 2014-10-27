package co.edu.unal.clinica.mb;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class GrowlView {
     
    public static void mensajePacienteRegistrado() {
        FacesContext context = FacesContext.getCurrentInstance();         
        context.addMessage(null, new FacesMessage("Successful",  "Se registro el Paciente Satisfactoriamente: "));
    }
}
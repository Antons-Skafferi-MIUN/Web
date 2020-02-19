/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.enterprise.context.Dependent;

/**
 *
 * @author joaki
 */
@Named(value = "testBean")
@Dependent
public class TestBean {
   private String message = "Hello World!";
	
   public String getBean() {
      return message;
   }
   public void setBean(String message) {
      this.message = message;
   }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Viktor Rosvall
 */
@Named(value = "myBean")
@SessionScoped
public class MyBean implements Serializable {

    private int i;

    /**
     * Creates a new instance of MyBean
     */
    public MyBean() {
        System.out.println("Bean CTOR");
    }

    public int getCount() {
        return ++i;
    }
}

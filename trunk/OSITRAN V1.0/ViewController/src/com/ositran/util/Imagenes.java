package com.ositran.util;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="imagenesMB")
@SessionScoped
public class Imagenes {
	  private List<String> imagenes;	     
	    @PostConstruct
	    public void init() {
	    	imagenes = new ArrayList<String>();
	        for (int i = 1; i <=5; i++) {
	        	imagenes.add("menu" + i + ".jpg");
	        }
	    }
		public List<String> getImagenes() {
			return imagenes;
			
		}

		public void setImagenes(List<String> imagenes) {
			this.imagenes = imagenes;
		}
}

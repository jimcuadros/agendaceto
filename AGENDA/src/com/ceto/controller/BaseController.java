package com.ceto.controller;

import com.ceto.vista.BaseWindow;
import java.util.Arrays;
import javax.swing.SwingUtilities;

/**
 * Copyright (c) 2017, Javier Manzanares - México.
 * @author jimcu
 * 
 */
public class BaseController{
  
  private BaseWindow window;
  
  public BaseController(){
    SwingUtilities.invokeLater(() -> {
      window = null;
      try {
        window = new BaseWindow();
        window.setVisible(true);
      } catch (Exception exp) {
        System.out.println(Arrays.toString(exp.getStackTrace()));
      }// fin try
    });
  }
   
}//-->

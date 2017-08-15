package com.ceto;

import com.ceto.controller.BaseController;

/**
 * Copyright (c) 2017, Javier Manzanares - México.
 * @author jimcu
 * 
 */
public class Inicio {

  private static final long serialVersionUID = 1L;

  public static void main(String[] args) {
    try {
    BaseController baseController = new BaseController();
    } catch (Exception ex){
      System.out.println(ex.getLocalizedMessage() + ex.getMessage());
    }// fin try
  }
  
}//-->

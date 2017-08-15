package com.ceto.modelo;

import com.mindfusion.common.*;


/**
 * Representa un día festivo.
 *
 */
public class Holiday {
  private DateTime date;
  private DateTime endDate;
  private String title;
  private boolean isDayOff;
  
  /**
   * Inicializa una nueva instancia de la clase {@link Holiday}.
   */
  public Holiday() {
  }

  /**
   * Inicializa una nueva instancia de la clase {@link Holiday} con 
   * la fecha y el título de inicio y fin especificados. 
   * @param start La fecha de inicio de la fiesta. 
   * @param end La fecha de finalización de la fiesta. 
   * @param title El título de la fiesta.
   */
  public Holiday(DateTime start, DateTime end, String title) {
    this.date = start;
    this.endDate = end;
    this.title = title;
  }

  /**
   * Inicializa una nueva instancia de la clase {@link Holiday} con 
   * la fecha y el título de inicio y fin especificados.
   * @param start La fecha de inicio de la fiesta. 
   * @param end La fecha de finalización de la fiesta. 
   * @param title El título de la fiesta.
   * @param isDayOff Un valor que indica si el día festivo es un día de descanso.
   */
  public Holiday(DateTime start, DateTime end, String title, boolean isDayOff){
      this.date = start;
      this.endDate = end;
      this.title = title;
      this.isDayOff = isDayOff;
  }

  /**
   * Obtiene la fecha de inicio del día festivo.
   */
  public DateTime getDate() {
      return date;
  }

  /**
   * Sets the start date of the holiday.
   */
  public void setDate(DateTime value) {
      date = value;
  }

  /**
   * Gets the end date of the holiday.
   */
  public DateTime getEndDate() {
      return endDate;
  }

  /**
   * Sets the end date of the holiday.
   */
  public void setEndDate(DateTime value) {
      endDate = value;
  }

  /**
   * Gets the title of the holiday.
   */
  public String getTitle() {
      return title;
  }

  /**
   * Sets the title of the holiday.
   */
  public void setTitle(String value) {
      title = value;
  }

  /**
   * Gets a value indicating whether the holiday is a rest day.
   */
  public boolean getIsDayOff() {
    return isDayOff;
  }

  /**
   * Sets a value indicating whether the holiday is a rest day.
   */
  public void setIsDayOff(boolean value) {
    isDayOff = value;
  }

}//-->

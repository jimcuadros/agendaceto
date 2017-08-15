package com.ceto.controller;

import org.w3c.dom.*;

import com.mindfusion.common.*;
import com.mindfusion.scheduling.model.*;


/**
 * Este es nuestro evento personalizado.
 * Tiene un solo campo personalizado. *
 */
public class MyEvent extends Appointment {
  private String _customField;
  
  /**
   * Se requieren eventos personalizados para proporcionar un constructor sin parámetros.
   */
  public MyEvent() {
    // Establezca el campo personalizado para el momento en que se creó el evento
    _customField = DateTime.now().toString("HH:mm a");
  }


	/**
	 * Un reemplazo SaveTo que proporciona serialización personalizada 
     * a documentos XML para nuestro evento.
	 */
	@Override()
	public void saveTo(Element element, XmlSerializationContext context) {
      context.writeString(_customField, "customField", element);
      super.saveTo(element, context);
	}

	/**
	 * A LoadFrom override that provides custom deserialization
	 * from XML document for our event.
	 */
	@Override()
	public void loadFrom(Element element, XmlSerializationContext context) {
      _customField = context.readString("customField", element);
      super.loadFrom(element, context);
	}

	/**
	 * A Clone override that enables interactive item cloning.
	 */
	public Object Clone() {
      MyEvent clone = new MyEvent();

      // The following code replicates the code used in
      // the Appointment's Clone method
      clone.setAllDayEvent(this.getAllDayEvent());
      clone.setDescriptionText(this.getDescriptionText());
      clone.setEndTime(this.getEndTime());
      clone.setHeaderText(this.getHeaderText());
      clone.setLocation(this.getLocation());
      clone.setLocked(this.getLocked());
      clone.setPriority(this.getPriority());
      clone.setReminder(this.getReminder());
      // TODO: implement
      //clone.setSelectedStyle(new Style(this.getSelectedStyle(), this.getSelectedStyle().));
      clone.setStartTime(this.getStartTime());
      clone.setStyle(this.getStyle().cloneShallow());
      clone.setTag(this.getTag());
      clone.setTask(this.getTask());
      clone.setVisible(this.getVisible());

      for (Resource resource : this.getResources()) {
        clone.getResources().add(resource);
      }// fin for

      for (Contact contact : this.getContacts()) {
        clone.getContacts().add(contact);
      }// fin for

      // Now copy the custom fields
      clone.setCustomField(this.getCustomField());

      return clone;
	}


	/**
	 * Gets the custom field.
	 */
	public String getCustomField() {
		return _customField;
	}
	
	/**
	 * Sets the custom field.
	 */
	public void setCustomField(String value) {
		_customField = value;

		// Mark this event as an exception if it is a recurrence instance
		if (getRecurrence() != null)
			getRecurrence().markException(this, false);
	}

}//-->
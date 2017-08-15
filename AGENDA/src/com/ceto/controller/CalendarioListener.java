package com.ceto.controller;

import com.mindfusion.common.DateTime;
import com.mindfusion.common.Rectangle;
import com.mindfusion.common.RectangleD;
import com.mindfusion.drawing.Align;
import com.mindfusion.drawing.Brush;
import com.mindfusion.drawing.Color;
import com.mindfusion.drawing.Colors;
import com.mindfusion.drawing.Pen;
import com.mindfusion.drawing.PenAlignment;
import com.mindfusion.drawing.SolidBrush;
import com.mindfusion.drawing.TextFormat;
import com.mindfusion.scheduling.CalendarAdapter;
import com.mindfusion.scheduling.CustomDrawElements;
import com.mindfusion.scheduling.DateChangedEvent;
import com.mindfusion.scheduling.DrawEvent;
import com.mindfusion.scheduling.TooltipEvent;
import com.mindfusion.scheduling.awt.AwtCalendar;

/**
 *
 * @author jimcu
 */
public class CalendarioListener extends CalendarAdapter {
  private Holiday[] holidays;
  private AwtCalendar calendar;
  
  public CalendarioListener(AwtCalendar calendar) {
    this.calendar = calendar;
    // Actualiza los días festivos a mostrar en el objeto calendario
    updateHolidays();
  }
    
  @Override
  public void tooltipDisplaying(TooltipEvent e) {
    StringBuilder tooltip = new StringBuilder();
    if (holidays != null && holidays.length > 0) {
      for (Holiday holiday: holidays) {
        if (DateTime.op_LessThanOrEqual(holiday.getDate(), e.getTime().getDate()) &&
          DateTime.op_LessThanOrEqual(e.getTime().getDate(), holiday.getEndDate())) {
          if (tooltip.length() > 0) {
            tooltip.append("; ");
          }// fin if
          tooltip.append(holiday.getTitle());
        }// fin if
      }// fin for
    }// fin if

    e.setTooltip(tooltip.toString());
  }

  @Override
  public void draw(DrawEvent e) {
    if (e.getElement() == CustomDrawElements.CellHeader) {
      Rectangle bounds = e.getBounds();
      if (DateTime.op_Equality(e.getDate().getDate(), DateTime.today())) {
          Brush brush = new SolidBrush(new Color(100, Colors.White));
          e.getGraphics().fillRectangle(brush, bounds);
          brush.dispose();

          Pen pen = new Pen(Colors.Red, 3);
          pen.setAlignment(PenAlignment.Inset);
          e.getGraphics().drawRectangle(pen, bounds);
          pen.dispose();
      } else {
        if (holidays != null && holidays.length > 0) {
          boolean isHoliday = false;
          for (Holiday holiday: holidays) {
            if (DateTime.op_LessThanOrEqual(holiday.getDate(), e.getDate().getDate()) &&
                DateTime.op_LessThanOrEqual(e.getDate().getDate(), holiday.getEndDate())) {
              isHoliday = true;
              break;
            }// fin if
          }// fin for

          if (isHoliday) {
            Brush brush = new SolidBrush(new Color(128, Colors.LightSteelBlue));
            e.getGraphics().fillRectangle(brush, bounds);
            brush.dispose();

            Pen pen = new Pen(new Color(192, Colors.SlateGray));
            Rectangle borderBounds = new Rectangle(
                bounds.getX(), bounds.getY(), bounds.getWidth() - 1, bounds.getHeight() - 1);
            e.getGraphics().drawRectangle(pen, borderBounds);
            pen.dispose();

            TextFormat format = new TextFormat();
            format.setHorizontalAlign(Align.Center);
            format.setVerticalAlign(Align.Center);

            Brush brush2 = new SolidBrush(new Color(192, 0, 0));
            e.getGraphics().drawString(e.getText(), e.getStyle().getHeaderFont(), brush2,
                new RectangleD(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight()), format);
            brush2.dispose();
          }// fin if
        }// fin if
      }// fin if
    }// fin if
  }

  @Override
  public void visibleDateChanged(DateChangedEvent e) {
    updateHolidays();
  }
  
  private void updateHolidays() {
    DateTime date = calendar.getDate();
    holidays = new USHolidayProvider().getHolidays(
    new DateTime(date.getYear(), date.getMonth(), 1),
    new DateTime(date.getYear(), date.getMonth(), DateTime.daysInMonth(date.getYear(), date.getMonth())));
  }
  
}//-->

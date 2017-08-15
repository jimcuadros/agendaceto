package com.ceto.controller;

import com.ceto.vista.NewJDialog;
import com.mindfusion.common.DateTime;
import com.mindfusion.common.Duration;
import com.mindfusion.common.MouseButtons;
import com.mindfusion.common.PointD;
import com.mindfusion.common.Rectangle;
import com.mindfusion.common.SizeD;
import com.mindfusion.drawing.Brushes;
import com.mindfusion.drawing.Font;
import com.mindfusion.drawing.FontStyles;
import com.mindfusion.drawing.Pens;
import com.mindfusion.scheduling.CalendarAdapter;
import com.mindfusion.scheduling.CustomDrawElements;
import com.mindfusion.scheduling.DateStyle;
import com.mindfusion.scheduling.DrawEvent;
import com.mindfusion.scheduling.ItemMouseEvent;
import com.mindfusion.scheduling.ResourceDateEvent;
import com.mindfusion.scheduling.awt.AwtCalendar;
import com.mindfusion.scheduling.model.ItemEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

/**
 *
 * @author jimcu
 */
public class HorarioListener extends CalendarAdapter {

    private AwtCalendar calendar;
    private AwtCalendar _schedule;
    private JPopupMenu contextMenu;
    private JFrame baseWindow;
    private DateTime _clickedDate;

    private AgendarController agendaC;
    private NewJDialog ndialog;
    private JButton jButton1;

    /**
     * Constructor de la clase
     *
     * @param calendar
     * @param _schedule
     * @param contextMenu
     * @param baseWindow
     * @param _clickedDate
     */
    public HorarioListener(AwtCalendar calendar, AwtCalendar _schedule, JPopupMenu contextMenu, JFrame baseWindow, DateTime _clickedDate) {
        this.calendar = calendar;
        this._schedule = _schedule;
        this.contextMenu = contextMenu;
        this.baseWindow = baseWindow;
        this._clickedDate = _clickedDate;
    }

  public AwtCalendar get_schedule(){

      return _schedule;
  }
    /**
     * ****** Sección de metodos sobreescritos o eventos *****
     */
    /**
     * Evento que sucede cuando se crea un item
     *
     * @param e
     */
    @Override
    public void itemCreated(ItemEvent e) {
        // Check if the item date already has custom style
        for (DateStyle s : calendar.getDayStyles()) {
            if (DateTime.op_Equality(s.getFrom().getDate(), e.getItem().getStartTime().getDate())) {
                return;
            }// fin if
        }// fin for

        // No custom style for this date -> add one
        DateStyle style = new DateStyle();
        style.setFrom(e.getItem().getStartTime().getDate());
        style.setTo(e.getItem().getStartTime().getDate());
        style.getStyle().setHeaderFont(new Font("Tahoma", 8, FontStyles.Bold));
        calendar.getDayStyles().add(style);
        calendar.invalidate();
    }

    @Override
    public void itemDeleted(ItemEvent e) {
        // Check if there are more items on this date.
        // If no - remove the custom style
        DateTime start = e.getItem().getStartTime().getDate();
        DateTime end = e.getItem().getEndTime();
        end = new DateTime(end.getYear(), end.getMonth(), end.getDay(), 23, 59, 59);
        if (_schedule.getSchedule().getAllItems(start, end).size() == 0) {
            for (DateStyle s : calendar.getDayStyles()) {
                if (DateTime.op_Equality(s.getFrom().getDate(), e.getItem().getStartTime().getDate())) {
                    calendar.getDayStyles().remove(s);
                    break;
                }// fin if
            }// fin for
        }// fin if
    }

    @Override
    public void dateClick(ResourceDateEvent e) {
       
        // Mecanismo para agendar una cita con dobleclick
        if (e.getClicks() > 1 && e.getButton() == MouseButtons.Left) {
            agendaC = new AgendarController(_schedule, calendar);
            _schedule.resetDrag();
           
        }// fin if

        
//    if (e.getClicks() == 1 && e.getButton() == MouseButtons.Left) {
//      DateStyle style = new DateStyle();
//      style.setFrom(e.getDate());
//      style.setTo(e.getDate());
//      style.setStyle(new Style());
//      style.getStyle().setBrush(new SolidBrush(Colors.Yellow));
//
//      _schedule.getDayStyles().add(style);
//      _clickedDate = e.getDate();
//      _schedule.repaint();
//    }//fin if
    }

    @Override
    public void draw(DrawEvent e) {
        if (e.getElement() == CustomDrawElements.TimetableItem) {
            MyEvent myEvent = (MyEvent) _schedule.getSchedule().getItems().get(e.getIndex());
            String customField = myEvent.getCustomField();

            Font font = e.getStyle().getFont();
            if (font == null) {
                font = _schedule.getItemSettings().getStyle().getFont();
            }// fin if
            if (font == null) {
                font = _schedule.getTimetableSettings().getStyle().getFont();
            } // fin if
            SizeD size = e.getGraphics().measureString(customField, font);

            if (size.getWidth() > e.getBounds().getWidth() - 4) {
                size = new SizeD(e.getBounds().getWidth() - 4, size.getHeight());
            }// fin if
            if (size.getHeight() > e.getBounds().getHeight() - 4) {
                size = new SizeD(size.getWidth(), e.getBounds().getHeight() - 4);
            } // fin if

            // Dibuja el campo personalizado en la esquina inferior derecha del elemento
            Rectangle bounds = new Rectangle(
                    e.getBounds().getRight() - (int) size.getWidth() - 3,
                    e.getBounds().getBottom() - (int) size.getHeight() - 3,
                    (int) size.getWidth(), (int) size.getHeight());

            e.getGraphics().fillRectangle(Brushes.Yellow, bounds);
            e.getGraphics().drawRectangle(Pens.Black, bounds);
            e.getGraphics().drawString(customField, font, Brushes.Black, new PointD(bounds.getX(), bounds.getY()));
        }// fin if

        if (DateTime.op_Inequality(_clickedDate, DateTime.MinValue)) {
            if (e.getElement() == CustomDrawElements.TimetableCell) {
                DateTime from = DateTime.op_Addition(e.getDate(), e.getStartTime());
                DateTime to = DateTime.op_Addition(e.getDate(), e.getEndTime());

                if (DateTime.op_LessThanOrEqual(from, _clickedDate)
                        && DateTime.op_LessThan(_clickedDate, to)) {
                    Rectangle bounds = new Rectangle(e.getBounds());
                    bounds = bounds.inflate(-1, -1);
                    e.getGraphics().fillRectangle(Brushes.Yellow, bounds);
                }
            }
        }
    }

    @Override
    public void itemClick(ItemMouseEvent e) {
        _schedule.getDayStyles().clear();
        _clickedDate = DateTime.MinValue;
        _schedule.repaint();
        // Mecanismo para activar el evento click sobre un item seleccionado
        if (e.getButton() == MouseButtons.Left && e.getClicks() > 1) {
            _schedule.resetDrag();
            // Mostrar el campo personalizado del evento pulsado
            JOptionPane.showMessageDialog(baseWindow, ((MyEvent) e.getItem()).getCustomField(), "Custom Event", JOptionPane.INFORMATION_MESSAGE);
        } // fin if
    }

}//-->

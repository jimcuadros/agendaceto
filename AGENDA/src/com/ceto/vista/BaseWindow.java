package com.ceto.vista;

import com.ceto.controller.CalendarioListener;
import com.ceto.controller.MyEvent;
import com.mindfusion.common.ChangeListener;
import com.mindfusion.common.DateTime;
import com.mindfusion.common.DayOfWeek;
import com.mindfusion.drawing.Color;
import com.mindfusion.scheduling.CalendarView;
import com.mindfusion.scheduling.CustomDrawElements;
import com.mindfusion.scheduling.DayOfWeekStyle;
import com.mindfusion.scheduling.ThemeType;
import com.mindfusion.scheduling.awt.AwtCalendar;
import com.mindfusion.scheduling.model.Schedule;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.EventObject;
import javax.swing.*;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;
import javax.swing.text.html.HTMLEditorKit;
import com.ceto.controller.HorarioListener;
import com.mindfusion.common.Duration;
import com.mindfusion.scheduling.CalendarListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

/**
 * Copyright (c) 2017, Javier Manzanares - México.
 *
 * @author jimcu
 *
 */
public class BaseWindow extends JFrame {

    private static final long serialVersionUID = 1L;

    private AwtCalendar _schedule;
    private AwtCalendar calendar;
    private DateTime _clickedDate = DateTime.MinValue;

    private CalendarioListener calendarioListener;
    private HorarioListener horarioListener;

    private JFileChooser fileChooser;
    private JPanel content;

    private JTextPane label;
    private JScrollPane labelPane;
    private JPopupMenu contextMenu;
    private JComboBox tiposervicio;
    private JRadioButtonMenuItem elementos[];
    private JLabel etiquetaTiempo;
    String horaactual, horacapturada;

    /**
     * Constructor.
     */
    public BaseWindow() {
        initComponents();
    }

    /**
     * Inicializa los componentes de la interfaz gráfica.
     */
    private void initComponents() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setExtendedState(MAXIMIZED_BOTH);
        setTitle("CETO AGENDA: Administración de citas");

        /* 
    *  Para poder serializar eventos personalizados, tenemos que registrar
    *  sus tipos en la tabla de clases del programa subyacente
         */
        Schedule.registerItemClass(MyEvent.class, "customEvent", 1);

        // PRINCIPIA: CONFIGURACIÓN DEL MENU
        JMenuBar menuBar = new JMenuBar();
        JMenu mFile = new JMenu("File");
        JMenuItem mIFOpen = new JMenuItem("Open");
        JMenuItem mIFSave = new JMenuItem("Save");
        menuBar.add(mFile);
        mFile.add(mIFOpen);
        mFile.add(mIFSave);
        setJMenuBar(menuBar);
        // TERMINA: CONFIGURACIÓN DEL MENU

        fileChooser = new JFileChooser();

        label = new JTextPane();
        label.setBackground(new java.awt.Color(255, 255, 225));
        label.setBorder(new LineBorder(java.awt.Color.BLUE, 1));
        label.setEditable(false);
        label.setEditorKit(new HTMLEditorKit());

        labelPane = new JScrollPane(label);

        content = new JPanel();
        content.setBackground(new java.awt.Color(242, 242, 242));
        content.setLayout(new GridLayout(1, 1));

        tiposervicio = new JComboBox();
        tiposervicio.addItem("Servicio 1");
        tiposervicio.addItem("Servicio 2");
        tiposervicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

            }
        });
        /* 
    *  Configurar el layout básico: un JTEXTPANE en la parte superior y 
    *  un JPANEL en la parte inferior
         */
        Container cp = getContentPane();
        SpringLayout layout = new SpringLayout();
        layout.putConstraint(SpringLayout.WEST, labelPane, 350, SpringLayout.WEST, cp);
        layout.putConstraint(SpringLayout.NORTH, labelPane, 0, SpringLayout.NORTH, cp);
        layout.putConstraint(SpringLayout.EAST, labelPane, 0, SpringLayout.EAST, cp);
        layout.putConstraint(SpringLayout.SOUTH, labelPane, 70, SpringLayout.NORTH, cp);

        layout.putConstraint(SpringLayout.WEST, tiposervicio, 0, SpringLayout.WEST, cp);
        layout.putConstraint(SpringLayout.NORTH, tiposervicio, 0, SpringLayout.NORTH, cp);
        layout.putConstraint(SpringLayout.EAST, tiposervicio, -1570, SpringLayout.EAST, cp);
        layout.putConstraint(SpringLayout.SOUTH, tiposervicio, 70, SpringLayout.NORTH, cp);

        layout.putConstraint(SpringLayout.WEST, content, 0, SpringLayout.WEST, cp);
        layout.putConstraint(SpringLayout.NORTH, content, 70, SpringLayout.NORTH, cp);
        layout.putConstraint(SpringLayout.EAST, content, 0, SpringLayout.EAST, cp);
        layout.putConstraint(SpringLayout.SOUTH, content, 0, SpringLayout.SOUTH, cp);
        cp.setLayout(layout);
        cp.add(labelPane);
        cp.add(content);
        cp.add(tiposervicio);
        // Mostrar información en el JTEXTPANE
        setInfo("<ul><li>Para crear una cita presione.</li>"
                + "<li>Para llenado de información de cita presione.</li></ul>");

        // Instanciación del objeto AWTCalendar que se configura como calendario
        calendar = new AwtCalendar();

// PRINCIPIA: INICIALIZACIÓN DEL OBJETO CALENDARIO
        calendar.beginInit();
        calendar.setCurrentTime(DateTime.now());
        calendar.setDate(DateTime.today());
        calendar.setEndDate(DateTime.today());
        calendar.setCurrentView(CalendarView.MonthRange);
        calendar.setTheme(ThemeType.Silver);

        calendar.getMonthRangeSettings().setMonthsPerRow(1);
        calendar.getMonthRangeSettings().setNumberOfMonths(2);
        calendar.getMonthRangeSettings().setScrollInterval(1);
        calendar.getSelection().setAllowMultiple(false);
        calendar.setShowToolTips(true);
        calendar.setCustomDraw(CustomDrawElements.CellHeader);

// Configurar fines de semana
        DayOfWeekStyle style = new DayOfWeekStyle();
        style.setDayOfWeek(DayOfWeek.Saturday);
        style.getStyle().setHeaderTextColor(new Color(192, 0, 0));
        calendar.getDayOfWeekStyles().add(style);
        style = new DayOfWeekStyle();
        style.setDayOfWeek(DayOfWeek.Sunday);
        style.getStyle().setHeaderTextColor(new Color(192, 0, 0));
        calendar.getDayOfWeekStyles().add(style);
        calendar.endInit();
        // TERMINA: INICIALIACIÓN DEL OBJETO CALENDARIO

        /*
    * Listen para el objeto calendario:
    *   tooltipDisplaying   Se invoca para permitir la modificación de la
    *                       información sobre herramientas de un elemento de 
    *                       calendario antes de que se muestre.
    *   draw                Se invoca para permitir el dibujo personalizado de
    *                       elementos de la interfaz de usuario de calendario.
    *   visibleDateChanged  Se invoca cuando el usuario selecciona otra fecha 
    *                       utilizando los controles de navegación de mes o año
    *                       en el área de encabezado del calendario.
         */
        calendarioListener = new CalendarioListener(calendar);
        calendar.addCalendarListener(calendarioListener);

        // Establece la fecha actual
        calendar.getSelection().set(DateTime.today());

        // Listen para los cambios de selección
        calendar.getSelection().addChangeListener(new ChangeListener() {
            @Override
            public void changed(EventObject e) {
                onSelectionChanged();
            }
        });

        // PRINCIPIA: CONFIGURACION DEL MENU CONTEXTUAL
        ManejadorElementos manejador = new ManejadorElementos(); // manejador para los elementos de men�
        String opciones[] = {"Iniciar", "Detener"}; // arreglo de colores

        ButtonGroup grupoColores = new ButtonGroup(); // administra los elementos de colores
        contextMenu = new JPopupMenu(); // crea el men� contextual
        elementos = new JRadioButtonMenuItem[2]; // elementos para seleccionar el color

        // construye elemento de men�, lo agrega al men� contextual, habilita el manejo de eventos
        for (int cuenta = 0; cuenta < elementos.length; cuenta++) {
            elementos[cuenta] = new JRadioButtonMenuItem(opciones[cuenta]);
            contextMenu.add(elementos[cuenta]); // agrega elemento al men� contextual
            grupoColores.add(elementos[cuenta]); // agrega elemento al grupo de botones
            elementos[cuenta].addActionListener(manejador); // agrega el manejador
        } // fin de for

        contextMenu.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(java.awt.event.ComponentEvent arg0) {
                onContextMenuHidden();
            }
        });
        contextMenu.addPopupMenuListener(new PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {

            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                onContextMenuHidden();

            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {
            }
        });

        // TERMINA: CONFIGURACION DEL MENU CONTEXTUAL
        // Instanciación del objeto AWTCalendar que se configura como un HORARIO
        _schedule = new AwtCalendar();
        // PRINCIPIA: INICIALIZACIÓN DEL OBJETO HORARIO
        _schedule.beginInit();
        _schedule.setCurrentView(CalendarView.Timetable);
        _schedule.setCustomDraw(CustomDrawElements.TimetableItem | CustomDrawElements.TimetableCell);
        //_schedule.getSelection().setEnabled(false);
        // sincronizar ambos objetos: CALENDARIO Y HORARIO
        _schedule.setSchedule(calendar.getSchedule());
        _schedule.setTheme(ThemeType.Silver);
        _schedule.setDate(calendar.getDate());
        _schedule.setEndDate(calendar.getEndDate());
        _schedule.setComponentPopupMenu(contextMenu);
        _schedule.setAllowInplaceCreate(false);
        _schedule.setAllowInplaceEdit(false);
        // Haga que el control cree eventos de nuestro tipo cuando
        // el usuario escribe directamente en el control
        _schedule.setInteractiveItemType(MyEvent.class);

// Set the displayed date to today
        DateTime today = DateTime.today();
        calendar.getTimetableSettings().getDates().clear();
        calendar.getTimetableSettings().getDates().add(today);
        _schedule.endInit();
        // TERMINA: INICIALIACIÓN DEL HORARIO

        /* Listen para:
    *  la creacion/actualización/eliminación de un item
    *  la acción de click en un item
    *  personalizar el dibujo del item
         
         */
        horarioListener = new HorarioListener(calendar, _schedule, contextMenu, this, _clickedDate);

        _schedule.addCalendarListener(horarioListener);

        /* Configuración del layout del JPanel. Se agrega un JSplitPane para dividir el panel
    *  en dos partes: en la Izquierda queda un Objeto AWTCalendar con la vista de calendario
    *  y en la Derecha un objeto AWTCalendar con la vista de horario
         */
        JSplitPane pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, calendar, _schedule);
        pane.setDividerLocation(350);
        content.add(pane);
    }

    public void setInfo(String value) {
        label.setText("<div style=\"padding: 2pt; font-family: Verdana; font-size: 11pt;\">" + value + "</div>");
        label.setCaretPosition(0);
    }

    public void onSelectionChanged() {
        if (calendar.getSelection().getIsEmpty()) {
            _schedule.getTimetableSettings().getDates().clear();
            return;
        }// fin if

        _schedule.beginInit();
        _schedule.getTimetableSettings().getDates().clear();
        _schedule.getTimetableSettings().getDates().add((DateTime) calendar.getSelection().getRanges().get(0));
        _schedule.endInit();
    }

    public void onContextMenuHidden() {
        _schedule.getDayStyles().clear();

        _clickedDate = DateTime.MinValue;

        _schedule.repaint();
    }

    public AwtCalendar getSchedule() {
        return _schedule;
    }

    private class ManejadorElementos implements ActionListener {
        // procesa las selecciones de los elementos de men�

        public void actionPerformed(ActionEvent evento) {
            // determina cu�l elemento de men� se seleccion�
            if (elementos[0].isSelected()) {
                //Instanciamos el objeto Calendar
                //en fecha obtenemos la fecha y hora del sistema
                Calendar calendario = Calendar.getInstance();

                //Obtenemos el valor del año, mes, día,
                //hora, minuto y segundo del sistema
                //usando el método get y el parámetro correspondiente
                int hora = calendario.get(Calendar.HOUR_OF_DAY);
                int minuto = calendario.get(Calendar.MINUTE);
                int segundo = calendario.get(Calendar.SECOND);
                horacapturada = (hora + ":" + minuto + ":" + segundo);

                System.out.println(horacapturada);
            }
            if (elementos[1].isSelected()) {
                Calendar calendarioA = Calendar.getInstance();

                int horaA = calendarioA.get(Calendar.HOUR_OF_DAY);
                int minutoA = calendarioA.get(Calendar.MINUTE);
                int segundoA = calendarioA.get(Calendar.SECOND);
                String tiempo;
                horaactual = (horaA + ":" + minutoA + ":" + segundoA);
                System.out.println(horaactual);
                tiempo = Diferenciahoras(horacapturada, horaactual);
                System.out.println(tiempo);
            }
        } // fin del m�todo actionPerformed
    } // fin de la clase interna privada ManejadorElementos

    public static String Diferenciahoras(String vinicio, String vfinal) {

        Date dinicio = null, dfinal = null;
        long milis1, milis2, diff;

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        try {
            // PARSEO STRING A DATE
            dinicio = sdf.parse(vinicio);
            dfinal = sdf.parse(vfinal);

        } catch (ParseException e) {

            System.out.println("Se ha producido un error en el parseo");
        }
        //INSTANCIA DEL CALENDARIO GREGORIANO
        Calendar cinicio = Calendar.getInstance();
        Calendar cfinal = Calendar.getInstance();

        //ESTABLECEMOS LA FECHA DEL CALENDARIO CON EL DATE GENERADO ANTERIORMENTE
        cinicio.setTime(dinicio);
        cfinal.setTime(dfinal);

        milis1 = cinicio.getTimeInMillis();
        milis2 = cfinal.getTimeInMillis();
        diff = milis2 - milis1;
        // calcular la diferencia en segundos

        long diffSegundos = Math.abs(diff / 1000);
        long segundos = diffSegundos % 60;
// calcular la diferencia en minutos

        long diffMinutos = Math.abs(diff / (60 * 1000));
        long restominutos = diffMinutos % 60;

        // calcular la diferencia en horas
        long diffHoras = (diff / (60 * 60 * 1000));

        String devolver = String.valueOf("Horas:" + diffHoras + "\tMinutos:" + restominutos + "\tSegundos:" + segundos);
        JOptionPane.showMessageDialog(null, devolver);
//        System.out.println(devolver);
        return devolver;
    }
}//-->

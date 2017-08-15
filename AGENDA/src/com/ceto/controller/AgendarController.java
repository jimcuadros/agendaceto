/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceto.controller;

import com.ceto.vista.AgendarWindow;
import com.ceto.vista.BaseWindow;
import com.mindfusion.common.DateTime;
import com.mindfusion.common.Duration;
import com.mindfusion.scheduling.awt.AwtCalendar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.SwingUtilities;

/**
 *
 * @author jimcu
 */
public class AgendarController implements ActionListener {

    private AgendarWindow window;
    private AwtCalendar _scheduler;
    private AwtCalendar calendar;

    public AgendarController(AwtCalendar _scheduler,AwtCalendar calendar) {
        SwingUtilities.invokeLater(() -> {
            window = null;
            try {
                window = new AgendarWindow();
                window.setVisible(true);
                iniListener();
            } catch (Exception exp) {
                System.out.println(Arrays.toString(exp.getStackTrace()));
            }// fin try
        });
        this._scheduler = _scheduler;
    }

    private void iniListener() {
        window.getjButton2().addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        DateTime se = new DateTime(window.getFecha_asignarcita().getJCalendar().getYearChooser().getYear(),window.getFecha_asignarcita().getJCalendar().getMonthChooser().getMonth()+1, window.getFecha_asignarcita().getJCalendar().getDayChooser().getDay(), window.getH(), window.getM(), window.getS());
        System.out.println(se);

        MyEvent myEvent = new MyEvent();
        myEvent.setHeaderText("My Event");
        myEvent.setDescriptionText("This is the event's description.");
        myEvent.setCustomField("This is my event.\nCool, isn't it?");
        myEvent.setStartTime(DateTime.op_Addition(se, Duration.Zero));
        myEvent.setEndTime(DateTime.op_Addition(se, new Duration(30 * Duration.TicksPerMinute)));
//        JOptionPane.showMessageDialog(window,myEvent.getStartTime(),"titulo",JOptionPane.INFORMATION_MESSAGE);
        _scheduler.getSchedule().getItems().add(myEvent);
        _scheduler.resetDrag();
        window.dispose();
    }
}//-->


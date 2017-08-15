/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceto.vista;

import com.toedter.calendar.JDateChooser;
import java.awt.Dialog;
import java.util.Calendar;
import javax.swing.JFrame;

/**
 *
 * @author jimcu
 */
public class AgendarWindow extends JFrame {

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> hora_lista;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser fecha_asignarcita;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField40;
    private int h, m, s;
    // End of variables declaration             

    public AgendarWindow() {
        iniCalendario();
        initComponents();
    }

    private void iniCalendario() {
        //Instanciamos el objeto Calendar
        //en fecha obtenemos la fecha y hora del sistema
        Calendar calendario = Calendar.getInstance();
        //Obtenemos el valor del año, mes, día,
        //hora, minuto y segundo del sistema
        //usando el método get y el parámetro correspondiente
        int año = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        int minuto = calendario.get(Calendar.MINUTE);
        int segundo = calendario.get(Calendar.SECOND);
        

        String fecha = (dia + "/" + (mes + 1) + "/" + año);
        String horaActual = (hora + ":" + minuto + ":" + segundo);
    }

    private void initComponents() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1300, 800);
        setTitle("Agendar cita");
        //setModalityType(DEFAULT_MODALITY_TYPE);
        setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setAlwaysOnTop(true);
        setLocationRelativeTo(this);

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTextField10 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jTextField25 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel26 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jTextField15 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jTextField16 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jTextField32 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jTextField31 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jTextField30 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel40 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        fecha_asignarcita = new com.toedter.calendar.JDateChooser();
        jLabel29 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jTextField40 = new javax.swing.JTextField();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        hora_lista = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jTextField26 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jTextField34 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jTextField35 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jTextField36 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jTextField37 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jTextField38 = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jTextField39 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField33 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jTextField27 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

//        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
//        setTitle("Datos de la paciente");
//        setMinimumSize(new java.awt.Dimension(800, 600));
//        setPreferredSize(new java.awt.Dimension(800, 600));
//        setResizable(false);
//        setSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(null);
//        HorarioListener p = new HorarioListener(calendar,_schedule,contextMenu,baseWindow,_clickedDate);
      
        jButton1.setText("jButton1");
        getContentPane().add(jButton1);
        jButton1.setBounds(1100, 610, 79, 25);
//
        jButton2.setText("Cita");
        jButton2.setName(""); // NOI18N
        getContentPane().add(jButton2);
        jButton2.setBounds(1010, 610, 79, 25);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Personales"));
        jPanel2.setLayout(null);

        jTextField10.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField10.setName("2nombre"); // NOI18N
        jPanel2.add(jTextField10);
        jTextField10.setBounds(440, 40, 130, 30);

        jTextField18.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField18.setName("1nombre"); // NOI18N
        jPanel2.add(jTextField18);
        jTextField18.setBounds(300, 40, 130, 30);

        jTextField19.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField19.setName("amaterno"); // NOI18N
        jPanel2.add(jTextField19);
        jTextField19.setBounds(150, 40, 130, 30);

        jTextField24.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField24.setToolTipText("");
        jTextField24.setName("apaterno"); // NOI18N
        jPanel2.add(jTextField24);
        jTextField24.setBounds(10, 40, 130, 30);

        jTextField25.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField25.setToolTipText("");
        jTextField25.setName("edad"); // NOI18N
        jPanel2.add(jTextField25);
        jTextField25.setBounds(230, 110, 40, 30);

        jLabel30.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel30.setText("Paterno");
        jLabel30.setToolTipText("Inserte apellido paterno");
        jPanel2.add(jLabel30);
        jLabel30.setBounds(10, 20, 55, 19);

        jLabel31.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel31.setText("Materno");
        jPanel2.add(jLabel31);
        jLabel31.setBounds(150, 20, 57, 19);

        jLabel32.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel32.setText("1° Nombre");
        jPanel2.add(jLabel32);
        jLabel32.setBounds(300, 20, 75, 19);

        jLabel33.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel33.setText("2° Nombre");
        jPanel2.add(jLabel33);
        jLabel33.setBounds(440, 20, 90, 19);

        jLabel35.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel35.setText("Edad");
        jPanel2.add(jLabel35);
        jLabel35.setBounds(230, 90, 40, 19);

        jLabel34.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel34.setText("Fecha de nacimiento");
        jPanel2.add(jLabel34);
        jLabel34.setBounds(20, 90, 150, 20);

        jDateChooser1.setDateFormatString("yyyy-MMM-dd");
        jDateChooser1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jDateChooser1.setName("fechanacimiento"); // NOI18N
        jPanel2.add(jDateChooser1);
        jDateChooser1.setBounds(20, 110, 190, 30);

        jLabel26.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel26.setText("CURP");
        jPanel2.add(jLabel26);
        jLabel26.setBounds(300, 90, 80, 19);

        jTextField22.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField22.setToolTipText("");
        jTextField22.setName("curp"); // NOI18N
        jPanel2.add(jTextField22);
        jTextField22.setBounds(300, 110, 160, 30);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(20, 60, 600, 230);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Valoración Médica"));
        jPanel3.setLayout(null);

        jTextField15.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField15.setToolTipText("");
        jTextField15.setName("operador"); // NOI18N
        jPanel3.add(jTextField15);
        jTextField15.setBounds(250, 50, 100, 30);

        jLabel16.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel16.setText("SDG");
        jPanel3.add(jLabel16);
        jLabel16.setBounds(10, 30, 80, 19);

        jLabel17.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel17.setText("Patologia");
        jPanel3.add(jLabel17);
        jLabel17.setBounds(150, 30, 80, 19);

        jComboBox2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        jComboBox2.setName("patologia"); // NOI18N
        jPanel3.add(jComboBox2);
        jComboBox2.setBounds(150, 50, 72, 30);

        jLabel19.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel19.setText("Operador");
        jPanel3.add(jLabel19);
        jLabel19.setBounds(250, 30, 80, 19);

        jLabel20.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel20.setText("Gestación");
        jPanel3.add(jLabel20);
        jLabel20.setBounds(380, 30, 80, 19);

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        jComboBox5.setName("gestacion"); // NOI18N
        jPanel3.add(jComboBox5);
        jComboBox5.setBounds(380, 50, 64, 30);

        jTextField16.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField16.setToolTipText("");
        jTextField16.setName("trimestre"); // NOI18N
        jPanel3.add(jTextField16);
        jTextField16.setBounds(470, 50, 100, 30);

        jLabel21.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel21.setText("Trimestre");
        jPanel3.add(jLabel21);
        jLabel21.setBounds(470, 30, 80, 19);

        jTextField17.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField17.setToolTipText("");
        jTextField17.setName("lcc"); // NOI18N
        jPanel3.add(jTextField17);
        jTextField17.setBounds(10, 130, 100, 30);

        jLabel22.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel22.setText("LCC");
        jPanel3.add(jLabel22);
        jLabel22.setBounds(10, 110, 80, 19);

        jTextField21.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField21.setToolTipText("");
        jTextField21.setName("sgd"); // NOI18N    
        jPanel3.add(jTextField21);
        jTextField21.setBounds(10, 50, 130, 30);

        jLabel28.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel28.setText("CLUES UNIDAD");
        jPanel3.add(jLabel28);
        jLabel28.setBounds(140, 90, 130, 20);

        jLabel23.setText("FN");
        jPanel3.add(jLabel23);
        jLabel23.setBounds(520, 110, 34, 16);

        jLabel27.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel27.setText("HORARIO DE CITA");
        jPanel3.add(jLabel27);
        jLabel27.setBounds(460, 90, 150, 19);

        jTextField32.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField32.setToolTipText("");
        jTextField32.setName("horariocita"); // NOI18N
        jPanel3.add(jTextField32);
        jTextField32.setBounds(480, 130, 100, 30);

        jLabel42.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel42.setText("SP");
        jPanel3.add(jLabel42);
        jLabel42.setBounds(360, 110, 80, 19);

        jTextField31.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField31.setToolTipText("");
        jTextField31.setName("sp"); // NOI18N
        jPanel3.add(jTextField31);
        jTextField31.setBounds(360, 130, 100, 30);

        jLabel41.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel41.setText("CAISES");
        jPanel3.add(jLabel41);
        jLabel41.setBounds(240, 110, 80, 19);

        jTextField30.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField30.setToolTipText("");
        jTextField30.setName("caises"); // NOI18N
        jPanel3.add(jTextField30);
        jTextField30.setBounds(240, 130, 100, 30);

        jLabel39.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel39.setText("Unidad");
        jPanel3.add(jLabel39);
        jLabel39.setBounds(140, 110, 80, 19);

        jComboBox4.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        jComboBox4.setName("unidad"); // NOI18N
        jPanel3.add(jComboBox4);
        jComboBox4.setBounds(140, 130, 72, 30);

        jLabel40.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel40.setText("Observaciones");
        jPanel3.add(jLabel40);
        jLabel40.setBounds(20, 160, 110, 30);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setName("observaciones"); // NOI18N
        jScrollPane1.setViewportView(jTextArea1);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(20, 190, 560, 90);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(630, 290, 660, 310);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Gestion y Seguimiento"));
        jPanel1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jPanel1.setLayout(null);

        jLabel25.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel25.setText("Previa Cita");
        jPanel1.add(jLabel25);
        jLabel25.setBounds(300, 80, 80, 19);

        jLabel43.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel43.setText("N°Afiliación");
        jPanel1.add(jLabel43);
        jLabel43.setBounds(20, 40, 90, 20);

        jTextField23.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField23.setToolTipText("");
        jTextField23.setName("numeroafiliacion"); // NOI18N
        jPanel1.add(jTextField23);
        jTextField23.setBounds(240, 40, 170, 30);

//        fecha_asignarcita.setDateFormatString("yyyy-MMM-dd");
        fecha_asignarcita.setName("previacita"); // NOI18N
        jPanel1.add(fecha_asignarcita);
        fecha_asignarcita.setBounds(20, 110, 160, 30);

        jLabel29.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel29.setText("Cita Siguiente");
        jPanel1.add(jLabel29);
        jLabel29.setBounds(470, 80, 100, 19);

        jLabel50.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel50.setText("Referido de:");
        jPanel1.add(jLabel50);
        jLabel50.setBounds(20, 150, 100, 20);

        jLabel52.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel52.setText("Expediente");
        jPanel1.add(jLabel52);
        jLabel52.setBounds(450, 20, 80, 20);

        jTextField40.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField40.setToolTipText("");
        jTextField40.setName("expediente"); // NOI18N
        jPanel1.add(jTextField40);
        jTextField40.setBounds(450, 40, 120, 30);

        jDateChooser3.setDateFormatString("yyyy-MMM-dd");
        jDateChooser3.setName("citasiguiente"); // NOI18N
        jPanel1.add(jDateChooser3);
        jDateChooser3.setBounds(300, 110, 160, 30);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(130, 40, 90, 30);

        jTextField1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField1.setName("referido"); // NOI18N
        jPanel1.add(jTextField1);
        jTextField1.setBounds(20, 180, 160, 30);

        jDateChooser4.setDateFormatString("yyyy-MMM-dd");
        jDateChooser4.setName("Fecha"); // NOI18N
        jPanel1.add(jDateChooser4);
        jDateChooser4.setBounds(470, 110, 160, 30);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel2.setText("Fecha");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 80, 50, 20);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel3.setText("Doctor");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(200, 150, 50, 19);

        jTextField3.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField3.setName("doctor"); // NOI18N
        jPanel1.add(jTextField3);
        jTextField3.setBounds(200, 180, 250, 30);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel4.setText("Consultorio");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(460, 150, 80, 19);

        jTextField4.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField4.setName("consultorio"); // NOI18N
        jPanel1.add(jTextField4);
        jTextField4.setBounds(460, 180, 120, 30);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel5.setText("Hora");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(200, 80, 41, 16);

        hora_lista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"9:30:12", "10:30:30", "12:30:10", "8:10:12"}));
        hora_lista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String[] horas = ((String) hora_lista.getSelectedItem()).split(":");
//               for(int i=0; i<horas.length;i++){
//                 System.out.println(horas[i]); 
//            }                
                h = Integer.parseInt(horas[0]);
                m = Integer.parseInt(horas[1]);
                s = Integer.parseInt(horas[2]);

            }
        });
        jPanel1.add(hora_lista);
        hora_lista.setBounds(180, 110, 120, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(630, 60, 660, 230);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Domicilio"));
        jPanel4.setLayout(null);

        jTextField26.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField26.setToolTipText("");
        jTextField26.setName("calle"); // NOI18N
        jPanel4.add(jTextField26);
        jTextField26.setBounds(20, 110, 290, 30);

        jLabel36.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel36.setText("Calle");
        jPanel4.add(jLabel36);
        jLabel36.setBounds(20, 90, 50, 19);

        jLabel44.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel44.setText("Colonia");
        jPanel4.add(jLabel44);
        jLabel44.setBounds(380, 20, 80, 20);

        jTextField34.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField34.setToolTipText("");
        jTextField34.setName("colonia"); // NOI18N
        jPanel4.add(jTextField34);
        jTextField34.setBounds(380, 40, 180, 30);

        jLabel45.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel45.setText("C.P.");
        jPanel4.add(jLabel45);
        jLabel45.setBounds(520, 90, 40, 19);

        jTextField35.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField35.setToolTipText("");
        jTextField35.setName("cp"); // NOI18N
        jPanel4.add(jTextField35);
        jTextField35.setBounds(520, 110, 50, 30);

        jLabel46.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel46.setText("No. Exterior");
        jPanel4.add(jLabel46);
        jLabel46.setBounds(330, 90, 82, 20);

        jTextField36.setToolTipText("");
        jTextField36.setName("nexterior"); // NOI18N
        jPanel4.add(jTextField36);
        jTextField36.setBounds(330, 110, 60, 30);

        jLabel47.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel47.setText("No. Interior");
        jPanel4.add(jLabel47);
        jLabel47.setBounds(430, 90, 80, 20);

        jTextField37.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField37.setToolTipText("");
        jTextField37.setName("ninterior"); // NOI18N
        jPanel4.add(jTextField37);
        jTextField37.setBounds(430, 110, 60, 30);

        jLabel48.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel48.setText("Municipio");
        jPanel4.add(jLabel48);
        jLabel48.setBounds(180, 20, 80, 20);

        jTextField38.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField38.setToolTipText("");
        jTextField38.setName("municipio"); // NOI18N
        jPanel4.add(jTextField38);
        jTextField38.setBounds(180, 40, 180, 30);

        jLabel49.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel49.setText("Estado");
        jPanel4.add(jLabel49);
        jLabel49.setBounds(20, 20, 60, 19);

        jTextField39.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField39.setToolTipText("");
        jTextField39.setName("estado"); // NOI18N
        jPanel4.add(jTextField39);
        jTextField39.setBounds(20, 40, 140, 30);

        jTextField2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField2.setName("correoelectronico"); // NOI18N
        jPanel4.add(jTextField2);
        jTextField2.setBounds(20, 170, 210, 30);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel1.setText("Correo Electronico");
        jPanel4.add(jLabel1);
        jLabel1.setBounds(20, 150, 140, 20);

        jTextField33.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField33.setToolTipText("");
        jTextField33.setName("tel1"); // NOI18N
        jPanel4.add(jTextField33);
        jTextField33.setBounds(250, 170, 100, 30);

        jLabel37.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel37.setText("Tel1");
        jPanel4.add(jLabel37);
        jLabel37.setBounds(250, 150, 34, 19);

        jTextField27.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextField27.setToolTipText("");
        jTextField27.setName("tel2"); // NOI18N
        jPanel4.add(jTextField27);
        jTextField27.setBounds(380, 170, 100, 30);

        jLabel38.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel38.setText("Tel2");
        jPanel4.add(jLabel38);
        jLabel38.setBounds(380, 150, 34, 19);

        getContentPane().add(jPanel4);
        jPanel4.setBounds(20, 290, 600, 300);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel6.setText("Fecha:" );
        getContentPane().add(jLabel6);
        jLabel6.setBounds(40, 10, 130, 40);

        jLabel8.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel8.setText("Hora:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(170, 10, 130, 40);

    }

    public javax.swing.JButton getjButton2() {
        return jButton2;
    }

    public JDateChooser getFecha_asignarcita() {
        return fecha_asignarcita;
    }

    public int getH() {
        return h;
    }

    public int getM() {
        return m;
    }

    public int getS() {
        return s;
    }
    
    
}

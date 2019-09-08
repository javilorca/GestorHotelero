/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import Constructores.consHabitacion;
import Constructores.consPago;
import Constructores.consReserva;
import Funciones.funConsumo;
import Funciones.funHabitacion;
import Funciones.funPago;
import Funciones.funProducto;
import Funciones.funReserva;
import java.sql.Date;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author javie
 */
public class framePago extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmpago
     */
    public framePago() {
        initComponents();
        mostrar(idreserva);
        inhabilitar();
        txtidreserva.setText(idreserva);
        //txtidpago.setText(idreserva);
        txtcliente.setText(cliente);
        txthabitacion.setText(habitacion);
        txtidhabitacion.setText(idhabitacion);
        txttotal_reserva.setText(Double.toString(total_reserva));
      

        
        funConsumo func = new funConsumo();
        func.mostrar(idreserva);
        
        //el txt de total pago recibe el total de reserva +  lo consumido, que lo tengo en la clase funConsumo
        txttotal_pago.setText(Double.toString(total_reserva + func.totalconsumo));
        
    }

    private String accion = "guardar";
    public static String idreserva;
    public static String cliente;
    public static String idhabitacion;
    public static String habitacion;
    public static Double total_reserva;
    

    void ocultar_columnas() {
        tablalistado.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        tablalistado.getColumnModel().getColumn(1).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(1).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(1).setPreferredWidth(0);
    }
    
    void ocultar_columnasconsumo() {
        tablalistadoconsumo.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        tablalistadoconsumo.getColumnModel().getColumn(1).setMaxWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(1).setMinWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(1).setPreferredWidth(0);
        
        tablalistadoconsumo.getColumnModel().getColumn(2).setMaxWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(2).setMinWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(2).setPreferredWidth(0);
    }

    //inhabilitamos algunos campos y botones para no poder utilizarlos en algunos momentos
    void inhabilitar() {
        txtidpago.setVisible(false);
        txtidreserva.setVisible(false);
        txtcliente.setVisible(false);
        txtnum_comprobante.setEnabled(false);
        cbtipo_comprobante.setEnabled(false);
        txtiva.setEnabled(false);
        txttotal_pago.setEnabled(false);
        txttotal_reserva.setEnabled(false);
        dcfecha_emision.setEnabled(false);
        dcfecha_pago.setEnabled(false);
        
        txtidhabitacion.setVisible(false);
        txthabitacion.setEnabled(false);

        btnguardar.setEnabled(false);
        btncancelar.setEnabled(false);
        btneliminar.setEnabled(false);
        txtidpago.setText("");
        txtnum_comprobante.setText("");
        txtiva.setText("");
        txttotal_pago.setText("");

    }

    void habilitar() {
        txtidpago.setVisible(false);
        txtidreserva.setVisible(true);
        txtcliente.setVisible(true);
        txtnum_comprobante.setEnabled(true);
        cbtipo_comprobante.setEnabled(true);
        txtiva.setEnabled(true);
        txttotal_pago.setEnabled(true);
        txttotal_reserva.setEnabled(true);
        dcfecha_emision.setEnabled(true);
        dcfecha_pago.setEnabled(true);
        
        txtidhabitacion.setVisible(true);
        txthabitacion.setEnabled(true);

        btnguardar.setEnabled(true);
        btncancelar.setEnabled(true);
        btneliminar.setEnabled(true);
        txtidpago.setText("");
        txtnum_comprobante.setText("");
        txtiva.setText("");
        //txttotal_pago.setText("");


    }

    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            funPago func = new funPago();

            //llamo a la funcion mostrar dentro de la clase funHabitacion
            modelo = func.mostrar(buscar);
            tablalistado.setModel(modelo);
            ocultar_columnas();
            lbltotalregistros.setText("Total pagos " + Integer.toString(func.totalregistros));
            
            //aqui mostramos lo datos de los consumos
            funConsumo func2 = new funConsumo();
            modelo = func2.mostrar(buscar);
            tablalistadoconsumo.setModel(modelo);
            ocultar_columnasconsumo();
            
            lbtotalregistrosconsumo.setText("Total consumos "+ func2.totalregistros);
            lbtotalconsumo.setText("Consumo total: € "+func2.totalconsumo);
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtidpago = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        txtcliente = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtnum_comprobante = new javax.swing.JTextArea();
        cbtipo_comprobante = new javax.swing.JComboBox<>();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        txttotal_reserva = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        txtidreserva = new javax.swing.JTextArea();
        txthabitacion = new javax.swing.JTextArea();
        txtidhabitacion = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txttotal_pago = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        txtiva = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        dcfecha_emision = new com.toedter.calendar.JDateChooser();
        dcfecha_pago = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        btneliminar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        lbltotalregistros = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablalistadoconsumo = new javax.swing.JTable();
        lbtotalregistrosconsumo = new javax.swing.JLabel();
        lbtotalconsumo = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBackground(new java.awt.Color(0, 87, 109));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        txtidpago.setBackground(new java.awt.Color(255, 255, 255));
        txtidpago.setColumns(20);
        txtidpago.setForeground(new java.awt.Color(0, 0, 0));
        txtidpago.setRows(5);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Reserva");

        txtcliente.setBackground(new java.awt.Color(255, 255, 255));
        txtcliente.setColumns(20);
        txtcliente.setForeground(new java.awt.Color(0, 0, 0));
        txtcliente.setRows(5);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Habitacion");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Num comprobante");

        txtnum_comprobante.setBackground(new java.awt.Color(255, 255, 255));
        txtnum_comprobante.setColumns(20);
        txtnum_comprobante.setForeground(new java.awt.Color(0, 0, 0));
        txtnum_comprobante.setRows(5);

        cbtipo_comprobante.setBackground(new java.awt.Color(102, 102, 102));
        cbtipo_comprobante.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        cbtipo_comprobante.setForeground(new java.awt.Color(0, 0, 0));
        cbtipo_comprobante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Factura", "Ticket" }));
        cbtipo_comprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbtipo_comprobanteActionPerformed(evt);
            }
        });

        btnnuevo.setBackground(new java.awt.Color(204, 204, 204));
        btnnuevo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnnuevo.setForeground(new java.awt.Color(0, 0, 0));
        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnnuevo.png"))); // NOI18N
        btnnuevo.setText("Nuevo");
        btnnuevo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnguardar.setBackground(new java.awt.Color(204, 204, 204));
        btnguardar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnguardar.setForeground(new java.awt.Color(0, 0, 0));
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnguardar.png"))); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btncancelar.setBackground(new java.awt.Color(204, 204, 204));
        btncancelar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btncancelar.setForeground(new java.awt.Color(0, 0, 0));
        btncancelar.setText("Cancelar");
        btncancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        txttotal_reserva.setBackground(new java.awt.Color(255, 255, 255));
        txttotal_reserva.setColumns(20);
        txttotal_reserva.setForeground(new java.awt.Color(0, 0, 0));
        txttotal_reserva.setRows(5);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Total reserva");

        txtidreserva.setBackground(new java.awt.Color(255, 255, 255));
        txtidreserva.setColumns(20);
        txtidreserva.setForeground(new java.awt.Color(0, 0, 0));
        txtidreserva.setRows(5);

        txthabitacion.setBackground(new java.awt.Color(255, 255, 255));
        txthabitacion.setColumns(20);
        txthabitacion.setForeground(new java.awt.Color(0, 0, 0));
        txthabitacion.setRows(5);

        txtidhabitacion.setBackground(new java.awt.Color(255, 255, 255));
        txtidhabitacion.setColumns(20);
        txtidhabitacion.setForeground(new java.awt.Color(0, 0, 0));
        txtidhabitacion.setRows(5);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tipo comprobante");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("I.V.A");

        txttotal_pago.setBackground(new java.awt.Color(255, 255, 255));
        txttotal_pago.setColumns(20);
        txttotal_pago.setForeground(new java.awt.Color(0, 0, 0));
        txttotal_pago.setRows(5);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Total pago");

        txtiva.setBackground(new java.awt.Color(255, 255, 255));
        txtiva.setColumns(20);
        txtiva.setForeground(new java.awt.Color(0, 0, 0));
        txtiva.setRows(5);

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Fecha emision");

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Fecha pago");

        dcfecha_emision.setBackground(new java.awt.Color(204, 204, 204));
        dcfecha_emision.setForeground(new java.awt.Color(0, 0, 0));

        dcfecha_pago.setBackground(new java.awt.Color(204, 204, 204));
        dcfecha_pago.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtiva, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbtipo_comprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnum_comprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(dcfecha_pago, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                        .addComponent(dcfecha_emision, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(txttotal_pago, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtidhabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(88, 88, 88)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtidpago, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtidreserva, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(44, 44, 44)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txthabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txttotal_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)))
                        .addGap(109, 109, 109))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtidpago, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtidreserva, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txttotal_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtidhabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txthabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbtipo_comprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnum_comprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtiva, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttotal_pago, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dcfecha_emision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dcfecha_pago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        jPanel2.setBackground(new java.awt.Color(0, 87, 109));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de pagos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        tablalistado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablalistado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablalistado);

        btneliminar.setBackground(new java.awt.Color(204, 204, 204));
        btneliminar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btneliminar.setForeground(new java.awt.Color(0, 0, 0));
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btneliminar.png"))); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnsalir.setBackground(new java.awt.Color(204, 204, 204));
        btnsalir.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnsalir.setForeground(new java.awt.Color(0, 0, 0));
        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnsalir.png"))); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        lbltotalregistros.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbltotalregistros.setForeground(new java.awt.Color(255, 255, 255));
        lbltotalregistros.setText("Registros");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbltotalregistros)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsalir)
                    .addComponent(btneliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbltotalregistros)
                .addGap(322, 322, 322))
        );

        jPanel3.setBackground(new java.awt.Color(0, 87, 109));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de consumos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        tablalistadoconsumo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablalistadoconsumo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoconsumoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablalistadoconsumo);

        lbtotalregistrosconsumo.setForeground(new java.awt.Color(255, 255, 255));
        lbtotalregistrosconsumo.setText("Registros");

        lbtotalconsumo.setForeground(new java.awt.Color(255, 255, 255));
        lbtotalconsumo.setText("Registros");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbtotalconsumo)
                .addGap(28, 28, 28)
                .addComponent(lbtotalregistrosconsumo)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbtotalregistrosconsumo)
                    .addComponent(lbtotalconsumo))
                .addGap(322, 322, 322))
        );

        jPanel4.setBackground(new java.awt.Color(0, 87, 109));

        jLabel1.setFont(new java.awt.Font("Future Earth", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pagos");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(534, 534, 534)
                .addComponent(jLabel1)
                .addContainerGap(561, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbtipo_comprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbtipo_comprobanteActionPerformed
        cbtipo_comprobante.transferFocus();
    }//GEN-LAST:event_cbtipo_comprobanteActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        habilitar();
        btnguardar.setText("Guardar");
        accion = "guardar"; //es la accion que pusimos antes, podia guardar o editar. Ahora indicamos que guardar
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        if (txtiva.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "No has ingresado el IVA correspondiente");
            txtiva.requestFocus();
            return;
        }

        if (txttotal_pago.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes indicar el total del pago del comprobante");
            txttotal_pago.requestFocus();
            return;
        }

        if (txtnum_comprobante.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "No has ingresado ningun numero de comprobante");
            txtnum_comprobante.requestFocus();
            return;
        }

        consPago dts = new consPago();
        funPago func = new funPago();

        dts.setIdreserva(Integer.parseInt(txtidreserva.getText()));

        int seleccionado = cbtipo_comprobante.getSelectedIndex();
        dts.setTipo_comprobante((String) cbtipo_comprobante.getItemAt(seleccionado));
        dts.setNum_comprobante(txtnum_comprobante.getText());
        dts.setIva(Double.parseDouble(txtiva.getText()));
        dts.setTotal_pago(Double.parseDouble(txttotal_pago.getText()));
        
        Calendar cal;
        int d, m, a;
        
        cal =dcfecha_pago.getCalendar();
        d=cal.get(Calendar.DAY_OF_MONTH);
        m=cal.get(Calendar.MONTH);
        a=cal.get(Calendar.YEAR)-1900;
        
        dts.setFecha_pago(new Date(a, m, d));
        
        cal =dcfecha_emision.getCalendar();
        d=cal.get(Calendar.DAY_OF_MONTH);
        m=cal.get(Calendar.MONTH);
        a=cal.get(Calendar.YEAR)-1900;
        
        dts.setFecha_emision(new Date(a, m, d));
        

        if (accion.equals("guardar")) {
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El pago en € "+txttotal_pago.getText()+
                        "del cliente "+txtcliente.getText()+ " se ha realizado correctamente");
                mostrar(idreserva);
                inhabilitar();
                
                //desocupamos la habitacion
                funHabitacion func2 = new funHabitacion();
                consHabitacion dts2 = new consHabitacion();
                
                dts2.setIdhabitacion(Integer.parseInt(txtidhabitacion.getText()));
                func2.desocuparHabitacion(dts2);
                
                //cancelamos o pagamos la reserva
                funReserva func3 = new funReserva();
                consReserva dts3 = new consReserva();
                
                dts3.setIdreserva(Integer.parseInt(txtidreserva.getText()));
                func3.pagar(dts3);
            }
        }
        else if(accion.equals("editar")){
            dts.setIdpago(Integer.parseInt(txtidpago.getText()));

            if (func.editar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El pago del cliente" + txtcliente.getText()+" se modifico correctamente");
                mostrar(idreserva);
                inhabilitar();
            }
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void tablalistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseClicked
        btnguardar.setText("editar");
        habilitar();
        btneliminar.setEnabled(true);
        accion="editar";

        int fila = tablalistado.rowAtPoint(evt.getPoint());

        txtidpago.setText(tablalistado.getValueAt(fila, 0).toString());
        txtidreserva.setText(tablalistado.getValueAt(fila, 1).toString());
        cbtipo_comprobante.setSelectedItem(tablalistado.getValueAt(fila, 2).toString());
        txtnum_comprobante.setText(tablalistado.getValueAt(fila, 3).toString());
        txtiva.setText(tablalistado.getValueAt(fila, 4).toString());
        txttotal_pago.setText(tablalistado.getValueAt(fila, 5).toString());
        dcfecha_emision.setDate(Date.valueOf(tablalistado.getValueAt(fila, 6).toString()));
        dcfecha_pago.setDate(Date.valueOf(tablalistado.getValueAt(fila, 7).toString()));
    }//GEN-LAST:event_tablalistadoMouseClicked

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        //si hay algo en txthabitacion, eliminalo
        if (!txtidpago.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "¿Seguro que desea eliminar el pago seleccionado?", "Confirmar", 2);

            if (confirmacion==0){
                funPago func = new funPago();
                consPago dts = new consPago();

                dts.setIdpago(Integer.parseInt(txtidpago.getText()));
                func.eliminar(dts);
                mostrar(idreserva);
                inhabilitar();
            }
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void tablalistadoconsumoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoconsumoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablalistadoconsumoMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(framePago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(framePago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(framePago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(framePago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new framePago().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox<String> cbtipo_comprobante;
    private com.toedter.calendar.JDateChooser dcfecha_emision;
    private com.toedter.calendar.JDateChooser dcfecha_pago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JLabel lbtotalconsumo;
    private javax.swing.JLabel lbtotalregistrosconsumo;
    private javax.swing.JTable tablalistado;
    private javax.swing.JTable tablalistadoconsumo;
    private javax.swing.JTextArea txtcliente;
    private javax.swing.JTextArea txthabitacion;
    private javax.swing.JTextArea txtidhabitacion;
    private javax.swing.JTextArea txtidpago;
    private javax.swing.JTextArea txtidreserva;
    private javax.swing.JTextArea txtiva;
    private javax.swing.JTextArea txtnum_comprobante;
    private javax.swing.JTextArea txttotal_pago;
    private javax.swing.JTextArea txttotal_reserva;
    // End of variables declaration//GEN-END:variables
}

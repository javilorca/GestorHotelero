/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;

import Constructores.consHabitacion;
import Constructores.consPago;
import Constructores.consProducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author javie
 */
public class funPago {
    
    private funConexion mysql=new funConexion();
    private Connection cn= mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
    
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"Idpago", "Idreserva", "Tipo comprobante", "Numero comprobante", "IVA", "Total pago", "Fecha emision", "Fecha pago"};
        
        String [] registro = new String[8];
        
        totalregistros=0;
        modelo = new DefaultTableModel(null, titulos);
        
        sSQL="SELECT * FROM pago where idreserva= " + buscar + " order by idpago desc";
        
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            //inserta lo que hay en la base de datos en cada columna correspondiente
            while(rs.next()){
                registro[0]=rs.getString("idpago");
                registro[1]=rs.getString("idreserva");
                registro[2]=rs.getString("tipo_comprobante");
                registro[3]=rs.getString("num_comprobante");
                registro[4]=rs.getString("iva");
                registro[5]=rs.getString("total_pago");
                registro[6]=rs.getString("fecha_emision");
                registro[7]=rs.getString("fecha_pago");
                
                totalregistros=totalregistros+1;
                modelo.addRow(registro);
                
            }
            return modelo;
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
    //funcion para insertar datos en la tabla
    public boolean insertar(consPago dts){
        sSQL="INSERT INTO pago (idreserva, tipo_comprobante, num_comprobante, iva, total_pago, fecha_emision, fecha_pago)"+
                "values (?,?,?,?,?,?,?)";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdreserva());
            pst.setString(2, dts.getTipo_comprobante());
            pst.setString(3, dts.getNum_comprobante());
            pst.setDouble(4, dts.getIva());
            pst.setDouble(5, dts.getTotal_pago());
            pst.setDate(6, dts.getFecha_emision());
            pst.setDate(7, dts.getFecha_pago());
          
            
            //compruebo que se insertan registros
            int n=pst.executeUpdate();
            if (n!=0){
                return true;
            }else{
                return false;
            }
        
        
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    
    
    //funcion para modificar datos de la tabla
    public boolean editar (consPago dts){
        sSQL="UPDATE pago set idreserva=?, tipo_comprobante=?, num_comprobante=?, iva=?, total_pago=?, fecha_emision=?, fecha_pago=?"+
                " WHERE idpago=?";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdreserva());
            pst.setString(2, dts.getTipo_comprobante());
            pst.setString(3, dts.getNum_comprobante());
            pst.setDouble(4, dts.getIva());
            pst.setDouble(5, dts.getTotal_pago());
            pst.setDate(6, dts.getFecha_emision());
            pst.setDate(7, dts.getFecha_pago());   
            pst.setInt(8, dts.getIdpago());
            
            //compruebo que se insertan registros
            int n=pst.executeUpdate();
            if (n!=0){
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    
    //funcion para eliminar datos de la tabla
    public boolean eliminar (consPago dts){
        sSQL="DELETE from pago where idpago=?";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);  
            pst.setInt(1, dts.getIdpago());
            
            //compruebo que se insertan registros
            int n=pst.executeUpdate();
            if (n!=0){
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
}

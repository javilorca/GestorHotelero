/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;

import Constructores.consHabitacion;
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
public class funHabitacion {
    private funConexion mysql=new funConexion();
    private Connection cn= mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
    
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID","Numero", "Piso", "Description", "Caracteristicas", "Precio", "Estado", "Tipo habitacion"};
        
        String [] registro = new String[8];
        
        totalregistros=0;
        modelo = new DefaultTableModel(null, titulos);
        
        sSQL="SELECT * FROM habitacion where piso like '%"+buscar+"%' order by idhabitacion";
        
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            //inserta lo que hay en la base de datos en cada columna correspondiente
            while(rs.next()){
                registro[0]=rs.getString("idhabitacion");
                registro[1]=rs.getString("numero");
                registro[2]=rs.getString("piso");
                registro[3]=rs.getString("descripcion");
                registro[4]=rs.getString("caracteristicas");
                registro[5]=rs.getString("precio_diario");
                registro[6]=rs.getString("estado");
                registro[7]=rs.getString("tipo_habitacion");
                
                totalregistros=totalregistros+1;
                modelo.addRow(registro);
                
            }
            return modelo;
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
    public DefaultTableModel mostrarVista(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID","Numero", "Piso", "Description", "Caracteristicas", "Precio", "Estado", "Tipo habitacion"};
        
        String [] registro = new String[8];
        
        totalregistros=0;
        modelo = new DefaultTableModel(null, titulos);
        
        sSQL="SELECT * FROM habitacion where piso like '%"+buscar+"%' and estado='Disponible' order by idhabitacion";
        
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            //inserta lo que hay en la base de datos en cada columna correspondiente
            while(rs.next()){
                registro[0]=rs.getString("idhabitacion");
                registro[1]=rs.getString("numero");
                registro[2]=rs.getString("piso");
                registro[3]=rs.getString("descripcion");
                registro[4]=rs.getString("caracteristicas");
                registro[5]=rs.getString("precio_diario");
                registro[6]=rs.getString("estado");
                registro[7]=rs.getString("tipo_habitacion");
                
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
    public boolean insertar(consHabitacion dts){
        sSQL="INSERT INTO habitacion (numero, piso, descripcion, caracteristicas, precio_diario, estado, tipo_habitacion)"+
                "values (?,?,?,?,?,?,?)";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNumero());
            pst.setString(2, dts.getPiso());
            pst.setString(3, dts.getDescripcion());
            pst.setString(4, dts.getCaracteristicas());
            pst.setDouble(5, dts.getPrecio_diario());
            pst.setString(6, dts.getEstado());
            pst.setString(7, dts.getTipo_habitacion());
            
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
    public boolean editar (consHabitacion dts){
        sSQL="UPDATE habitacion set numero=?, piso=?, descripcion=?, caracteristicas=?, precio_diario=?, estado=?, tipo_habitacion=?"+
                "WHERE idhabitacion=?";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNumero());
            pst.setString(2, dts.getPiso());
            pst.setString(3, dts.getDescripcion());
            pst.setString(4, dts.getCaracteristicas());
            pst.setDouble(5, dts.getPrecio_diario());
            pst.setString(6, dts.getEstado());
            pst.setString(7, dts.getTipo_habitacion());
            pst.setInt(8, dts.getIdhabitacion());
            
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
    
    
    public boolean desocuparHabitacion (consHabitacion dts){
        sSQL="UPDATE habitacion set estado='Disponible'"+
                " WHERE idhabitacion=?";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdhabitacion());
            
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
    
    
    public boolean ocuparHabitacion (consHabitacion dts){
        sSQL="UPDATE habitacion set estado='Ocupado'"+
                " WHERE idhabitacion=?";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdhabitacion());
            
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
    public boolean eliminar (consHabitacion dts){
        sSQL="DELETE from habitacion where idhabitacion=?";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);  
            pst.setInt(1, dts.getIdhabitacion());
            
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

 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;

import Constructores.consHabitacion;
import Constructores.consProducto;
import Constructores.consReserva;
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
public class funReserva {
    
    private funConexion mysql=new funConexion();
    private Connection cn= mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
    
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID","IdHabitacion", "Numero habitacion", "Idcliente", "Cliente", "Idtrabajador", "Nombre trabajador", "Tipo reserva", "Fecha reserva", "Fecha entrada", "Fecha salida","Precio", "Estado"};
        
        String [] registro = new String[13];
        
        totalregistros=0;
        modelo = new DefaultTableModel(null, titulos);
        
        //muestra en la tabla todos los datos seleccionados
        sSQL="SELECT r.idreserva, r.idhabitacion, h.numero, r.idcliente, "+
                "(Select nombre FROM persona where idpersona=r.idcliente)as clienten, "+
                "(Select primer_apellido FROM persona where idpersona=r.idcliente)as clientepa,"+
                "r.idtrabajador,(Select nombre FROM persona where idpersona=r.idtrabajador)as trabajadorn, "+
                "(Select primer_apellido FROM persona where idpersona=r.idtrabajador)as trabajadorap, "+
                "r.tipo_reserva, r.fecha_reserva, r.fecha_entrada, r.fecha_salida, "+
                "r.precio_alojamiento, r.estado FROM reserva r inner join habitacion h on r.idhabitacion=h.idhabitacion where r.fecha_reserva like '%"+buscar+"%' order by idreserva desc";
        
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            //inserta lo que hay en la base de datos en cada columna correspondiente
            while(rs.next()){
                registro[0]=rs.getString("idreserva");
                registro[1]=rs.getString("idhabitacion");
                registro[2]=rs.getString("numero");
                registro[3]=rs.getString("idcliente");
                registro[4]=rs.getString("clienten")+ " " + rs.getString("clientepa");
                registro[5]=rs.getString("idtrabajador");
                registro[6]=rs.getString("trabajadorn")+ " " + rs.getString("trabajadorap");
                registro[7]=rs.getString("tipo_reserva");
                registro[8]=rs.getString("fecha_reserva");
                registro[9]=rs.getString("fecha_entrada");
                registro[10]=rs.getString("fecha_salida");
                registro[11]=rs.getString("precio_alojamiento");
                registro[12]=rs.getString("estado");
                
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
    public boolean insertar(consReserva dts){
        sSQL="INSERT INTO reserva (idhabitacion, idcliente, idtrabajador, tipo_reserva, fecha_reserva, fecha_entrada, fecha_salida, precio_alojamiento, estado)"+
                "values (?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdhabitacion());
            pst.setInt(2, dts.getIdcliente());
            pst.setInt(3, dts.getIdtrabajador());
            pst.setString(4, dts.getTipo_reserva());
            pst.setDate(5, dts.getFecha_reserva());
            pst.setDate(6, dts.getFecha_entrada());
            pst.setDate(7, dts.getFecha_salida());
            pst.setDouble(8, dts.getPrecio_alojamiento());
            pst.setString(9, dts.getEstado());
            
            //compruebo que se insertan registros
            int n=pst.executeUpdate();
            if (n!=0){
                return true;
            }else{
                return false;
            }
        
        
        }catch (Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    
    //funcion para modificar datos de la tabla
    public boolean editar (consReserva dts){
        sSQL="UPDATE reserva set idhabitacion=?, idcliente=?, idtrabajador=?, tipo_reserva=?, fecha_reserva=?, fecha_entrada=?, fecha_salida=?, precio_alojamiento=?, estado=?"+
                " WHERE idreserva=?";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdhabitacion());
            pst.setInt(2, dts.getIdcliente());
            pst.setInt(3, dts.getIdtrabajador());
            pst.setString(4, dts.getTipo_reserva());
            pst.setDate(5, dts.getFecha_reserva());
            pst.setDate(6, dts.getFecha_entrada());
            pst.setDate(7, dts.getFecha_salida());
            pst.setDouble(8, dts.getPrecio_alojamiento());
            pst.setString(9, dts.getEstado());
            
            pst.setInt(10, dts.getIdreserva());
            
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
    
     public boolean pagar (consReserva dts){
        sSQL="UPDATE reserva set estado='Pagada'"+
                "WHERE idreserva=?";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
            pst.setInt(1, dts.getIdreserva());
            
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
    public boolean eliminar (consReserva dts){
        sSQL="DELETE from reserva where idreserva=?";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);  
            pst.setInt(1, dts.getIdreserva());
            
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

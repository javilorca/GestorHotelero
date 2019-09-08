/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;


import Constructores.consTrabajador;
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
public class funTrabajador {
    private funConexion mysql=new funConexion();
    private Connection cn= mysql.conectar();
    private String sSQL="";
    private String sSQL2="";
    public Integer totalregistros;
    
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID", "Nombre", "Primer apellido", "Segundo apellido", "Doc", "Numero documento", "Direccion", "Telefono", "Email", "Sueldo", "Acceso", "Login", "Clave", "Estado"};
        
        String [] registro = new String[14];
        
        totalregistros=0;
        modelo = new DefaultTableModel(null, titulos);
        
        sSQL="SELECT p.idpersona, p.nombre, p.primer_apellido, p.segundo_apellido, p.tipo_documento, p.num_documento, "
                + "p.direccion, p.telefono, p.email, t.sueldo, t.acceso, t.login, t.password, t.estado from persona p INNER JOIN trabajador t "
                + "on p.idpersona=t.idpersona where num_documento like '%"
                + buscar + "%' order by idpersona desc";    
        
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            //inserta lo que hay en la base de datos en cada columna correspondiente
            while(rs.next()){
                registro[0]=rs.getString("idpersona");
                registro[1]=rs.getString("nombre");
                registro[2]=rs.getString("primer_apellido");
                registro[3]=rs.getString("segundo_apellido");
                registro[4]=rs.getString("tipo_documento");
                registro[5]=rs.getString("num_documento");
                registro[6]=rs.getString("direccion");
                registro[7]=rs.getString("telefono");
                registro[8]=rs.getString("email");
                registro[9]=rs.getString("sueldo");
                registro[10]=rs.getString("acceso");
                registro[11]=rs.getString("login");
                registro[12]=rs.getString("password");
                registro[13]=rs.getString("estado");
                
                totalregistros=totalregistros+1;
                modelo.addRow(registro);
                
            }
            return modelo;
            
        }catch (Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
    //funcion para insertar datos en la tabla
    public boolean insertar(consTrabajador dts){
        sSQL="INSERT INTO persona (nombre, primer_apellido, segundo_apellido, tipo_documento, num_documento, direccion, telefono, email)"
               + "values (?,?,?,?,?,?,?,?)";
        
        sSQL2="INSERT INTO trabajador (idpersona, sueldo, acceso, login, password, estado)"
                + "values ((SELECT idpersona FROM persona order by idpersona desc limit 1),?,?,?,?,?)";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);
            
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getPrimer_apellido());
            pst.setString(3, dts.getSegundo_apellido());
            pst.setString(4, dts.getTipo_documento());
            pst.setString(5, dts.getNum_documento());
            pst.setString(6, dts.getDireccion());
            pst.setString(7, dts.getTelefono());
            pst.setString(8, dts.getEmail());
            
            pst2.setDouble(1, dts.getSueldo());
            pst2.setString(2, dts.getAcceso());
            pst2.setString(3, dts.getLogin());
            pst2.setString(4, dts.getPassword());
            pst2.setString(5, dts.getEstado());
            
          
            
            //compruebo que se insertan registros
            int n=pst.executeUpdate();
            if (n!=0){
                int n2=pst2.executeUpdate();
                if(n2!=0){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        
        
        }catch (Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    
    //funcion para modificar datos de la tabla
    public boolean editar (consTrabajador dts){
        sSQL="UPDATE persona set nombre=?, primer_apellido=?, segundo_apellido=?, tipo_documento=?, num_documento=?,"
                + " direccion=?, telefono=?, email=? WHERE idpersona=?";
        
        sSQL2="UPDATE trabajador set sueldo=?, acceso=?, login=?, password=?, estado=? WHERE idpersona=?";
                
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);
            
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getPrimer_apellido());
            pst.setString(3, dts.getSegundo_apellido());
            pst.setString(4, dts.getTipo_documento());
            pst.setString(5, dts.getNum_documento());
            pst.setString(6, dts.getDireccion());
            pst.setString(7, dts.getTelefono());
            pst.setString(8, dts.getEmail());
            pst.setInt(9, dts.getIdpersona());
            
            pst2.setDouble(1, dts.getSueldo());
            pst2.setString(2, dts.getAcceso());
            pst2.setString(3, dts.getLogin());
            pst2.setString(4, dts.getPassword());
            pst2.setString(5, dts.getEstado());    
            pst2.setInt(6, dts.getIdpersona());
            
            //compruebo que se insertan registros
            int n=pst.executeUpdate();
            if (n!=0){
                int n2=pst2.executeUpdate();
                if(n2!=0){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        
        
        }catch (Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    //funcion para eliminar datos de la tabla cliente, despues eliminara de persona
    public boolean eliminar (consTrabajador dts){
        sSQL="DELETE from trabajador where idpersona=?";
        sSQL2="DELETE from persona where idpersona=?";
        
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);
            
            pst.setInt(1, dts.getIdpersona());
 
            pst2.setInt(1, dts.getIdpersona());
            
            //compruebo que se insertan registros
            int n=pst.executeUpdate();
            if (n!=0){
                int n2=pst2.executeUpdate();
                if(n2!=0){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        
        
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    
    public DefaultTableModel login(String login, String password){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID", "Nombre", "Primer apellido", "Segundo apellido", "Acceso", "Login", "Clave", "Estado"};
        
        String [] registro = new String[8];
        
        totalregistros=0;
        modelo = new DefaultTableModel(null, titulos);
        
        sSQL="SELECT p.idpersona, p.nombre, p.primer_apellido, p.segundo_apellido, "
                +"t.acceso, t.login, t.password, t.estado from persona p INNER JOIN trabajador t "
                +"on p.idpersona=t.idpersona where t.login='"
                + login + "' and t.password='" + password + "' and t.estado='A'";    
        
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            //inserta lo que hay en la base de datos en cada columna correspondiente
            while(rs.next()){
                registro[0]=rs.getString("idpersona");
                registro[1]=rs.getString("nombre");
                registro[2]=rs.getString("primer_apellido");
                registro[3]=rs.getString("segundo_apellido");
                registro[4]=rs.getString("acceso");
                registro[5]=rs.getString("login");
                registro[6]=rs.getString("password");
                registro[7]=rs.getString("estado");
                
                totalregistros=totalregistros+1;
                modelo.addRow(registro);
                
            }
            return modelo;
            
        }catch (Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
}

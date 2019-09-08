/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;

import Constructores.consConsumo;
import Constructores.consHabitacion;
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
public class funConsumo {

    private funConexion mysql = new funConexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalregistros;
    public Double totalconsumo;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"Id", "IDreserva", "IDproducto", "Producto", "Cantidad", "Precio venta", "Estado"};

        String[] registro = new String[7];

        totalregistros = 0;
        totalconsumo = 0.0;

        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT c.idconsumo, c.idreserva, c.idproducto, p.nombre, c.cantidad, c.precio_venta, "
                + "c.estado from consumo c INNER JOIN producto p on c.idproducto=p.idproducto"
                + " where c.idreserva=" + buscar + " order by c.idconsumo desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            //inserta lo que hay en la base de datos en cada columna correspondiente
            while (rs.next()) {
                registro[0] = rs.getString("idconsumo");
                registro[1] = rs.getString("idreserva");
                registro[2] = rs.getString("idproducto");
                registro[3] = rs.getString("nombre");
                registro[4] = rs.getString("cantidad");
                registro[5] = rs.getString("precio_venta");
                registro[6] = rs.getString("estado");

                totalregistros = totalregistros + 1;
                totalconsumo = totalconsumo + (rs.getDouble("cantidad") * rs.getDouble("precio_venta"));
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    //funcion para insertar datos en la tabla
    public boolean insertar(consConsumo dts) {
        sSQL = "INSERT INTO consumo (idreserva, idproducto, cantidad, precio_venta, estado)"
                + "values (?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdreserva());
            pst.setInt(2, dts.getIdproducto());
            pst.setDouble(3, dts.getCantidad());
            pst.setDouble(4, dts.getPrecio_venta());
            pst.setString(5, dts.getEstado());

            //compruebo que se insertan registros
            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    //funcion para modificar datos de la tabla
    public boolean editar(consConsumo dts) {
        sSQL = "UPDATE consumo set idreserva=?, idproducto=?, cantidad=?, precio_venta=?, estado=?"
                + "WHERE idconsumo=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdreserva());
            pst.setInt(2, dts.getIdproducto());
            pst.setDouble(3, dts.getCantidad());
            pst.setDouble(4, dts.getPrecio_venta());
            pst.setString(5, dts.getEstado());;

            pst.setInt(6, dts.getIdconsumo());

            //compruebo que se insertan registros
            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    //funcion para eliminar datos de la tabla
    public boolean eliminar(consConsumo dts) {
        sSQL = "DELETE from consumo where idconsumo=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdconsumo());

            //compruebo que se insertan registros
            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Constructores;

import java.sql.Date;

/**
 *
 * @author javie
 */
public class consReserva {
    private int idreserva;
    private int idhabitacion;
    private int idcliente;
    private int idtrabajador;
    private String tipo_reserva;
    private Date fecha_reserva;
    private Date fecha_entrada;
    private Date fecha_salida;
    private Double precio_alojamiento;
    private String estado;

    public consReserva() {
    }

    public consReserva(int idreserva, int idhabitacion, int idcliente, int idtrabajador, String tipo_reserva, Date fecha_reserva, Date fecha_entrada, Date fecha_salida, Double precio_alojamiento, String estado) {
        this.idreserva = idreserva;
        this.idhabitacion = idhabitacion;
        this.idcliente = idcliente;
        this.idtrabajador = idtrabajador;
        this.tipo_reserva = tipo_reserva;
        this.fecha_reserva = fecha_reserva;
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.precio_alojamiento = precio_alojamiento;
        this.estado = estado;
    }

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public int getIdhabitacion() {
        return idhabitacion;
    }

    public void setIdhabitacion(int idhabitacion) {
        this.idhabitacion = idhabitacion;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdtrabajador() {
        return idtrabajador;
    }

    public void setIdtrabajador(int idtrabajador) {
        this.idtrabajador = idtrabajador;
    }

    public String getTipo_reserva() {
        return tipo_reserva;
    }

    public void setTipo_reserva(String tipo_reserva) {
        this.tipo_reserva = tipo_reserva;
    }

    public Date getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(Date fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public Date getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(Date fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public Double getPrecio_alojamiento() {
        return precio_alojamiento;
    }

    public void setPrecio_alojamiento(Double precio_alojamiento) {
        this.precio_alojamiento = precio_alojamiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}

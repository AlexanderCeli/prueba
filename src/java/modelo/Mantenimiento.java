/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alexander
 */
@Entity
@Table(name = "mantenimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mantenimiento.findAll", query = "SELECT m FROM Mantenimiento m")
    , @NamedQuery(name = "Mantenimiento.findByIdmantenimiento", query = "SELECT m FROM Mantenimiento m WHERE m.idmantenimiento = :idmantenimiento")
    , @NamedQuery(name = "Mantenimiento.findByVehiculo", query = "SELECT m FROM Mantenimiento m WHERE m.vehiculo = :vehiculo")
    , @NamedQuery(name = "Mantenimiento.findByFecha", query = "SELECT m FROM Mantenimiento m WHERE m.fecha = :fecha")
    , @NamedQuery(name = "Mantenimiento.findByDescripcion", query = "SELECT m FROM Mantenimiento m WHERE m.descripcion = :descripcion")
    , @NamedQuery(name = "Mantenimiento.findByKilometraje", query = "SELECT m FROM Mantenimiento m WHERE m.kilometraje = :kilometraje")
    , @NamedQuery(name = "Mantenimiento.findByCliente", query = "SELECT m FROM Mantenimiento m WHERE m.cliente = :cliente")})
public class Mantenimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmantenimiento")
    private Integer idmantenimiento;
    @Size(max = 45)
    @Column(name = "vehiculo")
    private String vehiculo;
    @Size(max = 45)
    @Column(name = "fecha")
    private String fecha;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 45)
    @Column(name = "kilometraje")
    private String kilometraje;
    @Size(max = 45)
    @Column(name = "cliente")
    private String cliente;

    public Mantenimiento(Integer idmantenimiento, String vehiculo, String fecha, String descripcion, String kilometraje, String cliente) {
        this.idmantenimiento = idmantenimiento;
        this.vehiculo = vehiculo;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.kilometraje = kilometraje;
        this.cliente = cliente;
    }

    public Mantenimiento() {
    }

    public Mantenimiento(Integer idmantenimiento) {
        this.idmantenimiento = idmantenimiento;
    }

    public Integer getIdmantenimiento() {
        return idmantenimiento;
    }

    public void setIdmantenimiento(Integer idmantenimiento) {
        this.idmantenimiento = idmantenimiento;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(String kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmantenimiento != null ? idmantenimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mantenimiento)) {
            return false;
        }
        Mantenimiento other = (Mantenimiento) object;
        if ((this.idmantenimiento == null && other.idmantenimiento != null) || (this.idmantenimiento != null && !this.idmantenimiento.equals(other.idmantenimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Mantenimiento[ idmantenimiento=" + idmantenimiento + " ]";
    }
    
}

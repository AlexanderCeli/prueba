/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import modelo.Clientes;

/**
 *
 * @author Alexander
 */
@Stateless
@Path("modelo.clientes")
public class ClientesFacadeREST extends AbstractFacade<Clientes> {

    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;

    public ClientesFacadeREST() {
        super(Clientes.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Clientes entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Clientes entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Clientes find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Clientes> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Clientes> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    @POST
    @Path("create")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String crear(@FormParam("cedula") Integer cedula, @FormParam("nombre") String nombre,
            @FormParam("apellido") String apellido, @FormParam("direccion") String direccion,@FormParam("edad") Integer edad,
            @FormParam("vehiculo") String vehiculo, @FormParam("telefono") String telefono,@FormParam("provincia") String provincia) {
        Clientes e = new Clientes(cedula,  nombre, apellido, direccion, edad, vehiculo, provincia);
        super.create(e);
        return "el objeto se creo con exito";
    }

    @POST
    @Path("editar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String editar(@FormParam("cedula") Integer cedula, @FormParam("nombre") String nombre,
            @FormParam("apellido") String apellido, @FormParam("direccion") String direccion,@FormParam("edad") Integer edad,
            @FormParam("vehiculo") String vehiculo,@FormParam("provincia") String provincia) {
        Clientes e = super.find(cedula);
        if(e == null){
            return "el objeto no se encuentra";
        }else{
        e.setNombre(nombre);
        e.setApellido(apellido);
        e.setDireccion(direccion);
        e.setEdad(edad);
        e.setProvincia(provincia);
        e.setVehiculo(vehiculo);
               
        return "el objeto se edito con exito";
        }
    }
}

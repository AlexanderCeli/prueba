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
import javax.persistence.TypedQuery;
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
import modelo.Mantenimiento;
import modelo.Vehiculo;

/**
 *
 * @author Alexander
 */
@Stateless
@Path("modelo.vehiculo")
public class VehiculoFacadeREST extends AbstractFacade<Vehiculo> {

    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;

    public VehiculoFacadeREST() {
        super(Vehiculo.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Vehiculo entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Vehiculo entity) {
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
    public Vehiculo find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Vehiculo> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Vehiculo> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    public String crear(@FormParam("id") Integer id, @FormParam("placa") String placa,
            @FormParam("año") String año, @FormParam("nPasajeros") String nPasajeros,@FormParam("concesonario") String concesonario,
            @FormParam("marca") String marca,@FormParam("modelo") String modelo,@FormParam("paisFabrica") String paisFabrica){
        Vehiculo e = new Vehiculo(id,placa,año, nPasajeros,concesonario,marca, modelo,paisFabrica);
        super.create(e);
        return "el objeto se creo con exito";
    }

    @POST
    @Path("editar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String editar(@FormParam("id") Integer id, @FormParam("placa") String placa,
            @FormParam("año") String año, @FormParam("nPasajeros") String nPasajeros,@FormParam("concesonario") String concesonario,
            @FormParam("marca") String marca,@FormParam("modelo") String modelo,@FormParam("paisFabrica") String paisFabrica) {
        Vehiculo e = super.find(id);
        if(e == null){
            return "el objeto no se encuentra";
        }else{
       e.setAño(año);
       e.setConcesonario(concesonario);
       e.setMarca(marca);
       e.setModelo(modelo);
       e.setNPasajeros(nPasajeros);
       e.setPaisFabrica(paisFabrica);
       e.setPlaca(placa);
        return "el objeto se edito con exito";
        }
    }
     @POST
    @Path("edades")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Vehiculo> pasajeros(@FormParam("nPasajeros") Integer nPasajeros ){
        TypedQuery consulta = (TypedQuery) getEntityManager().createQuery("SELECT v FROM Vehiculo v WHERE v.nPasajeros = :nPasajeros");
        consulta.setParameter("nPasajeros", nPasajeros);
        return consulta.getResultList();
    }
    
}

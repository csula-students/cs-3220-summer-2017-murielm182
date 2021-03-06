package edu.csula.jaxrs;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.inject.Singleton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.csula.jaxrs.models.Orders;
import edu.csula.jaxrs.OrdersDAO;

@Path("")
@Singleton 
public class ResourceOrder {
    private OrdersDAO dao = new OrdersDAO();
   
  

    @GET
    @Path("orders")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Orders> getOrders() {
        return dao.list();
    }

    @GET
    @Path("order/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Orders getOrderById(@PathParam("id") int id) {
        return dao.get(id).get();
    }

    @POST
    @Path("orders")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
  
   public boolean addOrder(Orders order) {
        dao.add(order);
        return true;
    }

    @PUT
    @Path("order/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean updateOrder(Orders order, @PathParam("id") int id) {
        if (id == order.getId()) {
            dao.update(order);
            return true;
        } else {
            return false;
        }
    }

    @DELETE
    @Path("order/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteOrder(@PathParam("id") int id) {
        dao.delete(id);
        return true;
    }
}
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

import edu.csula.jaxrs.models.User;
import edu.csula.jaxrs.models.FoodEntries;

@Path("")
@Singleton
public class ResourceFood {

	private FoodEntriesDAO dao = new FoodEntriesDAO();

	@GET
	@Path("fooditems")
	@Produces(MediaType.APPLICATION_JSON)
	public List<FoodEntries> list() {
		return dao.list();
	}

	@GET
	@Path("fooditem/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public FoodEntries getFoodItemById(@PathParam("id") int id) {
		return dao.get(id).get();
	}

	@POST
	@Path("fooditems")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean addFoodItem(FoodEntries foodItem) {
		dao.add(foodItem);
		System.out.println(dao.list());
		return true;
	}

	@PUT
	@Path("fooditem/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean updateFoodItem(FoodEntries foodItem, @PathParam("id") int id) {
		if (id == foodItem.getID()) {
			dao.update(foodItem);
			System.out.println(dao.list());
			return true;
		} else {
			return false;
		}
	}

	@DELETE
	@Path("fooditem/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean deleteFoodItem(@PathParam("id") int id) {
		dao.delete(id);
		System.out.println(dao.list());
		return true;
	}
}
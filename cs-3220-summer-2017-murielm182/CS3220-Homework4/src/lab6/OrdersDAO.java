package lab6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class OrdersDAO implements DAO<Orders> {
	
	public List<Orders>list(){
		List<Orders> list=new ArrayList<>();
		List<Integer> orderids = new ArrayList<>();
		Database db=new Database();
		try(Connection c=db.connection()){
			
			Statement stmt =c.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM orders INNER JOIN order_foods INNER JOIN Food_Items WHERE orders.order_id = order_foods.order_foods_id AND Food_Items.id = order_foods.order_foods_id;");
				while(rs.next()){
					int order_id=rs.getInt("order_id");
					FoodEntries food_item_to_add = new FoodEntries(
		                    rs.getInt("id"),
		                    rs.getString("name"),
		                    rs.getString("imageURL"),
		                    rs.getString("description"), 
		                    (double) rs.getFloat("price")
		                );
		                //food_item_to_add.quantity = rs.getInt("food_quantity");
					if (!orderids.contains(order_id)) {
	                    
	                    orderids.add(order_id);

	                    List<FoodEntries> list_with_food_item = new ArrayList<FoodEntries>();
	                    list_with_food_item.add(food_item_to_add);

	                    list.add(new Orders(
	                        order_id,
	                        list_with_food_item,
	                        rs.getString("customer_name"),
	                        rs.getString("order_status"),
	                        rs.getTimestamp("order_time")
	                    ));
					}
					
	                    else {
	                        for (int i = 0; i < list.size(); i++) {
	                            if (list.get(i).getId() == order_id) {
	                                list.get(i).food_items.add(food_item_to_add);
	                            }
	                        }
	                    }
	                }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	

	@Override
	public Optional<Orders> get(int id) {
		
		Optional<Orders> toRet = Optional.empty();
        Database db = new Database();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("SELECT * FROM orders INNER JOIN order_foods INNER JOIN Food_Items WHERE orders.order_id = ? AND order_foods.order_foods_id = ? AND order_foods.food_id = Food_Items.ID");
            pstmt.setInt(1, id);
            pstmt.setInt(2, id);
            ResultSet rs = pstmt.executeQuery();

            boolean createdNewOrder = false;
            Orders newOrder = null;
            if (rs.next()) {
                
            	FoodEntries foodItemToAdd = new FoodEntries(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("imageURL"),
                    rs.getString("description"), 
                    (double) rs.getFloat("price")
                );

                if (!createdNewOrder) {
                    List<FoodEntries> listOfFoodItems = new ArrayList<FoodEntries>();
                    listOfFoodItems.add(foodItemToAdd);
                    newOrder = new Orders(rs.getInt("order_id"),
                                            listOfFoodItems,
                                            rs.getString("customer_name"),
                                            rs.getString("order_status"),
                                            rs.getTimestamp("order_time")
                                            );
                    createdNewOrder = true;
                } else {
                    newOrder.food_items.add(foodItemToAdd);
                }

                toRet = Optional.of(newOrder);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toRet;
	}

	@Override
	public void add(Orders obj) {
		Database db = new Database();
        try (Connection c = db.connection()) {

            // insert into ORDERS table
            PreparedStatement pstmt = c.prepareStatement("INSERT INTO orders (order_id, customer_name, order_status, order_time) VALUES (?, ?, ?, ?)");
            pstmt.setInt(1, obj.getId());
            pstmt.setString(2, obj.getCustomerName());
            pstmt.setString(3, obj.getStatus());
            pstmt.setTimestamp(4, getSQLDate(obj.getOrderTime()));
            pstmt.executeUpdate();

            // for each food item in the order, insert one line into ORDER_FOODS table
            for (int i = 0; i < obj.getFoodItems().size(); i++) {
                pstmt = c.prepareStatement("INSERT INTO order_foods (order_foods_id, food_id, food_quantity) VALUES (?, ?, ?)");
                pstmt.setInt(1, obj.getId());
                pstmt.setInt(2, obj.getFoodItems().get(i).getID());
                //pstmt.setInt(3, obj.getItems().get(i).getQuantity());
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	private static java.sql.Timestamp getSQLDate(java.util.Date date) {
        return new java.sql.Timestamp(date.getTime());
}

	public int getNextOrderId(){
		Database db=new Database();
		int highest=1;
		try(Connection c=db.connection()){
			Statement stmt=c.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT max(order_id) FROM orders;");
			while(rs.next()){
				highest=rs.getInt("max(order_id)");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return highest+1;
	}


	@Override
	public void update(Orders obj) {
		 Database db = new Database();
	        try (Connection c = db.connection()) {
	            PreparedStatement pstmt = c.prepareStatement("UPDATE orders SET order_id = ?, customer_name = ?, order_status = ?, order_time = ? WHERE order_id = ?");
	            pstmt.setInt(1, obj.getId());
	            pstmt.setString(2, obj.getCustomerName());
	            pstmt.setString(3, obj.getStatus());
	            pstmt.setTimestamp(4, getSQLDate(obj.getOrderTime()));
	            pstmt.setInt(5, obj.getId());
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	}
		
	}

	@Override
	public void delete(int id) {
		 Database db = new Database();
	        try (Connection c = db.connection()) {
	            PreparedStatement pstmt = c.prepareStatement("DELETE FROM orders WHERE orders.order_id = ? ");
	            pstmt.setInt(1, id);
	            pstmt.executeUpdate();

	            pstmt = c.prepareStatement("DELETE FROM order_foods WHERE order_foods.order_foods_id = ? ");
	            pstmt.setInt(1, id);
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}
		
	}

	


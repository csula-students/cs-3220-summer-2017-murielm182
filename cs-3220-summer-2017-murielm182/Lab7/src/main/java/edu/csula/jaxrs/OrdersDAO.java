package edu.csula.jaxrs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

//import javax.sql.DataSource;

import java.util.ArrayList;
import edu.csula.jaxrs.models.Orders;

public class OrdersDAO implements ResourceDAO<Orders>{

    public List<Orders> list() {
        List<Orders> list = new ArrayList<>();
       ResourceDatabase db = new ResourceDatabase();
        try (Connection c = db.connection()) {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM orders ;");
            while (rs.next()) {
                    list.add(new Orders(
                       rs.getInt("order_id"), 
                        rs.getString("customer_name"),
                        rs.getString("status")
                    ));
                } 

               
            

        } catch (SQLException e) {
            e.printStackTrace();
            return list;
        }
        return list;
    }
    

    
    
    public Optional<Orders> get(int id) {
        Optional<Orders> lab7items = Optional.empty();
        ResourceDatabase db = new ResourceDatabase();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("SELECT * FROM orders where order_id=?");
            pstmt.setInt(1, id);
          
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
               
                 Orders   order = new Orders(rs.getInt("order_id"),
                                            rs.getString("customer_name"),
                                            rs.getString("status")
                                            );
                

                lab7items = Optional.of(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lab7items;
    }
    
    
    
    public void add(Orders order) {

        ResourceDatabase db = new ResourceDatabase();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("INSERT INTO orders (order_id, customer_name, status) VALUES (?, ?, ?)");
            pstmt.setInt(1, order.getId());
            pstmt.setString(2, order.getcustomer_name());
            pstmt.setString(3, order.getStatus());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
    public void update(Orders order) {
        ResourceDatabase db = new ResourceDatabase();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("UPDATE orders SET order_id = ?, customer_name = ?, status = ? WHERE order_id = ?");
            pstmt.setInt(1, order.getId());
            pstmt.setString(2, order.getcustomer_name());
            pstmt.setString(3, order.getStatus());
            pstmt.setInt(4, order.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
    ResourceDatabase db = new ResourceDatabase();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("DELETE FROM orders WHERE orders.order_id = ? ");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
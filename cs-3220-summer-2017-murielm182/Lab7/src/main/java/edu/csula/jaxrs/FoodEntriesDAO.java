package edu.csula.jaxrs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import edu.csula.jaxrs.models.FoodEntries;

public class FoodEntriesDAO implements ResourceDAO<FoodEntries> {
    public List<FoodEntries> list() {
        List<FoodEntries> list = new ArrayList<>();
        ResourceDatabase db = new ResourceDatabase();
        try (Connection c = db.connection()) {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM menu");
            while (rs.next()) {
                list.add(new FoodEntries(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getString("imagURL"),
                 rs.getDouble("price")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return list;
        }
        return list;
    }

    public Optional<FoodEntries> get(int id) {
        Optional<FoodEntries> items = Optional.empty();
        ResourceDatabase db = new ResourceDatabase();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("SELECT * FROM menu WHERE menu.id=?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
            	FoodEntries foodToEdit = new FoodEntries(rs.getInt("id"),
                                                    rs.getString("name"),
                                                    rs.getString("description"),
                                                    rs.getString("imagURL"),
                                                     rs.getDouble("price"));
                items = Optional.of(foodToEdit);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    public void add(FoodEntries obj) {
        ResourceDatabase db = new ResourceDatabase();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("INSERT INTO menu (id, name, description, imagURL, price) VALUES (?, ?, ?, ?, ?)");
            pstmt.setInt(1, obj.getID());
            pstmt.setString(2, obj.getName());
            pstmt.setString(3, obj.getDescription());
            pstmt.setString(4, obj.getImageURL());
            pstmt.setDouble(5,  obj.getPrice());
           
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(FoodEntries obj) {
      ResourceDatabase db = new ResourceDatabase();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("UPDATE menu SET id = ?, name = ?, description = ?, imagURL = ?, price = ? WHERE id = ?");
            pstmt.setInt(1, obj.getID());
            pstmt.setString(2, obj.getName());
            pstmt.setString(3, obj.getDescription());
            pstmt.setString(4, obj.getImageURL());
            pstmt.setDouble(5,  obj.getPrice());
            pstmt.setInt(6, obj.getID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        ResourceDatabase db = new ResourceDatabase();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("DELETE FROM menu WHERE menu.id = ?");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
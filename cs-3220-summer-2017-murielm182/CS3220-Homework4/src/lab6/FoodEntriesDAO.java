package lab6;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FoodEntriesDAO implements DAO<FoodEntries> {
	
	public FoodEntriesDAO()
	{
		
	}

	@Override
	public List<FoodEntries> list() {
		List<FoodEntries> list = new ArrayList<>();
		Database db = new Database();
		try (Connection c = db.connection()) {
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM food_items");
			while (rs.next()) {
				list.add(new FoodEntries(rs.getInt("id"), rs.getString("name"), rs.getString("imageURL"),
						rs.getString("description"), rs.getDouble("price")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
		return list;
	}

	@Override
	public Optional<FoodEntries> get(int id) {
		Optional<FoodEntries> toReturn = Optional.empty();
        Database db = new Database();
        try (Connection c = db.connection()) {
            PreparedStatement pst = c.prepareStatement("SELECT * FROM food_items WHERE id = ? ");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
            	FoodEntries edit = new FoodEntries(rs.getInt("id"),
                                                    rs.getString("name"),
                                                    rs.getString("imageURL"),
                                                    rs.getString("description"),
                                                    (double) rs.getFloat("price"));
                toReturn = Optional.of(edit);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toReturn;
	}

	@Override
	public void add(FoodEntries entry) {
		Database db = new Database();
		try (Connection c = db.connection()) {
			PreparedStatement pst = c
					.prepareStatement("INSERT INTO food_items(id,name,imageURL,description,price) VALUES (?,?,?,?,?)");
			pst.setInt(1, entry.getID());
			pst.setString(2, entry.getName());
			pst.setString(3, entry.getImageURL());
			pst.setString(4, entry.getDescription());
			pst.setDouble(5, entry.getPrice());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	@Override
	public void update(FoodEntries entry) {
		Database db = new Database();
		try (Connection c = db.connection()) {
			PreparedStatement pst = c
					.prepareStatement("UPDATE food_items SET id=?,name?,imageURL=?,description=?,price? WHERE id=? ");
			pst.setInt(1, entry.getID());
			pst.setString(2, entry.getName());
			pst.setString(3, entry.getImageURL());
			pst.setString(4, entry.getDescription());
			pst.setDouble(5, entry.getPrice());
			pst.setInt(6, entry.getID());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	@Override
	public void delete(int id) {
		Database db = new Database();
		try (Connection c = db.connection()) {
			PreparedStatement pst = c.prepareStatement("DELETE FROM food_items WHERE id=?");
			pst.setInt(1, id);

			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

}

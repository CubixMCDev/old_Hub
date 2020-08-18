package eu.cubix.mc.hub.manager;

import eu.cubix.mc.hub.Main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class CosmeticsManager {

    Main main;

    public CosmeticsManager(Main main) {
        this.main = main;
    }

    public void setCosmeticSQL(String name, boolean trueOrFalse, UUID playerUUID) {
        /*
        try {
            PreparedStatement q = (PreparedStatement) main.getAPI().get().getDataBase().getConnection().prepareStatement("UPDATE cosmetics SET " + name + " = ? WHERE uuid = ?");
            q.setInt(1, trueOrFalse ? 1 : 0);
            q.setString(2, playerUUID.toString());
            q.executeUpdate();
            q.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        */
    }

    public boolean hasCosmetic(String name, UUID playerUUID) {
        /*
        try {
            PreparedStatement q = (PreparedStatement) main.getAPI().getDatabase().getConnection().prepareStatement("SELECT " + name + " FROM cosmetics WHERE uuid = ?");
            q.setString(1, playerUUID.toString());

            int awnser = 0;
            ResultSet rs = q.executeQuery();

            while(rs.next()){
                awnser = rs.getInt(name);
            }

            q.close();

            if(awnser == 1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */
        return false;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import clinic.RegPatient;
import database.DBServices;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
 
/**
 *
 * @author Hadi
 */
public class SearchModal {
    private static DBServices obj;
    private PreparedStatement statment;
    private ResultSet result;
    public SearchModal() {
    }
    
    public void DBConnection(){
            try {
                obj = DBServices.getInstance();
                statment = obj.getConnection().prepareStatement("SELECT COUNT(*) FROM Patient where Name =?");
//                ResultSet result = statment.executeQuery();
//                while (result.next()) {
//                    int tmp = result.getInt(1) + 1;
//                }
            } catch (SQLException ex) {
                Logger.getLogger(SearchModal.class.getName()).log(Level.SEVERE, null, ex);
            }    
    }

    public ResultSet search(String q){
        try {
            statment.setString(0, q);
            statment.setString(1, q);
            result = statment.executeQuery();
            return result; 
        } catch (SQLException ex) {
            Logger.getLogger(SearchModal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
            
}

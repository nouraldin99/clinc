package MVC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hadi
 */
public class SearchController {
    
    private SearchModal searchModal;
    private SearchView  searchView;
    
    public SearchController(){
        searchView      = new SearchView();
        searchModal     = new SearchModal();
        searchView.setVisible(true);
    }
    
    public String search(String query){
        try {
            String strTemp = "";
            ResultSet rs = searchModal.search(query);
            while (rs.next()) {
                strTemp += rs.getString(1);
                System.out.println(strTemp);
            }
            return strTemp;
        } catch (SQLException ex) {
            Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Not found";
    }
    
    public void doSearch(){

        System.out.println("Btn Preased");
        String s = search(searchView.getTextSearch());
        searchView.setResultSearch(s);
    
    }
}
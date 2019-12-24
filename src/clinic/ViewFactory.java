/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinic;

import MVC.SearchController;

/**
 *
 * @author tsc
 */
public class ViewFactory {

    private static ViewFactory viewFact;
    HomePage homepage;
    Appoint appoint;
    RegPatient regPatient;
    Login login ;
    SearchController searchController;
    private ViewFactory() {
//        homepage = new HomePage();
//        appoint = new Appoint();
//        regPatient = new RegPatient();
    }

    public static ViewFactory getViewFactory() {
        if (viewFact == null) {
            viewFact = new ViewFactory();
        }
        return viewFact;
    }

    public void getView(String viewName) {
        if (viewName.equalsIgnoreCase("login")) {
            login = new Login();
            login.setVisible(true);
        }
        else if (viewName.equalsIgnoreCase("homePage")) {
            homepage = new HomePage();
            homepage.setVisible(true);
            login.setVisible(false);
            login.dispose();
        }
        else if (viewName.equalsIgnoreCase("appoint")) {
            appoint = new Appoint();
            appoint.setVisible(true);
            homepage.setVisible(false);
            homepage.dispose();
        } else if (viewName.equalsIgnoreCase("regpatient")) {
            regPatient = new RegPatient();
            regPatient.setVisible(true);
            homepage.setVisible(false);
            homepage.dispose();
            
        } else if (viewName.equalsIgnoreCase("report")) {

        } else {
            searchController = new SearchController();
            homepage.setVisible(false);
            homepage.dispose();
        }
    }
}

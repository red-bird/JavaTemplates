package Lesson8;

import Lesson8.Iterator.NotificationBar;
import Lesson8.Iterator.NotificationCollection;
import Lesson8.Mediator.*;

public class Main {
    public static void main(String[] args) {

        //Iterator

        NotificationCollection nc = new NotificationCollection();
        NotificationBar nb = new NotificationBar(nc);
        nb.printNotifications();

        System.out.println("---------------");



        // Mediator

        /// go to login page
        Mediator auth = new AuthenticationDialog();
        ((Checkbox)auth.getCheckbox()).setCheck(true);
        ((Button)auth.getLogButton()).click();
        System.out.println("---------------");

        /// wrong username and password
        ((Button)auth.getOkButton()).click();
        System.out.println("---------------");

        /// login success
        ((Textbox)auth.getLoginUsername()).setText("admin");
        ((Textbox)auth.getLoginPassword()).setText("admin");
        ((Button)auth.getOkButton()).click();
        System.out.println("---------------");

        ///Registration
        ((Button)auth.getRegButton()).click();        ((Button)auth.getOkButton()).click();
        System.out.println("---------------");
    }
}

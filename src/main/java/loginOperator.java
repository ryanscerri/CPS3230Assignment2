//import javax.swing.text.View;
//
//public class loginOperator {
//
//        private boolean loggedin = false, loggedout = false, ViewingAlerts = false;
//
//        boolean incorrectLogin() {
//            if ((loggedin == false) && (ViewingAlerts == false))
//            {
//                loggedout = true;
//                return true;
//            } else {
//                throw new IllegalStateException();
//            }
//        }
//
//        boolean CorrectLogin() {
//            if ((loggedout == false))
//            {
//
//                loggedin = true;
//                return true;
//
//            } else {
//                throw new IllegalStateException();
//            }
//
//        }
//
//        boolean ViewingAlerts() {
//            if ((loggedin == true) && (loggedout == false))
//            {
//                loggedin = true;
//                ViewingAlerts = true;
//                return true;
//
//            } else {
//                throw new IllegalStateException();
//            }
//
//        }
//
//        boolean LogOut(){
//
//            if((loggedin == true) || (ViewingAlerts == true)){
//                loggedout = true;
//                return true;
//            } else {
//                throw new IllegalStateException();
//            }
//
//        }
//
//        boolean isLoggedout() {
//            return loggedout;
//        }
//
//        boolean isLoggedin() {
//            return loggedin;
//        }
//
//        boolean isViewingAlerts() {
//            return ViewingAlerts;
//        }
//
//        /**
//         *
//         * @return false if zero or one variable is true. true otherwise
//         */
////        boolean onlyLoggedOutTrue() {
////            if (loggedout == true) {
////
////                return loggedin = false;
////
////            } else {
////
////                return loggedin = true;
////            }
////        }
////
////        boolean isLoggedIn() {
////            return loggedin || loggedout || ViewingAlerts;
////        }
//
//    /*public static void main(String[] args) {
//	final Scanner sc = new Scanner(System.in);
//        final BulbOperator bulbOperator = new BulbOperator();
//
//        System.out.println("---BULB MANAGER---");
//        int choice;
//        do{
//            System.out.println("Chose an option to control your bulb.");
//            System.out.println("1. Turn on bulb.");
//            System.out.println("2. Turn off bulb.");
//            System.out.println("3. Increase brightness.");
//            System.out.println("4. Decrease brightness.");
//            System.out.println("5. Exit.");
//            choice = sc.nextInt();
//            switch(choice){
//                case 1:
//                    if(bulbOperator.turnOn()){
//                        System.out.println("Bulb turned on.");
//                    } else {
//                        System.out.println("Cannot turn on bulb now.");
//                    }
//                    break;
//                case 2:
//                    if(bulbOperator.turnOff()){
//                        System.out.println("Bulb turned off.");
//                    } else {
//                        System.out.println("Bulb can't be turned off now.");
//                    }
//                    break;
//                case 3:
//                    if(bulbOperator.increaseBrightness()){
//                        System.out.println("Bulb brightness increased.");
//                    } else {
//                        System.out.println("Can't increase bulb brightness.");
//                    }
//                    break;
//                case 4:
//                    if(bulbOperator.decreaseBrightness()){
//                        System.out.println("Bulb brightness decreased.");
//                    } else {
//                        System.out.println("Can't decrease bulb brightness.");
//                    }
//                    break;
//                case 5:
//                    System.out.println("Bye.");
//                    break;
//                default:
//                    System.out.println("Incorrect option chosen.");
//            }
//        } while(choice != 5);
//    }*/
//    }

import javax.swing.text.View;
import java.util.IllegalFormatException;

public class loginOperator
{
    boolean LoggedOut = false;
    boolean LoggedIn = false;
    boolean ViewingAlerts = false;

    boolean IncorrectLogin()
    {
        if((LoggedIn == false) && (ViewingAlerts == false))
        {
            LoggedOut = true;
            return true;
        }
        else
        {
            throw new IllegalStateException();
        }
    }

    boolean CorrectLogin()
    {
        if((LoggedOut == false))
        {
            LoggedIn = true;
            return true;
        }
        else
        {
            throw new IllegalStateException();
        }
    }

    boolean ViewingAlerts()
    {
        if((LoggedIn == true) && (LoggedOut == false)) //&& (ViewingAlerts == true)
        {
            LoggedIn = true;
            ViewingAlerts = true;
            return true;
        }
        else
        {
            throw new IllegalStateException();
        }
    }

    boolean LogOut()
    {
        if((LoggedIn == true) || (ViewingAlerts == true))
        {
            LoggedOut = true;
            return true;
        }
        else
        {
            throw new IllegalStateException();
        }
    }

    boolean isLoggedOut() {return LoggedOut;}
    boolean isLoggedIn() {return LoggedIn;}
    boolean isViewingAlerts() {return ViewingAlerts;}

}
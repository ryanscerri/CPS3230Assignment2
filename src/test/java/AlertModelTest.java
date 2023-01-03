//import nz.ac.waikato.modeljunit.Action;
//import nz.ac.waikato.modeljunit.FsmModel;
//import nz.ac.waikato.modeljunit.GreedyTester;
//import nz.ac.waikato.modeljunit.StopOnFailureListener;
//import nz.ac.waikato.modeljunit.coverage.ActionCoverage;
//import nz.ac.waikato.modeljunit.coverage.StateCoverage;
//import nz.ac.waikato.modeljunit.coverage.TransitionPairCoverage;
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.Random;
//
//
//public class loginModelTest implements FsmModel {
//
//    private loginOperator systemUnderTest = new loginOperator();
//    private loginStateEnum StateEnum = loginStateEnum.loggedOut;
//    private boolean loggedin = false;
//    private boolean loggedout = false;
//    private boolean ViewingAlerts = false;
//
//    @Override
//    public loginStateEnum getState() {
//        return StateEnum;
//    }
//
//    @Override
//    public void reset(final boolean b) {
//
//        if(b) {
//
//            systemUnderTest = new loginOperator();
//        }
//
//        StateEnum = loginStateEnum.LoggingIn;
//        loggedin = false;
//        loggedout = false;
//        ViewingAlerts = false;
//    }
//
//    //method Implementation
//    public boolean IncorrectLoginGuard() {return getState().equals(loginStateEnum.LoggingIn);}
//    public @Action void incorrectLogIn(){
//
//        systemUnderTest.incorrectLogin();
//        StateEnum = loginStateEnum.BadLogin;
//        loggedout = true;
//
//        Assert.assertEquals(loggedout, systemUnderTest.isLoggedout());
//    }
//
//    public boolean correctLoginGuard() {return getState().equals(loginStateEnum.LoggingIn);}
//    public @Action void correctLogIn(){
//
//        systemUnderTest.CorrectLogin();
//        StateEnum = loginStateEnum.loggedIn;
//        loggedin = true;
//
//        Assert.assertEquals(loggedin, systemUnderTest.isLoggedin());
//    }
//
//    public boolean ViewAlertsGuard() {return getState().equals(loginStateEnum.loggedIn);}
//    public @Action void ViewAlerts(){
//
//        systemUnderTest.ViewingAlerts();
//        StateEnum = loginStateEnum.ViewingAlerts;
//        ViewingAlerts = true;
//
//        Assert.assertEquals(ViewingAlerts, systemUnderTest.isViewingAlerts());
//}
//
//    public boolean LogOutGuard() {return getState().equals(loginStateEnum.loggedIn) || getState().equals(loginStateEnum.ViewingAlerts);}
//    public @Action void LogOut(){
//
//        systemUnderTest.LogOut();
//        StateEnum = loginStateEnum.loggedOut;
//        loggedout = true;
//
//        Assert.assertEquals(loggedout, systemUnderTest.isLoggedout());
//    }
//
//    @Test
//    public void BulbOperatorModelRunner() {
//        final GreedyTester tester = new GreedyTester(new loginModelTest()); //Creates a test generator that can generate random walks. A greedy random walk gives preference to transitions that have never been taken before. Once all transitions out of a state have been taken, it behaves the same as a random walk.
//        tester.setRandom(new Random()); //Allows for a random path each time the model is run.
//        tester.buildGraph(); //Builds a model of our FSM to ensure that the coverage metrics are correct.
//        tester.addListener(new StopOnFailureListener()); //This listener forces the test class to stop running as soon as a failure is encountered in the model.
//        tester.addListener("verbose"); //This gives you printed statements of the transitions being performed along with the source and destination states.
//        tester.addCoverageMetric(new TransitionPairCoverage()); //Records the transition pair coverage i.e. the number of paired transitions traversed during the execution of the test.
//        tester.addCoverageMetric(new StateCoverage()); //Records the state coverage i.e. the number of states which have been visited during the execution of the test.
//        tester.addCoverageMetric(new ActionCoverage()); //Records the number of @Action methods which have ben executed during the execution of the test.
//        tester.generate(500); //Generates 500 transitions
//        tester.printCoverage(); //Prints the coverage metrics specified above.
//    }
//
//
//
//
//
//
// }

import junit.framework.Assert;
import nz.ac.waikato.modeljunit.Action;
import nz.ac.waikato.modeljunit.FsmModel;
import nz.ac.waikato.modeljunit.GreedyTester;
import nz.ac.waikato.modeljunit.StopOnFailureListener;
import nz.ac.waikato.modeljunit.coverage.ActionCoverage;
import nz.ac.waikato.modeljunit.coverage.StateCoverage;
import nz.ac.waikato.modeljunit.coverage.TransitionPairCoverage;
import org.junit.Test;

import java.util.Random;

public class AlertModelTest implements FsmModel
{
    private AlertsOperator systemUnderTest = new AlertsOperator();

    private AlertStateEnum modelAlerts = AlertStateEnum.ViewingAlerts;
    private boolean CorrectNumberOfDeleteAndAlerts = false;
    private boolean CheckProperties = false;
    private boolean ContainsInfo = false;

    @Override
    public AlertStateEnum getState() {
        return modelAlerts;
    }

    @Override
    public void reset(final boolean b)
    {
        if (b)
        {
            systemUnderTest = new AlertsOperator();
        }
        modelAlerts = AlertStateEnum.ViewingAlerts;
        CorrectNumberOfDeleteAndAlerts = false;
        CheckProperties = false;
        ContainsInfo = false;
    }

    public boolean CorrectNumberOfAlertsAndDeletesGuard() {return getState().equals(AlertStateEnum.ViewingAlerts);}
    public @Action void CorrectNumberOfAlertsAndDeletes() {

        systemUnderTest.DeleteAndPostedSuccesfully();

        modelAlerts = AlertStateEnum.CorrectNumberOfDeleteAndAlerts;
        CorrectNumberOfDeleteAndAlerts = true;

        Assert.assertEquals( CorrectNumberOfDeleteAndAlerts , systemUnderTest.isCorrectNumberOfDeleteAndAlerts());
    }

    public boolean IncorrectNumberOfAlertsAndDeletesGuard() {return getState().equals(AlertStateEnum.ViewingAlerts);}
    public @Action void IncorrectNumberOfAlertsAndDeletes() {

        systemUnderTest.DeleteAndPostedUnsuccesfully();

        modelAlerts = AlertStateEnum.IncorrectNumberOfDeleteAlerts;
        CorrectNumberOfDeleteAndAlerts = false;

        Assert.assertEquals(CorrectNumberOfDeleteAndAlerts , systemUnderTest.isCorrectNumberOfDeleteAndAlerts());
    }

    public boolean CheckingPropertiesGuard() {return getState().equals(AlertStateEnum.CorrectNumberOfDeleteAndAlerts);}
    public @Action void CheckingProperties() {

        systemUnderTest.CheckAlertProperties();

        modelAlerts = AlertStateEnum.CheckingProperties;
        CheckProperties = true;

        Assert.assertEquals(CheckProperties , systemUnderTest.isCheckingProperties());
    }

    public boolean ContainsInfoGuard() {return getState().equals(AlertStateEnum.CheckingProperties);}
    public @Action void ContainsInfo() {

        systemUnderTest.ContainsAllInfo();

        modelAlerts = AlertStateEnum.ContainsAllInfo;
        ContainsInfo = true;

        Assert.assertEquals(ContainsInfo , systemUnderTest.isContainsInfo());
    }

    public boolean MissingInfoGuard() {return getState().equals(AlertStateEnum.CheckingProperties);}
    public @Action void MissingInfo() {

        systemUnderTest.MissingInfo();

        modelAlerts = AlertStateEnum.MissingInfo;
        ContainsInfo = false;

        Assert.assertEquals(ContainsInfo , systemUnderTest.isContainsInfo());
    }




    @Test
    public void LoginModelTest() {
        final GreedyTester tester = new GreedyTester(new AlertModelTest()); //Creates a test generator that can generate random walks. A greedy random walk gives preference to transitions that have never been taken before. Once all transitions out of a state have been taken, it behaves the same as a random walk.
        tester.setRandom(new Random()); //Allows for a random path each time the model is run.
        tester.buildGraph(); //Builds a model of our FSM to ensure that the coverage metrics are correct.
        tester.addListener(new StopOnFailureListener()); //This listener forces the test class to stop running as soon as a failure is encountered in the model.
        tester.addListener("verbose"); //This gives you printed statements of the transitions being performed along with the source and destination states.
        tester.addCoverageMetric(new TransitionPairCoverage()); //Records the transition pair coverage i.e. the number of paired transitions traversed during the execution of the test.
        tester.addCoverageMetric(new StateCoverage()); //Records the state coverage i.e. the number of states which have been visited during the execution of the test.
        tester.addCoverageMetric(new ActionCoverage()); //Records the number of @Action methods which have ben executed during the execution of the test.
        tester.generate(500); //Generates 500 transitions
        tester.printCoverage(); //Prints the coverage metrics specified above.
    }
}

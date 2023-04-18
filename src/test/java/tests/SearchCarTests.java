package tests;

import org.testng.Assert;

public class SearchCarTests extends TestBase{

    public void searchCurrentSuccess(){
        app.getHelperCar().searchCurrentMonth("Tel Aviv, Israel","4/25/2023","4/28/2023");
        app.getHelperCar().submit();
        //Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());
    }
}

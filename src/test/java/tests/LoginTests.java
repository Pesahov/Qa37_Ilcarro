package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }
    @Test
    public void loginSuccess1(){

        User user = new User().setEmail("shilol@gmail.com").setPassword("Shilol12345$");

        logger.info("Test start with test data --->" + user.toString());
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        //Assert if element with text "Logged in success" is present
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");


    }

    @Test
    public void loginSuccess(){
        logger.info("Test start with test data --->/n" + "email : 'shilol@gmail.com' & password : 'Shilol12345$'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("shilol@gmail.com","Shilol12345$");
        app.getHelperUser().submit();
        //Assert if element with text "Logged in success" is present
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");

    }
    @Test
    public void loginSuccessModel(){
        logger.info("Test start with test data --->/n" + "email : 'shilol@gmail.com' & password : 'Shilol12345$'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("shilol@gmail.com","Shilol12345$");
        app.getHelperUser().submit();
        //Assert if element with text "Logged in success" is present
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");

    }
    @Test
    public void loginWrongEmail(){
        logger.info("Test negative check if it possible to login with wrong format email ");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("","Shilol12345$");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(),"It'snot look like email");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
    }
    @Test
    public void loginWrongPassword(){
        logger.info("Test negative check if it possible to login with wrong format password ");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("shilol@gmail.com","Shilol12");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"\"Login or Password incorrect\"");
    }
    @Test
    public void loginUnregistered(){
        logger.info("Test negative check if it possible to login with valid format data unregistered user ");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("lucky@gmail.com","lucky12345$");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"\"Login or Password incorrect\"");
    }
    @AfterMethod
    public void postCondition(){
        app.getHelperUser().closeWindow();
    }

}
//app.getHelperUser().fillLoginForm("shilol@gmail.com", "Shilol12345$");
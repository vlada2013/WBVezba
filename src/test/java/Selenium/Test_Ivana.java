package Selenium;

import org.testng.annotations.Test;

public class Test_Ivana {

    @Test
    public void objectActions()

    {
        Objects_Ivana pageObject = new Objects_Ivana();
        pageObject.titleTextCheck();
        pageObject.radioButtonAction();
        pageObject.autocompleteAction();
        pageObject.checkboxAction();
        pageObject.dropdownAction();
        pageObject.mouseHoverAction();
        //pageObject.closeWindow();
    }
}

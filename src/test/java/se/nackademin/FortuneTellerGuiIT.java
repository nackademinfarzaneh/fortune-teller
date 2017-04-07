package se.nackademin;

import java.awt.event.ActionEvent;
import javax.swing.JButton;

import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.edt.GuiQuery;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import se.nackademin.gui.FortuneTellerGui;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;

public class FortuneTellerGuiIT {

    FortuneTeller fortuneTeller;
    FortuneTellerGui fortuneTellerGui;//= new FortuneTellerGui(fortuneTeller);

    @Test(timeout = 10000)
    public void testGetFortuneUsingGui() {
        window.textBox("nameField").enterText("Sture Hagfors");
        window.textBox("incomeField").enterText("11000");
        window.textBox("locationField").enterText("Hagfors");
        window.textBox("ageField").enterText("16");
        window.textBox("heightField").enterText("165");
        window.button("calculateButton").click();
        String output = window.textBox("resultField").text();

        assertEquals("Verify that the fortune is calculated correctly", "Din framtid är mjuk. Du borde sluta se. Vi ser att du snart kommer att skaffa en fotboja. Snart kommer du vilja mäta, men då är det viktigt att du är mörk.", output);

    }

    @Test(timeout = 10000)
    public void testCalculateButtonIsClicked() {

        JButton button = new JButton();
        ActionEvent actionEvent = new ActionEvent(button, 0, "");
        fortuneTellerGui.actionPerformed(actionEvent);

        window.textBox("nameField").enterText("Sture Hagfors");
        window.textBox("incomeField").enterText("11000");
        window.textBox("locationField").enterText("Hagfors");
        window.textBox("ageField").enterText("16");
        window.textBox("heightField").enterText("165");
        window.button("calculateButton").click();

        boolean b = actionEvent.getSource().getClass().equals(JButton.class);
        Assert.assertTrue(b);

    }

    @Test(timeout = 10000)
    public void testInvalidIncome() {
        window.textBox("nameField").enterText("Sture Hagfors");
        window.textBox("incomeField").enterText("hej");
        window.textBox("locationField").enterText("Hagfors");
        window.textBox("ageField").enterText("16");
        window.textBox("heightField").enterText("165");
        window.button("calculateButton").click();
        String errorMessage = window.optionPane().label("OptionPane.label").text();
        assertThat("error message should contain text 'Invalid income'", errorMessage, containsString("Invalid income"));
        window.optionPane().button().click();
    }

    @Test(timeout = 10000)
    public void testInvalidName() {
        window.textBox("nameField").enterText("");
        window.textBox("incomeField").enterText("10000");
        window.textBox("locationField").enterText("Hagfors");
        window.textBox("ageField").enterText("16");
        window.textBox("heightField").enterText("165");
        window.button("calculateButton").click();
        String errorMessage = window.optionPane().label("OptionPane.label").text();
        assertThat("error message should contain text 'Invalid name'", errorMessage, containsString("Invalid name"));
        window.optionPane().button().click();
    }

    @Test(timeout = 10000)
    public void testInvalidLocation() {
        window.textBox("nameField").enterText("Sture Hagfors");
        window.textBox("incomeField").enterText("10000");
        window.textBox("locationField").enterText("");
        window.textBox("ageField").enterText("27");
        window.textBox("heightField").enterText("165");
        window.button("calculateButton").click();
        String errorMessage = window.optionPane().label("OptionPane.label").text();
        assertThat("error message should contain text 'Invalid location'", errorMessage, containsString("Invalid location"));
        window.optionPane().button().click();
    }

    @Test(timeout = 10000)
    public void testInvalidAge() {
        window.textBox("nameField").enterText("Sture Hagfors");
        window.textBox("incomeField").enterText("10000");
        window.textBox("locationField").enterText("Hagfors");
        window.textBox("ageField").enterText("");
        window.textBox("heightField").enterText("165");
        window.button("calculateButton").click();
        String errorMessage = window.optionPane().label("OptionPane.label").text();
        assertThat("error message should contain text 'Invalid age'", errorMessage, containsString("Invalid age"));
        window.optionPane().button().click();
    }

    @Test(timeout = 10000)
    public void testInvalidHeight() {
        window.textBox("nameField").enterText("Sture Hagfors");
        window.textBox("incomeField").enterText("10000");
        window.textBox("locationField").enterText("Hagfors");
        window.textBox("ageField").enterText("20");
        window.textBox("heightField").enterText("");
        window.button("calculateButton").click();
        String errorMessage = window.optionPane().label("OptionPane.label").text();
        assertThat("error message should contain text 'Invalid height'", errorMessage, containsString("Invalid height"));
        window.optionPane().button().click();
    }

    private FrameFixture window;

    @BeforeClass
    public static void setUpOnce() {
        // FailOnThreadViolationRepaintManager.install();
    }

    @Before
    public void setUp() {
        fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        fortuneTellerGui = GuiActionRunner.execute(new GuiQuery<FortuneTellerGui>() {
            protected FortuneTellerGui executeInEDT() {
                return new FortuneTellerGui(fortuneTeller);
            }
        });
        window = new FrameFixture(fortuneTellerGui);
        window.show();
    }

    @After
    public void tearDown() {
        window.cleanUp();
    }

}

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RetirePlanGUITest {

    private RetirePlanGUI retirePlanGUI;

    @BeforeEach
    public void setUp() {
        
        retirePlanGUI = new RetirePlanGUI();
    }

    @Test
    public void testActionPerformedWithLowIncome() {
        
        retirePlanGUI.incomeField.setText("2500");
        
        
        retirePlanGUI.actionPerformed(null);
        
        
        assertEquals("you cannot afford to live alone", retirePlanGUI.balanceLabel.getText());
    }

    @Test
    public void testActionPerformedWithHighIncome() {
        
        retirePlanGUI.incomeField.setText("5000");
        
        
        retirePlanGUI.actionPerformed(null);
        
        
        String expected = "Budget Sheet: \nRent: $1250.0\nUtilities: $412.5\nInsurance: $200.0\nGroceries: $500.0\nPhone: $100.0\nCar: $253.75\nSave: $513.84375\nMoney to Spend: $570.9375\nRetirement: $1198.96875";
        assertEquals(expected, retirePlanGUI.balanceLabel.getText());
    }

    @Test
    public void testActionPerformedWithInvalidInput() {
        
        retirePlanGUI.incomeField.setText("abc");
        
        
        retirePlanGUI.actionPerformed(null);
        
        
        assertEquals("Please enter valid numbers.", retirePlanGUI.balanceLabel.getText());
    }
}


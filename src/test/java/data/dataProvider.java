package data;

import org.testng.annotations.DataProvider;

public class dataProvider {
    @DataProvider(name = "SingleColumn")
    public Object[][] storeSingleColumnValue(){
        return new Object[][]{
                {"Sazzad"},
                {"Vai"},
                {"Kemon Asen"}
        };
    }
}

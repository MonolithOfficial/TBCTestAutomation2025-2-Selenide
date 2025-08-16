package ge.tbc.testautomation.data;

import org.testng.annotations.DataProvider;

public class DataSupplier {
    @DataProvider(name = "SwoopDataProvider")
    public static Object[][] swoopDataProvider(){
        return new Object[][]{
                {"კინო", "კინოთეატრი"},
                {"დასვენება", "დასვენება"},
                {"აუზი", "საცურაო აუზი"},
                {"გართობა", "გართობა"},
                {"კვება", "კვება"},
                {"საბავშვო", "საბავშვო"},
                {"სპორტი", "სპორტი"},
        };
    }
}

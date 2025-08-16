package ge.tbc.testautomation.tests;

import org.testng.annotations.Factory;

public class ParametrizedClassExecutorTest {
    @Factory
    public Object[] languageFactory(){
        return new Object[]{
              new ParametrizedTestClass("GE"),
              new ParametrizedTestClass("EN")
        };
    }
}

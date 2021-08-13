package web.app.TechStore.TechStore;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@ApplicationScoped
public class TestServiceOne {

    private TestServiceTwo serviceTwo;

    @Inject
    public TestServiceOne(TestServiceTwo serviceTwo) {
        this.serviceTwo = serviceTwo;
    }


    public String greetingFromServiceOne() {
        return serviceTwo.greeting() + "and greeting from service one";
    }
}
package webapp.techstore;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Scope;
import javax.inject.Singleton;

@RequestScoped
public class TestServiceOne {

    private TestServiceTwo serviceTwo;

    @Inject
    public TestServiceOne(TestServiceTwo serviceTwo) {
        this.serviceTwo = serviceTwo;
    }

    protected TestServiceOne() {
        this(null);
    }

    public String greetingFromServiceOne() {
        return serviceTwo.greeting() + "and greeting from service one";
    }
}

package web.app.TechStore.TechStore;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;

@ApplicationScoped
public class TestServiceTwo {

    public String greeting() {
        return "Greetings From TestServiceTWo";
    }
}

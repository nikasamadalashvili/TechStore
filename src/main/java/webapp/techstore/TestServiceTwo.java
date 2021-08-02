package webapp.techstore;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Named;

@RequestScoped
public class TestServiceTwo {

    public String greeting() {
        return "Greetings From TestServiceTWo";
    }
}
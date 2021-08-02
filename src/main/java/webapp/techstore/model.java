package webapp.techstore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "demo")
public class model {

    @Column
    @Id
    int id;

    @Column
    String name;

    public model(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public model() {
    }
}

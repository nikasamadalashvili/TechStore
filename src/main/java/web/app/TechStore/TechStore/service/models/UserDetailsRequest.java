package web.app.TechStore.TechStore.service.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDetailsRequest {

    private Long id;

    public UserDetailsRequest(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

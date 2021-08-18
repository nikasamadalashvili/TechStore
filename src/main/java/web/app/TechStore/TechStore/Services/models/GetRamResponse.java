package web.app.TechStore.TechStore.Services.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetRamResponse {
    private List<String> rams;
}

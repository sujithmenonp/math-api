package math.api.model.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class DiffRequest {

    @NotEmpty(message = "Please provide x")
    String x;

    @NotEmpty(message = "Please provide y")
    String y;
}

package math.api.model.response;

import lombok.Data;

@Data
public class DiffResponse  {

    private String result = "";
    public DiffResponse(String result){
        this.result = result;
    }
    public DiffResponse(){}
}

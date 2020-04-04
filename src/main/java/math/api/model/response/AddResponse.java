package math.api.model.response;

import lombok.Data;

@Data
public class AddResponse  {

  private String result = "";
  public AddResponse(String result){
      this.result = result;
  }
  public AddResponse(){

  }
}

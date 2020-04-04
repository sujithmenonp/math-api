package math.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import math.api.model.request.AddRequest;
import math.api.model.request.DiffRequest;
import math.api.model.response.AddResponse;
import math.api.model.response.DiffResponse;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    void testHttpPostAddCall(){
        AddRequest request = new AddRequest();
        request.setX("10");
        request.setY("20");
        HttpEntity<AddRequest> entity = new HttpEntity<>(request);
        String uri="http://localhost:"+port+"/api/add";

        ResponseEntity<AddResponse> responseEntity = testRestTemplate.postForEntity(uri ,
                entity, AddResponse.class);

        assert responseEntity.getBody().getResult().equals("30");
        assert responseEntity.getStatusCode()== HttpStatus.OK;
    }

    @Test
    void testHttpPostDiffCall(){
        DiffRequest request = new DiffRequest();
        request.setX("10");
        request.setY("20");
        HttpEntity<DiffRequest> entity = new HttpEntity<>(request);
        String uri="http://localhost:"+port+"/api/diff";

        ResponseEntity<DiffResponse> responseEntity = testRestTemplate.postForEntity(uri ,
                entity, DiffResponse.class);

        assert responseEntity.getBody().getResult().equals("-10");
        assert responseEntity.getStatusCode()== HttpStatus.OK;
    }

    @Test
    void testHttpPostException(){
        DiffRequest request = new DiffRequest();
        request.setX("10");
        request.setY("a");
        HttpEntity<DiffRequest> entity = new HttpEntity<>(request);
        String uri="http://localhost:"+port+"/api/add";

        ResponseEntity<AddResponse> responseEntity = testRestTemplate.postForEntity(uri ,
                entity, AddResponse.class);

        assert responseEntity.getStatusCode()== HttpStatus.BAD_REQUEST;
    }
}

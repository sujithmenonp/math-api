package math.api;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;

import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import math.api.controller.MathController;
import math.api.model.request.AddRequest;
import math.api.model.request.DiffRequest;
import math.api.service.OperationService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@SpringBootTest
public class MathControllerTest {

    @Autowired
    private MathController mathController;

    @Mock
    private OperationService service;

    @Test
    void testController(){
        assertThat(mathController).isNotNull();
        AddRequest addRequest = new AddRequest();
        addRequest.setY("10");
        addRequest.setX("20");

        DiffRequest diffRequest = new DiffRequest();
        diffRequest.setX("20");
        diffRequest.setY("30");

        mathController.add(addRequest);
        mathController.diff(diffRequest);

        verify(service,times(2));
    }

}

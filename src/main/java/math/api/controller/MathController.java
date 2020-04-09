package math.api.controller;

import math.api.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import math.api.exception.AddException;
import math.api.exception.DiffException;
import math.api.model.request.AddRequest;
import math.api.model.request.DiffRequest;
import math.api.model.response.AddResponse;
import math.api.model.response.DiffResponse;

import javax.validation.Valid;

@RestController
public class MathController {

    @Autowired
    private OperationService operationService;

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public ResponseEntity getHealth(){
        return ResponseEntity.ok("OK");
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<AddResponse> add(@Valid @RequestBody AddRequest addRequest) {
        try {
            String result= operationService.add(addRequest.getX(), addRequest.getY());
            return new ResponseEntity<AddResponse>(new AddResponse(result), HttpStatus.OK);
        }
        catch (AddException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    ex.getMessage(), ex);
        }
    }

    @RequestMapping(value = "/diff", method = RequestMethod.POST)
    public ResponseEntity<DiffResponse> diff(@Valid @RequestBody DiffRequest diffRequest) {
        try {
            String result= operationService.diff(diffRequest.getX(), diffRequest.getY());
            return new ResponseEntity<DiffResponse>(new DiffResponse(result), HttpStatus.OK);
        }
        catch (DiffException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    ex.getMessage(), ex);
        }
    }
}

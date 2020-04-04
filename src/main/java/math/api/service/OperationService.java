package math.api.service;

import org.springframework.stereotype.Service;
import math.api.exception.AddException;
import math.api.exception.DiffException;

import java.math.BigDecimal;


@Service
public class OperationService {

    public String add(String x, String y) throws AddException {
        BigDecimal bigX = BigDecimal.ZERO;
        BigDecimal bigY = BigDecimal.ZERO;
        try{
            bigX = BigDecimal.valueOf(new Double(x));
            bigY = BigDecimal.valueOf(new Double(y));
        }
        catch (Exception ex){
            throw new AddException("Invalid input parameters: "+x+" "+y);
        }
        return bigX.add(bigY).stripTrailingZeros().toEngineeringString();
    }

    public String diff(String x, String y) throws DiffException {
        BigDecimal bigX = BigDecimal.ZERO;
        BigDecimal bigY = BigDecimal.ZERO;
        try{
            bigX = BigDecimal.valueOf(new Double(x));
            bigY = BigDecimal.valueOf(new Double(y));
        }
        catch (Exception ex){
            throw new DiffException("Invalid input parameters: "+x+" "+y);
        }
        return bigX.subtract(bigY).stripTrailingZeros().toEngineeringString();
    }
}

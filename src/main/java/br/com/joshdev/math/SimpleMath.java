package br.com.joshdev.math;

import br.com.joshdev.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class SimpleMath {


    public Double sum( Double numberOne,  Double numberTwo) {


        return (numberOne)+(numberTwo);
    }

    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(Double numberOne,  Double numberTwo)  {


        return (numberOne)-(numberTwo);
    }


    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(Double numberOne,  Double numberTwo)  {


        return (numberOne)*(numberTwo);
    }

    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(Double numberOne,  Double numberTwo)  {


        return (numberOne)/(numberTwo);
    }


    @RequestMapping("/mean/{numberOne}/{numberTwo}")
    public Double mean(Double numberOne,  Double numberTwo)  {


        return ((numberOne)+(numberTwo))/2;
    }


    @RequestMapping("/square-root/{number}/")
    public Double squareRoot(@PathVariable("number") Double number)  {


        return Math.sqrt((number));
    }
}

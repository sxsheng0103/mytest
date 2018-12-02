package test.SpringMVC;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
/**
 * ����ȫ���쳣������Controller��
 * @author Lenovo
 *
 */
@ControllerAdvice
public class testControllerAdvice {
    @ExceptionHandler
    public ModelAndView exceptionHandler(Exception ex){
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exception", ex);
        System.out.println("in testControllerAdvice");
        return mv;
    }
} 
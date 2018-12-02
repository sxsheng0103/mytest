package test.SpringMVC;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import test.SpringMVC.model.User;

@Controller
@RequestMapping("/json")
public class jsonController {
    
    @ResponseBody
    @RequestMapping("/user")
    public  User get(){
        User u = new User();
        u.setId(1);
        u.setName("jayjay");
        u.setBirth(new Date());
        return u;
    }
    /**
     * 处理局部异常（Controller内）
     * @param ex
     * @return
     */
    @ExceptionHandler
    public ModelAndView exceptionHandler(Exception ex){
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exception", ex);
        System.out.println("in testExceptionHandler");
        return mv;
    }
    
    @RequestMapping("/error")
    public String error(){
        int i = 5/0;
        return "hello";
    }
}
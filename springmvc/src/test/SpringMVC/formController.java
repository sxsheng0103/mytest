package test.SpringMVC;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import test.SpringMVC.model.User;

@Controller
@RequestMapping("/form")
public class formController {
    @RequestMapping(value="/add",method=RequestMethod.POST)    
    public String add(Model model,@Valid User u,BindingResult br){
    	model.addAttribute("user",u);
        if(br.getErrorCount()>0){    //birth2016-12-12        
            return "addUser";
        }
        return "showUser";
    }
    /**
     * 国际化标准
     * @param model
     * @param u
     * @param br
     * @return
     */
    @RequestMapping(value="/addStand",method=RequestMethod.POST)    
    public String addStand(){
        return "locale";
    }
    @RequestMapping(value="/addm",method=RequestMethod.POST)    
    public String addModel(Model model){
    	User user = new User();  
        model.addAttribute("user",user);
        return "validatefrom";
    }
    @RequestMapping(value="/addm1",method=RequestMethod.POST)  
    public ModelAndView addModel1(HttpServletRequest req) throws Exception {  
        ModelAndView mv = new ModelAndView();  
        mv.addObject("key1", req.getParameter("key1"));//req.getParameter("key1")是取得key1的值
        mv.addObject("key2", req.getParameter("key2"));
        mv.setViewName("jsp/locale.jsp");  
        return mv;  
    }
    @RequestMapping(value="/addm2",method=RequestMethod.POST)  
    public ModelAndView handleRequest(@RequestParam("key1") String key1,@RequestParam String key2) throws Exception {  
        ModelAndView mv = new ModelAndView();
        mv.addObject("key1", key1);
        mv.addObject("key2", key2);
        mv.setViewName("jsp/locale.jsp");  
        return mv;  
    }
    @RequestMapping(value="/add",method=RequestMethod.GET)
    public String add(Map<String,Object> map){
        map.put("user",new User());
        return "addUser";
    }
    
    @RequestMapping(value = "/imgUpload",method=RequestMethod.POST)
    @ResponseBody
    public synchronized String imgUpload(@RequestParam("filename") MultipartFile file,HttpServletRequest request) throws IOException {
        String tishi="no";
        System.out.println("arrive here");
        if(!file.isEmpty()) {
            //System.out.println(file.getOriginalFilename());
            String message = System.currentTimeMillis() + file.getOriginalFilename();//现在的文件名是时间戳加原文件名，出现图片相同时，读取不出来的bug
            String realPath = request.getSession().getServletContext().getRealPath("/upload/");//将文件保存在当前工程下的一个upload文件
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(realPath, message));//将文件的输入流输出到一个新的文件
            message="upload/"+message;
            HttpSession session=request.getSession();
            Integer id=(Integer)session.getAttribute("userid");//在session中获得用户id
//            User user=userService.get(id);//在dao层保存数据，也就是图片的地址
//            user.setPhoto(message);
//            userService.update(user);
            tishi="yes";//返回yes,表示存储成功，可以使用try,catch来捕捉错误，这里偷懒不用
        }
        return tishi;
    }
}
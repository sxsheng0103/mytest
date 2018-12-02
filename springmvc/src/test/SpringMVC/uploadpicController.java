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
@Controller
@ResponseBody
@RequestMapping("/upload")
public class uploadpicController {
	

	@RequestMapping(value = "/imgUpload",method=RequestMethod.POST)
    @ResponseBody
    public synchronized String imgUpload(@RequestParam("file") MultipartFile file,HttpServletRequest request) throws IOException {
        String tishi="no";
        System.out.println("arrive here");
        if(!file.isEmpty()) {
            //System.out.println(file.getOriginalFilename());
            String message = System.currentTimeMillis() + file.getOriginalFilename();//���ڵ��ļ�����ʱ�����ԭ�ļ���������ͼƬ��ͬʱ����ȡ��������bug
            String realPath = request.getSession().getServletContext().getRealPath("/upload/");//���ļ������ڵ�ǰ�����µ�һ��upload�ļ�
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(realPath, message));//���ļ��������������һ���µ��ļ�
            message="upload/"+message;
            HttpSession session=request.getSession();
            Integer id=(Integer)session.getAttribute("userid");//��session�л���û�id
//            User user=userService.get(id);//��dao�㱣�����ݣ�Ҳ����ͼƬ�ĵ�ַ
//            user.setPhoto(message);
//            userService.update(user);
            tishi="yes";//����yes,��ʾ�洢�ɹ�������ʹ��try,catch����׽��������͵������
        }
        return tishi;
    }
	@RequestMapping(value = "/imgUpload1",method=RequestMethod.POST)   
    public  void imgUpload(HttpServletRequest request){
       System.out.println("123");
    }
}
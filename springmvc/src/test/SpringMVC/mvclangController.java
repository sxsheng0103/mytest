package test.SpringMVC;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test1")
public class mvclangController {
	@Autowired
    private ResourceBundleMessageSource messageSource;

	@RequestMapping("/i18n")
    public String testI18N(Locale locale) {
        String val = messageSource.getMessage("username", null, locale);
        System.out.println(val);
        return "i18n";
    }
}
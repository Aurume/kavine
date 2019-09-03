package kaviney;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class GreetingController {

    @GetMapping("/uzsakymai")
   public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
       model.addAttribute("name", name);
        return "uzsakymai";
    }
    
    @GetMapping("/paruosimas")
    public String paruosimas(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "paruosimas";
    }
    
    //Mappinam patiekalus
    @GetMapping("/patiekalai")
    public String patiekalai(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "patiekalai";
    }
   
     @GetMapping("/patiekalairaides49")
    public String patiekalairaides() {
    	return "patiekalai";
    }    

       
    @GetMapping("/uzsakkkykkk33il666klh")
    public String uzsakymaix(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "paruosimas";
    }    
    
    @RequestMapping("/simple") // pavyzdys ka atiduoda, kai yra response body, o ne String
    public @ResponseBody String greeting() {
        return "Hello Simple";
    }    
    
    //pridedu cia produktus
    @GetMapping("/produktai")
    public String produktai(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "produktaix";
    
    }
    
    //pridedu cia produktus
    @GetMapping("/produktairaides0119")
    public String produktaix(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "produktaix";
    
    }   
}

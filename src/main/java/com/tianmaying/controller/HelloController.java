package com.tianmaying.controller;

import org.apache.catalina.startup.HomesUserDatabase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tianmaying.entity.Employee;
import com.tianmaying.entity.User;

@Controller
public class HelloController {

	private User currentUser;
	
	@RequestMapping("/")
	public String index() {
		//return "index";
		return "login";
	}
	
	@RequestMapping("/mobile")
	public String mobie() {
		return "mobile";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody User user, Model model){
		User loginUser = new User(user.getId(),user.getName(),user.getPassword());
		if (user.getName().equals("admin") && user.getPassword().equals("123456")){
			model.addAttribute("user", loginUser);
			System.out.print("验证成功");
			return "home";
		}else{
			model.addAttribute("errorMsg", "用户名或者密码错误!");
			System.out.print("验证失败");
			return "error";
		}
    }
	
	@RequestMapping(value="/login_register",method=RequestMethod.POST)
	public String userLogin(@RequestBody User user, Model model){
		currentUser = new User(user.getId(),user.getName(),user.getPassword());
		if (user.getName().equals("admin") && user.getPassword().equals("123456")){
			model.addAttribute("user", currentUser);
			System.out.print("验证成功");
			return "home";
		}else{
			model.addAttribute("errorMsg", "用户名或者密码错误!");
			System.out.print("验证失败");
			return "error";
		}
	}
	
	@RequestMapping("/test")
	public String testing() {
		return "test";
	}
	
	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("user",currentUser);
		return "home";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public String updateEmployee(@RequestBody Employee employee, Model model){

        Employee newEm = new Employee(employee.getId(),employee.getName(),employee.getTitle());
        model.addAttribute("emp", newEm);
        return "hello";
    }
    
	@RequestMapping(value="/test", method = RequestMethod.POST)
    public String test(@RequestParam("username") String name, @RequestParam("password") String pwd, Model model) {
        model.addAttribute("username", name);
        model.addAttribute("password", pwd);
        return "hello";
    }
	
	@RequestMapping("/hello2")
    public String hello( Model model) {
		Employee newEm = new Employee("tttt", "ggg", "hhh");
        model.addAttribute("emp", newEm);
        return "hello";
    }
	
    @RequestMapping("/hello")
    public String hello(@RequestParam("username") String name, @RequestParam("password") String pwd, Model model) {
        model.addAttribute("username", name);
        model.addAttribute("password", pwd);
        return "hello";
    }
}
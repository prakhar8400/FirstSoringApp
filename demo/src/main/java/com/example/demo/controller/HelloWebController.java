package com.example.demo.controller;
import org. springframework.stereotype.Controller;
import org. springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloWebController {

    @GetMapping("/web")
    public String hello(){
        return "hello";
    }

    @GetMapping("/web/message")
    public String message(Model model) {
        model. addAttribute("message", "This is a custom message");
        return "message";
    }
    // curl localhost:8080/hello/query?name=Naxayan -w "\n"
    @RequestMapping(value = {"/query"}, method = RequestMethod.GET)
    public String sayHello(@RequestParam(value = "name") String name) {
        return "Hello " + name + "1";
    }
    // curl localhost:8080/hello/param/Naxayan -w "\n"
    @GetMapping("/param/{name}")
    public String sayHelloParam(@PathVariable String name) {
        return "Hello " + name + "!";
    }


}

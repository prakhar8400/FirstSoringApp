package com.example.demo.controller;
import com.example.demo.model.User;
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
    // curl -X POST -H "Content-Type: application/ison"
    //               -d '{"firstName": "Lisa", "lastName": "Harry"}'
    //   "http://localhost: 8080/hello/post" -w "\n"
    @PostMapping("/post")
    public String sayHello(@RequestBody User user) {
        return "Hello " + user.getFirstName() + "  " + user.getLastName() + "!";
    }

    // curl -X PUT localhost: 8080/hello/put/Lisa/?lastName=Terrisa -w "\n"
    @PutMapping("/put/{firstName}")
    public String sayHello(@PathVariable String firstName,
                           @RequestParam(value = "lastName") String lastName) {
        return "Hello " + firstName + " " + lastName + "!";
    }

}

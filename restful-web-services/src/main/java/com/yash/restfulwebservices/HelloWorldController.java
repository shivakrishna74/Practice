package com.yash.restfulwebservices;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;


    @GetMapping(path="/hello-world-International")
    public String helloWorldInternationalized(@RequestHeader(name="Accept-Language",required = false)  Locale locale)
    {
        return messageSource.getMessage("good.morning.message",null,locale);
    }

   @GetMapping("/helloworld")
    public String returnHelloWorld()
   {
       return "Hello world";
   }


   @GetMapping("/helloworldbean")
   public HelloWorldBean helloWorldBean()
   {
       return new HelloWorldBean("hello World bean helloo");
   }

    @GetMapping(path="/helloworldbean/path-vairiable/{name}")
    public HelloWorldBean helloWorldPathViaraible(@PathVariable String name)
    {
        return new HelloWorldBean(String.format("Hello World, %s",name));
    }







}

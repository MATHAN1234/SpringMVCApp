package com.pro.controller;

import com.pro.bean.User;
import com.pro.model.DataProvider;
import com.pro.scrapper.ExpansysScrapper;
import com.pro.scrapper.Item;
import com.pro.scrapper.iPriceScrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.sql.SQLException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {

    @RequestMapping(value= {"/","/home","/index"})
    public ModelAndView index() {
        ModelAndView mv= new ModelAndView("page");
        mv.addObject("title","Home");
        mv.addObject("UserClickHome",true);
        return mv;
    }

    @RequestMapping(value= "/About")
    public ModelAndView About() {
        ModelAndView mv= new ModelAndView("page");
        mv.addObject("title","About Us");
        mv.addObject("UserClickAbout",true);
        return mv;
    }

    @RequestMapping(value= "/Login")
    public ModelAndView Login() {
        ModelAndView mv= new ModelAndView("page");
        mv.addObject("title","Login");
        mv.addObject("UserClickLogin",true);
        return mv;
    }

    @RequestMapping(value= "/Register", method= RequestMethod.GET)
    public ModelAndView Register(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv= new ModelAndView("page");
        mv.addObject("title","Register");
        mv.addObject("UserClickRegister",true);
        return mv;
    }


    @RequestMapping(value= "/registerProcess")
    public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
        ModelAndView mv= new ModelAndView("page");
        String UserName=request.getParameter("UserName");
        String FullName=request.getParameter("FullName");
        String Password=request.getParameter("Password");
        User user=new User();
        DataProvider dProvider =new DataProvider();
        user.setUserName(UserName);
        user.setFullName(FullName);
        user.setPassword(Password);
        String s2=dProvider.writeData(user);
        if(s2.equalsIgnoreCase("")) {
            mv.addObject("UserClickLogin",true);
            mv.addObject("title","Login");
        }
        else {
            mv.addObject("error",s2);
            mv.addObject("UserClickRegister",true);
            mv.addObject("title","Register");
        }

        return mv;
    }

    @RequestMapping(value= "/loginProcess")
    public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
        ModelAndView mv= new ModelAndView("page");
        mv.addObject("title","Login");
        String UserName=request.getParameter("UserName");
        String FullName=request.getParameter("FullName");
        String Password=request.getParameter("Password");
        User user=new User();
        DataProvider dProvider =new DataProvider();
        user.setUserName(UserName);
        user.setFullName(FullName);
        user.setPassword(Password);
        String[] s1=dProvider.readData(user);
        if(s1[0].equalsIgnoreCase("success")) {
            mv.addObject("Name",s1[1]);
            mv.addObject("UserClickHome",true);
        }else {
            mv.addObject("Wrong","Wrong UserName or Password");
            mv.addObject("UserClickLogin",true);
        }
        return mv;
    }

    @RequestMapping(value= "/Search")
    public ModelAndView Search(@RequestParam(value="query")String queryString) throws IOException,NullPointerException {
        List<Item> iPriceProducts = new ArrayList<Item>();
        List<Item> expansysProducts = new ArrayList<Item>();
        List<Item> AlList = new ArrayList<Item>();
        iPriceScrapper iPrice =new iPriceScrapper();
        ExpansysScrapper expansys=new ExpansysScrapper();
        ModelAndView mv= new ModelAndView("page");
        try {
            iPriceProducts=iPrice.parse(queryString);
            AlList.addAll(iPriceProducts);
            expansysProducts = expansys.parse(queryString);
            AlList.addAll(expansysProducts);
        }
        catch (NullPointerException e){
        }
        mv.addObject("Items",AlList);
        mv.addObject("searchString",queryString);
        mv.addObject("title",queryString);
        mv.addObject("UserClickHome",true);
        return mv;
    }

}

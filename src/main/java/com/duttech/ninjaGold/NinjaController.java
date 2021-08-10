package com.duttech.ninjaGold;

import javax.servlet.http.HttpSession;

import java.util.Date;
import java.util.Random;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
@Controller
public class NinjaController {
	
	@RequestMapping("/gold")
	public String index(HttpSession session, Model model) {
		if(session.getAttribute("count") == null && session.getAttribute("locations") == null){
			session.setAttribute("count",0);
			ArrayList<String>activityList = new ArrayList<String>();
			session.setAttribute("locations", activityList);
		}
		model.addAttribute("goldCount", session.getAttribute("count"));
		return "Gold.jsp";
	}
	
	private int population(int low, int high, HttpSession session) {
		Random rand = new Random();
		int result = rand.nextInt((high+1)-low)+low;
		String.valueOf(result);
		int gold = (int)session.getAttribute("count");
		session.setAttribute("count", gold+result);
		return result;
	}
	
	
		
		
	
	
	

	
	
	@RequestMapping(value = "/goldProcess", method = RequestMethod.POST)
	public String goldProcess(HttpSession session, 
			@RequestParam (value= "location") String location, Model model){
		
		if(location.equals("farm")) {
			int farmGold = population(10,20,session);
			Date farmdate = new Date();
			DateFormat dateFormat = new SimpleDateFormat("MMMM dd yyyy HH:mm aa");
			String newDate = dateFormat.format(farmdate);
			String farmFinal = "you entered a farm and earned: " + farmGold + " " + newDate;
			ArrayList<String>activityList = (ArrayList<String>)session.getAttribute("locations");
			activityList.add(0,farmFinal);
			session.setAttribute("locations", activityList);
			
			
		}
		else if(location.equals("cave")) {
			int caveGold = population(5,10,session);
			Date cavedate = new Date();
			DateFormat dateFormat = new SimpleDateFormat("MMMM dd yyyy HH:mm aa");
			String newDate = dateFormat.format(cavedate);
			String caveFinal = "you entered a cave and earned: " + caveGold + " " + newDate;
			ArrayList<String>activityList = (ArrayList<String>)session.getAttribute("locations");
			activityList.add(caveFinal);
			session.setAttribute("locations", activityList);
		}
		
		
		else if(location.equals("house")) {
			int houseGold = population(2,5,session);
			
			Date housedate = new Date();
			DateFormat dateFormat = new SimpleDateFormat("MMMM dd yyyy HH:mm aa");
			String newDate = dateFormat.format(housedate);
			String houseFinal = "you entered a farm and earned: " + houseGold + " " + newDate;
			ArrayList<String>activityList = (ArrayList<String>)session.getAttribute("locations");
			activityList.add(houseFinal);
			session.setAttribute("locations", activityList);
		}
		
		else if(location.equals("casino")) {
			int casinoGold = population(-50,50,session);
			Date casinoDate = new Date();
			DateFormat dateFormat = new SimpleDateFormat("MMMM dd yyyy HH:mm aa");
			String newDate = dateFormat.format(casinoDate);
			if (casinoGold < 0) {
				String casinoFinal = "you entered a casino and lost: " + casinoGold + " " + newDate;
			}
			String casinoFinal = "you entered a casino and earned: "+ casinoGold + " " + newDate;
			
			
			ArrayList<String>activityList = (ArrayList<String>)session.getAttribute("locations");
			activityList.add(casinoFinal);
			session.setAttribute("locations", activityList);
		}
		else if(location.equals("spa")) {
			population (5,20, session);
		}
		
		else if(location.equals("reset")) {
			session.setAttribute("count",0);
			ArrayList<String>activityList = new ArrayList<String>();
			session.setAttribute("locations", activityList);
		}

			model.addAttribute("goldCount",session.getAttribute("count"));
			
			
		return "redirect:/gold";
		
	}
	
	
	

}

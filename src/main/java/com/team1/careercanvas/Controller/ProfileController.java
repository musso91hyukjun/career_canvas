package com.team1.careercanvas.Controller;

import com.team1.careercanvas.mapper.PartyMapper;
import com.team1.careercanvas.vo.PartyVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team1.careercanvas.mapper.PofolMapper;
import com.team1.careercanvas.mapper.UserMapper;
import com.team1.careercanvas.vo.PofolVO;
import com.team1.careercanvas.vo.UserVO;

import java.util.List;

@Controller
public class ProfileController {
	
	private final UserMapper usermapper;
	private final PofolMapper pofolmapper;
	private final PartyMapper partymapper;
	
	public ProfileController(UserMapper usermapper, PofolMapper pofolmapper, PartyMapper partymapper) {
		this.usermapper = usermapper;
		this.pofolmapper = pofolmapper;
		this.partymapper = partymapper;
	}
	
	@GetMapping("/profile/portfolio")
	public ModelAndView profileInfo(@RequestParam("uid") String userid ) {
		UserVO uservo = usermapper.getUserInfo(userid);
		int pofolamount = pofolmapper.getpofolamount(userid);

		List<PofolVO> pofolvo = pofolmapper.getPofolInfo(userid);
		
		ModelAndView mav =new ModelAndView();
		mav.addObject("uVO", uservo);
		mav.addObject("pCount", pofolamount);
		mav.addObject("pVO", pofolvo);
		mav.setViewName("users/userProfile");
		
		return mav;
	}

	@GetMapping("/profile/party")
	public ModelAndView party(@RequestParam("uid")String userid){
		UserVO uservo = usermapper.getUserInfo(userid);
		int pofolamount = pofolmapper.getpofolamount(userid);
		ModelAndView mav = new ModelAndView();
		mav.addObject("pCount", pofolamount);
		List<PartyVO> pvo = partymapper.getmyParty(userid);
		mav.addObject("partyvo", pvo);
		mav.addObject("uVO", uservo);
		mav.setViewName("users/userProfile_party");
		return mav;
	}
}
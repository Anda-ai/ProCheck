package com.kapelle.procheck.Controller;
import java.util.List;
/**
 *
 * @author anda
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kapelle.procheck.Model.ProfileDetailsEntity;
import com.kapelle.procheck.Model.ProfileDetailsRepository;

@Controller
public class HomeController {
	
	@Autowired
    ProfileDetailsRepository profileDetailsRepository;

	int value = 0;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(Model model){
		Pageable sortedByBookings = PageRequest.of(0, 3, Sort.by("bookings").descending());
		Page<ProfileDetailsEntity> paginatedPros = profileDetailsRepository.findAll(sortedByBookings);
		model.addAttribute("paginatedpros", paginatedPros.toList());
		return "home";
	}
	@GetMapping(path = "/allpros")
    public String AllPros(Model model) {
		value = 0;
        Pageable sortedByBookings = PageRequest.of(value, 1, Sort.by("bookings").descending());
		Page<ProfileDetailsEntity> paginatedPros = profileDetailsRepository.findAll(sortedByBookings);
		model.addAttribute("paginatedpros", paginatedPros.toList());
		System.out.println("paginatedPros list: "+paginatedPros.toList());
		if(paginatedPros.toList().isEmpty()){
			System.out.println("no more results");
		}
		else{
			value++;
		}
		return "pros";
    }
	@GetMapping(path = "/getpros")
    public String getPros(Model model) {
        Pageable sortedByBookings = PageRequest.of(value, 1, Sort.by("bookings").descending());
		Page<ProfileDetailsEntity> paginatedPros = profileDetailsRepository.findAll(sortedByBookings);
		if(paginatedPros.toList().isEmpty()){
			return null;
		}
		else{
			model.addAttribute("paginatedpros", paginatedPros.toList());
			value++;
			return "pros_Item";
		}
    }
}

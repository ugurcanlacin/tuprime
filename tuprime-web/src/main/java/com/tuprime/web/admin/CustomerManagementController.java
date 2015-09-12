package com.tuprime.web.admin;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tuprime.common.business.user.UserService;
import com.tuprime.common.business.userdiet.UserDietService;
import com.tuprime.entities.Diet;
import com.tuprime.entities.User;
import com.tuprime.entities.UserDiet;

@Controller
@RequestMapping("/admin/customermanagement")
public class CustomerManagementController {

	@Resource(name = "userService")
	private UserService userService;

	@Resource(name = "userDietService")
	private UserDietService userDietService;

	public UserDietService getUserDietService() {
		return userDietService;
	}

	public void setUserDietService(UserDietService userDietService) {
		this.userDietService = userDietService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/select/{id}", method = RequestMethod.GET)
	public ModelAndView selectUserById(@PathVariable("id") int id) {
		User userForm = userService.find(id);
		ModelAndView model = new ModelAndView("trainer/select");
		model.addObject("userForm", userForm);
		List<UserDiet> userDiet = userDietService
				.getUserDietListByUserId(userForm.getId());
		model.addObject("userDiet", userDiet);
		return model;
	}

	@RequestMapping(value = "/deletediet/{diet_id}/{user_id}", method = RequestMethod.GET)
	public String deleteUserDietById(@PathVariable("diet_id") int diet_id,
			@PathVariable("user_id") int user_id) {
		try {
			UserDiet objectForDeletion = userDietService
					.getUserDietByUserAndDietId(diet_id, user_id);
			userDietService.delete(objectForDeletion);
		} catch (Exception e) {
			System.out.println(e);
		}
		return "redirect:/admin/customermanagement/select/" + user_id;
	}

	@RequestMapping(value = "/adddiet/{user_id}", method = RequestMethod.GET)
	public ModelAndView getAddDietPage(@PathVariable("user_id") int user_id) {
		return new ModelAndView("trainer/addDiet", "diet", new Diet()).addObject("user_id", user_id);
	}

	@RequestMapping(value = "/adddiet", method = RequestMethod.POST)
	public ModelAndView addNewDietForSpecificUser(
			@ModelAttribute("diet") Diet diet,
			@RequestParam("user_id") int user_id) {
		ModelAndView model = new ModelAndView("common/result");
		diet.setTimestamp(new Date());
		UserDiet userDiet = new UserDiet();
		userDiet.setDiet(diet);
		userDiet.setUser(userService.find(user_id));
		try {
			userDietService.merge(userDiet);
			model.addObject("result", "Kayıt başarılıyla tamamlandı!");
		} catch (Exception e) {
			model.addObject("result",
					"Kayıt başarısız oldu. Lütfen tekrar deneyin.");
		}
		return model;
	}

}

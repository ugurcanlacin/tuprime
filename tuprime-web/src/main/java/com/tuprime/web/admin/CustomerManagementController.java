package com.tuprime.web.admin;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tuprime.common.business.diet.DietService;
import com.tuprime.common.business.exercise.ExerciseService;
import com.tuprime.common.business.user.UserService;
import com.tuprime.common.business.userdiet.UserDietService;
import com.tuprime.common.business.userworkout.UserWorkoutService;
import com.tuprime.common.business.workout.WorkoutService;
import com.tuprime.common.security.AuthenticationService;
import com.tuprime.entities.Diet;
import com.tuprime.entities.Exercise;
import com.tuprime.entities.User;
import com.tuprime.entities.UserDiet;
import com.tuprime.entities.UserWorkout;
import com.tuprime.entities.Workout;

@Controller
@RequestMapping("/admin/customermanagement")
public class CustomerManagementController {

	private static final Logger logger = Logger.getLogger(CustomerManagementController.class);
	
	@Resource(name = "authenticationService")
	private AuthenticationService authService;
	
	@Resource(name = "userService")
	private UserService userService;

	@Resource(name = "userDietService")
	private UserDietService userDietService;

	@Resource(name = "dietService")
	private DietService dietService;

	@Resource(name = "exerciseService")
	private ExerciseService exerciseService;

	@Resource(name = "userWorkoutService")
	private UserWorkoutService userWorkoutService;

	public AuthenticationService getAuthService() {
		return authService;
	}

	public void setAuthService(AuthenticationService authService) {
		this.authService = authService;
	}
	
	public UserWorkoutService getUserWorkoutService() {
		return userWorkoutService;
	}

	public void setUserWorkoutService(UserWorkoutService userWorkoutService) {
		this.userWorkoutService = userWorkoutService;
	}

	public ExerciseService getExerciseService() {
		return exerciseService;
	}

	public void setExerciseService(ExerciseService exerciseService) {
		this.exerciseService = exerciseService;
	}

	public DietService getDietService() {
		return dietService;
	}

	public void setDietService(DietService dietService) {
		this.dietService = dietService;
	}

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
	public ModelAndView selectUserById(@PathVariable("id") int user_id) {
		User userForm = userService.find(user_id);
		ModelAndView model = new ModelAndView("trainer/select");
		model.addObject("userForm", userForm);
		List<UserDiet> userDiet = userDietService
				.getUserDietListByUserId(userForm.getId());
		model.addObject("userDiet", userDiet);
		model.addObject("userWorkout", userForm.getUserWorkout());
		model.addObject("pdetails", userForm.getPersonalDetails());
		logger.info(authService.getAuthenticatedAdmin()+" executed selectUserById()");
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
		logger.info(authService.getAuthenticatedAdmin()+" executed deleteUserDietById()");
		return "redirect:/admin/customermanagement/select/" + user_id;
	}

	@RequestMapping(value = "/adddiet/{user_id}", method = RequestMethod.GET)
	public ModelAndView getAddDietPage(@PathVariable("user_id") int user_id) {
		logger.info(authService.getAuthenticatedAdmin()+" executed getAddDietPage()");
		return new ModelAndView("trainer/addDiet", "diet", new Diet())
				.addObject("user_id", user_id);
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
		model.addObject("redirectPath", "customermanagement/select/"+user_id);
		logger.info(authService.getAuthenticatedAdmin()+" executed addNewDietForSpecificUser()");
		return model;
	}

	@RequestMapping(value = "/editdiet/{id}", method = RequestMethod.GET)
	public ModelAndView editUserById(@PathVariable("id") int id) {
		logger.info(authService.getAuthenticatedAdmin()+" executed editUserById()");
		return new ModelAndView("trainer/editDiet", "diet",
				dietService.find(id));
	}

	@RequestMapping(value = "/editdiet", method = RequestMethod.POST)
	public ModelAndView editUserByInstance(@ModelAttribute("diet") Diet diet,
			@RequestParam("diet_id") int diet_id) {
		ModelAndView model = new ModelAndView("common/result");
		diet.setId(diet_id);
		diet.setTimestamp(new Date());
		try {
			dietService.update(diet);
			model.addObject("result", "Güncelleme başarıyla tamamlandı!");
		} catch (Exception e) {
			model.addObject("result",
					"Güncelleme tamamlanmadı.Lütfen tekrar deneyiniz.");
		}
		model.addObject("redirectPath", "customermanagement");
		logger.info(authService.getAuthenticatedAdmin()+" executed editUserByInstance()");
		return model;
	}

	@RequestMapping(value = "/addworkout/{user_id}", method = RequestMethod.GET)
	public ModelAndView getAddWorkoutPage(@PathVariable("user_id") int user_id) {
		ModelAndView model = new ModelAndView("trainer/addWorkout", "workout",
				new Workout());
		model.addObject("user_id", user_id);
		model.addObject("exercises", exerciseService.getAllExercises());
		logger.info(authService.getAuthenticatedAdmin()+" executed getAddWorkoutPage()");
		return model;
	}

	@RequestMapping(value = "/addworkout", method = RequestMethod.POST)
	public ModelAndView addNewWorkoutForSpecificUser(
			@ModelAttribute("workout") Workout workout,
			@RequestParam(value = "exercise") int[] exerciseArray,
			@RequestParam("user_id") int user_id) {
		ModelAndView model = new ModelAndView("common/result");
		Set<Exercise> exerciseSet = new HashSet<Exercise>();
		for (int exerciseId : exerciseArray) {
			exerciseSet.add(exerciseService.find(exerciseId));
		}
		User user = userService.find(user_id);
		UserWorkout userWorkout = new UserWorkout();
		userWorkout.setUser(user);
		workout.setExercises(exerciseSet);
		workout.setTimestamp(new Date());
		userWorkout.setWorkout(workout);
		try {
			userWorkoutService.merge(userWorkout);
			model.addObject("result", "Kayıt başarılıyla tamamlandı!");
		} catch (Exception e) {
			model.addObject("result",
					"Kayıt başarısız oldu. Lütfen tekrar deneyin.");
		}
		model.addObject("redirectPath", "customermanagement/select/"+user_id);
		logger.info(authService.getAuthenticatedAdmin()+" executed addNewWorkoutForSpecificUser()");
		return model;
	}

	@RequestMapping(value = "/deleteworkout/{workout_id}/{user_id}", method = RequestMethod.GET)
	public String deleteUserWorkoutById(
			@PathVariable("workout_id") int workout_id,
			@PathVariable("user_id") int user_id) {
		try {
			UserWorkout objectForDeletion = userWorkoutService
					.getUserWorkoutByUserAndWorkoutId(workout_id, user_id);
			userWorkoutService.delete(objectForDeletion);
		} catch (Exception e) {
			System.out.println(e);
		}
		logger.info(authService.getAuthenticatedAdmin()+" executed deleteUserWorkoutById()");
		return "redirect:/admin/customermanagement/select/" + user_id;
	}

}

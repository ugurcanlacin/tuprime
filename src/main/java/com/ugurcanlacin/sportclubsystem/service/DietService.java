package com.ugurcanlacin.sportclubsystem.service;

import com.ugurcanlacin.sportclubsystem.model.Diet;

public interface DietService {
	void persistDiet(Diet diet);
	void updateDiet(Diet diet);
	void deleteDiet(Diet diet);
	
}

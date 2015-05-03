package com.ugurcanlacin.sportclubsystem.dao;

import com.ugurcanlacin.sportclubsystem.model.Diet;

public interface DietDao {
	void persistDiet(Diet diet);
	void updateDiet(Diet diet);
	void deleteDiet(Diet diet);
	
}

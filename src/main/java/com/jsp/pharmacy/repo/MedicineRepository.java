package com.jsp.pharmacy.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jsp.pharmacy.entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, String>{

	List<Medicine> findMedicineByNameLikeIgnoreCaseOrIngredientsLikeIgnoreCase(String name, String ingredient);

}

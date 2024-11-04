package com.jsp.pharmacy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jsp.pharmacy.entity.Pharmacy;
import com.jsp.pharmacy.exception.AdminNotFoundByIdException;
import com.jsp.pharmacy.exception.PharmacyNotFoundByIdException;
import com.jsp.pharmacy.mapper.PharmacyMapper;
import com.jsp.pharmacy.repo.AdminRepository;
import com.jsp.pharmacy.repo.PharmacyRepository;
import com.jsp.pharmacy.requestdto.PharmacyRequest;
import com.jsp.pharmacy.responsedto.PharmacyResponse;

@Service
public class PharmacyService {

	private final PharmacyRepository pharmacyRepository;
	private  final AdminRepository adminRepository;
	private final PharmacyMapper pharmacyMapper;


	public PharmacyService(PharmacyRepository pharmacyRepository, AdminRepository adminRepository,
			PharmacyMapper pharmacyMapper) {
		super();
		this.pharmacyRepository = pharmacyRepository;
		this.adminRepository = adminRepository;
		this.pharmacyMapper = pharmacyMapper;
	}


	public PharmacyResponse savePharmacy(PharmacyRequest pharmacyRequest, String adminId) {
		return adminRepository.findById(adminId)
				.map((admin) ->{
					Pharmacy pharmacy = pharmacyRepository
							.save(pharmacyMapper.mapToPharmacy(pharmacyRequest, new Pharmacy()));
					admin.setPharmacy(pharmacy);
					adminRepository.save(admin);
					return pharmacy;
				})
				.map(pharmacyMapper::mapToPharmacyResponse)
				.orElseThrow(()-> new AdminNotFoundByIdException("Failed to add pharmacy because admin not found"));
	}



	public List<PharmacyResponse> findAllPharmacy() {
		return pharmacyRepository.findAll()
				.stream()
				.map(pharmacyMapper :: mapToPharmacyResponse)
				.toList();
	}


	public PharmacyResponse findPharmacy(String adminId) {
		return adminRepository.findPharmacyByAdminId(adminId)
				.map(pharmacyMapper :: mapToPharmacyResponse)
				.orElseThrow(() -> new PharmacyNotFoundByIdException("Failed to Find Pharmacy"));
	}

}

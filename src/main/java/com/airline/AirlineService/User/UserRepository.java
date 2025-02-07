package com.airline.AirlineService.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserOnboarding, String>{
	@Query(value= "Select u from UserOnboarding u where u.userMobileNumber = :mobile") UserOnboarding findbyMobile (@Param("mobile") String MobileNumber);
	@Query(value= "Select u from UserOnboarding u where u.userEmail =  :email") UserOnboarding findByEmail (@Param("email") String Email);

}

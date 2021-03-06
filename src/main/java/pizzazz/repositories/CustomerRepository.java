package pizzazz.repositories;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pizzazz.models.Customer;;

public interface CustomerRepository 
	extends CrudRepository<Customer, Integer>{
	@Query("SELECT u FROM Customer u WHERE u.username=:username AND u.password=:password")
	Iterable<Customer> findCustomerByCredentials(
		@Param("username") String username, 
		@Param("password") String password);

	
	@Query("SELECT u FROM Customer u WHERE u.username=:username AND u.password=:password")
	Customer findCustomer(
		@Param("username") String username, 
		@Param("password") String password);
	
	@Query("SELECT u FROM Customer u WHERE u.username=:username")
	Iterable<Customer> findCustomerByUsername(
		@Param("username") String username);

}

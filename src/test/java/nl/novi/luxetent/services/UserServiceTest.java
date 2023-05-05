package nl.novi.luxetent.services;

import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import nl.novi.luxetent.models.Tent;
import nl.novi.luxetent.models.User;
import nl.novi.luxetent.repositories.TentRepository;
import nl.novi.luxetent.repositories.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
	
	@Mock
	private TentRepository tentRepository;
	
	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private UserService userService;
	
	 @Test
	    void assignTentToUserWhenTentAndUserExist() {
		 	User user = new User(); 
	        user.setUsername("Peter"); 
		 
	        Tent tent = new Tent(); 
	        tent.setId(10L);
	        tent.setTitle("Luxe Tent");
	        tent.setDescription("Welkom bij de luxe tent");
	        tent.setPricePerNight(99);
	        tent.setMaxNumberOfPersons(2);
	        tent.setStreet("Molenstraat");
	        tent.setHouseNumber("4a");
	        tent.setCity("Breda");
	        tent.setProvince("Noord-Brabant"); 
	        
	        when(userRepository.findById(user.getUsername())).thenReturn(Optional.of(user));
	        when(tentRepository.findById(tent.getId())).thenReturn(Optional.of(tent)); 

	        userService.assignTentToUser(user.getUsername(), tent.getId()); 

	 }  
}

package junitprotein;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.realcoderz.beans.AccountantBean;
import com.realcoderz.service.AccountantService;
import com.realcoderz.service.AdminService;

class Admintest {
	 @Test 
	  void updateAcccountSuccessful() {
	AccountantService as = new AccountantService();
	 AccountantBean ac= new AccountantBean(); 
	  ac.setAddress("varanasi");
	  ac.setContact("89398939");
	  ac.setEmail("pta@u=yush");
	  ac.setId(0);
	  ac.setName("hatsh");
	  ac.setPassword("iuih");
	  
	  
	  
	  int updateAccountant = as.update(ac);
	   
	  assertEquals(0, updateAccountant);
	    
	  }
		@Test
		void updateAcccountNotSuccessful() {

			AccountantService as = new AccountantService();
			 AccountantBean ac= new AccountantBean(); 
			  ac.setAddress("varanasi");
			  ac.setContact("89398939");
			  ac.setEmail("pta@u=yush");
			  ac.setId(0);
			  ac.setName("hatsh");
			  ac.setPassword("iuih");
			  
			  
			  
			  int updateAccountant = as.update(ac);
			   
			  assertEquals(0, updateAccountant);
			    
	 
		}

	  @Test 
	  void deleteAcccountSuccessful() {
	  
	 AccountantService ac= new AccountantService(); 
	  int deletedAccount = ac.delete(1000);
	   
	  assertEquals(1, deletedAccount);
	    
	  }
		@Test
		void deleteAcccountNotSuccessful() {

			AccountantService accountService = new AccountantService();
			int deletedAccount = accountService.delete(1000);
			
			assertEquals(0, deletedAccount);
	 
		}
//
//		  @Test 
//		  void getIdAcccountSuccessful() {
//		  
//		 AccountantService ac= new AccountantService(); 
//		  int getIdAccount = ac.delete(1000);
//		   
//		  assertEquals(1, getIdAccount);
//		    
//		  }
//			@Test
//			void getIdAcccountNotSuccessful() {
//
//				AccountantService accountService = new AccountantService();
//				int getIdAccount = accountService.delete(1000);
//				
//				assertEquals(0, getIdAccount);
//		 
//			}
			  
				
}	 

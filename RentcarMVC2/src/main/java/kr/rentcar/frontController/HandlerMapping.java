package kr.rentcar.frontController;

import java.util.HashMap;

import kr.rentcar.controller.rentcar.*;
import kr.rentcar.controller.user.*;

public class HandlerMapping {
	private HashMap<String,Controller> mappings;
 
	public HandlerMapping() {
		this.mappings = new HashMap<String, Controller>();
		mappings.put("/main.do", new MainController());
		mappings.put("/rentcarInfomation.do", new RentcarInfomationController());
		mappings.put("/rentcarInsert.do", new RentcarInsertController());
		mappings.put("/rentcarList.do", new RentcarListController());
		mappings.put("/rentcarReservation.do", new RentcarReservationController());
		mappings.put("/rentcarReservationDelete.do", new RentcarReservationDeleteController());
		mappings.put("/rentcarSelectOption.do", new RentcarSelectOptionController());
		mappings.put("/uploadRentcarImg.do", new UploadRentcarImgController());
		mappings.put("/userDelete.do", new UserDeleteController());
		mappings.put("/userDeleteReservationCheck.do", new UserDeleteReservationCheckController());
		mappings.put("/userInfomation.do", new UserInfomationController());
		mappings.put("/userLogin.do", new UserLoginController());
		mappings.put("/userLogout.do", new UserLogoutController());
		mappings.put("/userJoin.do", new UserJoinController());
		mappings.put("/userReservationList.do", new UserReservationListController());
		mappings.put("/userReservationView.do", new UserReservationViewController());
		mappings.put("/userUpdate.do", new UserUpdateController());
		mappings.put("/validateId.do", new ValidateIdController());
		mappings.put("/validateLogin.do", new ValidateLoginController());
	}
	
	public Controller getController(String key) {
		return mappings.get(key);
	}
}

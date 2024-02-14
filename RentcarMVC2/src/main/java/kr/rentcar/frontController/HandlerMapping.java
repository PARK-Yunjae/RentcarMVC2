package kr.rentcar.frontController;

import java.util.HashMap;

import kr.rentcar.controller.rentcar.*;
import kr.rentcar.controller.user.*;

public class HandlerMapping {
	private HashMap<String,Controller> mappings;

	public HandlerMapping() {
		this.mappings = new HashMap<String, Controller>();
		mappings.put("/carInfo.do", new CarInfoController());
		mappings.put("/carList.do", new CarListController());
		mappings.put("/deleteResercation.do", new DeleteReservationController());
		mappings.put("/deleteUser.do", new DeleteUserController());
		mappings.put("/insertCar.do", new InsertCarController());
		mappings.put("/loginUser.do", new LoginUserController());
		mappings.put("/logoutUser.do", new LogoutUserController());
		mappings.put("/joinUser.do", new JoinUserController());
		mappings.put("/main.do", new MainController());
		mappings.put("/reservationCar.do", new ReservationCarController());
		mappings.put("/selectCarOption.do", new SelectCarOptionController());
		mappings.put("/updateUser.do", new UpdateUserController());
		mappings.put("/uploadCarImg.do", new UploadCarImgController());
		mappings.put("/userInfomation.do", new UserInfomationController());
		mappings.put("/userResecationList.do", new UserResevationListController());
		mappings.put("/userReserveView.do", new UserReserveViewController());
		mappings.put("/validateId.do", new ValidateIdController());
	}
	
	public Controller getController(String key) {
		return mappings.get(key);
	}
}

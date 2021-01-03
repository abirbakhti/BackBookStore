package com.vermeg.ams.utilities;

import java.util.List;

public class Calculate {
	
	public static double totalPrice(List<CommandRequest> cr) {
		double tp=0;
		for(CommandRequest c : cr) {
			tp=tp+(c.getPrice()*c.getCartQuantity());
		}
		return tp;
	}

}

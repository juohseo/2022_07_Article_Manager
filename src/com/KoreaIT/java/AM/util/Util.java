package com.KoreaIT.java.AM.util;

import java.text.*;
import java.util.*;

public class Util {
	// ���� ��¥ �ð�
	public static String getNowDateStr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date time = new Date();

		return format.format(time);
	}

}
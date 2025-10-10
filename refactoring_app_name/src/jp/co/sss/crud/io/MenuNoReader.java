package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;

public class MenuNoReader {

	public static String menuNoReader(BufferedReader br) throws IOException {
		String menuNoStr = br.readLine();
		return menuNoStr;
	}

}
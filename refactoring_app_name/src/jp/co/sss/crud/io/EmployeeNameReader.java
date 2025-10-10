package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;

public class EmployeeNameReader {
	BufferedReader br;

	public EmployeeNameReader(BufferedReader br) {
		this.br = br;
	}

	public String employeeNameReader() throws IOException {
		return br.readLine();
	}
}

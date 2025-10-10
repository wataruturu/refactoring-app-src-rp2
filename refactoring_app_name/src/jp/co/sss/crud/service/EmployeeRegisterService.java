package jp.co.sss.crud.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import jp.co.sss.crud.db.DBManager;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.util.ConstantSQL;

public class EmployeeRegisterService {
	public static void employeeRegistersService(BufferedReader br)
			throws ClassNotFoundException, SQLException, IOException, ParseException {
		// 登録する値を入力

		System.out.print("社員名:");
		String empName = br.readLine();
		System.out.print("性別(0:その他, 1:男性, 2:女性, 9:回答なし):");
		String gender = br.readLine();
		System.out.print("生年月日(西暦年/月/日):");
		String birthday = br.readLine();
		System.out.print("部署ID(1:営業部、2:経理部、3:総務部):");
		String deptId = br.readLine();

		// 登録機能の呼出
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_INSERT);

			// 入力値をバインド
			preparedStatement.setString(1, empName);
			preparedStatement.setInt(2, Integer.parseInt(gender));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			preparedStatement.setObject(3, sdf.parse(birthday), Types.DATE);
			preparedStatement.setInt(4, Integer.parseInt(deptId));

			// SQL文を実行
			preparedStatement.executeUpdate();

			// 登録完了メッセージを出力
			ConsoleWriter.displayEmployeeRegistersService();
		} finally {
			DBManager.close(preparedStatement);
			DBManager.close(connection);
		}
	}
}

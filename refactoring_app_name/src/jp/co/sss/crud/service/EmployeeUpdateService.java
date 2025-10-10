package jp.co.sss.crud.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import jp.co.sss.crud.db.DBManager;
import jp.co.sss.crud.util.ConstantSQL;

public class EmployeeUpdateService {
	public static void employeeUpdateService()
			throws IOException, ClassNotFoundException, SQLException, ParseException {
		// 更新する社員IDを入力
		System.out.print("更新する社員の社員IDを入力してください：");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 更新する値を入力する
		String empId = br.readLine();
		Integer.parseInt(empId);

		// 更新機能の呼出
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// データベースに接続
			connection = DBManager.getConnection();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_UPDATE);

			System.out.print("社員名：");
			String emp_name = br.readLine();
			// 性別を入力
			System.out.print("性別(0:回答しない, 1:男性, 2:女性, 9:その他):");
			String gender = br.readLine();
			// 誕生日を入力
			System.out.print("生年月日(西暦年/月/日)：");
			String birthday = br.readLine();

			// 部署IDを入力
			System.out.print("部署ID(1：営業部、2：経理部、3：総務部)：");
			String deptId = br.readLine();

			// 入力値をバインド
			preparedStatement.setString(1, emp_name);
			preparedStatement.setInt(2, Integer.parseInt(gender));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			preparedStatement.setObject(3, sdf.parse(birthday), Types.DATE);
			preparedStatement.setInt(4, Integer.parseInt(deptId));
			preparedStatement.setInt(5, Integer.parseInt(empId));

			// SQL文の実行(失敗時は戻り値0)
			preparedStatement.executeUpdate();

		} finally {
			// クローズ処理
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
		System.out.println("社員情報を更新しました");

	}
}

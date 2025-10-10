package jp.co.sss.crud.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.sss.crud.db.DBManager;
import jp.co.sss.crud.util.ConstantSQL;

public class EmployeeAllFindService extends IEmployeeService {
	/**
	 * 全ての社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 */
	public static void employeeAllFindService() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_ALL_SELECT);

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			//resultSetの結果Setがない場合はfalse
			if (!resultSet.isBeforeFirst()) {
				System.out.println("該当者はいませんでした");
				return;
			}

			// レコードを出力
			System.out.println("社員ID\t社員名\t性別\t生年月日\t部署名");
			while (resultSet.next()) {
				System.out.print(resultSet.getString("emp_id") + "\t");
				System.out.print(resultSet.getString("emp_name") + "\t");

				int gender = Integer.parseInt(resultSet.getString("gender"));
				if (gender == 0) {
					System.out.print("回答なし" + "\t");
				} else if (gender == 1) {
					System.out.print("男性" + "\t");

				} else if (gender == 2) {
					System.out.print("女性" + "\t");

				} else if (gender == 9) {
					System.out.print("その他" + "\t");

				}

				System.out.print(resultSet.getString("birthday") + "\t");
				System.out.println(resultSet.getString("dept_name"));
			}

			System.out.println("");
		} finally {
			// ResultSetをクローズ
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}

}

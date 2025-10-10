package jp.co.sss.crud.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.sss.crud.db.DBManager;
import jp.co.sss.crud.io.ConsoleWriter;
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
			ConsoleWriter.displayEmployeeAllFind(resultSet);

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

package jp.co.sss.crud.io;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsoleWriter {

	//メニューの表示
	public static void displayMainMenu() {
		System.out.println("=== 社員管理システム ===");
		System.out.println("1.全件表示");
		System.out.println("2.社員名検索");
		System.out.println("3.部署ID検索");
		System.out.println("4.新規登録");
		System.out.println("5.更新");
		System.out.println("6.削除");
		System.out.println("7.終了");
		System.out.print("メニュー番号を入力してください：");
	}

	public static void displayEndText() {
		System.out.println("システムを終了します。");
	}

	//全件表示のレコードを出力
	public static void displayEmployeeAllFind(ResultSet resultSet) throws SQLException {

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
	}

	//社員名検索のレコードを出力
	public static void displayEmployeeFindByEmpNameService(ResultSet resultSet) throws SQLException {
		if (!resultSet.isBeforeFirst()) {
			System.out.println("該当者はいませんでした");
			return;
		}

		System.out.println("社員ID\t社員名\t性別\t生年月日\t部署名");
		while (resultSet.next()) {
			System.out.print(resultSet.getString("emp_id"));
			System.out.print("\t");

			System.out.print(resultSet.getString("emp_name"));
			System.out.print("\t");

			String genderString = resultSet.getString("gender");
			int gender = Integer.parseInt(genderString);
			if (gender == 0) {
				System.out.print("回答なし");
			} else if (gender == 1) {
				System.out.print("男性");

			} else if (gender == 2) {
				System.out.print("女性");

			} else if (gender == 9) {
				System.out.print("その他");

			}

			System.out.print("\t");
			System.out.print(resultSet.getString("birthday"));
			System.out.print("\t");

			System.out.println(resultSet.getString("dept_name"));
		}

		System.out.println("");
	}

	//部署ID検索のレコードを出力
	public static void displayEmployeeFindByDeptIdService(ResultSet resultSet) throws SQLException {

		if (!resultSet.isBeforeFirst()) {
			System.out.println("該当者はいませんでした");
			return;
		}

		System.out.println("社員ID\t社員名\t性別\t生年月日\t部署名");
		while (resultSet.next()) {
			System.out.print(resultSet.getString("emp_id"));
			System.out.print("\t");

			System.out.print(resultSet.getString("emp_name"));
			System.out.print("\t");

			String genderString = resultSet.getString("gender");
			int gender = Integer.parseInt(genderString);
			if (gender == 0) {
				System.out.print("回答なし");
			} else if (gender == 1) {
				System.out.print("男性");

			} else if (gender == 2) {
				System.out.print("女性");

			} else if (gender == 9) {
				System.out.print("その他");

			}

			System.out.print("\t");
			System.out.print(resultSet.getString("birthday"));
			System.out.print("\t");

			String deptIdString = resultSet.getString("dept_id");
			int deptId2 = Integer.parseInt(deptIdString);
			if (deptId2 == 1) {
				System.out.println("営業部");
			} else if (deptId2 == 2) {
				System.out.println("経理部");
			} else if (gender == 3) {
				System.out.println("総務部");

			}
		}

		System.out.println("");
	}

	public static void displayEmployeeRegistersService() {
		System.out.println("社員情報を登録しました");
	}

	public static void displayEmployeeUpdateService() {
		System.out.println("社員情報を更新しました");
	}

	public static void displayEmployeeDeleteService() {
		System.out.println("社員情報を削除しました");
	}
}

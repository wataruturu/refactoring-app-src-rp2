package jp.co.sss.crud.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.MenuNoReader;
import jp.co.sss.crud.service.EmployeeAllFindService;
import jp.co.sss.crud.service.EmployeeDeleteService;
import jp.co.sss.crud.service.EmployeeFindByDeptIdService;
import jp.co.sss.crud.service.EmployeeFindByEmpNameService;
import jp.co.sss.crud.service.EmployeeRegisterService;
import jp.co.sss.crud.service.EmployeeUpdateService;

/**
 * 社員情報管理システム開始クラス 社員情報管理システムはこのクラスから始まる。<br/>
 * メニュー画面を表示する。
 *
 * @author System Shared
 *コミット、プッシュのテスト
 */
public class MainSystem {
	/**
	 * 社員管理システムを起動
	 *
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int menuNo = 0;

		do {
			// メニューの表示
			ConsoleWriter.displayMainMenu();

			// メニュー番号の入力

			menuNo = Integer.parseInt(MenuNoReader.menuNoReader(br));

			// 機能の呼出
			switch (menuNo) {
			case 1:
				// 全件表示機能の呼出
				EmployeeAllFindService.employeeAllFindService();
				;
				break;

			case 2:
				// 社員名検索機能の呼び出し
				EmployeeFindByEmpNameService.employeeFindByEmpNameService(br);
				break;

			case 3:
				// 部署ID検索機能の呼び出し
				EmployeeFindByDeptIdService.employeeFindByDeptIdService(br);
				break;

			case 4:
				//新規登録機能の呼び出し
				EmployeeRegisterService.employeeRegistersService(br);
				break;

			case 5:
				//更新機能の呼出
				EmployeeUpdateService.employeeUpdateService();

				break;

			case 6:
				//削除機能呼び出し
				EmployeeDeleteService.employeeDeleteService();
				break;

			}
		} while (menuNo != 7);
		//終了時の文章を表示
		ConsoleWriter.displayEndText();
	}
}

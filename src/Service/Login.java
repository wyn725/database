package Service;
import Utils.DAOFactory;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
public class Login {
    //主菜单
    public static void mainMenu(String userid, int roleNum) throws ParseException, IOException {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("*******功能选择*******");
            System.out.println("1-园林植物基本信息管理");
            System.out.println("2-园林植物分类管理");
            System.out.println("3-园林植物养护管理");
            System.out.println("4-园林植物病虫害防治管理");
            System.out.println("5-园林植物监测管理");
            System.out.println("6-用户管理");
            System.out.println("7-退出");
            System.out.print("请输入选择：");
            int c = sc.nextInt();
            while (c != 1 && c != 2 && c != 3 && c != 4 && c != 5 && c != 6) {
                System.out.println("您的输入错误，请输入1/2/3/4/5/6!");
                c = sc.nextInt();
            }
            switch (c) {
                case 1:
                    InformationService.service(userid, roleNum);
                    break;
                case 2:
            }
        }
    }

    /**
     * 因为username是主码，所以1个username只对应一个角色，但是一个no可以有多个username
     *
     * @return 登陆成功返回true，失败返回false
     */
    public static void login() throws ParseException, IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("*******园林植物综合管理系统*******");
        System.out.println("请输入您的用户名：");
        String username = sc.nextLine();
        System.out.println("请输入您的密码：");
        String password = sc.nextLine();
        System.out.println("1 系统管理员");
        System.out.println("2 上级主管部门");
        System.out.println("3 养护人员");
        System.out.println("4 防治人员");
        System.out.println("5 监测人员");
        System.out.println("请输入该账户的角色序号：");
        String role = null;
        int roleNum = sc.nextInt();
        while (roleNum != 1 && roleNum != 2 && roleNum != 3 && roleNum != 4 && roleNum != 5) {
            System.out.println("输入错误！请输入1/2/3/4/5!");
            roleNum = sc.nextInt();
        }
        if (roleNum == 1) {
            role = "admin";
        } else if (roleNum == 2) {
            role = "leader";
        } else if (roleNum == 3) {
            role = "yhstaff";
        } else if (roleNum == 4) {
            role = "fzstaff";
        } else if (roleNum == 5) {
            role = "jcstaff";
        }
        // 从数据表中查询到的password和role
        String realPassword = DAOFactory.getInstance().getLoginCheckDAO().getLoginCheckByUsername(username).getPassword();
        String realRole = DAOFactory.getInstance().getLoginDetailDAO().getLoginDetailByUsername(username).getRole();

        if (realPassword!=null && realRole!=null && realPassword.trim().equals(password.trim()) && realRole.trim().equals(role)) {
            System.out.println("登录成功");
            mainMenu(DAOFactory.getInstance().getLoginDetailDAO().getLoginDetailByUsername(username).getNo(),roleNum);
        } else {
            System.out.println("登陆失败");
        }
    }
}



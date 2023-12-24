package Utils;
import Dao.*;
import Dao.Impl.*;
public class DAOFactory {
    private static DAOFactory daoFactory;
    static {
        daoFactory = new DAOFactory();
    }
    public static DAOFactory getInstance(){
        return daoFactory;
    }
    public LoginCheckDAO getLoginCheckDAO() {
        return new LoginCheckDAOImpl();
    }

    public LoginDetailDAO getLoginDetailDAO() {
        return new LoginDetailDAOImpl();
    }
}

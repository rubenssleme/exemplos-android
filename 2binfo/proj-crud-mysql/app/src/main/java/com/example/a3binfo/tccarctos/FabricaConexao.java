import android.os.AsyncTask;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao  extends AsyncTask {
    Connection con = null;
    @Override
    protected Object doInBackground(Object[] objects) {
        //BUROCRACIA
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //IMPORTANTE
        try {
            con= DriverManager.getConnection("jdbc:mysql://sql175.main-hosting.eu/u511412856_help","u511412856_arcto", "1234567");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}

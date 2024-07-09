package repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Season;

public class SeasonRepositorio {
    String url="jdbc:mysql://127.0.0.1:3306/formula1";
    String usuario="cristhian";
    String contrasenia="cris03022";

    public List<Season> yearGeneral(){
        List<Season> listSeasons=new ArrayList<Season>();

        try {
            Connection cnt=DriverManager.getConnection(url, usuario, contrasenia);

            String sql="SELECT * FROM `seasons`;";
            Statement st=cnt.createStatement();
            ResultSet rs=st.executeQuery(sql);

            while (rs.next()) {
                int year=rs.getInt("year");
                String url=rs.getString("url");

                Season s=new Season(year, url);

                listSeasons.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
			System.out.println("=".repeat(30)+"¡ERROR EN LA BASE DE DATOS!"+"=".repeat(30));
        }
        return listSeasons;
    }

    public List<Season> yearOrderBy(){
        List<Season> listSeasons=new ArrayList<Season>();

        try {
            Connection cnt=DriverManager.getConnection(url, usuario, contrasenia);

            String sql="SELECT * FROM `seasons`\n"
                    +"ORDER BY year DESC;";
            Statement st=cnt.createStatement();
            ResultSet rs=st.executeQuery(sql);

            while (rs.next()) {
                int year=rs.getInt("year");
                String url=rs.getString("url");

                Season s=new Season(year, url);

                listSeasons.add(s);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("\n\n"+"=".repeat(70)+"\nFALLO EN LA BASE DE DATOS, INTÉNTELO DE NUEVO O MÁS TARDE!\n"+"=".repeat(70));
        }
        return listSeasons;
    }
}

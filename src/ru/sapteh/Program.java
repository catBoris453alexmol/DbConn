package ru.sapteh;

import ru.sapteh.model.Auto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) throws IOException {
        Connection connection = DataBaseConnection.getConnection();

        List<Auto> autos = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Просмотр данных из бд -s: ");
        System.out.println("Добавить данные в бд -i: ");
        System.out.println("Обновить данные из бд -u: ");
        System.out.println("Удалить данные из бд -d: ");


        String strReader = reader.readLine();
        if (strReader.equals("-s")){
            String sql = String.format("SELECT * FROM " + Auto.TABLE_NAME);
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Long id = resultSet.getLong(Auto.ID_COLUMN);
                String marka = resultSet.getString(Auto.MARKA_COLUMN);
                String model = resultSet.getString("model");
                String proiz = resultSet.getString("proiz");
                String age = resultSet.getString("age");
                String color = resultSet.getString("color");
                Auto auto = new Auto(id,marka,model,proiz,age,color);
                autos.add(auto);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(autos);
    }
        if (strReader.equals("-i")){
            System.out.println("input mark: ");
            String mark = reader.readLine();
            System.out.println("input model: ");
            String model = reader.readLine();
            System.out.println("input proiz: ");
            String proiz = reader.readLine();
            System.out.println("input age: ");
            String age = reader.readLine();
            System.out.println("input color: ");
            String color = reader.readLine();

            Auto auto = new Auto((long) (autos.size() + 1), mark,model,proiz,age,color);
            try {
                String sql = String.format("INSERT INTO  " + Auto.TABLE_NAME +"(marka, model, proiz, age, color) VALUES (%s, %s, %s, %s, %s)");
                PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString( 1,auto.getMarka());
                statement.setString( 2,auto.getModel());
                statement.setString( 3,auto.getProiz());
                statement.setString( 4,auto.getAge());
                statement.setString( 5,auto.getColor());
                statement.executeUpdate();
                    autos.add(auto);
                } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }
}


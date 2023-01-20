package dao.DataBase;

import dao.fabric.StartDBSingleton;
import dto.JenreDTO;
import service.StartDAtaBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JenreDaoDB {
    private final StartDAtaBase sdb;

    public JenreDaoDB(StartDAtaBase sdb) {
        this.sdb = StartDBSingleton.getInstance();
    }

    public List<JenreDTO> getJanresDB()  {
        List<JenreDTO> ljdto=new ArrayList<>();
        try(Connection connection= sdb.load();
        PreparedStatement preparedStatement= connection.prepareStatement("SELECT id, name FROM app.Jenre"+"ORDER BY id;")){
        ResultSet resultSet= preparedStatement.executeQuery();
        while (resultSet.next()){
            int id= resultSet.getInt("id");
            String name= resultSet.getString("name");
            ljdto.add(new JenreDTO(id,name));
        }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return  ljdto;
    }

    public  boolean addJanre(String newNameJanre){
        try(Connection connection= sdb.load();
        PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO app.Jenre (name)"+"VALUES (?)")){
            preparedStatement.setString(1, newNameJanre);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            throw  new RuntimeException(e);
        }
        return true;
        }

    public  void  updateListJanre(int id, String nameJanre){
        try(Connection connection= sdb.load();
        PreparedStatement preparedStatement=connection.prepareStatement("UPDATE app.Jenre"+"SET name=&"+"WHERE id=?;")) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2,nameJanre);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
            }
        }


    public  boolean  deletetJanre(int id){
        try(Connection connection= sdb.load();
            PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM app.Jenre"+"WHERE id=?;")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return false;
    }

    public boolean exist(int id){
        List<JenreDTO> jenres=getJanresDB();
        for(JenreDTO jenreDTO:jenres){
            if (id== jenreDTO.getIdJenre()){
                return true;
            }
        }
        return false;
    }

    }






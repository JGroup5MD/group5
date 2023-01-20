package dao.DataBase;

import dao.fabric.SingerDaoSingleton;
import dao.fabric.StartDBSingleton;
import dto.JenreDTO;
import dto.SingerDTO;
import service.StartDAtaBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SingerDaoDB {


 private final StartDAtaBase sdb;

 public SingerDaoDB() {
  this.sdb = new StartDAtaBase();
 }

 public List<SingerDTO> getSingersDB()  {
  List<SingerDTO> ljdto=new ArrayList<>();
  try(Connection connection= sdb.load();
      PreparedStatement preparedStatement= connection.prepareStatement("SELECT id, name FROM app.Singer"+"ORDER BY id;")){
   ResultSet resultSet= preparedStatement.executeQuery();
   while (resultSet.next()){
    int id= resultSet.getInt("id");
    String name= resultSet.getString("name");
    ljdto.add(new SingerDTO(id,name));
   }
  }catch (SQLException e){
   throw new RuntimeException(e);
  }
  return  ljdto;
 }

 public  boolean addSinger(String newNameSinger){
  try(Connection connection= sdb.load();
      PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO app.Singer (name)"+"VALUES (?)")){
   preparedStatement.setString(1, newNameSinger);
   preparedStatement.executeUpdate();
  } catch (SQLException e){
   throw  new RuntimeException(e);
  }
  return true;
 }

 public  void  updateListSinger(int id, String nameSinger){
  try(Connection connection= sdb.load();
      PreparedStatement preparedStatement=connection.prepareStatement("UPDATE app.Singer"+"SET name=&"+"WHERE id=?;")) {
   preparedStatement.setInt(1, id);
   preparedStatement.setString(2,nameSinger);
   preparedStatement.executeUpdate();
  }catch (SQLException e){
   throw new RuntimeException(e);
  }
 }


 public  boolean  deletetJanre(int id){
  try(Connection connection= sdb.load();
      PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM app.Singer"+"WHERE id=?;")) {
   preparedStatement.setInt(1, id);
   preparedStatement.executeUpdate();
  }catch (SQLException e){
   throw new RuntimeException(e);
  }
  return false;
 }

 public boolean exist(int id){
  List<SingerDTO> singers=getSingersDB();
  for(SingerDTO singerDTO: singers){
   if (id== singerDTO.getIdSinger()){
    return true;
   }
  }
  return false;
 }
}


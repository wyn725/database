package Dao.plant;

import Entity.Plant;
import java.util.List;
import java.util.Map;

public interface PlantDao {
    void addPlant(Plant plant);                      //添加植物信息
    void deletePlant(Plant plant);                     //删除植物信息
    void updatePlant(Plant plant,String[] fieldsToUpdate, String newValue);                   //修改植物信息
    List<Plant> findPlant(String id, int i);           //1是学生查看，2是导师查看所有，3学科负责人查看所有
}

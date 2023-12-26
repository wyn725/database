package Dao;

import Entity.Plant;
import java.util.List;
import java.util.Map;

public interface PlantDao {
    void addPlant(Plant plant);                      //添加植物信息
    void deletePlant(Plant plant);                     //删除植物信息
    void updatePlant(Plant plant,String[] fieldsToUpdate, String newValue);        //修改植物信息
    void findPlant(Plant plant);            //查看植物基本信息
}

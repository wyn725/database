package Entity;

public class Picture {
    public String photoId;
    public String photoPlace;     //植物名称
    public String familyname;     //植物科名
    public String feature;     //植物特征
    public String value;      //植物应用价值
    public String skill;     //栽培要点
    public int classifyID;    //分类编号
    public String disAreaID;       //地区编号


    public String getphotoId() {
        return photoId;
    }

    public void setphotoId(String photoId) {
        this.id = id;
    }

    public String getphotoPlace() {
        return photoPlace;
    }

    public void setphotoPlace(String photoPlace) {
        this.photoPlace = photoPlace;
    }

    public String getFamilyname() {
        return familyname;
    }

    public void setFamilyname(String familyname) {
        this.familyname = familyname;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public int getClassifyID() {
        return classifyID;
    }

    public void setClassifyID(int classifyID) {
        this.classifyID = classifyID;
    }

    public String getDisAreaID() {
        return disAreaID;
    }

    public void setDisAreaID(String disAreaID) {
        this.disAreaID = disAreaID;
    }

    @Override
    public String toString() {
        return "植物{" +
                "植物id='" + id + '\'' +
                ", 植物名称='" + photoPlace + '\'' +
                ", 植物科名='" + familyname + '\'' +
                ", 植物特征='" + feature + '\'' +
                ", 植物应用价值='" + value + '\'' +
                ", 植物栽培要点='" + skill + '\'' +
                ", 分类编号=" + classifyID +
                ", 地区编号='" + disAreaID + '\'' +
                '}';
    }
}

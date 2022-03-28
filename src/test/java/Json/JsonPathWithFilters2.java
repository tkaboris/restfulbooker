package Json;

import java.io.File;
import java.util.List;

import io.restassured.path.json.JsonPath;

public class JsonPathWithFilters2 {
    public static void main(String[] args) {

        //String filePath = System.getProperty("user.dir")+"src/test/java/Json/people1.json";
        File jsonArrayFile = new File("src/test/java/Json/people1.json");

        JsonPath jsonPath = new JsonPath(jsonArrayFile);

        System.out.println(jsonPath.getString("data[0].first_name"));


        List<String> allFemaleFirstnames = jsonPath.getList("data.findAll{it.gender == 'Female'}.first_name");
        System.out.println(allFemaleFirstnames);


    }
}

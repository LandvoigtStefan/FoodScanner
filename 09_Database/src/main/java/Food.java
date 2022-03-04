import java.util.HashMap;
import java.util.List;

public class Food {
    private String mName;
    private int mId;
    private String mFoodGroup;
    HashMap<String, Integer> mNutritions;
    public Food(Integer id, String name, String foodGroup, Integer calories, Integer fat, Integer proteins,
                Integer carbohydrates, Integer sugar, Integer fiber, Integer cholesterol, Integer saturatedFats){
        mName = name;
        mId = id;
        mFoodGroup = foodGroup;
        mNutritions.put("Kalorien", calories);
        mNutritions.put("Fett", fat);
        mNutritions.put("Proteine", proteins);
        mNutritions.put("Kohlenhydrate", carbohydrates);
        mNutritions.put("Zucker", sugar);
        mNutritions.put("Ballaststoffe", fiber);
        mNutritions.put("Cholesterin", cholesterol);
        mNutritions.put("GesätigteFettsäuren", saturatedFats);
    }

    public String getmName() {
        return mName;
    }

    public int getmId() {
        return mId;
    }

    public String getmFoodGroup() {
        return mFoodGroup;
    }
}

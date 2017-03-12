package Service;

/**
 * Created by jasper wil.lankhorst on 8-2-2017.
 */
public class ModelService {

    private static ModelService _instance = new ModelService();

    public static ModelService get(){
        return _instance;
    }

    private ModelService(){}

    public void function(){
    }
}

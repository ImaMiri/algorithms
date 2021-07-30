package interview;

/**
 * Created by ima on 9/1/19.
 */
public class FactoryMethod {

    public static FactoryMethod createFactoryMethod(FactoryType type){
        if(type == FactoryType.BLACK){
            return new BlackFactoryMethod();
        }else if(type == FactoryType.RED){
            return new RedFactoryMethod();
        }
        return null;
    }
}

package za.ac.cput.communitystoremarketplace.util;

public class Helper {
    public static boolean isNullorEmpty(String anyString){
        if(anyString==null || anyString.equals("")){
            return true;
        }
        return false;
    }
}

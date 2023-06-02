public class validations {
    
    public boolean checkNumber(String value)
    {
        if(value.matches("[0-9]*"))
        {
            return true;
        }
        return false;
    }

    public boolean checkString(String value)
    {
        if(value.matches("[a-zA-Z]*")){
            return true;
        }
        return false;
    }
}

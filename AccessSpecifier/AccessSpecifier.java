

public class AccessSpecifier{

    private String privateData = "Private data";

    String defaultdata = "default data";

    protected String protectedData = "protected data";

    public String publicData = "public data";

    private String getPrivateData(){
        return privateData;
    }

    String getDefaultData(){
        return defaultdata;
    }

    protected String getProtectedData(){
        return protectedData;
    }

    public String getPublicData(){
        return publicData;
    }

    public static void main(String[] args){

        AccessSpecifier accessSpecifier = new AccessSpecifier();

        System.out.println("public - data : " + accessSpecifier.publicData);
        System.out.println("default - data : " + accessSpecifier.defaultdata);
        System.out.println("protected - data : " + accessSpecifier.protectedData);

        //using get methods
        System.out.println("get public - data : " + accessSpecifier.getPublicData());
        System.out.println("get default - data : " + accessSpecifier.getDefaultData());
        System.out.println("get protected - data : " + accessSpecifier.getProtectedData());

        System.out.println("Private Method : " + accessSpecifier.privateData);
        System.out.println("Private Method (accessed internally): " + accessSpecifier.getPrivateData());

    }
}
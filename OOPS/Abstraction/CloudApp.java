//Interface with Default Methods (Cloud Storage Service)

interface CloudStorage{

    void uploadFile(String fileName);

    default void encryptData(){
        System.out.println("encrypting file defore upload");
    }
}

class AzureStorage implements CloudStorage{

    @Override 
    public void uploadFile(String fileName){
        encryptData();
        System.out.println("file upload successfully");
    }
}

public class CloudApp{
    public static void main(String[] args){
        CloudStorage azureUpload = new AzureStorage();
        azureUpload.uploadFile("report.pdf");
    }
}
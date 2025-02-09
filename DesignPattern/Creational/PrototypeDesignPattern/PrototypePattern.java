// Prototype Interface
class Document implements Cloneable {
    private String content;

    public Document(String content) { this.content = content; }
    public void setContent(String content) { this.content = content; }
    public void display() { System.out.println("Document Content: " + content); }

    public Document clone() throws CloneNotSupportedException {
        return (Document) super.clone();
    }
}

// Client
public class PrototypePattern {
    public static void main(String[] args) throws CloneNotSupportedException {
        Document template = new Document("Standard Template");
        Document newDoc = template.clone();
        newDoc.setContent("Modified Document");

        template.display();
        newDoc.display();
    }
}


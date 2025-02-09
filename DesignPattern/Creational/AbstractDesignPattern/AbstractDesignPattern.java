interface Button{
    void render();
}

interface Checkbox{
    void render();
}

interface GUIFactory{
    Button createButton();
    Checkbox createCheckbox();
}

class WindowsButton implements Button{
    @Override
    public void render() {
        System.out.println("Rendering Windows Button");
    }
}

class WindowsCheckbox implements Checkbox{
    @Override
    public void render() {
        System.out.println("Rendering Windows Checkbox");
    }
}

class MacOSButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering macOS Button");
    }
}

class MacOSCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering macOS Checkbox");
    }
}


//concreate facktory for windows
class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

// Concrete Factory for macOS
class MacOSFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}

// Client code
public class AbstractDesignPattern {
    private static GUIFactory configureFactory(String os) {
        if (os.equalsIgnoreCase("Windows")) {
            return new WindowsFactory();
        } else if (os.equalsIgnoreCase("MacOS")) {
            return new MacOSFactory();
        }
        throw new IllegalArgumentException("Unsupported OS");
    }

    public static void main(String[] args) {
        String os = "Windows"; // Change to "MacOS" for macOS
        GUIFactory factory = configureFactory(os);

        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        button.render();
        checkbox.render();
    }
}



import java.util.Stack;

class UndoRedoManager{
    private final Stack<String> undoStack;
    private final Stack<String> redoStack;

    public UndoRedoManager(){
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    public synchronized void pushAction(String message){
        undoStack.push(message);
        redoStack.clear();//clear the redo stack whenever the undo gets performed...
    }

    public synchronized String undo() {
        if (!undoStack.isEmpty()) {
            String action = undoStack.pop();
            redoStack.push(action);
            return "Undone: " + action;
        }
        return "Nothing to undo";
    }

    // Method to perform a redo operation
    public synchronized String redo() {
        if (!redoStack.isEmpty()) {
            String action = redoStack.pop();
            undoStack.push(action);
            return "Redone: " + action;
        }
        return "Nothing to redo";
    }
    
    public synchronized void printStacks() {
        System.out.println("Undo Stack: " + undoStack);
        System.out.println("Redo Stack: " + redoStack);
    }

}



public class TextEditorApp{
    public static void main(String[] args){

        UndoRedoManager manager = new UndoRedoManager();

        manager.pushAction("User typed 'Hello'");
        manager.pushAction("User typed ' World'");
        manager.pushAction("User deleted ' World'");
        manager.pushAction("User typed ' Java'");

        manager.printStacks();  // Print the current state of the stacks
    
        System.out.println(manager.undo());  // Undo the last action
        manager.printStacks();  // Print after undo

        System.out.println(manager.redo());  // Redo the undone action
        manager.printStacks();  // Print after redo

    }
}
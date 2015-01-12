package example.plugins;


public class TodoListPlugin implements Plugin {

    @Override
    public String getHtmlContent() {
        return "<b>TodoList:</b><ol><li>Clean Kitchen</li><li>Write Todolist.</li></ol>";
    }
    
}

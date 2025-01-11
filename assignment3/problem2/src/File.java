import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class File implements Component{
    private String name;
    private int size;
    private LocalDateTime creationTime;
    private String path;
    private Component parent;
    public File(int size,String name)
    {
        this.size=size;
        this.name=name;
        creationTime = LocalDateTime.now();
    }
    @Override
    public int getSize()
    {
        return size;
    }
    @Override
    public String getName()
    {
        return name;
    }
    @Override
    public int getCount()
    {
        return 1;
    }
    @Override
    public LocalDateTime getTime()
    {
        return creationTime;
    }
    @Override
    public String getType()
    {
        return "File";
    }
    @Override
    public ArrayList<Component> getComponentsList()
    {
        return new ArrayList<Component>();
    }
    @Override
    public String getDirectory()
    {
       return path;
    }
    @Override
    public void setDirectory(String path)
    {
        this.path=path;
    }
    @Override
    public void setParent(Component obj)
    {
        this.parent=obj;
    }
    @Override
    public Component getParent()
    {
        return this.parent;
    }
}

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Drive implements Component{
    String name;
    ArrayList<Component> componentsList;
    private LocalDateTime creationTime;
    String path;
    Component parent;

    public Drive(String name)
    {
        this.name=name;
        creationTime = LocalDateTime.now();
        componentsList=new ArrayList<>();
    }
    @Override
    public int getSize()
    {
        int size=0;
        for(Component x:componentsList)
        {
            size+= x.getSize();
        }
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
        return componentsList.size();
    }
    @Override
    public LocalDateTime getTime()
    {
        return creationTime;
    }
    @Override
    public String getType()
    {
        return "Drive";
    }
    @Override
    public ArrayList<Component> getComponentsList()
    {
        return componentsList;
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

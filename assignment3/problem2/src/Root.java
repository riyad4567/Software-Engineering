import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Root implements Component{
    private String name;
    private ArrayList<Component> componentsList;
    private LocalDateTime creationTime;
    private String path;
    private Component parent;

    public Root(){componentsList=new ArrayList<>();creationTime = LocalDateTime.now();}
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
        return "Root";
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

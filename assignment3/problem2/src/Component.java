import java.time.LocalDateTime;
import java.util.ArrayList;
public interface Component {
    int getSize();
    String getDirectory();
    LocalDateTime getTime();
    String getType();
    int getCount();
    ArrayList<Component> getComponentsList();
    String getName();
    void setDirectory(String path);
    void setParent(Component obj);
    Component getParent();
}

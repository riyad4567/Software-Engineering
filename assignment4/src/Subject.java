import java.io.IOException;
import java.util.Map;

public interface Subject {
     void notifyUsers(Map<Observer, SocketWrapper> userWithSocket)throws IOException;
     void addUser(Observer user);
     void removeUser(Observer user);
}

import java.time.format.DateTimeFormatter;

public class FileSystem {
    public void touch(String name, int size, Component obj) {
        if (obj instanceof Root) {
            System.out.println("Can't create file");
        } else {
            File temp = new File(size, name);
            temp.setParent(obj);
            temp.setDirectory(obj.getDirectory() + "\\" + name);
            obj.getComponentsList().add(temp);
            System.out.println("File has been created");
        }
    }

    public void makeDrive(String name, Component current, Root root) {
        if (current == root) {
            Drive temp = new Drive(name);
            temp.setParent(root);
            root.getComponentsList().add(temp);
            temp.setDirectory(name+":");
            System.out.println("Drive has been created");
        } else {
            System.out.println("Can't create Drive");
        }
    }

    public void makeFolder(String name, Component current) {
        if (current instanceof Root) {
            System.out.println("Can't create folder");
        } else {
            Folder temp = new Folder(name);
            current.getComponentsList().add(temp);
            temp.setParent(current);
            temp.setDirectory(temp.getParent().getDirectory()+"\\"+name);
            System.out.println("Folder has been created");
        }
    }

    public Component changeDirectory(String name, Component current) {
        for(Component x:current.getComponentsList())
        {
            if(x.getName().equals(name))
            {
                if(x instanceof File)
                {
                    System.out.println("Can't change directory ,, It is a file");
                    return current;
                }
                else{
                    System.out.println("Directory has been changed");
                    return x;
                }
            }
        }
        System.out.println("Can't find in current directory");
        return current;
    }

    public void helpDetails(Component obj) {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd MMMM, yyyy h:mm a");
        String formattedDate = obj.getTime().format(myFormatObj);
        System.out.println("Name: " + obj.getName());
        System.out.println("Type: " + obj.getType());
        System.out.println("Size: " + obj.getSize());
        System.out.println("Directory: " + obj.getDirectory());
        System.out.println("Component: " + obj.getCount());
        System.out.println("Creation Time: " + formattedDate);
    }

    public void details(Component obj, String name) {
        if (obj.getName().equals(name)) {
            helpDetails(obj);
        } else {
            for (Component x : obj.getComponentsList()) {
                if (x.getName().equals(name)) {
                    helpDetails(x);
                    return;
                }
            }
            System.out.println("Can not find in current directory ");
        }
    }

    public Component delete(Component current, String name) {
        Component temp = current.getParent();
        if (current.getName().equals(name)) {
            if (current.getComponentsList().isEmpty()) {
                temp.getComponentsList().remove(current);
                System.out.println("Deleting.........");
                return temp;
            } else {
                System.out.println("Can't delete this directory");
                return current;
            }
        } else {
            for (Component x : current.getComponentsList()) {
                if (x.getName().equals(name)) {
                    if (x.getComponentsList().isEmpty()) {
                        current.getComponentsList().remove(x);
                        System.out.println("Deleting.........");
                        return current;
                    } else {
                        System.out.println("Can't delete this directory");
                        return current;
                    }
                }
            }
            System.out.println("Can not find in current directory ");
            return current;
        }
    }

    public Component recursiveDelete(Component current, String name) {
        Component temp = current.getParent();
        if (current.getName().equals(name)) {
            current.getComponentsList().clear();
            temp.getComponentsList().remove(current);
            System.out.println("Recursive deletion completed");
            return temp;
        } else {
            for (Component x : current.getComponentsList()) {
                if (x.getName().equals(name)) {
                    if (x instanceof File) {
                        current.getComponentsList().remove(x);
                        System.out.println("Warning!!!File in recursive deletion");
                        return current;
                    } else {
                        x.getComponentsList().clear();
                        current.getComponentsList().remove(x);
                        System.out.println("Recursive deletion completed");
                        return current;
                    }
                }
            }
            System.out.println("Can not find in current directory");
            return current;
        }
    }
    public void listing(Component current)
    {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        for(Component x: current.getComponentsList())
        {
            String formattedDate = x.getTime().format(myFormatObj);
            System.out.println(x.getName()+"    "+x.getSize()+"KB"+"     "+formattedDate);
        }
    }

}

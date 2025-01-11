import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String str, name;
        int size = 0;
        boolean flag = true;
        Scanner input = new Scanner(System.in);
        Root root = new Root();
        root.setParent(null);
        Component current = root;
        FileSystem obj = new FileSystem();
        while (flag) {
            str = input.next();
            if (str.equals("touch")) {
                name = input.next();
                size = input.nextInt();
                obj.touch(name, size, current);
                //System.out.println("Current directory: "+current.getDirectory());
            } else if (str.equals("Is")) {
                name = input.next();
                obj.details(current, name);
                //System.out.println("Current directory: "+current.getDirectory());
            } else if (str.equals("mkdrive")) {
                name = input.next();
                obj.makeDrive(name, current, root);
            } else if (str.equals("delete")) {
                String local=input.next();
                if(local.equals("-r"))
                {
                    name = input.next();
                    current=obj.recursiveDelete(current,name);
                }
                else{
                    current = obj.delete(current,local);
                }
                //System.out.println("Current directory: "+current.getDirectory());
            } else if (str.equals("mkdir")) {
                name = input.next();
                obj.makeFolder(name, current);
                //System.out.println("Current directory: "+current.getDirectory());
            } else if (str.equals("cd")) {
                name = input.next();
                if(name.equals("~"))
                {
                   current=root;
                  //  System.out.println("Current directory: ");
                }
                else{
                    String []arr=name.split(":");
                    current=obj.changeDirectory(arr[0],current);
                   // System.out.println("Current directory: "+current.getDirectory());
                }
            } else if (str.equals("list")) {
                obj.listing(current);
                //System.out.println("Current directory: "+current.getDirectory());
            } else if(str.equals("close"))
            {
                flag=false;
            }
        }
    }
}
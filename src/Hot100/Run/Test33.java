package Hot100.Run;

import Hot100.Medium.So33Combine;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Test33 {
    public static void main(String args[]) throws FileNotFoundException {
        So33Combine so = new So33Combine();
        List<List<Integer>> ans = so.combine(4, 2);
        System.out.println(ans);

        File directory = new File("");
        String courseFile = directory.getPath();
        System.out.println("path2: " + courseFile);

        File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();
        String desktopPath = desktopDir.getAbsolutePath();
        System.out.println(desktopPath);
        String newDesktopPath = desktopPath+"\\result.txt";
        System.out.println(newDesktopPath);

        File newFile = new File(newDesktopPath);
        FileOutputStream out = new FileOutputStream(newFile);

    }

}

package net.asherchurch.book.utils;

import android.os.Environment;

import java.io.File;
import java.io.IOException;

public class CustomSecurityManager {
    private static final String ROOT_PATH = Environment.getExternalStorageDirectory() + "";
    private static final String[] sRootFilesPath;

    static {
        sRootFilesPath = new String[] {
                ROOT_PATH + "/system/bin/su",
                ROOT_PATH + "/system/xbin/su",
                ROOT_PATH + "/system/app/SuperUser.apk",
                ROOT_PATH + "/data/data/com.noshufou.android.su"
        };
    }

    public static boolean isRooting() {
        boolean isRootingFlag = false;

        try {
            Runtime.getRuntime().exec("su");
            isRootingFlag = true;
        }
        catch(IOException e) {}

        if(!isRootingFlag) {
            isRootingFlag = checkRootingFiles(createFiles(sRootFilesPath));
        }

        return isRootingFlag;
    }

    private static File[] createFiles(String[] sFiles) {
        int fileCount = sFiles.length;
        File[] rootingFiles = new File[fileCount];
        for(int i=0; i<fileCount; i++) {
            rootingFiles[i] = new File(sFiles[i]);
        }

        return rootingFiles;
    }

    private static boolean checkRootingFiles(File... files) {
        boolean result = false;
        for(File f : files) {
            if(f != null && f.exists() && f.isFile()) {
                result = true;
                break;
            }
        }

        return result;
    }

}

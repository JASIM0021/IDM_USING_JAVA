package org.example;

import org.example.config.models.FileInfo;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Downloader extends  Thread {
    private FileInfo file;

    DownloadManager manager;
    public Downloader(FileInfo file,DownloadManager manager){
        this.file=file;
        this.manager=manager;
    }
    public void run (){
        this.file.setStatus("DOWNLOADING...");
        this.manager.updateUI(this.file);
//        download logic
        try {
            Files.copy(new URL(this.file.getUrl()).openStream(), Paths.get(this.file.getPath()));
            file.setStatus("DONE");
        } catch (IOException e) {
            file.setStatus("FAILD");
            throw new RuntimeException(e);
        }
        this.manager.updateUI(this.file);


    }

}

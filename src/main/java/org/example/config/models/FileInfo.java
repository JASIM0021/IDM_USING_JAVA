package org.example.config.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import org.example.DownloadManager;

public class FileInfo {
    private SimpleStringProperty index=new SimpleStringProperty();
    private SimpleStringProperty fileName=new SimpleStringProperty();
    private SimpleStringProperty url=new SimpleStringProperty();
    private SimpleStringProperty status=new SimpleStringProperty();
//    Downloading.. ,Done, Starting
    private SimpleStringProperty action=new SimpleStringProperty();
    private SimpleStringProperty path=new SimpleStringProperty();
    private DownloadManager downloadManagerController;

    public FileInfo(String index, String fileName, String url, String status,String action,String path, DownloadManager downloadManagerController) {
        this.index.set(index);
        this.fileName.set(fileName);
        this.url.set(url);
        this.status.set(status);
        this.action.set(action);
        this.path.set(path);

    }

    public String getIndex() {
        return index.get();
    }

    public SimpleStringProperty indexProperty() {
        return index;
    }

    public void setIndex(String index) {
        this.index.set(index);
    }

    public String getFileName() {
        return fileName.get();
    }

    public SimpleStringProperty fileNameProperty() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName.set(fileName);
    }

    public String getUrl() {
        return url.get();
    }

    public SimpleStringProperty urlProperty() {
        return url;
    }

    public void setUrl(String url) {
        this.url.set(url);
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public String getAction() {
        return action.get();
    }

    public SimpleStringProperty actionProperty() {
        return action;
    }

    public void setAction(String action) {
        this.action.set(action);
    }

    public String getPath() {
        return path.get();
    }

    public SimpleStringProperty pathProperty() {
        return path;
    }

    public void setPath(String path) {
        this.path.set(path);
    }

    public DownloadManager getDownloadManagerController() {
        return downloadManagerController;
    }

    public void setDownloadManagerController(DownloadManager downloadManagerController) {
        this.downloadManagerController = downloadManagerController;
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "index=" + index +
                ", fileName=" + fileName +
                ", url=" + url +
                ", status=" + status +
                ", action=" + action +
                ", path=" + path +
                ", downloadManagerController=" + downloadManagerController +
                '}';
    }
}
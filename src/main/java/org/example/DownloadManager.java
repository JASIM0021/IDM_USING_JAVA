package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.example.config.AppConfig;
import org.example.config.models.FileInfo;

import java.io.File;

public class DownloadManager {
    @FXML
    private TextField urlTextField;
    @FXML
    private TableView<FileInfo> tableView;
    private  int index=0;
    @FXML
    void handleDownload(ActionEvent event) {

        String url=this.urlTextField.getText().trim();
        String filename=url.substring(url.lastIndexOf("/")+1);
        String status="STARTING...";
        String action="OPEN";
        String path= AppConfig.DOWNLOAD_PATH + File.separator+filename;
        FileInfo file=new FileInfo((index+1)+"",filename,url,status,action,path,this);
        this.index=this.index+1;
        Downloader downloader=new Downloader(file,this);
        this.tableView.getItems().add(Integer.parseInt(file.getIndex())-1,file);
        this.urlTextField.setText("");
        downloader.start();

    }

    public void updateUI(FileInfo file) {
        System.out.println(file);
        FileInfo fileInfo=this.tableView.getItems().get(Integer.parseInt(file.getIndex())-1);
        fileInfo.setStatus(file.getStatus());
        this.tableView.refresh();
        System.out.println("--------------------------");
    }
    @FXML
    public void initialize(){
        System.out.println("Initialize View");
        TableColumn<FileInfo,String> sn=(TableColumn<FileInfo, String>) this.tableView.getColumns().get(0);
        sn.setCellValueFactory(item->{
            return item.getValue().indexProperty();
        });
        TableColumn<FileInfo,String> filename=(TableColumn<FileInfo, String>) this.tableView.getColumns().get(1);
        filename.setCellValueFactory(item->{
            return item.getValue().fileNameProperty();
        });

        TableColumn<FileInfo,String> url=(TableColumn<FileInfo, String>) this.tableView.getColumns().get(2);
        url.setCellValueFactory(item->{
            return item.getValue().urlProperty();
        });
        TableColumn<FileInfo,String> status=(TableColumn<FileInfo, String>) this.tableView.getColumns().get(3);
        status.setCellValueFactory(item->{
            return item.getValue().statusProperty();
        });
        TableColumn<FileInfo,String> action=(TableColumn<FileInfo, String>) this.tableView.getColumns().get(4);
        action.setCellValueFactory(item->{
            return item.getValue().actionProperty();
        });

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author Sithara
 */
public class Config {

    private File configFile;
    private Properties props;
    private final String fileName;

    public Config() throws IOException {
        this.fileName = "config.properties";
        InputStream is = Config.class.getResourceAsStream(fileName);
        if (is != null) {
            this.props = new Properties();
            props.load(is);
        }
    }

    public String getConf(String key) {
        return props.getProperty(key);
    }

    public void setConf(String key, String value) throws IOException {
        props.setProperty(key, value);
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            props.store(fos, null);
        }
    }
}

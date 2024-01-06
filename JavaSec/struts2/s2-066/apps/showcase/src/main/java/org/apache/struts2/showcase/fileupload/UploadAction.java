package org.apache.struts2.showcase.fileupload;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;

/**
 * @author by RacerZ
 * @date 2024/1/6.
 */
public class UploadAction extends ActionSupport {

    private static final long serialVersionUID = 5156288255337069381L;

    private String contentType;
    private File upload;
    private String uploadFileName;
    private String caption;

    public String input() throws Exception {
        return SUCCESS;
    }

    public String upload() {
        String path = ServletActionContext.getServletContext().getRealPath("/")+"upload";
        String realPath = path + File.separator + uploadFileName;
        System.out.println(realPath);
        try {
            FileUtils.copyFile(upload, new File(realPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    // since we are using <s:file name="upload" .../> the file name will be
    // obtained through getter/setter of <file-tag-name>FileName
    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String fileName) {
        this.uploadFileName = fileName;
    }


    // since we are using <s:file name="upload" ... /> the content type will be
    // obtained through getter/setter of <file-tag-name>ContentType
    public String getUploadContentType() {
        return contentType;
    }

    public void setUploadContentType(String contentType) {
        this.contentType = contentType;
    }


    // since we are using <s:file name="upload" ... /> the File itself will be
    // obtained through getter/setter of <file-tag-name>
    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }


    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public long getUploadSize() {
        if (upload != null) {
            return upload.length();
        } else {
            return 0;
        }
    }
}


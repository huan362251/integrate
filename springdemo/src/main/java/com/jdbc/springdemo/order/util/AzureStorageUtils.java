package com.jdbc.springdemo.order.util;

import cn.hutool.core.util.ObjectUtil;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlobDirectory;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.net.URISyntaxException;
import java.util.List;

/**
 * @Description
 * @Date 2021/10/20 15:08
 * @Author by liu.huan
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AzureStorageUtils {

    public static final String SETTLEMENT = "settlement";

    public static final String CSV_TYPE = ".csv";

    public static CloudBlobContainer getCloudBlobContainer() {
        CloudStorageAccount storageAccount ;
        CloudBlobClient blobClient ;
        CloudBlobContainer container = null;
        // Parse the connection string and create a blob client to interact with Blob storage
        try {
            storageAccount = CloudStorageAccount.parse("DefaultEndpointsProtocol=https;AccountName=ronhandevopsdiag;AccountKey=+IJShys+CNFrG597bPYUeUsNq2jbZNrp7ZRYIU1++SkFXIlkN/T+ZMeGFi3iyUfjKcL1/+jNzMx4Vit1nte3tw==;EndpointSuffix=core.windows.net");
            blobClient = storageAccount.createCloudBlobClient();
            container = blobClient.getContainerReference(SETTLEMENT);
        } catch (Exception e) {
            log.error("AzureStorageUtils fail:{}" + e);
        }

        return container;
    }

    public static CloudBlockBlob getCloudBlockBlob(Long merchantNo, String prefix, String settlementDate, CloudBlobContainer container) throws URISyntaxException, StorageException {
        CloudBlobDirectory directoryReferenceMerchant = container.getDirectoryReference(String.valueOf(merchantNo));
        CloudBlobDirectory directoryReferenceDate = directoryReferenceMerchant.getDirectoryReference(settlementDate);
        return directoryReferenceDate.getBlockBlobReference(prefix + CSV_TYPE);
    }

    public void upload(Long merchantNo, String prefix, List<String> data, String settlementDate) {
        long start = System.currentTimeMillis();
        File sourceFile = null;
        CloudBlobContainer container = null;
        Writer output = null;
        Writer fileWriter = null;
        try {
            container = getCloudBlobContainer();
            if(ObjectUtil.isEmpty(container)){
                log.error("AzureStorageUtils.upload method container is null");
            }
            //Getting a blob reference
            CloudBlockBlob blob = getCloudBlockBlob(merchantNo, prefix, settlementDate, container);
//            blob.uploadText();
            //Creating file
//            sourceFile = File.createTempFile(prefix, CSV_TYPE, new File(filePath));
            fileWriter = new FileWriter(sourceFile);
            output = new BufferedWriter(fileWriter);
            for (String datum : data) {
                output.write(datum + "\r\n");
                output.flush();
            }
            output.close();
            //Creating blob and uploading file to it
            blob.uploadFromFile(sourceFile.getAbsolutePath());
            boolean deleteFlag = sourceFile.delete();
            if(!deleteFlag){
                log.warn("file name {} not delete sucess",sourceFile.getName());
            }
            long end = System.currentTimeMillis();
            long time = (end - start) / 1000;
            log.info("耗时:{}" ,time);
        } catch (StorageException ex) {
            log.error(String.format("AzureStorageUtils.upload StorageException ex, Error returned from the service. Http code: %d and error code: %s", ex.getHttpStatusCode(), ex.getErrorCode()));
        } catch (Exception ex) {
            log.error("AzureStorageUtils.upload Exception ex,exception:{}", ex);
        }finally {
            try {
                fileWriter.close();
            } catch (Exception e) {
                log.error("upload method close file write exception:{}",e);
            }
            try {
                output.close();
            } catch (Exception e) {
                log.error("upload method close output write exception:{}",e);
            }
        }
    }
}

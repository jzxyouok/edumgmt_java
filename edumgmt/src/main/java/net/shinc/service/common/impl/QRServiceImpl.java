package net.shinc.service.common.impl;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import net.shinc.service.common.QRService;
import net.shinc.utils.MatrixToImageWriter;
import net.shinc.utils.UUIDUtils;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

/**
 * @ClassName QRServiceImpl 
 * @Description 二维码生成实现类
 * @author guoshijie 
 * @date 2015年9月6日 下午5:02:15
 */
@Service
public class QRServiceImpl implements QRService {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Value("${qrcode.tempPath}")
	private String qrcodeTempPath;
	
	/**
	 * 扫描二维码访问的地址
	 */
	@Value("${api.php.host}")
	private String apiHost;
	
	public String generateQrCode(Map<String,Object> param) {
		if(param == null || param.size() == 0) return "";
		
		StringBuilder sb = new StringBuilder();
		sb.append(apiHost).append("?");
		for(Map.Entry<String, Object> entry : param.entrySet()) {
			sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
		}
		return generateQrCode(qrcodeTempPath,apiHost,sb.toString());
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String generateQrCode(String filePath, String phpPath, String content) {
		try {
			 MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
		     
		     logger.info("content"+content);
		     
		     Map hints = new HashMap();
		     hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		     BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, 300, 300, hints);
		     
		     String qrName = "qr_" + UUIDUtils.getUuid() + ".png";
		     File file = new File(filePath, qrName);
		     MatrixToImageWriter.writeToFile(bitMatrix, "png", file);
		     String abName = file.getAbsolutePath();
		     logger.info(abName);
		     return abName;
		 } catch (Exception e) {
			 logger.error(ExceptionUtils.getStackTrace(e));
		 }
		return null;
	}
	

}
